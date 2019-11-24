package com.cg.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


//@Data
//@EqualsAndHashCode(exclude = "menus")

@Entity
@Table(name = "cafedetails")
//@SequenceGenerator(name = "cafeseq", sequenceName = "cafedetails_seq", initialValue = 100, allocationSize = 1)
public class CafeDetails implements Serializable{

	@Id
	//@GeneratedValue(generator = "cafeseq")
	@Column(name = "cafe_id")
	private int cafeId;
	private String cafeName;
	@Column(name = "cafe_location")
	private String cafeLocation;
	private String cafeOwner;
	private double cafeRating;
	private String cafeImagePath;

	@ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                })
	@JoinTable(
			name = "detailandmenu", 
			joinColumns = @JoinColumn(referencedColumnName = "cafe_id"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "item_id"))
	Set<CafeMenu> menus = new HashSet<CafeMenu>();

	public CafeDetails() {
	}
	
	public CafeDetails(int cafeId, String cafeName, String cafeLocation, String cafeOwner, double cafeRating,
			String cafeImagePath, Set<CafeMenu> menus) {
		super();
		this.cafeId = cafeId;
		this.cafeName = cafeName;
		this.cafeLocation = cafeLocation;
		this.cafeOwner = cafeOwner;
		this.cafeRating = cafeRating;
		this.cafeImagePath = cafeImagePath;
		this.menus = menus;
	}

	public String getCafeName() {
		return cafeName;
	}

	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public String getCafeOwner() {
		return cafeOwner;
	}

	public void setCafeOwner(String cafeOwner) {
		this.cafeOwner = cafeOwner;
	}

	public int getCafeId() {
		return cafeId;
	}

	public void setCafeId(int cafeId) {
		this.cafeId = cafeId;
	}

	public String getCafeLocation() {
		return cafeLocation;
	}

	public void setCafeLocation(String cafeLocation) {
		this.cafeLocation = cafeLocation;
	}

	public double getCafeRating() {
		return cafeRating;
	}

	public void setCafeRating(double cafeRating) {
		this.cafeRating = cafeRating;
	}

	public Set<CafeMenu> getMenus() {
		return menus;
	}

	public void setMenus(Set<CafeMenu> menus) {
		this.menus = menus;
	}

	public String getCafeImagePath() {
		return cafeImagePath;
	}

	public void setCafeImagePath(String cafeImagePath) {
		this.cafeImagePath = cafeImagePath;
	}
	
	
	
}
