package com.project.onlinemusic.Domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the purchases database table.
 * 
 */
@Entity
@Table(name="purchases")
@NamedQuery(name="Purchas.findAll", query="SELECT p FROM Purchas p")
public class Purchas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int qty;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regtime;

	private int status;

	@Column(name="sub_tot")
	private String subTot;

	private double total;

	//bi-directional many-to-one association to AlbumsHasSong
	@OneToMany(mappedBy="purchas")
	private List<AlbumsHasSong> albumsHasSongs;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	private Customer customer;

	//bi-directional many-to-one association to Discount
	@ManyToOne
	private Discount discount;

	public Purchas() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Date getRegtime() {
		return this.regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSubTot() {
		return this.subTot;
	}

	public void setSubTot(String subTot) {
		this.subTot = subTot;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<AlbumsHasSong> getAlbumsHasSongs() {
		return this.albumsHasSongs;
	}

	public void setAlbumsHasSongs(List<AlbumsHasSong> albumsHasSongs) {
		this.albumsHasSongs = albumsHasSongs;
	}

	public AlbumsHasSong addAlbumsHasSong(AlbumsHasSong albumsHasSong) {
		getAlbumsHasSongs().add(albumsHasSong);
		albumsHasSong.setPurchas(this);

		return albumsHasSong;
	}

	public AlbumsHasSong removeAlbumsHasSong(AlbumsHasSong albumsHasSong) {
		getAlbumsHasSongs().remove(albumsHasSong);
		albumsHasSong.setPurchas(null);

		return albumsHasSong;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Discount getDiscount() {
		return this.discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

}