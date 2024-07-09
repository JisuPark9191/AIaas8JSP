package com.prac.myapp.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.prac.myapp.addr.model.MemberVO;

public interface IClientRepository {
	int getClientCount();
	List<MemberVO> getClientList(@Param("value")String value, @Param("orderby")String orderby);
	List<MemberVO> getClientNameList(String name);
	MemberVO getClientInfo(String id);
	void updateClient(MemberVO mem);
	void insertClient(MemberVO mem);
	void deleteClient(@Param("id")String id, @Param("pw")String pw);
}
