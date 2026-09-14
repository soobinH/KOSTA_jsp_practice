package service;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.Part;

import dao.ArticleDao;
import dao.ArticleDaoImpl;
import dto.Article;
import util.PageInfo;

public class ArticleServiceImpl implements ArticleService {
	private ArticleDao articleDao;
	public ArticleServiceImpl() {
		articleDao =new ArticleDaoImpl();	
	}

	private String fileUpload(String uploadPath, Part file)throws Exception {
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
		
	    if (ifile != null && ifile.getSubmittedFileName() != null
	            && !ifile.getSubmittedFileName().isEmpty()) {
	        article.setImageFilename(fileUpload(uploadPath, ifile));
	    }

	    
	    if (dfile != null && dfile.getSubmittedFileName() != null
	            && !dfile.getSubmittedFileName().isEmpty()) {
	        article.setDownloadFilename(fileUpload(uploadPath, dfile));
	    }

	    System.out.println(article);

	    return articleDao.insertArticle(article);

	}
	
	

	@Override
	public Article detailArticle(Integer num) throws Exception {
		articleDao.updateArticleViewCnt(num);
		return articleDao.selectArticle(num);
	}

	@Override
	public void deleteArticle(Integer num) throws Exception {
		articleDao.deleteArticle(num);

	}

	@Override
	public void modifyArticle(Article article, String uploadPath, Part ifile, Part dfile) throws Exception {
		if (ifile != null && ifile.getSubmittedFileName() != null
	            && !ifile.getSubmittedFileName().isEmpty()) {
	        article.setImageFilename(fileUpload(uploadPath, ifile));
	    }

	    
	    if (dfile != null && dfile.getSubmittedFileName() != null
	            && !dfile.getSubmittedFileName().isEmpty()) {
	        article.setDownloadFilename(fileUpload(uploadPath, dfile));
	    }

		
		articleDao.updateArticle(article);
	}

	@Override
	public List<Article> articleList(PageInfo pageInfo) throws Exception {
		// 전체 게시글 수
		Integer articleCnt = articleDao.selectArticleCnt();
		Integer allPage = (int)Math.ceil(articleCnt/10.0); //전체 페이지 수
		
		
		
		// startPage : curPage(1~10) -> 1, curPage(11~20)->11, curPage(21, 30) -> 21
		Integer startPage = (pageInfo.getCurPage()-1)/10*1+1;
		Integer endPage = startPage+10;
		if(endPage>allPage) endPage = allPage; // 마지막 페이지 보정, 전체 페이지 넘지 않게
		if(pageInfo.getCurPage()>endPage) {
			pageInfo.setCurPage(endPage);
		}
		pageInfo.setAllPage(allPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		Integer row = (pageInfo.getCurPage()-1)*10+1;
		return articleDao.selectArticleList(row-1);
	}

}
