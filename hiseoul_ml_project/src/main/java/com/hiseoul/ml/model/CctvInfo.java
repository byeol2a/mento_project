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
@Table(name="tb_cctv_info")
@Getter
@Setter
@ToString
public class CctvInfo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "cctv_uuid")
	private String cctvUuid;
	
	private String cctv_active_status;
	private String cctv_marker;
	private String cctv_model;
	private String cctv_name;
	private String cctv_product_company;
	private String cctv_resolution;
	private String cctv_type;
	private Timestamp cctv_update_date;
	private String cctv_use_yn;
	private Timestamp cctv_write_date;
	
	public String getCctvUuid() {
		return cctvUuid;
	}	
	public void setCctvUuid(String cctvUuid) {
		this.cctvUuid = cctvUuid;
	}	
	
	public String getCctvActiveStatus() {
		return cctv_active_status;
	}
	public void setCctvActiveStatus(String cctv_active_status) {
		this.cctv_active_status = cctv_active_status;
	}
	
	public String getCctvMarker() {
		return cctv_marker;
	}
	public void setCctvMarker(String cctv_marker) {
		this.cctv_marker = cctv_marker;
	}
	
	public String getCctvModel() {
		return cctv_model;
	}
	public void setCctvModel(String cctv_model) {
		this.cctv_model = cctv_model;
	}
	
	public String getCctvName() {
		return cctv_name;
	}
	public void setCctvName(String cctv_name) {
		this.cctv_name = cctv_name;
	}
		
	public String getCctvProductCompany() {
		return cctv_product_company;
	}
	public void setCctvProductCompany(String cctv_product_company) {
		this.cctv_product_company = cctv_product_company;
	}
		
	public String getCctvResolution() {
		return cctv_resolution;
	}
	public void setCctvResolution(String cctv_resolution) {
		this.cctv_resolution = cctv_resolution;
	}	
	
	public String getCctvType() {
		return cctv_type;
	}
	public void setCctvType(String cctv_type) {
		this.cctv_type = cctv_type;
	}	
	
	public Timestamp getCctvUpdatedate() {
		return cctv_update_date;
	}
	public void setCctvUpdatedate(Timestamp cctv_update_date) {
		this.cctv_update_date = cctv_update_date;
	}
	
	public String getCctvUseyn() {
		return cctv_use_yn;
	}
	public void setCctvUseyn(String cctv_use_yn) {
		this.cctv_use_yn = cctv_use_yn;
	}
	
	public Timestamp getCctvWritedate() {
		return cctv_write_date;
	}
	public void setCctvWritedate(Timestamp cctv_write_date) {
		this.cctv_write_date = cctv_write_date;
	}
}
