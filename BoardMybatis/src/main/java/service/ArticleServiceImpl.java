package service;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.Part;

import dao.ArticleDao;
import dao.ArticleDaoImpl;
import dto.Article;

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
		
		return articleDao.selectArticle(num);
	}

	@Override
	public void deleteArticle(Integer num) throws Exception {
		// TODO Auto-generated method stub

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
	public List<Article> articleList(Integer page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
