package co.company.spring;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.company.spring.config.DBConfiguration;
import co.company.spring.config.MybatisConfiguration;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DBConfiguration.class,MybatisConfiguration.class } )
public class EmpDaoMapperClient {
	@Autowired EmpMapper empDAO;
	
	@Test
	public void DeptRecordCount() {
		List<Map<String, Object>> list = empDAO.getStatDept();
		System.out.println(list.get(1).get("deptName"));
	}
	
	//@Test
	public void recordCount() {
		EmpSearch emp = new EmpSearch();
		emp.setMinSalary(2000);
		emp.setMaxSalary(10000);
		System.out.println(empDAO.getCount(emp) + "개");
	}
	
	//@Test
	public void InsertProcTest() {
		Emp emp = new Emp();
		emp.setLastName("choi");
		emp.setEmail("aaa");
		emp.setJobId("IT_PROG");
		empDAO.insertEmpProc(emp);
		
		System.out.println(emp.getEmployeeId() + " : " + emp.getMsg());
	}
	
	//@Test 
	public void deleteMultyTest() {
		EmpSearch emp = new EmpSearch();
		emp.setList(new String[] {"1000","1001"});
		empDAO.deleteMultiEmp(emp);
	}
	
	//@Test
	public void InsertTest() {
		Emp emp = new Emp();
		
		emp.setFirstName("길동");
		emp.setLastName("choi");
		emp.setEmail("a@a.comm");
		emp.setHireDate(new Date(System.currentTimeMillis()));
		emp.setJobId("IT_PROG");
		empDAO.insertEmp(emp);
		
		System.out.println(emp.getEmployeeId());
	}
	
	//@Test
	public void updateTest() {
		Emp emp = new Emp();
		
		emp.setEmployeeId("100");
		System.out.println(empDAO.getEmp(emp));
		//hong 업데이트
		emp.setFirstName("aaa");
		empDAO.updateEmp(emp);
		System.out.println(empDAO.getEmp(emp));
		//salary 업데이트
		emp.setSalary(3000);
		empDAO.updateEmp(emp);
		System.out.println(empDAO.getEmp(emp));
	}
	
	//@Test
	public void test() {
		EmpSearch empvo = new EmpSearch();
//		empvo.setFirstName("pat");
//		empvo.setDepartmentId("20");
		empvo.setMinSalary(5000);
		empvo.setMaxSalary(10000);
		List<Emp> list = empDAO.getEmpList(empvo); //Mapper는 Null이라도 넘김
		for(Emp emp : list) {
			System.out.println(emp.getEmployeeId() + " : " 
						     + emp.getFirstName() + " : " 
					         + emp.getDepartmentId() + " : "
					         + emp.getJobId() + " : "
					         + emp.getSalary());
		}
	}
}