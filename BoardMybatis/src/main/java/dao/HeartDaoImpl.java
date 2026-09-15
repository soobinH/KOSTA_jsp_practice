package dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import config.MybatisSqlSessionFactory;

public class HeartDaoImpl implements HeartDao{
	
	@Override
	public Integer selectHeart(Map<String, Object> param) throws Exception{
		try(SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession()) {
			return sqlSession.selectOne("mapper.heart.selectHeart", param);
		}
	}
}
