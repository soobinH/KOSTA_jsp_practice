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
	public List<Article> selectArticleList(Integer row) throws Exception {
		try(SqlSession sqlSession  = MybatisSqlSessionFactory.getSqlSessionFactory().openSession()) {
			return sqlSession.selectList("mapper.article.selectArticleList", row);
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Integer selectArticleCnt() throws Exception {
		try(SqlSession sqlSession  = MybatisSqlSessionFactory.getSqlSessionFactory().openSession()) {
			return sqlSession.selectOne("mapper.article.selectArticleCnt");
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void updateArticleViewCnt(Integer num) throws Exception {
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
		try {
			sqlSession.update("mapper.article.updateArticleViewCnt", num);
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
	public void deleteArticle(Integer num) throws Exception {
		SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
		try {
			sqlSession.delete("mapper.article.deleteArticle",num);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		
	}

}
