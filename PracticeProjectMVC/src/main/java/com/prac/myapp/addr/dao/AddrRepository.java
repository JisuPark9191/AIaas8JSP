package com.prac.myapp.addr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.prac.myapp.addr.model.AddrVO;

@Repository
public class AddrRepository implements IAddrRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class AddrMapper implements RowMapper<AddrVO>{
		@Override
		public AddrVO mapRow(ResultSet rs,int count) throws SQLException{
			AddrVO addr = new AddrVO();
			addr.setId(rs.getString("id"));
			addr.setName(rs.getString("name"));
			addr.setPhone(rs.getString("phone"));
			addr.setEmail(rs.getString("email"));
			addr.setAddress(rs.getString("address"));
			addr.setAddrGroup(rs.getString("addrGroup"));
			return addr;
		}
	}
	
	public int getAddrCount(String id) {
		String sql = "select count(*) from "+id;
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public List<AddrVO> getAddrList(String id, String value, String orderby) {
		String sql = "select * from address where id=?";
		switch(value) {
		case "date" :
				sql +=" order by id";
			break;
		case "name" :
				sql +=" order by name";
			break;
		case "addrGroup":
				sql +=" order by addrGroup";
			break;
		}
		if(orderby.equals("ascend")) {
			sql +=" asc";
		}else if(orderby.equals("descend")) {
			sql +=" desc";
		}
		return jdbcTemplate.query(sql, new RowMapper<AddrVO>() {
			@Override
			public AddrVO mapRow(ResultSet rs,int count) throws SQLException{
				AddrVO addr = new AddrVO();
				addr.setId(rs.getString("id"));
				addr.setName(rs.getString("name"));
				addr.setPhone(rs.getString("phone"));
				addr.setEmail(rs.getString("email"));
				addr.setAddress(rs.getString("address"));
				addr.setAddrGroup(rs.getString("addrGroup"));
				return addr;
			}
		},id);
	}
	
	public List<AddrVO> getAddrNameList(String id, String name){
		String sql = "select * from address where id=? and name =?";
		return jdbcTemplate.query(sql, new RowMapper<AddrVO>(){
			@Override
			public AddrVO mapRow(ResultSet rs,int count) throws SQLException{
				AddrVO addr = new AddrVO();
				addr.setId(rs.getString("id"));
				addr.setName(rs.getString("name"));
				addr.setPhone(rs.getString("phone"));
				addr.setEmail(rs.getString("email"));
				addr.setAddress(rs.getString("address"));
				addr.setAddrGroup(rs.getString("addrGroup"));
				return addr;
			}
		},id, name);
	}
	
	public AddrVO getAddrInfo(String id, String phone) {
		String sql = "select id, name, phone, email, address, addrGroup from address"
				+ " where id=? and phone=?";
		return jdbcTemplate.queryForObject(sql,new AddrMapper(),id,phone);
	}
	
	public void updateAddr(String id, String phone, AddrVO addr) {
		String sql = "update address set name=?, email=?, address=?, addrGroup=?"
						+" where id=? and phone=?";
		jdbcTemplate.update(sql,
				addr.getName(),
				addr.getEmail(),
				addr.getAddress(),
				addr.getAddrGroup(),
				id,
				phone
				);
	}
	
	public void insertAddr(String id, AddrVO addr) {
		String sql = "insert into address (id, name, phone, email, address, addrGroup)"
				   +" values (?,?,?,?,?,?)";
		jdbcTemplate.update(sql,
				id,
				addr.getName(),
				addr.getPhone(),
				addr.getEmail(),
				addr.getAddress(),
				addr.getAddrGroup()
			);
	}
	
	public void deleteAddr(String id, String phone) {
		String sql ="delete from address where id = ? and phone = ?";
		jdbcTemplate.update(sql,id,phone);
	}
}
