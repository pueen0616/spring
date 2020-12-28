package co.company.spring.dao;

import java.util.List;
import java.util.Map;

public interface EmpMapper { //emp_mapper.xml에 쿼리
	public List<Emp> getEmpList(EmpSearch emp); //전체조회
	public int getCount(EmpSearch emp); //전체 조건 건수 조회
	
	public int updateEmp(Emp emp); //업데이트
	public Emp getEmp(Emp emp); //단건조회
	public int deleteEmp(Emp emp); //단건삭제
	public int deleteMultiEmp(EmpSearch emp); //선택 다건 삭제
	public int insertEmp(Emp emp); //한건 삽입
	public void insertEmpProc(Emp emp); //프로시저 리턴값 x
	public List<Map<String, Object>> getStatDept();
	
	public List<Jobs> jobSelect();
	public List<Depts> deptSelect();
}
