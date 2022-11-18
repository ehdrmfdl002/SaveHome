package com.ssafy.home.apt.model.service;

import java.util.List;

import com.ssafy.home.apt.model.AptCode;
import com.ssafy.home.apt.model.AptInfo;

public interface AptService {
	List<AptCode> getSido() throws Exception;
	List<AptCode> getGugunInSido(String sido) throws Exception;
	List<AptInfo> getDongInGugun(String gugun) throws Exception;
	List<AptInfo> getAptInDong(String dong) throws Exception;
	
}
