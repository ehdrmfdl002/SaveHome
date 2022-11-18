package com.ssafy.home.apt.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.apt.model.AptCode;
import com.ssafy.home.apt.model.AptInfo;

@Mapper
public interface AptMapper {

	List<AptCode> getSido() throws SQLException;
	List<AptCode> getGugunInSido(String sido) throws SQLException;
	List<AptInfo> getDongInGugun(String gugun) throws SQLException;
	List<AptInfo> getAptInDong(String dong) throws SQLException;
	
}
