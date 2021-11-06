package com.kaev.IEscheduler.authentication;

import org.springframework.security.core.Authentication;

public interface myAuthenticationFacade {
    Authentication getAuthentication();
}
