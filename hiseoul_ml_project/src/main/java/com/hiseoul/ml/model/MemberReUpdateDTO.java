package com.hiseoul.ml.model;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberReUpdateDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer no;
	private String pass;
	private String name;
	private String email;
	private String instance_yn;
	private Timestamp write_date;
	private Timestamp update_date;
	private String active_yn;
	private Integer permission;
	private Integer auth;
	private String authkey; //
	
		
	public Integer getNo() {
		return no;
	}	
	public void setNo(Integer no) {
		this.no = no;
	}	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass){
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getInstanceyn() {
		return instance_yn;
	}
	public void setInstanceyn(String instance_yn) {
		this.instance_yn = instance_yn;
	}	
	public Timestamp getWritedate() {
		return write_date;
	}
	public void setWritedate(Timestamp write_date) {
		this.write_date = write_date;
	}	
	public Timestamp getUpdate() {
		return update_date;
	}
	public void setUpdate(Timestamp update_date) {
		this.update_date = update_date;
	}
	public String getActiveyn() {
		return active_yn;
	}
	public void setActiveyn(String active_yn) {
		this.active_yn = active_yn;
	}
	public Integer getPermission() {
		return permission;
	}	
	public void setPermission(Integer permission) {
		this.permission = permission;
	}
	public Integer getAuth() {
		return auth;
	}	
	public void setAuth(Integer auth) {
		this.auth = auth;
	}	

	@Override
	public String toString() {
		return "MemberReUpdateDTO{" +
		           "no=" + no +
		           ", pass='" + pass + '\'' +
		           ", name='" + name + '\'' +
		           ", email='" + email + '\'' +
		           ", instance_yn='" + instance_yn + '\'' +
		           ", write_date='" + write_date + '\'' +
		           ", update_date='" + update_date + '\'' +	    
		           ", active_yn='" + active_yn + '\'' +
		           ", permission='" + permission + '\'' + 	           
		           ", auth='" + auth + '\'' +
		           ", authkey='" + authkey + '\'' +
		           '}';
	}
	public String getAuthkey() {
		return authkey;
	}
	public void setAuthkey(String authkey) {
		this.authkey = authkey;
	}
}
