package com.prac.myapp.addr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.prac.myapp.addr.dao.IAddrRepository;
import com.prac.myapp.addr.model.AddrVO;

@Service
public class AddrService implements IAddrService{

	@Autowired
	@Qualifier("IAddrRepository")
	IAddrRepository addrRepository;
	
	@Override
	public int getAddrCount(String id) {
		return addrRepository.getAddrCount(id);
	}
	
	@Override
	public List<AddrVO> getAddrList(String id, String value, String orderby){
		return addrRepository.getAddrList(id, value, orderby);
	}
	
	@Override
	public List<AddrVO> getAddrNameList(String id, String name){
		return addrRepository.getAddrNameList(id, name);
	}
	
	@Override
	public AddrVO getAddrInfo(String id, String phone) {
		return addrRepository.getAddrInfo(id, phone);
	}
	
	@Override
	public void updateAddr(String id, String phone, AddrVO addr) {
		addrRepository.updateAddr(id, phone, addr);
	}
	
	@Override
	public void insertAddr(String id, AddrVO addr) {
		addrRepository.insertAddr(id, addr);
	}
	
	@Override
	public void deleteAddr(String id, String phone) {
		addrRepository.deleteAddr(id, phone);
	}
	
}
