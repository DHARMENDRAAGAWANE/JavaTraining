package com.mt.daretotry.entity.security.service;

public interface TokenService {

    String getToken(String username, String password);
}
