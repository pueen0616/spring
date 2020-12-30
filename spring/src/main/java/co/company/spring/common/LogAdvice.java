package co.company.spring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // bean 등록 (xml에서 할수도이서 java에서 할수도 잇음)
@Aspect //어노테이션 아스펙트
public class LogAdvice {
	@Pointcut("execution(* co.company.spring..*Impl.*(..))") //포인트컷 정의
	public void allpointcut() {}
	
	@Before("allpointcut()") //포인트컷 id
	public void printLog(JoinPoint jp) { //조인포인트
		String method = jp.getSignature().getName();
		Object[] param = jp.getArgs();
		System.out.println("[공통로그] before " + method + "\n" + ((param != null && param.length>0)? param[0] :""));
	}
}
