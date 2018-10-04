package model.vo;

public class ReviewVO {
	
	
	
	
	private String writer;
	private String img_urls;
	private String date;
	private String content;
	private int no;
	
	public ReviewVO() {}
	

	
	public ReviewVO(String writer, String img_urls, String date, String content, int no) {
		super();
		this.writer = writer;
		this.img_urls = img_urls;
		this.date = date;
		this.content = content;
		this.no = no;
	}



	public ReviewVO(int no, String writer, String img_urls,  String content) {
		super();
		this.no = no;
		this.writer = writer;
		this.img_urls = img_urls;
		
		this.content = content;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getImg_urls() {
		return img_urls;
	}
	public void setImg_urls(String img_urls) {
		this.img_urls = img_urls;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ReviewVO [no=" + no + ",writer=" + writer + ", img_urls=" + img_urls + ", date=" + date + ", content=" + content
				+ "]";
	}
	
}
