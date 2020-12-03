package com.iCleanApi.Dominio.DTO;

public class PostNotificationDTO {
	
	private String to;
	private String title;
	private String body;
	private DataLimpezaDTO data;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public DataLimpezaDTO getData() {
		return data;
	}
	public void setData(DataLimpezaDTO data) {
		this.data = data;
	}
}
