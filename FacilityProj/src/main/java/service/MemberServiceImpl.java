package service;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}

	@Override
	public void join(Member member) throws Exception {
		memberDao.insertMember(member);
	}

	@Override
	public Member login(String id, String password) throws Exception {
		Member member = memberDao.selectMember(id);
		if(member==null) throw new Exception("아이디 오류입니다.");
		if(!member.getPassword().equals(password)) throw new Exception("비밀번호 오류입니다.");
		member.setPassword("");
		return member;
	}
	
	@Override
	public boolean checkMemberId(String id) throws Exception {
		return memberDao.selectMember(id)!=null;
	}
}