package service;

import javax.servlet.http.Part;

import dto.Member;

public interface MemberService {
	void join(Member member, String uploadPath, Part profile) throws Exception;
	Member login(String id, String password) throws Exception;
}
