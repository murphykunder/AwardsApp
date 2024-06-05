package com.awards.app.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	private String errorMessage;
	private LocalDateTime dateTime;

	public ErrorDetails(String message, LocalDateTime dateTime) {
		super();
		this.errorMessage = message;
		this.dateTime = dateTime;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String message) {
		this.errorMessage = message;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

}
