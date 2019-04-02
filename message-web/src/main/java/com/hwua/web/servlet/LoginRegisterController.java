package com.hwua.web.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hwua.entity.User;
import com.hwua.service.IUserService;

@Controller
@RequestMapping("/LR")
@SessionAttributes(value = { "user", "info" }) // 将user和info放入到session作用域中
public class LoginRegisterController {
	@Autowired
	private IUserService us;

	/**
	 * 登录功能
	 * 
	 * @param user 登录的用户
	 * @return ModelAndView
	 */
	@RequestMapping("/login")
	public ModelAndView login(User user) {
		ModelAndView mv = new ModelAndView();
		user = us.login(user);
		if (user != null) {
			mv.addObject("user", user);
			mv.setViewName("redirect:/view/main.jsp");
		} else {
			mv.addObject("info", "用户名或密码错误");
			mv.setViewName("redirect:/index.jsp");
		}
		return mv;
	}

	/**
	 * 注册功能
	 * 
	 * @param user  注册的用户
	 * @param code  验证码
	 * @param scode session中验证码
	 * @return
	 */
	@RequestMapping("/register")
	@ResponseBody
	public String register(User user, String code, @SessionAttribute("code") String scode) {
		if (!code.equalsIgnoreCase(scode)) {
			return "code error";
		} else {
			// 调用业务成插入一条件数据
			boolean flag = us.register(user);
			if (flag) {
				return "success";
			} else {
				return "failure";
			}
		}
	}

}
