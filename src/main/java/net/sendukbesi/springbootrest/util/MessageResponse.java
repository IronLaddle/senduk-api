package net.sendukbesi.springbootrest.util;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class MessageResponse {
	
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Timestamp timestamp;

	private int status;

	private String code;

	private String message;
	
	private Object response;


	public MessageResponse() {
	}

	public MessageResponse(SendukErrorCodeEnum SendukEnum, Object response) {
		this.timestamp = new Timestamp(new Date().getTime());
		this.status = SendukEnum.getCode();
		this.code = SendukEnum.name();
		this.message = SendukEnum.getMessage();
		this.response = response;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

}
