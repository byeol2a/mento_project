package com.hiseoul.ml.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tb_menu_cate")
@Getter
@Setter
@ToString
public class MenuCate{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "cate_no")
	private Integer cateNo;
	
	private String menu_name;
	private Integer menu_perm;
	private Integer parant_no;
	private String uri;
	private String menu_use_yn;
	private Timestamp write_date;
	private Timestamp update_date;
	
	public Integer getCateno() {
		return cateNo;
	}	
	public void setNo(Integer cateNo) {
		this.cateNo = cateNo;
	}	
	public String getMenuname() {
		return menu_name;
	}
	public void setMenuname(String menu_name) {
		this.menu_name = menu_name;
	}
	public Integer getMenuperm() {
		return menu_perm;
	}
	public void setMenuperm(Integer menu_perm){
		this.menu_perm = menu_perm;
	}
	public Integer getParantno() {
		return parant_no;
	}
	public void setParantno(Integer parant_no) {
		this.parant_no = parant_no;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri){
		this.uri = uri;
	}
	public String getMenuuseyn() {
		return menu_use_yn;
	}
	public void setMenuuseyn(String menu_use_yn) {
		this.menu_use_yn = menu_use_yn;
	}	
	public Timestamp getWritedate() {
		return write_date;
	}
	public void setWritedate(Timestamp write_date) {
		this.write_date = write_date;
	}	
	public Timestamp getUpdatedate() {
		return update_date;
	}
	public void setUpdatedate(Timestamp update_date) {
		this.update_date = update_date;
	}	
}

