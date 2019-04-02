package com.hwua.entity;

/**
 * 消息实体类
 * 
 * @author yuluo
 *
 */
public class Message {
	private int id; // 消息id
	private int sendid; // 发送者id
	private String title; // 消息标题
	private String msgcontent; // 消息内容
	private int state; // 消息息状态
	private int receiveid; // 接收者id
	private String msg_create_date; // 短息发送时间
	private User sendUser = null; // 发送用户

	public User getSendUser() {
		return sendUser;
	}

	public void setSendUser(User sendUser) {
		this.sendUser = sendUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSendid() {
		return sendid;
	}

	public void setSendid(int sendid) {
		this.sendid = sendid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsgcontent() {
		return msgcontent;
	}

	public void setMsgcontent(String msgcontent) {
		this.msgcontent = msgcontent;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getReceiveid() {
		return receiveid;
	}

	public void setReceiveid(int receiveid) {
		this.receiveid = receiveid;
	}

	public String getMsg_create_date() {
		return msg_create_date;
	}

	public void setMsg_create_date(String msg_create_date) {
		this.msg_create_date = msg_create_date;
	}

	public Message(int sendid, String title, String msgcontent, int state, int receiveid, String msg_create_date) {
		super();
		this.sendid = sendid;
		this.title = title;
		this.msgcontent = msgcontent;
		this.state = state;
		this.receiveid = receiveid;
		this.msg_create_date = msg_create_date;
	}

	public Message() {
		super();
	}

	public Message(int id, int sendid, String title, String msgcontent, int state, int receiveid,
			String msg_create_date) {
		super();
		this.id = id;
		this.sendid = sendid;
		this.title = title;
		this.msgcontent = msgcontent;
		this.state = state;
		this.receiveid = receiveid;
		this.msg_create_date = msg_create_date;
	}

}
