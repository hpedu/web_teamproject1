package model.vo;

public class BoardVO {
	private int no;
	private String writer;
	private String register_date;
	private String content;
	public BoardVO() {}
	public BoardVO(int no, String writer, String register_date, String content) {
		super();
		this.no = no;
		this.writer = writer;
		this.register_date = register_date;
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
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", writer=" + writer + ", register_date=" + register_date + ", content=" + content
				+ "]";
	}
	
}
