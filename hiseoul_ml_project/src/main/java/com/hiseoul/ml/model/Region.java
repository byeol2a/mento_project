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
@Table(name="tb_region")
@Getter
@Setter
@ToString
public class Region{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "region_uuid")
	private String regionUuid;
	
	private String region_address;
	private String region_latitude;
	private String region_longitude;
	private String region_name;
	private String region_nation;
	private String region_nation_code;
	private String region_post_code;
	private String region_type;
	private Timestamp region_update_date;
	private String region_use_yn;
	private Timestamp region_write_date;
	
	public String getRegionUuid() {
		return regionUuid;
	}	
	public void setRegionUuid(String regionUuid) {
		this.regionUuid = regionUuid;
	}	
	
	public String getRegionAddress() {
		return region_address;
	}
	public void setRegionAddress(String region_address) {
		this.region_address = region_address;
	}
	
	public String getRegionLatitude() {
		return region_latitude;
	}
	public void setRegionLatitude(String region_latitude) {
		this.region_latitude = region_latitude;
	}
	
	public String getRegionLongitude() {
		return region_longitude;
	}
	public void setRegionLongitude(String region_longitude) {
		this.region_longitude = region_longitude;
	}
	
	public String getRegionName() {
		return region_name;
	}
	public void setRegionName(String region_name) {
		this.region_name = region_name;
	}
		
	public String getRegionNation() {
		return region_nation;
	}
	public void setRegionNation(String region_nation) {
		this.region_nation = region_nation;
	}
		
	public String getRegionNationCode() {
		return region_nation_code;
	}
	public void setRegionNationCode(String region_nation_code) {
		this.region_nation_code = region_nation_code;
	}	
	
	public String getRegionPostCode() {
		return region_post_code;
	}
	public void setRegionPostCode(String region_post_code) {
		this.region_post_code = region_post_code;
	}	

	public String getRegionType() {
		return region_type;
	}
	public void setRegionType(String region_type) {
		this.region_type = region_type;
	}
	
	public Timestamp getRegionUpdatedate() {
		return region_update_date;
	}
	public void setRegionUpdatedate(Timestamp region_update_date) {
		this.region_update_date = region_update_date;
	}
	
	public String getRegionUseyn() {
		return region_use_yn;
	}
	public void setRegionUseyn(String region_use_yn) {
		this.region_use_yn = region_use_yn;
	}
	
	public Timestamp getRegionWritedate() {
		return region_write_date;
	}
	public void setRegionWritedate(Timestamp region_write_date) {
		this.region_write_date = region_write_date;
	}
}
