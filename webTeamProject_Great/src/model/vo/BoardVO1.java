package model.vo;

public class BoardVO1 {
	private int no;
	private String name;
	private String writer;
	private String imgurls;
	private String timePosted;		//DB¿¡¼­´Â time_posted
	
	public BoardVO1(int no, String name, String writer, String imgurls, String timePosted) {
		super();
		this.no = no;
		this.name = name;
		this.writer = writer;
		this.imgurls = imgurls;
		this.timePosted = timePosted;
	}
	
	
}
