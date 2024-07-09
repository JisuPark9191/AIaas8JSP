package com.prac.myapp.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.prac.myapp.addr.model.MemberVO;

@Repository
public class MemberRepository{
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
	
	private class  ClientMapper implements RowMapper<MemberVO>{
		@Override
		public MemberVO mapRow(ResultSet rs,int count) throws SQLException{
			MemberVO clnt = new MemberVO();
			clnt.setId(rs.getString("id"));
			clnt.setPw(rs.getString("pw"));
			clnt.setName(rs.getString("name"));
			clnt.setPhone(rs.getString("phone"));
			clnt.setEmail(rs.getString("email"));
			clnt.setAddress(rs.getString("address"));
			clnt.setRDate(rs.getDate("rDate"));
			clnt.setMemo(rs.getString("memo"));
			return clnt;
		}
	}
	
	public int getClientCount() {
		String sql ="select count(*) from client";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public List<MemberVO> getClientList(String value, String orderby) {
		String sql = "select * from client";
		switch(value) {
		case "date" :
				sql +=" order by id";
			break;
		case "name" :
				sql +=" order by name";
			break;
		case "rDate":
				sql +=" order by rDate";
			break;
		}
		if(orderby.equals("ascend")) {
			sql +=" asc";
		}else if(orderby.equals("descend")) {
			sql +=" desc";
		}
		return jdbcTemplate.query(sql, new RowMapper<MemberVO>() {
			@Override
			public MemberVO mapRow(ResultSet rs, int count)throws SQLException{
				MemberVO clnt = new MemberVO();
				clnt.setId(rs.getString("id"));
				clnt.setPw(rs.getString("pw"));
				clnt.setName(rs.getString("name"));
				clnt.setPhone(rs.getString("phone"));
				clnt.setEmail(rs.getString("email"));
				clnt.setAddress(rs.getString("address"));
				clnt.setRDate(rs.getDate("rDate"));
				clnt.setMemo(rs.getString("memo"));
				return clnt;
			}
		});
	}
	
	public List<MemberVO> getClientNameList(String name) {
		String sql = "select * from client where name=?";
		return jdbcTemplate.query(sql, new RowMapper<MemberVO>() {
			@Override
			public MemberVO mapRow(ResultSet rs, int count)throws SQLException{
				MemberVO clnt = new MemberVO();
				clnt.setId(rs.getString("id"));
				clnt.setPw(rs.getString("pw"));
				clnt.setName(rs.getString("name"));
				clnt.setPhone(rs.getString("phone"));
				clnt.setEmail(rs.getString("email"));
				clnt.setAddress(rs.getString("address"));
				clnt.setRDate(rs.getDate("rDate"));
				clnt.setMemo(rs.getString("memo"));
				return clnt;
			}
		}, name);
	}
	
	public MemberVO getClientInfo(String id) {
		String sql="select id, pw, name, phone, email, address, rDate, memo"
				+" from client where id=?";
		return jdbcTemplate.queryForObject(sql,new ClientMapper(),id);
	}
	
	public void updateClient(MemberVO clnt) {
		String sql = "update client "
				+"set name=?, phone=?, email=?, address=?, rDate=?, memo=? "
				+"where id=?";
		jdbcTemplate.update(sql,
				clnt.getName(),
				clnt.getPhone(),
				clnt.getEmail(),
				clnt.getAddress(),
				clnt.getRDate(),
				clnt.getMemo(),
				clnt.getId()
				);
	}
	
	public void insertClient(MemberVO clnt) {
		String sql = "INSERT INTO client (id, pw, name, phone, email, address, rDate, memo) "
		           + "VALUES (?, ?, ?, ?, ?, ?, SYSDATE, ?)";
		jdbcTemplate.update(sql,
				clnt.getId(),
				clnt.getPw(),
				clnt.getName(),
				clnt.getPhone(),
				clnt.getEmail(),
				clnt.getAddress(),
				clnt.getMemo()
				);
	}
	
	public void deleteClient(String id, String pw) {
		String sql = "delete from client where id=? and pw=?";
		jdbcTemplate.update(sql,id,pw);
	}
	
}
