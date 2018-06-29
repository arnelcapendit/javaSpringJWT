package com.example;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    /* Maps to all HTTP actions by default (GET,POST,..)*/
    @RequestMapping("/users")
    public @ResponseBody String getUsers(HttpServletResponse response) throws IOException {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if (!(auth instanceof AnonymousAuthenticationToken)) {
    		System.out.println("Authenticated");
    		return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
                    "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
		}else {
			System.out.println("NotAuthenticated");
			response.sendRedirect("https://www.google.com");
		}		
    	return null;
    }
}