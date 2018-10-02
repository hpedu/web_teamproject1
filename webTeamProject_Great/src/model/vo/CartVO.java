package model.vo;

public class CartVO {
	private String id;
	private String product_name;
	private int quantity;
	@Override
	public String toString() {
		return "CartVO [id=" + id + ", product_name=" + product_name + ", quantity=" + quantity + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartVO(String id, String product_name, int quantity) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.quantity = quantity;
	}
	public CartVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
