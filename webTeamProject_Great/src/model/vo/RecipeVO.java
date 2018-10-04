package model.vo;

public class RecipeVO {

	private int num;
	private String name;
	private String imgurls;
	private String main_ingredientents;
	private String sub_ingredientents;
	private String writer;
	private String register_date;
	private String type;
	private int hits;
	private String descript;
	private String content;
	private String tip;
	private boolean recommend;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgurls() {
		return imgurls;
	}
	public void setImgurls(String imgurls) {
		this.imgurls = imgurls;
	}
	public String getMain_ingredientents() {
		return main_ingredientents;
	}
	public void setMain_ingredientents(String main_ingredientents) {
		this.main_ingredientents = main_ingredientents;
	}
	public String getSub_ingredientents() {
		return sub_ingredientents;
	}
	public void setSub_ingredientents(String sub_ingredientents) {
		this.sub_ingredientents = sub_ingredientents;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public boolean isRecommend() {
		return recommend;
	}
	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public RecipeVO() {
		super();
	}
	public RecipeVO(int num, String name, String imgurls, String main_ingredientents, String sub_ingredientents,
			String writer, String register_date, String type, int hits, String descript, String content, String tip,
			boolean recommend) {
		super();
		this.num = num;
		this.name = name;
		this.imgurls = imgurls;
		this.main_ingredientents = main_ingredientents;
		this.sub_ingredientents = sub_ingredientents;
		this.writer = writer;
		this.register_date = register_date;
		this.type = type;
		this.hits = hits;
		this.descript = descript;
		this.content = content;
		this.tip = tip;
		this.recommend = recommend;
	}
	@Override
	public String toString() {
		return "RecipeVO [num=" + num + ", name=" + name + ", imgurls=" + imgurls + ", main_ingredientents="
				+ main_ingredientents + ", sub_ingredientents=" + sub_ingredientents + ", writer=" + writer
				+ ", register_date=" + register_date + ", type=" + type + ", hits=" + hits + ", descript=" + descript
				+ ", content=" + content + ", tip=" + tip + ", recommend=" + recommend + "]";
	}
	
	
	
}