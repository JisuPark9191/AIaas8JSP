package com.prac.myapp.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.prac.myapp.addr.model.MemberVO;

public interface IMemberRepository {
	int getMemberCount();
	List<MemberVO> getMemberList(@Param("value")String value, @Param("orderby")String orderby);
	List<MemberVO> getMemberNameList(String name);
	MemberVO getMemberInfo(String id);
	void updateMember(MemberVO mem);
	void insertMember(MemberVO mem);
	void deleteMember(@Param("id")String id, @Param("pw")String pw);
}
