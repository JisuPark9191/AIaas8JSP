package com.prac.myapp.member.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.prac.myapp.addr.model.MemberVO;
import com.prac.myapp.member.dao.IClientRepository;

@Service
public class ClientService implements IClientService{
	
	@Autowired
	@Qualifier("IClientRepository")
	IClientRepository clientRepository;
	
	@Override
	public String checkClient(String id, String pw) {
		MemberVO clnt = clientRepository.getClientInfo(id);
		if(clnt.getPw().equals(pw)) {
			return id;
		}
		return "error";
	}
	
	@Override
	public int getClientCount() {
		return clientRepository.getClientCount();
	}
	
	@Override
	public List<MemberVO> getClientList(String value, String orderby){
		return clientRepository.getClientList(value,orderby);
	}
	
	@Override
	public List<MemberVO> getClientNameList(String name){
		return clientRepository.getClientNameList(name);
	}
	
	@Override
	public MemberVO getClientInfo(String id) {
		return clientRepository.getClientInfo(id);
	}
	
	@Override
	public void updateClient(MemberVO clnt) {
		clientRepository.updateClient(clnt);
	}
	
	@Override
	public void insertClient(MemberVO clnt) {
		clientRepository.insertClient(clnt);
	}
	
	@Override
	public void deleteClient(String id, String pw) {
		clientRepository.deleteClient(id, pw);
	}
}
