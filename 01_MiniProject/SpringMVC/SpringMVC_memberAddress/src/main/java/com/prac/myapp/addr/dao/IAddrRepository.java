package com.prac.myapp.addr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.prac.myapp.addr.model.AddrVO;

public interface IAddrRepository {
	int getAddrCount(String id);
	List<AddrVO> getAddrList(@Param("id")String id, @Param("value") String value, @Param("orderby")String orderby);
	List<AddrVO> getAddrNameList(@Param("id")String id, @Param("name")String name);
	AddrVO getAddrInfo(@Param("id")String id, @Param("phone")String phone);
	void updateAddr(@Param("id")String id, @Param("phone")String phone, @Param("addr")AddrVO addr);
	void insertAddr(@Param("id")String id, @Param("addr")AddrVO addr);
	void deleteAddr(@Param("id")String id, @Param("phone")String phone);
}
