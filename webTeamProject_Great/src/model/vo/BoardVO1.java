package model.vo;

public class BoardVO1 {
	private int no;
	private String title;
	private String writer;
	private String password;
	private String content;
	private int hits;
	private String timePosted;		//DB에서는 time_posted
	
	public BoardVO1(int no, String title, String writer, String password, String content, int hits, String timePosted) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.password = password;
		this.content = content;
		this.hits = hits;
		this.timePosted = timePosted;
	}
	public BoardVO1() { }
	// password만 빠진 생성자(SELECT_POSTING)
	public BoardVO1(int no, String title, String writer, String content, int hits, String timePosted) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.hits = hits;
		this.timePosted = timePosted;
	}
	//INSERT_POSTING
	public BoardVO1(String title, String writer, String password, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.password = password;
		this.content = content;
	}
	
	public BoardVO1(int no, String title, String writer, String timePosted, int hits){
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.timePosted = timePosted;
		this.hits = hits;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getHits() {
		return hits;
	}
	
	public void setHits(int hits) {
		this.hits = hits;
	}
	
	public String getTimePosted() {
		return timePosted;
	}
	
	public void setTimePosted(String timePosted) {
		this.timePosted = timePosted;
	}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", writer=" + writer + ", password=" + password + ", content="
				+ content + ", hits=" + hits + ", timePosted=" + timePosted + "]";
	}
	
}
