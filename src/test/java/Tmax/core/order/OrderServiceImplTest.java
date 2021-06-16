package Tmax.core.order;

import Tmax.core.discount.FixDiscountPolicy;
import Tmax.core.member.Grade;
import Tmax.core.member.Member;
import Tmax.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 1000);

        Assertions.assertThat(order.getItemPrice()).isEqualTo(1000);
    }
}
