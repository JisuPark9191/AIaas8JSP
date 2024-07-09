package com.prac.myapp.member.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.prac.myapp.addr.model.MemberVO;
import com.prac.myapp.member.dao.IMemberRepository;

@Service
public class MemberService implements IMemberService{
	
	@Autowired
	@Qualifier("IMemberRepository")
	IMemberRepository memberRepository;
	
	@Override
	public String checkMember(String id, String pw) {
		MemberVO clnt = memberRepository.getMemberInfo(id);
		if(clnt.getPw().equals(pw)) {
			return id;
		}
		return "error";
	}
	
	@Override
	public int getMemberCount() {
		return memberRepository.getMemberCount();
	}
	
	@Override
	public List<MemberVO> getMemberList(String value, String orderby){
		return memberRepository.getMemberList(value,orderby);
	}
	
	@Override
	public List<MemberVO> getMemberNameList(String name){
		return memberRepository.getMemberNameList(name);
	}
	
	@Override
	public MemberVO getMemberInfo(String id) {
		return memberRepository.getMemberInfo(id);
	}
	
	@Override
	public void updateMember(MemberVO clnt) {
		memberRepository.updateMember(clnt);
	}
	
	@Override
	public void insertMember(MemberVO clnt) {
		memberRepository.insertMember(clnt);
	}
	
	@Override
	public void deleteMember(String id, String pw) {
		memberRepository.deleteMember(id, pw);
	}
}
