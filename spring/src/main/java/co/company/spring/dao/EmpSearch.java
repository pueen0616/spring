package co.company.spring.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false) //Data 경고창 없앰
public class EmpSearch extends Emp {
	Integer minSalary;
	Integer maxSalary;
	Integer first;
    Integer last;
    String[] list;
}
