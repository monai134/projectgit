package springmvc.hello;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class HelloWorldController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		// 1. �ռ�����֤����
		// 2. �󶨲������������
		// 3. ���������������ҵ��������ҵ����
		// 4. ѡ����һ��ҳ��
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "hello world!");
		mv.setViewName("/hello");
//		return new ModelAndView("/hello");
		return mv;
	}

}
