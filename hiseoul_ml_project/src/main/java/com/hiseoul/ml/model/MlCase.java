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
@Table(name="tb_ml_case")
@Getter
@Setter
@ToString
public class MlCase{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "ml_case_uuid")
	private String mlCaseUuid;
	
	@Column(name = "ml_case_biz_model_uuid")
	private String mlCaseBizModelUuid;

	@Column(name = "ml_case_cctv_uuid")
	private String mlCaseCctvUuid;
	
	private String ml_case_count;
	private String ml_case_ml_number;
	private String ml_case_name;
	
	private String ml_case_pre_count;

	@Column(name = "ml_case_region_uuid")
	private String mlCaseRegionUuid;
	
	private String ml_case_type;
	private Timestamp ml_case_update_date;
	private String ml_case_use_yn;
	private Timestamp ml_case_write_date;
	
	public String getMlcaseUuid() {
		return mlCaseUuid;
	}	
	public void setMlcaseUuid(String mlCaseUuid) {
		this.mlCaseUuid = mlCaseUuid;
	}	
	
	public String getMlcaseBizModelUuid() {
		return mlCaseBizModelUuid;
	}
	public void setMlcaseBizModelUuid(String mlCaseBizModelUuid) {
		this.mlCaseBizModelUuid = mlCaseBizModelUuid;
	}
	public String getMlcaseCctvUuid() {
		return mlCaseCctvUuid;
	}
	public void setMlcaseCctvUuid(String mlCaseCctvUuid){
		this.mlCaseCctvUuid = mlCaseCctvUuid;
	}
	public String getMlcaseCount() {
		return ml_case_count;
	}
	public void setMlcaseCount(String ml_case_count) {
		this.ml_case_count = ml_case_count;
	}
	public String getMlcaseMlnumber() {
		return ml_case_ml_number;
	}
	public void setMlcaseMlnumber(String ml_case_ml_number){
		this.ml_case_ml_number = ml_case_ml_number;
	}
	public String getMlcaseName() {
		return ml_case_name;
	}
	public void setMlcaseName(String ml_case_name) {
		this.ml_case_name = ml_case_name;
	}
	
	public String getMlcasePrecount() {
		return ml_case_pre_count;
	}
	public void setMlcasePrecount(String ml_case_pre_count) {
		this.ml_case_pre_count = ml_case_pre_count;
	}
	public String getMlcaseRegionUuid() {
		return mlCaseRegionUuid;
	}
	public void setMlcaseRegionUuid(String mlCaseRegionUuid){
		this.mlCaseRegionUuid = mlCaseRegionUuid;
	}
	public String getMlcaseType() {
		return ml_case_type;
	}
	public void setMlcaseType(String ml_case_type) {
		this.ml_case_type = ml_case_type;
	}
	
	public Timestamp getMlcaseUpdatedate() {
		return ml_case_update_date;
	}
	public void setMlcaseUpdatedate(Timestamp ml_case_update_date) {
		this.ml_case_update_date = ml_case_update_date;
	}	
	public String getMlcaseUseyn() {
		return ml_case_use_yn;
	}
	public void setMlcaseUseyn(String ml_case_use_yn) {
		this.ml_case_use_yn = ml_case_use_yn;
	}
	
	public Timestamp getMlcaseWritedate() {
		return ml_case_write_date;
	}
	public void setMlcaseWritedate(Timestamp ml_case_write_date) {
		this.ml_case_write_date = ml_case_write_date;
	}
}
