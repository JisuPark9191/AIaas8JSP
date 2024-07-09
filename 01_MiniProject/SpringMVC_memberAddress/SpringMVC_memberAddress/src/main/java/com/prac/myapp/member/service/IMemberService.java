package com.prac.myapp.member.service;

import java.util.List;

import com.prac.myapp.addr.model.MemberVO;

public interface IMemberService {
	String checkMember(String id, String pw);
	int getMemberCount();
	List<MemberVO> getMemberList(String value, String orderby);
	List<MemberVO> getMemberNameList(String name);
	MemberVO getMemberInfo(String id);
	void updateMember(MemberVO clnt);
	void insertMember(MemberVO clnt);
	void deleteMember(String id, String pw);
}
