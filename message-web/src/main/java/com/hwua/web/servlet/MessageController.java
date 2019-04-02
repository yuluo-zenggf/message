package com.hwua.web.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.hwua.entity.Message;
import com.hwua.entity.PageEntity;
import com.hwua.entity.User;
import com.hwua.service.IMessageService;
import com.hwua.service.IUserService;
import com.hwua.util.StringUtil;

@Controller
@RequestMapping("/msg")
public class MessageController {

	@Autowired
	private IUserService us;
	@Autowired
	private IMessageService msgService;

	/**
	 *   根据登录用户id查询一页消息
	 * @param user 登录用户
	 * @param pageNo 当前页面
	 * @param pageSize 一页显示数目
	 * @return
	 */
	@RequestMapping("/querybyloginid")
	@ResponseBody
	public PageEntity querybyloginid(@SessionAttribute("user") User user, Integer pageNo, Integer pageSize) {
		PageEntity pageEntity = new PageEntity();
		Long totalRecords = msgService.queryMsgCount(user.getId());
		pageEntity.setPageNo(pageNo);
		pageEntity.setPageSize(pageSize);
		pageEntity.setTotalRecords(totalRecords);
		// 第一页 start 0 2
		// 第二页 2 2
		// 第三页 4 2
		List<Message> messages = msgService.queryMessageByLoginUser(user.getId(), (pageNo - 1) * pageSize, pageSize);
		pageEntity.setMsgList(messages);
		return pageEntity;
	}

	/**
	 * 显示消息
	 * 
	 * @param id 消息id
	 * @return ModelAndView
	 */
	@RequestMapping("/showmsgbyid")
	public ModelAndView showmsgbyid(String id) {
		ModelAndView mv = new ModelAndView();
		Message msg = msgService.queryMessageById(id);
		int sendid = msg.getSendid();
		User sendUser = us.queryUserBySendid(sendid);
		msg.setSendUser(sendUser);
		mv.addObject("msg", msg);
		mv.setViewName("forward:/view/readMsg.jsp");
		return mv;
	}

	/**
	 * 发送消息
	 * 
	 * @param user    发送用户
	 * @param title   消息标题
	 * @param content 消息内容
	 * @param toUser  接收者id
	 * @return ModelAndView
	 */
	@RequestMapping("/send")
	public ModelAndView send(@SessionAttribute("user") User user, String title, String content, Integer toUser) {
		ModelAndView mv = new ModelAndView();
		int sendid = user.getId();// 发送者id
		title = StringUtil.repaceStr(title);// 消息标题
		content = StringUtil.repaceStr(content);// 消息内容
		int state = 1;// 消息状态
		String msg_create_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());// 消息发送时间
		Message msg = new Message(sendid, title, content, state, toUser, msg_create_date);
		int res = msgService.sendMessage(msg);
		if (res > 0) {
			mv.setViewName("redirect:/user/queryallusers");
		}
		return mv;
	}

	/**
	 * 根据消息id删除短消息
	 * 
	 * @param id 消息id
	 * @return 是否删除成功
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Integer id) {
		int res = msgService.deleteMsgById(id);
		if (res > 0) {
			return "success";
		} else {
			return "failure";
		}
	}

}
