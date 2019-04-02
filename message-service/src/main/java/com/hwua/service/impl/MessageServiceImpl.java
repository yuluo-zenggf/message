package com.hwua.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hwua.entity.Message;
import com.hwua.mapper.MessageMapper;
import com.hwua.service.IMessageService;

@Service("msgService")
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class MessageServiceImpl implements IMessageService {
	@Resource(name = "msgMapper")
	private MessageMapper msgDao = null;

	@Override
	public List<Message> queryMessageByLoginUser(int loginid, int start, int pageSize) {
		List<Message> msgList = null;
		try {
			msgList = msgDao.queryMsgByPage(loginid, start, pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msgList;

	}

	@Override
	public Message queryMessageById(String id) {
		Message message = null;
		try {
			message = msgDao.queryMsgById(id);
			message.setState(0);
			msgDao.update(message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public int sendMessage(Message msg) {
		int res = 0;
		try {
			res = msgDao.save(msg);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteMsgById(int id) {
		int res = 0;
		try {
			res = msgDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Long queryMsgCount(int loginid) {
		Long count = 0l;
		try {
			count = msgDao.queryCount(loginid);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

}
