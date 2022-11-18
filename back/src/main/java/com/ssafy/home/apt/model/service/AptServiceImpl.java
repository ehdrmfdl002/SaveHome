package com.ssafy.home.apt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.apt.model.AptCode;
import com.ssafy.home.apt.model.AptInfo;
import com.ssafy.home.apt.model.mapper.AptMapper;

@Service
public class AptServiceImpl implements AptService {

	private AptMapper aptMapper;

	@Autowired
	public AptServiceImpl(AptMapper aptMapper) {
		this.aptMapper = aptMapper;
	}

	@Override
	public List<AptCode> getSido() throws Exception {
		return aptMapper.getSido();
	}

	@Override
	public List<AptCode> getGugunInSido(String sido) throws Exception {
		return aptMapper.getGugunInSido(sido);
	}

	@Override
	public List<AptInfo> getDongInGugun(String gugun) throws Exception {
		return aptMapper.getDongInGugun(gugun);
	}

	@Override
	public List<AptInfo> getAptInDong(String dong) throws Exception {
		return aptMapper.getAptInDong(dong);
	}

}
