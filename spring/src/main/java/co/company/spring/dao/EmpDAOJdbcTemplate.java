package co.company.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component //bean 등록 spring 컨테이너에 담겨서 사용가능
public class EmpDAOJdbcTemplate {
	final String SELECT = "SELECT * FROM EMPLOYEES";
	final String INSERT = "INSERT INTO EMPLOYEES(EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID) VALUES(?,?,?,SYSDATE,'IT_PROG')";
	
	@Autowired //등록된거 가져오기
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> getListMap(){
		return jdbcTemplate.queryForList(SELECT); //jdbc템플릿하면 이렇게 한줄로 끝
	}
	
	public void insert(Emp emp) {
		Object[] param = new Object[]{ //오브젝트 배열
			emp.getEmployeeId(),
			emp.getLastName(),
			emp.getEmail()
		};
		jdbcTemplate.update(INSERT, param);
	}
	
	public List<Emp> getList(){
		return jdbcTemplate.query(SELECT, new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp emp = new Emp();
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmployeeId(rs.getString("employee_id"));
				return emp;
			}
		});
	}
}
