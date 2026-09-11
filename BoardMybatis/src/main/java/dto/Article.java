package dto;

public class Article {
	private Integer num;
	private String title;
	private String content;
	private String writer;
	private String imageFilename;
	private String downloadFilename;
	
	public Article() {
		super();
	}
	
	public Article(Integer num, String title, String content, String writer, String ifile, String dfile) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.imageFilename =ifile;
		this.downloadFilename =dfile;
	}
	
	public Article(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getImageFilename() {
		return imageFilename;
	}
	
	public void setImageFilename(String ifile) {
		this.imageFilename =ifile;
	}
	
	public String getDownloadFilename() {
		return downloadFilename;
	}
	
	public void setDownloadFilename(String dfile) {
		this.downloadFilename = dfile;
	}

	@Override
	public String toString() {
	    return "Article [num=" + num
	            + ", title=" + title
	            + ", content=" + content
	            + ", writer=" + writer
	            + ", imageFilename=" + imageFilename
	            + ", downloadFilename=" + downloadFilename
	            + "]";
	}

	
	
	
}
