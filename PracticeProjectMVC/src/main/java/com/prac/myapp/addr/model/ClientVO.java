package com.prac.myapp.addr.model;

import java.sql.Date;
import lombok.Data;

@Data
public class ClientVO {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private String address;
	private Date rDate;
	private String memo;
}
