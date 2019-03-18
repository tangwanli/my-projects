package com.ros.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Order {
    private Integer orderId;

    private Integer userId;

    private Integer orderSitId;

    private String orderFoodId;

    private String orderFoodPrice;
 
    private Date orderTime;
  
    private Date oderFinishtime;

    private Integer orderStatus;

    public Order() {
		super();
	}

	public Order(Integer orderId, Integer userId, Integer orderSitId, String orderFoodId, String orderFoodPrice,
			Date orderTime, Date oderFinishtime, Integer orderStatus) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderSitId = orderSitId;
		this.orderFoodId = orderFoodId;
		this.orderFoodPrice = orderFoodPrice;
		this.orderTime = orderTime;
		this.oderFinishtime = oderFinishtime;
		this.orderStatus = orderStatus;
	}

	public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrderSitId() {
        return orderSitId;
    }

    public void setOrderSitId(Integer orderSitId) {
        this.orderSitId = orderSitId;
    }

    public String getOrderFoodId() {
        return orderFoodId;
    }

    public void setOrderFoodId(String orderFoodId) {
        this.orderFoodId = orderFoodId == null ? null : orderFoodId.trim();
    }

    public String getOrderFoodPrice() {
        return orderFoodPrice;
    }

    public void setOrderFoodPrice(String orderFoodPrice) {
        this.orderFoodPrice = orderFoodPrice;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getOderFinishtime() {
        return oderFinishtime;
    }

    public void setOderFinishtime(Date oderFinishtime) {
        this.oderFinishtime = oderFinishtime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", orderSitId=" + orderSitId + ", orderFoodId="
				+ orderFoodId + ", orderFoodPrice=" + orderFoodPrice + ", orderTime=" + orderTime + ", oderFinishtime="
				+ oderFinishtime + ", orderStatus=" + orderStatus + "]";
	}
}