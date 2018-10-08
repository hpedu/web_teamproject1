package model.vo;

public class RecipeVO {
	private int num;
	private String name;
	private String imgurls;
	private String main_ingredientents;
	private String sub_ingredientents;
	private String writer;
	private String date;
	private String type;
	private int hits;
	private String descript;
	private String content;
	private String tip;
<<<<<<< HEAD
	private boolean recommend;
	
	
	public RecipeVO() {
		super();
		// TODO Auto-generated constructor stub
=======
	private String recommend;
	public String getName() {
		return name;
>>>>>>> refs/remotes/origin/master
	}

	public RecipeVO(int num, String name, String imgurls, String main_ingredientents, String sub_ingredientents,
			String writer, String date, String type, int hits, String descript, String content, String tip) {
		super();
		this.num = num;
		this.name = name;
		this.imgurls = imgurls;
		this.main_ingredientents = main_ingredientents;
		this.sub_ingredientents = sub_ingredientents;
		this.writer = writer;
		this.date = date;
		this.type = type;
		this.hits = hits;
		this.descript = descript;
		this.content = content;
		this.tip = tip;
	}
	
<<<<<<< HEAD
=======
	
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
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
>>>>>>> refs/remotes/origin/master
	public RecipeVO(int num, String name, String imgurls, String main_ingredientents, String sub_ingredientents,
<<<<<<< HEAD
			String writer, String date, String type, int hits, String descript, String content, String tip,
			boolean recommend) {
=======
			String writer, String register_date, String type, int hits, String descript, String content, String tip,
			String recommend) {
>>>>>>> refs/remotes/origin/master
		super();
		this.num = num;
		this.name = name;
		this.imgurls = imgurls;
		this.main_ingredientents = main_ingredientents;
		this.sub_ingredientents = sub_ingredientents;
		this.writer = writer;
		this.date = date;
		this.type = type;
		this.hits = hits;
		this.descript = descript;
		this.content = content;
		this.tip = tip;
		this.recommend = recommend;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	@Override
	public String toString() {
		return "RecipeVO [num=" + num + ", name=" + name + ", imgurls=" + imgurls + ", main_ingredientents="
				+ main_ingredientents + ", sub_ingredientents=" + sub_ingredientents + ", writer=" + writer + ", date="
				+ date + ", type=" + type + ", hits=" + hits + ", descript=" + descript + ", content=" + content
				+ ", tip=" + tip + "]";
	}
<<<<<<< HEAD

=======
	
	
	
	
>>>>>>> refs/remotes/origin/master
}