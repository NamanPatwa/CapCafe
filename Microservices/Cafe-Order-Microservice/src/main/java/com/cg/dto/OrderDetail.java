package com.cg.dto;

import javax.persistence.CascadeType;

//import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Order_Details")
@SequenceGenerator(name = "detailseq",sequenceName = "detail_seq",allocationSize = 1)
public class OrderDetail {
	    @Id
	    @Column(name = "ID", length = 50, nullable = false)
	    @GeneratedValue(generator = "detailseq")
	    private int id;
	    
	    @Column(name="ItemId")
	    private int itemId;
	    
	    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	    @JoinColumn(referencedColumnName ="order_id" )
	    private Order order;
	    
	    @Column(name = "Quantity", nullable = false)
	    private int quantity;
	    
	    @Column(name = "ItemPrice", nullable = false)
	    private double itemPrice;
	    
	    @Column(name="ItemType")
	    private String itemType;
	    
	    @Column(name="ItemName")
	    private String itemName;
	    
	    @Column(name="ItemTotal")
	    private double itemTotal;
	    
		public double getItemTotal() {
			return itemTotal;
		}

		public void setItemTotal(double itemTotal) {
			this.itemTotal = itemTotal;
		}

		public String getItemName() {
			return itemName;
		}

		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		public String getItemType() {
			return itemType;
		}

		public void setItemType(String itemType) {
			this.itemType = itemType;
		}

		public int getItemId() {
			return itemId;
		}

		public void setItemId(int itemId) {
			this.itemId = itemId;
		}

		public double getItemPrice() {
			return itemPrice;
		}

		public void setItemPrice(double itemprice) {
			this.itemPrice = itemprice;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	    public void setOrder(Order order) {
	        this.order = order;
	    }
		public int getQuantity() {
	        return quantity;
	    }
	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
}
