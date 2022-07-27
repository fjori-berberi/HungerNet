package com.myspring.hungernet.Model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="order_id")private int orderId;
		
		@Column(name="order_description")private int orderDescription;
		@Column(name="order_Status")private int orderStatus;
		
		
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public int getOrderDescription() {
			return orderDescription;
		}
		public void setOrderDescription(int orderDescription) {
			this.orderDescription = orderDescription;
		}
		public int getOrderStatus() {
			return orderStatus;
		}
		public void setOrderStatus(int orderStatus) {
			this.orderStatus = orderStatus;
		}
		
		
}
