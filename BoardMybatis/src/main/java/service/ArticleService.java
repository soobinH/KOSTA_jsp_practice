package service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;

import dto.Article;
import util.PageInfo;

public interface ArticleService {
	//글작성
	Integer writeArticle(Article article, String realPath, Part ifile, Part dfile) throws Exception;
	//글상세
	Map<String, Object> detailArticle(Integer num) throws Exception;
	//글삭제
	void deleteArticle(Integer num) throws Exception;
	//글수정
	void modifyArticle(Article article, String realPath, Part ifile, Part dfile) throws Exception;
	//글목록(페이징)
	List<Map<String,Object>> articleList(PageInfo pageInfo, String keyword, String type) throws Exception;
	
	Boolean isHeart(Integer articleNum, String memberId) throws Exception;
}
