package com.example.frontend;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class GuestbookMessage extends RepresentationModel<GuestbookMessage> {
	private Long id;

	private String name;

	private String message;

	private String imageUri;
	
	public GuestbookMessage() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}



}
