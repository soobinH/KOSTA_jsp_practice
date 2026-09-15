package dao;

import java.util.List;
import java.util.Map;

import dto.Article;

public interface ArticleDao {
	Integer insertArticle(Article article) throws Exception;
	Article selectArticle(Integer num) throws Exception;
	void updateArticle(Article article) throws Exception;
	List<Article> selectArticleList(Integer row) throws Exception;
	Integer selectArticleCnt(Map<String,Object> param) throws Exception;
	void updateArticleViewCnt(Integer num) throws Exception;
	void deleteArticle(Integer num) throws Exception;
	Map<String, Object> selectArticleWithMember(Integer num) throws Exception;
	List<Map<String,Object>> selectArticleWithMemberList(Map<String,Object> param) throws Exception; 
	Integer selectArticleWithMemberCnt(Map<String, Object> param) throws Exception;
}
