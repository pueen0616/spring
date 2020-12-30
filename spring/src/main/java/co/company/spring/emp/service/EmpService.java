package co.company.spring.emp.service;

import java.util.List;
import java.util.Map;

import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpSearch;

public interface EmpService {
	public List<Emp> getEmpList(EmpSearch emp); //전체조회
	public List<Map<String, Object>> getStatDept();
	public Emp getEmp(Emp emp); //단건조회
	public int insertEmp(Emp emp); //한건 삽입
	public int updateEmp(Emp emp); //업데이트
	public int deleteEmp(Emp emp); //단건삭제
}
