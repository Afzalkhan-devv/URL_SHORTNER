package com.example.java.urlshortner.services;

import org.springframework.stereotype.Component;

import com.example.java.urlshortner.domain.entities.ShortUrl;
import com.example.java.urlshortner.domain.entities.User;
import com.example.java.urlshortner.domain.model.ShortUrlDto;
import com.example.java.urlshortner.domain.model.UserDto;

@Component
public class EntityMapper {
	
	 public ShortUrlDto toShortUrlDto(ShortUrl shortUrl) {
	        UserDto userDto = null;
	        if(shortUrl.getCreatedBy() != null) {
	            userDto = toUserDto(shortUrl.getCreatedBy());
	        }

	        return new ShortUrlDto(
	                shortUrl.getId(),
	                shortUrl.getShortKey(),
	                shortUrl.getOriginalUrl(),
	                shortUrl.getIsPrivate(),
	                shortUrl.getExpiresAt(),
	                userDto,
	                shortUrl.getClickCount(),
	                shortUrl.getCreatedAt()
	        );
	    }

	    public UserDto toUserDto(User user) {
	        return new UserDto(user.getId(), user.getName());
	    }
	}