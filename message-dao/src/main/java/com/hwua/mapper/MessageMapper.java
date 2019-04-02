package com.hwua.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hwua.entity.Message;

@Repository("msgMapper")
public interface MessageMapper {
	/**
	 * 查询一页短消息
	 * 
	 * @param receiveid 接收者id
	 * @param start     起始位置
	 * @param pageSize  每页显示的条数
	 * @return 短消息list
	 * @throws SQLException
	 */
	public List<Message> queryMsgByPage(@Param("receiveid") int receiveid, @Param("start") int start,
			@Param("pageSize") int pageSize) throws SQLException;

	/**
	 * 根据消息id来查询短消息
	 * 
	 * @param id 消息id
	 * @return 短消息
	 * @throws SQLException
	 */
	public Message queryMsgById(String id) throws SQLException;

	/**
	 * 更新短消息
	 * 
	 * @param msg 短消息
	 * @return 影响数据库的行数
	 * @throws SQLException
	 */
	public int update(Message msg) throws SQLException;

	/**
	 * 保存短消息
	 * 
	 * @param msg 短消息
	 * @return 影响数据库的行数
	 * @throws SQLException
	 */
	public int save(Message msg) throws SQLException;

	/**
	 * 删除短消息
	 * 
	 * @param id 消息id
	 * @return 影响数据库的行数
	 * @throws SQLException
	 */
	public int delete(int id) throws SQLException;

	/**
	 * 根据接收者id查询消息数量
	 * 
	 * @param receiveid 接收者id
	 * @return 消息数量
	 * @throws SQLException
	 */
	public Long queryCount(int receiveid) throws SQLException;
}
