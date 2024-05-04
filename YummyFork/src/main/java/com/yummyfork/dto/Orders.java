package com.yummyfork.dto;

public class Orders {

	private int orderId;
	private double totalBill;
	private int custId;
	private String status;
	
	
	public Orders() {
		super();
	}

	public Orders(double totalBill, int custId, String status) {
		super();
		this.totalBill = totalBill;
		this.custId = custId;
		this.status = status;
	}

	public Orders(int orderId, double totalBill, int custId, String status) {
		super();
		this.orderId = orderId;
		this.totalBill = totalBill;
		this.custId = custId;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}


	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
