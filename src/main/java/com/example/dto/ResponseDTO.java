package com.example.dto;

public class ResponseDTO {
	private String responseMessage;
	
	public ResponseDTO(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public ResponseDTO() {
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
