package service;

import java.io.File;
import java.nio.file.Paths;

import javax.servlet.http.Part;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao=new MemberDaoImpl();
	}

	@Override
	public void join(Member member, String uploadPath, Part profile) throws Exception {
		String fileName = Paths.get(profile.getSubmittedFileName()).getFileName().toString();
		
		if(profile!=null &&fileName!=null&&!fileName.isEmpty()) {
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists()) uploadDir.mkdir();
			profile.write(uploadPath+File.separator+fileName);
			member.setProfile(fileName);
		}
		
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

}
