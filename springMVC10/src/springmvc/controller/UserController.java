package springmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.controller.entity.User;
import springmvc.controller.service.IUserManager;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userManager")
	private IUserManager userManager;
	
	@RequestMapping("/addUser")
	public String addUser(User user){
		userManager.addUser(user);
		return "redirect:/user/getAllUser";
	}
	
	@RequestMapping("/toAddUser")
	public String toAddUser(User user){
		return "/addUser";
	}
	
	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){
		List<User> users = userManager.getAllUser();
		request.setAttribute("user", users);
		
		return "/userManager";
	}
	
	@RequestMapping("/delUser")
	public void delUser(String id, HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		if(userManager.delUser(id)){
			result = "{\"result\":\"success\"}";
		}
		
		PrintWriter out = null;
		response.setContentType("application/json");
		
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
		
	}
	
	@RequestMapping("/getUser")
	public String getUser(HttpServletRequest request, String id){
		User user = userManager.getUser(id);
		request.setAttribute("user", user);
		
		return "/editUser";
		
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest request, User user){
		boolean isUpdateSuccess = userManager.updateUser(user);
		
		if(isUpdateSuccess){
			return "redirect:/user/getAllUser";
		}
		return "/error";
		
	}
}
