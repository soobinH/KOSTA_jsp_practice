package dao;

import java.util.List;

import dto.Article;

public interface ArticleDao {
	Integer insertArticle(Article article) throws Exception;
	Article selectArticle(Integer num) throws Exception;
	void updateArticle(Article article) throws Exception;
	List<Article> articleList(Integer row) throws Exception;
	
}
