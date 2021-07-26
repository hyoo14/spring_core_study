package hello.core;

import hello.core.order.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreApplicationTests {

//	@Autowired  OrderService orderService; //테스트코드에서는 오토와이어드 해조 됨.


	@Test
	void contextLoads() {
	}

}
