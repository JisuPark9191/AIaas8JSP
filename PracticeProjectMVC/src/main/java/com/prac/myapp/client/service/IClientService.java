package com.prac.myapp.client.service;

import java.util.List;

import com.prac.myapp.addr.model.ClientVO;

public interface IClientService {
	String checkClient(String id, String pw);
	int getClientCount();
	List<ClientVO> getClientList(String value, String orderby);
	List<ClientVO> getClientNameList(String name);
	ClientVO getClientInfo(String id);
	void updateClient(ClientVO clnt);
	void insertClient(ClientVO clnt);
	void deleteClient(String id, String pw);
}
