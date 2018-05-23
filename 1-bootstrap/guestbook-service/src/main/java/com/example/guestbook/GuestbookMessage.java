package com.example.guestbook;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class GuestbookMessage {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String message;
	
	private String imageUri;
}

