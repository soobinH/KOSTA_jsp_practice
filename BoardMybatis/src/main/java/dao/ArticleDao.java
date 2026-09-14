package dao;

import java.util.List;

import dto.Article;

public interface ArticleDao {
	Integer insertArticle(Article article) throws Exception;
	Article selectArticle(Integer num) throws Exception;
	void updateArticle(Article article) throws Exception;
	List<Article> selectArticleList(Integer row) throws Exception;
	Integer selectArticleCnt() throws Exception;
	void updateArticleViewCnt(Integer num) throws Exception;
	void deleteArticle(Integer num) throws Exception;
	
}
