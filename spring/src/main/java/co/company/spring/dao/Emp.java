package co.company.spring.dao;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Emp {
	@JsonProperty(value="empId") //employeeId를 empId로 바꾸기~
    String employeeId;   
	String firstName;
	String lastName;
	String email;	
	@DateTimeFormat(pattern="yyyy-mm-dd") //이 형식으로 쓰겠다
	@JsonFormat(shape=Shape.STRING) Date hireDate; //JsonFormat() 날짜값 변환	
	String jobId;	
	String departmentId;
	@JsonIgnore Integer salary; //JsonIgnore 데이타 필없는거 제외시키기
	@JsonIgnore String msg; //OUT 받기위한 msgVO
}
