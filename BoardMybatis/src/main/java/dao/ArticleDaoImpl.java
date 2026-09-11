package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.MybatisSqlSessionFactory;
import dto.Article;

public class ArticleDaoImpl implements ArticleDao {

	@Override
	public Integer insertArticle(Article article) throws Exception {
	    SqlSession sqlSession =
	        MybatisSqlSessionFactory.getSqlSessionFactory().openSession();

	    try {
	        sqlSession.insert("mapper.article.insertArticle", article);
	        sqlSession.commit();
	    } catch(Exception e) {
	        e.printStackTrace();
	        sqlSession.rollback();
	    } finally {
	        sqlSession.close();
	    }

	    return article.getNum();
	}

	@Override
	public Article selectArticle(Integer num) throws Exception {
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
		Article article = new Article();
		try {
			article = sqlSession.selectOne("mapper.article.selectArticle", num);
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			sqlSession.close();
		}
		return article;
	}

	@Override
	public void updateArticle(Article article) throws Exception {
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
		try {
			sqlSession.update("mapper.article.updateArticle", article);
			sqlSession.commit();
		} catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public List<Article> articleList(Integer row) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
