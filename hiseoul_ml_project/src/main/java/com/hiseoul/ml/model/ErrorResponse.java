package com.hiseoul.ml.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class ErrorResponse{
	private Integer code;
	private String message;
	
	public ErrorResponse(String message) {
		this.setMessage(message);
	}
	public String getMessage(String message) {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getCord() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
}