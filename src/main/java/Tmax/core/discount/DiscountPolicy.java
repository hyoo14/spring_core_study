package Tmax.core.discount;

import Tmax.core.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     * @param member
     * @param price
     * @return
     */
    int discount(Member member, int price);
}
