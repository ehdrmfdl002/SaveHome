package com.ssafy.home.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.home.member.model.Member;
import com.ssafy.home.member.model.service.JwtServiceImpl;
import com.ssafy.home.member.model.service.MemberService;


@CrossOrigin("*")
@RestController
@RequestMapping("/member")
public class MemberController {
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private MemberService memberservice;
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	public MemberController(MemberService memberservice) {
		this.memberservice = memberservice;
	}
	
	@Autowired
	private JwtServiceImpl jwtservice;
	
	@GetMapping("/allInfo")
	private ResponseEntity<?> list() throws Exception {
		System.out.println("list");
		return new ResponseEntity<>(memberservice.selectAll(), HttpStatus.OK);
	}
	
	@PostMapping(("/signup"))
	private ResponseEntity<?> signUp(@RequestBody Member member) throws Exception {
		System.out.println("signup");
		return new ResponseEntity<>(memberservice.insertUser(member), HttpStatus.OK);
	}
	
//	@PostMapping("/login")
//	private ResponseEntity<?> login(@RequestBody Member member) throws Exception {
//		System.out.println("login");
//		String id = member.getId();
//		String password = member.getPassword();
//		
//		Member tmp = memberservice.selectById(id);
//		if (member != null && tmp.getPassword().equals(password)) {
//			return new ResponseEntity<>("true", HttpStatus.OK);
//		} 
//		else 
//			return new ResponseEntity<>("false", HttpStatus.OK);
//	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Member member) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		System.out.println(member.toString());
		try {
			Member loginUser = memberservice.login(member);
			if (loginUser != null) {
				String accessToken = jwtservice.createAccessToken("userid", loginUser.getId());// key, data
				String refreshToken = jwtservice.createRefreshToken("userid", loginUser.getId());// key, data
				memberservice.saveRefreshToken(member.getId(), refreshToken);
				logger.debug("로그인 accessToken 정보 : {}", accessToken);
				logger.debug("로그인 refreshToken 정보 : {}", refreshToken);
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<>(resultMap, status);
	}

	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody Member member, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		logger.debug("token : {}, memberDto : {}", token, member);
		if (jwtservice.checkToken(token)) {
			if (token.equals(memberservice.getRefreshToken(member.getId()))) {
				String accessToken = jwtservice.createAccessToken("userid", member.getId());
				logger.debug("token : {}", accessToken);
				logger.debug("정상적으로 액세스토큰 재발급!!!");
				resultMap.put("access-token", accessToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
		} else {
			logger.debug("리프레쉬토큰도 사용불!!!!!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@PostMapping("/findPass")
	private ResponseEntity<?> findForm(@RequestBody Member member) throws Exception {
		String id = member.getId();
		String name = member.getName();
		String email = member.getEmail();
		Member tmp = memberservice.selectById(id);
		if(tmp != null && tmp.getName().equals(name) && tmp.getEmail().equals(email)) {
			return new ResponseEntity<>("true", HttpStatus.OK);			
		}
		else
			return new ResponseEntity<>("false", HttpStatus.OK);
	}
	
//	@GetMapping("/info/{id}")
//	private ResponseEntity<?> info(@PathVariable String id) throws Exception {
//		return new ResponseEntity<>(memberservice.selectById(id), HttpStatus.OK);
//	}
	
	@GetMapping("/info/{id}")
	public ResponseEntity<?> getInfo(@PathVariable String id, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		System.out.println("아이디찾기 호출");
		System.out.println(id);
		System.out.println(request.getHeader("access-token"));
		if (jwtservice.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				Member memberDto = memberservice.selectById(id);
				resultMap.put("userInfo", memberDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<>(resultMap, status);
	}
	
	@PutMapping("/changePass/{id}")
	private ResponseEntity<?> passChange(@RequestBody Member member, @PathVariable String id) throws Exception {
		Member tmp = memberservice.selectById(id);
		tmp.setPassword(member.getPassword());
		return new ResponseEntity<> (memberservice.updateUser(tmp), HttpStatus.OK);
	}
	
	@PutMapping("/changeinfo/{id}")
	private ResponseEntity<?> update(@RequestBody Member member, @PathVariable String id) throws Exception {
		member.setId(id);
		return new ResponseEntity<>(memberservice.updateUser(member), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<?> delete(@PathVariable String id) throws Exception {
		return new ResponseEntity<>(memberservice.deleteById(id), HttpStatus.OK);
	}
	
	@GetMapping("/logout/{id}")
	public ResponseEntity<?> removeToken(@PathVariable String id) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			memberservice.deleRefreshToken(id);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("로그아웃 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);

	}
}
