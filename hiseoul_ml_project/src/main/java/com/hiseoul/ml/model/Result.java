package com.hiseoul.ml.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Result {
	private ErrorResponse error;
	private Object payload;
	public ErrorResponse getError() {
		return error;
	}
	public void setError(ErrorResponse error) {
		this.error = error;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}
}