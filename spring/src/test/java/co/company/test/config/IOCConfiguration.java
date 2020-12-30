package co.company.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@ComponentScan(basePackages= {"co.company.test"}) //이 패키지에서 찾음
public class IOCConfiguration {
//	//bean 객체 생성될때 메소드 호출
//	@Bean(initMethod = "init", destroyMethod = "destroy") //bean 등록 테스트 //<bean id="tv" class=""
//	@Scope("prototype") //singletone, request, session //싱글톤 설정
//	public TV tv() {
//		return new TV();
//	}
}
