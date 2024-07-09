package com.prac.myapp.member.service;

import java.util.List;

import com.prac.myapp.addr.model.MemberVO;

public interface IClientService {
	String checkClient(String id, String pw);
	int getClientCount();
	List<MemberVO> getClientList(String value, String orderby);
	List<MemberVO> getClientNameList(String name);
	MemberVO getClientInfo(String id);
	void updateClient(MemberVO clnt);
	void insertClient(MemberVO clnt);
	void deleteClient(String id, String pw);
}
