package co.company.spring.users.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import co.company.spring.users.service.UserService;
import co.company.spring.users.service.UserVO;

@RestController //모든 응답 결과가 json으로 넘어감
public class RestfulUserController {
	@Autowired
	UserService userService;
	
	//전체조회
	@RequestMapping(value="/users", method=RequestMethod.GET)
		public List<UserVO> getUserList(Model model, UserVO vo) {
			return  userService.getUserList(vo);
		}
	
	//단건조회
	@RequestMapping(value="/users/{id}",  method=RequestMethod.GET)
	public UserVO getUser(@PathVariable String id, UserVO vo, Model model) { //@PathVariable 변수 {id} 읽어냄
		vo.setId(id);
		return  userService.getUser(vo);
	}
	
	//삭제
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	public Map  getUserList( @PathVariable String id, UserVO vo, Model model) {
		vo.setId(id);
		userService.deleteUser(vo);
		Map result = new HashMap<String, Object>();
		result.put("result", Boolean.TRUE);
		return result;
	}
	//등록
	@RequestMapping(value="/users"
			,method=RequestMethod.POST //post : 등록
	)
	public Map insertUser(@RequestBody UserVO vo, Model model, HttpServletResponse response) { //@RequestBody - json구조로 넘길때 vo에 담아줌
		userService.insertUser(vo);
		return Collections.singletonMap("reslut", true);
//		response.setStatus(HttpServletResponse.SC_OK); //void 리턴값 없을때 완료 status(200번) 하나는 넘겨주기
	}
	
	//수정
	@RequestMapping(value="/users"
			,method=RequestMethod.PUT //put : 수정
	)
	public UserVO updateUser(@RequestBody UserVO vo, Model model) {
		userService.updateUser(vo);
		return  vo;
	}	
	
	@RequestMapping(value="/respAPI")
	public Map respAPI() {
		RestTemplate rest = new RestTemplate();
		return rest.getForObject("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20120101", Map.class);
	}
	
}
