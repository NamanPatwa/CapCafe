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
/**
 * 
 * @author Team 1
 * @version 1
 * Order Details entity class having field with getter and setter of field
 *
 */
@Entity
@Table(name = "Order_Details")
@SequenceGenerator(name = "detailseq", sequenceName = "detail_seq", allocationSize = 1)
public class OrderDetail {
	@Id
	@Column(name = "ID", length = 50, nullable = false)
	@GeneratedValue(generator = "detailseq")
	private int id;

	@Column(name = "ItemId")
	private int itemId;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(referencedColumnName = "order_id")
	private Order order;

	@Column(name = "Quantity", nullable = false)
	private int quantity;

	@Column(name = "ItemPrice", nullable = false)
	private double itemPrice;

	@Column(name = "ItemType")
	private String itemType;

	@Column(name = "ItemName")
	private String itemName;

	@Column(name = "ItemTotal")
	private double itemTotal;

	/**
	 * Getter method to get total price for particular Item
	 * 
	 * @return itemTotal
	 */
	public double getItemTotal() {
		return itemTotal;
	}

	/**
	 * Setter method to set total price for particular Item
	 * 
	 * @param itemTotal
	 */
	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}

	/**
	 * Getter method to get item name
	 * 
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Setter method to set itemName
	 * 
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * getter method to get Item Type
	 * 
	 * @return itemType
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * Setter method to set ItemType
	 * 
	 * @param itemType
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	/**
	 * getter method to get item Id
	 * 
	 * @return itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * Setter method to set ItemId
	 * 
	 * @param itemId
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * Getter method to get ItemPrice
	 * 
	 * @return itemPrice
	 */
	public double getItemPrice() {
		return itemPrice;
	}

	/**
	 * Setter method to set itemPrice
	 * 
	 * @param itemprice
	 */
	public void setItemPrice(double itemprice) {
		this.itemPrice = itemprice;
	}

	/**
	 * Setter method to set Order
	 * 
	 * @param order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * getter method to get quantity
	 * 
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Setter method to set quantity
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
