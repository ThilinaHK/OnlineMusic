package com.project.onlinemusic.Domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the albums_has_song database table.
 * 
 */
@Entity
@Table(name="albums_has_song")
@NamedQuery(name="AlbumsHasSong.findAll", query="SELECT a FROM AlbumsHasSong a")
public class AlbumsHasSong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regtime;

	private int status;

	//bi-directional many-to-one association to Album
	@ManyToOne
	@JoinColumn(name="albums_id")
	private Album album;

	//bi-directional many-to-one association to Purchas
	@ManyToOne
	@JoinColumn(name="purchases_id")
	private Purchas purchas;

	//bi-directional many-to-one association to Song
	@ManyToOne
	private Song song;

	public AlbumsHasSong() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Purchas getPurchas() {
		return this.purchas;
	}

	public void setPurchas(Purchas purchas) {
		this.purchas = purchas;
	}

	public Song getSong() {
		return this.song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

}