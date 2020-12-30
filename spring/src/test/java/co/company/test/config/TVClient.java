package co.company.test.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {IOCConfiguration.class}) //ioc컨피규레이션 클래스
public class TVClient {
	@Autowired TV tv; //tv 가져옴
	@Autowired TV tv2; //같은 tv인지
	@Test
	public void tvTest() {
		System.out.println(tv == tv2); //tv나 tv2나 같은 객체
		tv.volumeup();
	}
}
