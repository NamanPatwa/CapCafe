package com.cg.cafemenu.dto;

import java.util.HashSet;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import lombok.Data;
//import lombok.EqualsAndHashCode;

//@Data
//@EqualsAndHashCode(exclude = "details")

@Entity
@Table(name = "cafemenu")
@NamedQuery(name = "CafeMenu.findMenuItemByName", query = "SELECT m from CafeMenu m where m.itemName=?1")
//@SequenceGenerator(name = "menuseq", sequenceName = "cafemenu_seq", initialValue = 500, allocationSize = 1)
public class CafeMenu {

	@Id
	//@GeneratedValue(generator = "menuseq")
	private int itemId;
	private String itemName;
	private String itemType;
	private double itemPrice;
	
	@ManyToMany(mappedBy = "menus"
			, fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                }
	)
	Set<CafeDetails> details = new HashSet<CafeDetails>();
		
	public CafeMenu() {
	}

	public CafeMenu(int itemId, String itemName, String itemType, double itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
	}


	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	
}
