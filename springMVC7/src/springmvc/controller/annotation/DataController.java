package springmvc.controller.annotation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.controller.entity.User;

@Controller
@RequestMapping("/user/data")
public class DataController {
	@RequestMapping("/addUser")
	public String addUser(String userName,String age,HttpServletRequest request){
		request.setAttribute("userName", userName);
		request.setAttribute("age", age);
		return "/userManager";
	}
	
	@RequestMapping("/toUser")
	public String toUser(){
//		return "/addUser";
		return "/json";
	}
	
	@RequestMapping("/addUserJson")
	public void addUserJson(User user,HttpServletRequest request,HttpServletResponse response){
		//{"username":"userName","age","age"}
		String result = "{\"userName\":\" "+ user.getUserName() +" \",\"age\":\" "+ user.getAge()+" \"}";
		PrintWriter out = null;
		response.setContentType("application/json");
		
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
