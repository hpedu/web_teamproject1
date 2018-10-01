package model;

public class ProductVO {
	private String name;
	private int price;
	private String origin;
	private String img_urls;
	private String content;
	private String type;
	private String brand;
	
	public ProductVO() {}

	public ProductVO(String name, int price, String origin, String img_urls, String content, String type, String brand) {
		super();
		this.name = name;
		this.price = price;
		this.origin = origin;
		this.img_urls = img_urls;
		this.content = content;
		this.type = type;
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getImg_urls() {
		return img_urls;
	}

	public void setImg_urls(String img_urls) {
		this.img_urls = img_urls;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + ", origin=" + origin + ", imgurls=" + img_urls
				+ ", content=" + content + ", type=" + type + ", brand=" + brand + "]";
	}
}