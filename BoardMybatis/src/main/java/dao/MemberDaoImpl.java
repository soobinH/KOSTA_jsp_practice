package dao;

import org.apache.ibatis.session.SqlSession;

import config.MybatisSqlSessionFactory;
import dto.Member;

public class MemberDaoImpl implements MemberDao {

	@Override
	public void insertMember(Member member) throws Exception {
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
		try {
			sqlSession.insert("mapper.member.insertMember", member);
			sqlSession.commit();
		} catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public Member selectMember(String id) throws Exception {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession()) {
			return sqlSession.selectOne("mapper.member.selectMember", id);
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
