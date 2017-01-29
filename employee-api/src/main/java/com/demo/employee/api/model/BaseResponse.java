package com.demo.employee.api.model;

import javax.xml.bind.annotation.XmlElement;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BaseResponse<T> {

	private String status;

	private T result;

	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public BaseResponse() {
		
	}

	@XmlElement(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlElement(name = "result")
	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public BaseResponse(String status, T result) {
		this.status = status;
		this.result = result;
	}
}
