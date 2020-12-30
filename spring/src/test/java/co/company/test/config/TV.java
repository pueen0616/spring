package co.company.test.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//직접 빈 등록 해볼꺼임
@Component
public class TV {
	//@Autowired 
	//@Qualifier("appleSpeaker") //빈 여러개라면 하나 정해주기(맨앞글자 소문자로)
	@Resource(name = "appleSpeaker") //autowired, qualifier 합친거 //pom에 어노테이션 추가
	Speaker speaker; //스피커 가져옴
	
	public void volumeup() {
		speaker.volumeup();
	}
	
	public TV() {
		System.out.println("TV가져옴");
	}
	
	public void init() {
		System.out.println("init 생성됨");
	}
	
	public void destroy() {
		System.out.println("destroy 소멸됨");
	}
}
