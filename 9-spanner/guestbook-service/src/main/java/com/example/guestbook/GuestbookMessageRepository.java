package com.example.guestbook;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GuestbookMessageRepository extends
	PagingAndSortingRepository<GuestbookMessage, String> {

		List<GuestbookMessage> findByName(String name);
}
