package com.prac.myapp.client.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.prac.myapp.addr.model.ClientVO;

@Repository
public class ClientRepository implements IClientRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class  ClientMapper implements RowMapper<ClientVO>{
		@Override
		public ClientVO mapRow(ResultSet rs,int count) throws SQLException{
			ClientVO clnt = new ClientVO();
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
	
	public List<ClientVO> getClientList(String value, String orderby) {
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
		return jdbcTemplate.query(sql, new RowMapper<ClientVO>() {
			@Override
			public ClientVO mapRow(ResultSet rs, int count)throws SQLException{
				ClientVO clnt = new ClientVO();
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
	
	public List<ClientVO> getClientNameList(String name) {
		String sql = "select * from client where name=?";
		return jdbcTemplate.query(sql, new RowMapper<ClientVO>() {
			@Override
			public ClientVO mapRow(ResultSet rs, int count)throws SQLException{
				ClientVO clnt = new ClientVO();
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
	
	public ClientVO getClientInfo(String id) {
		String sql="select id, pw, name, phone, email, address, rDate, memo"
				+" from client where id=?";
		return jdbcTemplate.queryForObject(sql,new ClientMapper(),id);
	}
	
	public void updateClient(ClientVO clnt) {
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
	
	public void insertClient(ClientVO clnt) {
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
	
//	//Client 이름으로 DB생성하기
//	public void createDB(String id) {
//		String table_id = id;
//		String sql = "CREATE TABLE " + table_id + " ("
//                + "id VARCHAR2(20), "
//                + "name VARCHAR2(20), "
//                + "phone VARCHAR2(20), "
//                + "email VARCHAR2(30), "
//                + "address VARCHAR2(50), "
//                + "addrGroup VARCHAR2(20), "
//                + "PRIMARY KEY(phone), "
//                + "CONSTRAINT " + id + "_fk FOREIGN KEY(id) REFERENCES client(id) "
//                + "ON DELETE CASCADE);";
//		jdbcTemplate.update(sql);
//	}
	
	public void deleteClient(String id, String pw) {
		String sql = "delete from client where id=? and pw=?";
		jdbcTemplate.update(sql,id,pw);
	}
	
}
