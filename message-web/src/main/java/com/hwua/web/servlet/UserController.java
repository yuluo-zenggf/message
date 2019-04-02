package com.hwua.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hwua.entity.User;
import com.hwua.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService us;

	/**
	 * 用户注销功能
	 * 
	 * @param request 请求
	 * @return ModelAndView
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		request.getSession(false).invalidate(); // 销毁session
		mv.setViewName("redirect:/index.jsp");
		return mv;
	}

	/**
	 * 查询所有的用户
	 * 
	 * @param sendid 发送者id
	 * @return ModelAndView
	 */
	@RequestMapping("/queryallusers")
	public ModelAndView queryallusers(Integer sendid) {
		ModelAndView mv = new ModelAndView();
		List<User> uList = us.getAllUsers();
		// 代表是回复而不是发送短消息
		if (sendid != null) {
			mv.addObject("sendid", sendid);
		}
		// 传递一个sendid过去
		mv.addObject("users", uList);
		mv.setViewName("forward:/view/newMsg.jsp");
		return mv;
	}

	/**
	 * 通过用户名查询
	 * 
	 * @param name 用户名
	 * @return
	 */
	@RequestMapping("/queryByName")
	@ResponseBody
	public String queryByName(String name) {
		boolean bool = us.queryUserByName(name);
		return (bool + "");
	}
}
