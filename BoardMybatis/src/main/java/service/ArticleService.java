package service;

import java.util.List;

import javax.servlet.http.Part;

import dto.Article;
import util.PageInfo;

public interface ArticleService {
	Integer writeArticle(Article article, String realPath, Part ifile, Part dfile) throws Exception; // 글 작성
	Article detailArticle(Integer num)throws Exception; // 글 상세
	void deleteArticle(Integer num) throws Exception; // 글 삭제
	void modifyArticle(Article article, String realPath, Part ifile, Part dfile) throws Exception; // 글 수정
	List<Article> articleList(PageInfo pageInfo) throws Exception; // 글 목록(페이징)
	
}
