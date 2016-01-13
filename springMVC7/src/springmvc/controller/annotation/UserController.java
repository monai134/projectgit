package springmvc.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest req){
		String result="add user";
		req.setAttribute("result", result);
		return "/annocation";
	}
	
//	@RequestMapping(value="/delUser"/*,method=RequestMethod.GET*/)
	@RequestMapping("/delUser")
	public String delUser(HttpServletRequest req){
		String result="del user";
		req.setAttribute("result", result);
		return "/annocation";
	}
	
	@RequestMapping("/toUser")
	public String toUser(){
		return "/annocation";
	}
}
