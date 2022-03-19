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
@Table(name="tb_biz_model")
@Getter
@Setter
@ToString
public class BizModel{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "biz_model_uuid")
	private String bizModelUuid;
	
	private String biz_model_contents;
	private String biz_model_name;
	private String biz_model_type;
	private Timestamp biz_model_update_date;
	private String biz_model_use_yn;
	private Timestamp biz_model_write_date;
	
	public String getBizModelUuid() {
		return bizModelUuid;
	}	
	public void setBizModelUuid(String bizModelUuid) {
		this.bizModelUuid = bizModelUuid;
	}	
	
	public String getBizModelContents() {
		return biz_model_contents;
	}
	public void setBizModelContents(String biz_model_contents) {
		this.biz_model_contents = biz_model_contents;
	}
	
	public String getBizModelName() {
		return biz_model_name;
	}
	public void setBizModelName(String biz_model_name) {
		this.biz_model_name = biz_model_name;
	}

	public String getBizModelType() {
		return biz_model_type;
	}
	public void setBizModelType(String biz_model_type) {
		this.biz_model_type = biz_model_type;
	}
	
	public Timestamp getBizModelUpdatedate() {
		return biz_model_update_date;
	}
	public void setBizModelUpdatedate(Timestamp biz_model_update_date) {
		this.biz_model_update_date = biz_model_update_date;
	}
	
	public String getBizModelUseyn() {
		return biz_model_use_yn;
	}
	public void setBizModelUseyn(String biz_model_use_yn) {
		this.biz_model_use_yn = biz_model_use_yn;
	}
	
	public Timestamp getBizModelWritedate() {
		return biz_model_write_date;
	}
	public void setBizModelWritedate(Timestamp biz_model_write_date) {
		this.biz_model_write_date = biz_model_write_date;
	}
}
