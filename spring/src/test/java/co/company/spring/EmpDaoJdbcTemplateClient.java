package co.company.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.company.spring.config.DBConfiguration;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpDAOJdbcTemplate;

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(classes = { DBConfiguration.class})
public class EmpDaoJdbcTemplateClient {
	//EmpDAO TEST
	
	@Autowired EmpDAOJdbcTemplate empDAO; //EmpDAO 불러오기
	
	@Test
	public void empdaoTest() {
		System.out.println("값 어딧노 " + empDAO.getListMap());
	}
	
	@Test
	public void insert() {
		Emp emp = new Emp();
		emp.setEmployeeId("0616");
		emp.setLastName("hyeonDong");
		emp.setEmail("e@e.e");
		empDAO.insert(emp);
	}
}
