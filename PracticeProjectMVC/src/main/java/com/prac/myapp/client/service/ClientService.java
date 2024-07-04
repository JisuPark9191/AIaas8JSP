package com.prac.myapp.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.myapp.addr.model.ClientVO;
import com.prac.myapp.client.dao.IClientRepository;

@Service
public class ClientService implements IClientService{
	
	@Autowired
	IClientRepository clientRepository;
	
	@Override
	public String checkClient(String id, String pw) {
		ClientVO clnt = clientRepository.getClientInfo(id);
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
	public List<ClientVO> getClientList(String value, String orderby){
		return clientRepository.getClientList(value,orderby);
	}
	
	@Override
	public List<ClientVO> getClientNameList(String name){
		return clientRepository.getClientNameList(name);
	}
	
	@Override
	public ClientVO getClientInfo(String id) {
		return clientRepository.getClientInfo(id);
	}
	
	@Override
	public void updateClient(ClientVO clnt) {
		clientRepository.updateClient(clnt);
	}
	
	@Override
	public void insertClient(ClientVO clnt) {
		clientRepository.insertClient(clnt);
	}
	
	@Override
	public void deleteClient(String id, String pw) {
		clientRepository.deleteClient(id, pw);
	}
}
