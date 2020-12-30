package co.company.spring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // bean 등록 (xml에서 할수도이서 java에서 할수도 잇음)
@Aspect //어노테이션 아스펙트
public class AfterAdvice {
	@Pointcut("execution(* co.company.spring..*Impl.get*(..))") //포인트컷 정의
	public void getpointcut() {}
	
	@AfterReturning(pointcut = "getpointcut()", returning = "returnObj") //포인트컷 id, 리터닝
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		System.out.println("[공통로그] after " + method + "\n" + returnObj);
	}
}
