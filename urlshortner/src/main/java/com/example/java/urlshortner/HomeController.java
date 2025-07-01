package com.example.java.urlshortner;
 

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.java.urlshortner.domain.entities.ShortUrl;
import com.example.java.urlshortner.domain.repositories.ShortUrlRepository;
import com.example.java.urlshortner.services.ShortUrlService;

import java.util.List;
@Controller
public class HomeController {
	
	private final ShortUrlService shortUrlService;
	
	public HomeController(ShortUrlService shortUrlService) {
		this.shortUrlService = shortUrlService;
	}


	@GetMapping("/")

    public String home(Model model) {
		List<ShortUrl> shortUrls = shortUrlService.findAllPublicShortUrls();
        model.addAttribute("shortUrls", shortUrls);
        model.addAttribute("baseUrl","http://localhost:8080/");
        return "index";

    }
 
 
  

}
 