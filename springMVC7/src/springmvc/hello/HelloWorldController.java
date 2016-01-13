package springmvc.hello;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class HelloWorldController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		// 1. 收集并验证参数
		// 2. 绑定参数到命令对象
		// 3. 将命令参数对象传入业务对象进行业务处理
		// 4. 选择下一个页面
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "hello world!");
		mv.setViewName("/hello");
//		return new ModelAndView("/hello");
		return mv;
	}

}
