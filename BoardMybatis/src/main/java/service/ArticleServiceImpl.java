package service;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;

import dao.ArticleDao;
import dao.ArticleDaoImpl;
import dao.HeartDao;
import dao.HeartDaoImpl;
import dto.Article;
import util.PageInfo;

public class ArticleServiceImpl implements ArticleService {
	private ArticleDao articleDao;
	private HeartDao heartDao;
	
	public ArticleServiceImpl() {
		articleDao = new ArticleDaoImpl();
		heartDao = new HeartDaoImpl();
		
	}
	
	private String fileUpload(String uploadPath, Part file) throws Exception {
		String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString();
		if(fileName!=null && !fileName.isEmpty()) {
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists()) uploadDir.mkdir();
			file.write(uploadPath+File.separator+fileName);
		}
		return fileName;
	}

	@Override
	public Integer writeArticle(Article article, String uploadPath, Part ifile, Part dfile) throws Exception {
		
		if(ifile!=null) article.setImageFilename(fileUpload(uploadPath, ifile));
		if(dfile!=null) article.setDownloadFilename(fileUpload(uploadPath, dfile));
		return articleDao.insertArticle(article);
	}

	@Override
	public Map<String, Object> detailArticle(Integer num) throws Exception {
		articleDao.updateArticleViewCnt(num);
		return articleDao.selectArticleWithMember(num);
	}

	@Override
	public void deleteArticle(Integer num) throws Exception {
		articleDao.deleteArticle(num);
	}

	@Override
	public void modifyArticle(Article article, String uploadPath, Part ifile, Part dfile) throws Exception {
		if(ifile!=null) article.setImageFilename(fileUpload(uploadPath, ifile));
		if(dfile!=null) article.setDownloadFilename(fileUpload(uploadPath, dfile));
		
		articleDao.updateArticle(article);
	}

	@Override
	public List<Map<String,Object>> articleList(PageInfo pageInfo, String keyword, String type) throws Exception {
		//전체 게시글 수
		Map<String, Object> param= new HashMap<>();
		param.put("keyword",keyword);
		param.put("type", type);
		Integer articleCnt = articleDao.selectArticleWithMemberCnt(param);
		Integer allPage = (int)Math.ceil(articleCnt/10.0); //전체 페이지 수
		//startPage : curPge(1~10)=>1, curPage(11~20)=>11, curPage(21,30)=>21
		Integer startPage = (pageInfo.getCurPage()-1)/10*10+1;
		Integer endPage = startPage+10;
		if(endPage>allPage) endPage = allPage; //마지막 페이지 보정, 전체 페이지 넘지 않게
		if(pageInfo.getCurPage()>endPage) {
			pageInfo.setCurPage(endPage);
		}
		
		pageInfo.setAllPage(allPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		Integer row = (pageInfo.getCurPage()-1)*10+1;
		param.put("row", row-1);
		return articleDao.selectArticleWithMemberList(param);
	}

	@Override
	public Boolean isHeart(Integer articleNum, String memberId) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("articleNum", articleNum);
		param.put("memberId", memberId);
		return heartDao.selectHeart(param) != null;
	}
}