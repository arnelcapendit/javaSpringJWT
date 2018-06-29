package com.javadeveloperzone;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * Created by Lenovo on 17-12-2017.
 */
@Component
public class WebSecurity {
    public boolean checkUserId(UsernamePasswordAuthenticationToken authentication, Integer id) {
        System.out.println("home");
				return false;
    }
}
