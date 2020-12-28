package co.company.spring.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import co.company.spring.dao.Emp;

// 커맨드 객체 검증 클래스 Validator 에러메시지 넘겨줌
public class EmpValidator implements Validator{
	//email 정규 표현식
	public final String emailRegExp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
	private Pattern pattern;
	
	public EmpValidator() {
		pattern = Pattern.compile(emailRegExp); //패턴 초기화에 정규 표현식 넣어줌
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Emp.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Emp emp = (Emp)target;
		if(emp.getLastName() == null ||
		   emp.getLastName().trim().isEmpty()) {
			errors.rejectValue("lastName", "required", new Object[] {"lastName"},""); //에러코드메시지는 label.properties에
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobId", "required", new Object[] {"jobId"},"");
		//이메일형식 (@이랑 .드가기)
		if(emp.getEmail() == null || emp.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required", new Object[] {"email"},""); //에러코드메시지는 label.properties에
		} else {
			Matcher matcher = pattern.matcher(emp.getEmail());
			if(! matcher.matches()) {
				errors.rejectValue("email", "bad"); //에러코드메시지는 label.properties에
			}
		}
	}
}
