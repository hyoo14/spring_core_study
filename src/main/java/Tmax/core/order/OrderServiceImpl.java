package Tmax.core.order;

import Tmax.core.discount.DiscountPolicy;
import Tmax.core.discount.FixDiscountPolicy;
import Tmax.core.member.Member;
import Tmax.core.member.MemberRepository;
import Tmax.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{


    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
