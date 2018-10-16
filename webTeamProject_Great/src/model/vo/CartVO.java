package model.vo;

public class CartVO {
	 private String img_urls;
	 private String name;
	 private int price;
	 private int quantity;
	public String getImg_urls() {
		return img_urls;
	}
	public void setImg_urls(String img_urls) {
		this.img_urls = img_urls;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartVO [img_urls=" + img_urls + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	public CartVO(String img_urls, String name, int price, int quantity) {
		super();
		this.img_urls = img_urls;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	 
	public CartVO() {}
}
