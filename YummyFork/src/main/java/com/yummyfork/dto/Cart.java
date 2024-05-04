package com.yummyfork.dto;

public class Cart {
	
	private int cartId;
	private int cartQuantity;
	private int cartFoodId;
	private int cartCustId;
	
	public Cart(int cartId, int cartQuantity, int cartFoodId, int cartCustId) {
		super();
		this.cartId = cartId;
		this.cartQuantity = cartQuantity;
		this.cartFoodId = cartFoodId;
		this.cartCustId = cartCustId;
	}

	public Cart(int cartQuantity, int cartFoodId, int cartCustId) {
		super();
		this.cartQuantity = cartQuantity;
		this.cartFoodId = cartFoodId;
		this.cartCustId = cartCustId;
	}

	public Cart() {
		super();
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public int getCartFoodId() {
		return cartFoodId;
	}

	public void setCartFoodId(int cartFoodId) {
		this.cartFoodId = cartFoodId;
	}

	public int getCartCustId() {
		return cartCustId;
	}

	public void setCartCustId(int cartCustId) {
		this.cartCustId = cartCustId;
	}
	
	
}
