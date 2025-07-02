package com.example.java.urlshortner.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.java.urlshortner.domain.model.ShortUrlDto;
import com.example.java.urlshortner.domain.repositories.ShortUrlRepository;


@Service
public class ShortUrlService {
	
	private final ShortUrlRepository shortUrlRepository;
	private final EntityMapper entityMapper;

	public ShortUrlService(ShortUrlRepository shortUrlRepository, EntityMapper entityMapper) {
		this.shortUrlRepository = shortUrlRepository;
		this.entityMapper = entityMapper;
	}
	
	public List<ShortUrlDto> findAllPublicShortUrls(){
		return shortUrlRepository.findPublicShortUrls()
				.stream().map(entityMapper::toShortUrlDto).toList();
	}
	
	

}
