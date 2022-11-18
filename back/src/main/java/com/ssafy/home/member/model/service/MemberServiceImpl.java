package com.ssafy.home.member.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.member.model.Member;
import com.ssafy.home.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberMapper memberMapper;
	
	@Autowired
	public MemberServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	@Override
	public Member selectById(String id) throws Exception {
		return memberMapper.select(id);
	}

	@Override
	public int deleteById(String id) throws Exception {
		return memberMapper.delete(id);
	}

	@Override
	public int updateUser(Member member) throws Exception {
		return memberMapper.update(member);
	}

	@Override
	public int insertUser(Member member) throws Exception {
		return memberMapper.insert(member);
	}

	@Override
	public List<Member> selectAll() throws Exception {
		return memberMapper.selectAll();
	}

	@Override
	public Member login(Member member) throws Exception {
		if(member.getId() == null || member.getPassword() == null)
			return null;
		return memberMapper.login(member);
	}

	@Override
	public void saveRefreshToken(String id, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("token", refreshToken);
		memberMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String id) throws Exception {
		return memberMapper.getRefreshToken(id);
	}

	@Override
	public void deleRefreshToken(String id) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("token", null);
		memberMapper.deleteRefreshToken(map);
	}
	
}
