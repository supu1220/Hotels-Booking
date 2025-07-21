package com.bookingservice.dto;

public class StripeResponse {

    private String status;
    private String message;
    public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getSessionUrl() {
		return sessionUrl;
	}
	public void setSessionUrl(String sessionUrl) {
		this.sessionUrl = sessionUrl;
	}
	private String sessionId;
    private String sessionUrl;
}
