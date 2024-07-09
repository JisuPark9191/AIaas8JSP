package com.prac.myapp.addr.service;

import java.util.List;

import com.prac.myapp.addr.model.AddrVO;

public interface IAddrService {
	int getAddrCount(String id);
	List<AddrVO> getAddrList(String id, String value, String orderby);
	List<AddrVO> getAddrNameList(String id, String name);
	AddrVO getAddrInfo(String id, String phone);
	void updateAddr(String id, String phone, AddrVO addr);
	void insertAddr(String id, AddrVO addr);
	void deleteAddr(String id, String phone);
}
