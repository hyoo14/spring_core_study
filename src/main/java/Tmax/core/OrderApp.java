package Tmax.core;

import Tmax.core.member.Grade;
import Tmax.core.member.Member;
import Tmax.core.member.MemberService;
import Tmax.core.member.MemberServiceImpl;
import Tmax.core.order.Order;
import Tmax.core.order.OrderService;
import Tmax.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class OrderApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService(); 2nd code
//        OrderService orderService = appConfig.orderService();

      //  MemberService memberService = new MemberServiceImpl(); 1st code
      //  OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}
