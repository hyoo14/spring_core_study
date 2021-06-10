package Tmax.core;

import Tmax.core.discount.DiscountPolicy;
import Tmax.core.discount.FixDiscountPolicy;
import Tmax.core.discount.RateDiscountPolicy;
import Tmax.core.member.MemberService;
import Tmax.core.member.MemberServiceImpl;
import Tmax.core.member.MemoryMemberRepository;
import Tmax.core.order.OrderService;
import Tmax.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}