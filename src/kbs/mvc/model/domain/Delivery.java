package kbs.mvc.model.domain;

public class Delivery {
	private int orderNo;
	private String customerId;
	private int deliveryStaus;
	private String address;
	
		
	public Delivery () {}	
	
	
	public Delivery(int order_no, String customerId, int deliveryStaus, String address) {
		
		this.orderNo = order_no;
		this.customerId = customerId;
		this.deliveryStaus = deliveryStaus;
		this.address = address;
	}
	public int getOrder_no() {
		return orderNo;
	}
	public void setOrder_no(int order_no) {
		this.orderNo = order_no;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getDeliveryStaus() {
		return deliveryStaus;
	}
	public void setDeliveryStaus(int deliveryStaus) {
		this.deliveryStaus = deliveryStaus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
}
