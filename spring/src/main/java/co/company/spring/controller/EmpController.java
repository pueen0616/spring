package co.company.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.company.spring.dao.Depts;
import co.company.spring.dao.Emp;
import co.company.spring.dao.EmpMapper;
import co.company.spring.dao.EmpSearch;
import co.company.spring.dao.Jobs;
import co.company.spring.emp.service.EmpService;

@Controller
public class EmpController {
		@Autowired EmpMapper dao; //DAO 가져오기
		
		@ModelAttribute("jobs")
		public List<Jobs> jobs(){
			return dao.jobSelect();
		}
		@ModelAttribute("depts")
		public List<Depts> depts(){
			return dao.deptSelect();
		}
		
		@RequestMapping("ajax/jobSelect")
		@ResponseBody //RestController 없을 시 이거 해줌 @Controller + @ResponsBody = @RestController
		public List<Jobs> jobSelect(){
			return dao.jobSelect();
		}
		
		@RequestMapping(value="/empSelect", method = RequestMethod.GET) // <- form 메소드 넘기는거랑 같음
		public ModelAndView select(EmpSearch emp) { //모델 앤 뷰
			ModelAndView mav = new ModelAndView();
			//조회
			mav.addObject("list", dao.getEmpList(emp)); //list 이름으로 줌
			mav.setViewName("emp/select"); //리턴
			return mav;
		}
		
		//입력화면
		@GetMapping("/empinsertForm")
		public String insertForm(Model model, Emp emp) { //Emp emp 빈거라도 넘겨줘야함
//			model.addAttribute("jobs", dao.jobSelect()); //jobs 이름으로 줌
//			model.addAttribute("depts", dao.deptSelect()); //depts 이름 줌
			return "emp/insert";
		}
		
		//수정화면(입력이랑 비슷)
		@GetMapping("/empUpdateForm")
		public String updateForm(Model model, Emp emp) { //Emp emp 빈거라도 넘겨줘야함
//			model.addAttribute("jobs", dao.jobSelect()); //jobs 이름으로 줌
			model.addAttribute("emp", dao.getEmp(emp)); //단건조회 emp 담아서 넘김
//			model.addAttribute("depts", dao.deptSelect()); //depts 이름 줌
			return "emp/insert";
		}
		//입력처리
		@PostMapping("/empInsert")
		public String insert(Emp emp, Errors errors) { //Emp emp로 VO 다 가져옴   //객체명 따로 주자 할때는 ModelAttribute("속성명")
			new EmpValidator().validate(emp, errors); //검증 객체 생성
			if(errors.hasErrors()) {
				return "emp/insert";
			}
			
			if(emp.getEmployeeId() == null) //employeeId가 널이면 입력 아니면 수정											 
				dao.insertEmp(emp); //등록 dao 가져옴
			else
				dao.updateEmp(emp);
//			return "redirect:/empSelect";
			return "emp/insertOutput";
		}
		
//		public String insert(HttpServletRequest request,
//							 @RequestParam(value="lastName", 	//변수명 다르게 해줄때 value
//							 			   required = false,	//값을 안넘겼을때 required
//							 			   defaultValue = "noname") String lName, //입력안하고 기본값 주기 noname
//							 @RequestParam(required = false) int salary,
//							 Emp emp){ //vo 객체 자체를 주면 다 가져올 수 있음 개사기
//			//파라미터
//			String firstName = request.getParameter("firstName");
//			System.out.println(lName + ":" + firstName + ":" + salary);
//			System.out.println("emp\n" + emp); //emp 전체 가져오기
//			//등록처리
//			//조회로
//			return "redirect:/empSelect";
//		}
}
