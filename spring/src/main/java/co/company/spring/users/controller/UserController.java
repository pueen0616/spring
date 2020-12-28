package co.company.spring.users.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import co.company.spring.users.service.UserService;
import co.company.spring.users.service.UserVO;

@Controller
public class UserController {
	@Autowired
	UserService service;

	// 등록페이지로 이동
	@GetMapping("/userInsert")
	public String userInsertForm() {
		return "user/insert";
	}

	// 등록처리
	@PostMapping("/userInsert")
	public String userInsert(HttpServletRequest request, UserVO user) {
		// request miltipart로 캐스팅
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 이미지파일
		MultipartFile multipartFile = multipartRequest.getFile("uploadFile"); // input타입의 name값 : uploadFile
		if (!multipartFile.isEmpty() && multipartFile.getSize() > 0) {
			try {
				String path = request.getSession().getServletContext().getRealPath("/images"); // /images폴더 위치 mvc에 추가
				System.out.println("pp" + path);
				multipartFile.transferTo(new File(path, multipartFile.getOriginalFilename()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setProfile(multipartFile.getOriginalFilename());
		}
		service.insertUser(user);
		return "user/insert";
	}

	@RequestMapping("/getUser") //단건조회
	public String getUser(UserVO user, Model model) {
		model.addAttribute("user",service.getUser(user));
		return "user/user";
	}
	
	 //이미지 다운로드
	@RequestMapping("/filedown")
	public void filedown(HttpServletRequest request, HttpServletResponse response, @RequestParam String uFile) throws IOException { //리퀘스트, 리스판스, 파람 uFile
		response.setContentType("application/octet-stream;charset=UTF-8"); //브라우저 타입 알려주기
		String fn = URLEncoder.encode(uFile,"UTF-8"); //한글파일일시 인코딩
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\""); //다운받을때 파일명 정확하게
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		try {
			String path = request.getSession().getServletContext().getRealPath("/images"); // /images폴더 위치 mvc에 추가
			in = new BufferedInputStream(new FileInputStream(path + "/" + uFile));
			out = new BufferedOutputStream(response.getOutputStream());
			FileCopyUtils.copy(in, out);
			out.flush();
		} catch (IOException ex) {
		} finally {
			in.close();
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
	}
}
