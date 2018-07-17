package com.example.guestbook;

import lombok.*;
import org.springframework.cloud.gcp.data.spanner.core.mapping.*;
import org.springframework.data.annotation.Id;

@Data
@Table(name = "guestbook_message")
public class GuestbookMessage {
	@PrimaryKey
	@Id
	private String id;

	private String name;
	
	private String message;

	@Column(name = "image_uri")
	private String imageUri;

	public GuestbookMessage() {
		this.id = java.util.UUID.randomUUID().toString();
	}
}
