package service;

import dto.Member;

public interface MemberService {
	void join(Member member) throws Exception;
	Member login(String id, String password) throws Exception;
	boolean checkMemberId(String id) throws Exception;
}
