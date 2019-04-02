package com.hwua.service;

import java.util.List;

import com.hwua.entity.Message;

public interface IMessageService {
	/**
	 * 获取登录用户收到的所有短消息
	 * 
	 * @param loginid
	 * @return
	 */
	public List<Message> queryMessageByLoginUser(int loginid, int start, int pageSize);

	/**
	 * 通过消息id查询消息
	 * 
	 * @param id 消息id
	 * @return 消息
	 */
	public Message queryMessageById(String id);

	/**
	 * 发送消息
	 * 
	 * @param msg 消息
	 * @return 影响数据库的行数
	 */
	public int sendMessage(Message msg);

	/**
	 * 通过消息id删除消息
	 * 
	 * @param id 消息id
	 * @return 影响数据库的行数
	 */
	public int deleteMsgById(int id);

	/**
	 * 根据登录用户id查询该用户所有的消息数量
	 * 
	 * @param loginid 登录用户的id
	 * @return 该用户所有的消息数量
	 */
	public Long queryMsgCount(int loginid);
}
