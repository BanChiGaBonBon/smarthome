package com.example.furniture.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorCodeConfig implements ErrorPageRegistrar {
    /**
     * Register pages as required with the given registry.
     *
     * @param registry the error page registry
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/error/403")
                , new ErrorPage(HttpStatus.NOT_FOUND, "/error/404")
                , new ErrorPage(HttpStatus.GATEWAY_TIMEOUT, "/error/504")
                , new ErrorPage(HttpStatus.HTTP_VERSION_NOT_SUPPORTED, "/error/505"));
    }
}
