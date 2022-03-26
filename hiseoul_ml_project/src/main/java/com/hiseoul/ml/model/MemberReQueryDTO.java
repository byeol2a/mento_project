package com.hiseoul.ml.model;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

@Getter
public class MemberReQueryDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer no;
	private String id;
	private String pass;
	private String name;
	private String email;
	private String instance_yn;
	private Timestamp write_date;
	private Timestamp update_date;
	private String active_yn;
	private Integer permission;
	private Integer auth;
	
	public MemberReQueryDTO(Integer no, String id, String pass, String name, String email, String instance_yn, Timestamp write_date, Timestamp update_date, String active_yn, Integer permission, Integer auth) {
		this.no = no;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.instance_yn = instance_yn;
		this.write_date = write_date;
		this.update_date = update_date;
		this.active_yn = active_yn;
		this.permission = permission;
		this.auth = auth;	
	}	
	public Integer getNo() {
		return no;
	}	
	public String getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getInstanceyn() {
		return instance_yn;
	}
	public Timestamp getWritedate() {
		return write_date;
	}
	public Timestamp getUpdate() {
		return update_date;
	}
	public String getActiveyn() {
		return active_yn;
	}
	public Integer getPermission() {
		return permission;
	}	
	public Integer getAuth() {
		return auth;
	}	
	@Override
	public String toString() {
		return "MemberReQueryDTO{" +
	           "no=" + no +
	           ", id='" + id + '\'' +
	           ", pass='" + pass + '\'' +
	           ", name='" + name + '\'' +
	           ", email='" + email + '\'' +
	           ", instance_yn='" + instance_yn + '\'' +
	           ", write_date='" + write_date + '\'' +
	           ", update_date='" + update_date + '\'' +	    
	           ", active_yn='" + active_yn + '\'' +
	           ", permission='" + permission + '\'' + 	           
	           ", auth='" + auth + '\'' +
	           '}';
	}
}
