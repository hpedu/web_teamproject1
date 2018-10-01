package model.vo;

import java.sql.Date;

public class ReviewVO {
	private String writer;
	private String img_urls;
	private Date date;
	private String content;
	public ReviewVO() {}
	public ReviewVO(String writer, String img_urls, Date date, String content) {
		super();
		this.writer = writer;
		this.img_urls = img_urls;
		this.date = date;
		this.content = content;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
		return "ReviewVO [writer=" + writer + ", img_urls=" + img_urls + ", date=" + date + ", content=" + content
				+ "]";
	}
	
}
