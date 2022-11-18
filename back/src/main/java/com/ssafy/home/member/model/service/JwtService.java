package com.ssafy.home.member.model.service;

import java.util.Map;

import com.ssafy.home.member.model.Member;

public interface JwtService {
	<T> String createAccessToken(String key, T data);
	<T> String createRefreshToken(String key, T data);
	<T> String create(String key, T data, String subject, long expir);
	Map<String, Object> get(String key);
	String getUserId();
	boolean checkToken(String jwt);
}
