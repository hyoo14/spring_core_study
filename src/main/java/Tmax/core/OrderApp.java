package Tmax.core;

import Tmax.core.member.Grade;
import Tmax.core.member.Member;
import Tmax.core.member.MemberService;
import Tmax.core.member.MemberServiceImpl;
import Tmax.core.order.Order;
import Tmax.core.order.OrderService;
import Tmax.core.order.OrderServiceImpl;

import java.util.Arrays;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}
