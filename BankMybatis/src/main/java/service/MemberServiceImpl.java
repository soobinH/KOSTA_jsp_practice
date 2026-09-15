package service;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService{
	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}
	
	public void join(Member member)throws Exception{
		Member smember =memberDao.selectMember(member.getId());
		if(smember!=null)throw new Exception("아이디가 중복됩니다.");
		memberDao.insertMember(member);
	}
	
	public Member login(String id, String password) throws Exception {
		Member member = memberDao.selectMember(id);
		if(member == null) throw new Exception("아이디가 틀립니다.");
		if(!member.getPassword().trim().equals(password.trim())) throw new Exception("비밀번호가 틀립니다.");
		member.setPassword("");
		return member;
	}
	
	public boolean checkDoubleId(String id) throws Exception {
		Member member = memberDao.selectMember(id);
		return member!=null;
	}
}
