package com.project.onlinemusic.Domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the song database table.
 * 
 */
@Entity
@NamedQuery(name="Song.findAll", query="SELECT s FROM Song s")
public class Song implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String filepath;

	private String name;

	private double price;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regtime;

	private int status;

	//bi-directional many-to-one association to AlbumsHasSong
	@OneToMany(mappedBy="song")
	private List<AlbumsHasSong> albumsHasSongs;

	//bi-directional many-to-one association to Album
	@ManyToOne
	@JoinColumn(name="albums_id")
	private Album album;

	//bi-directional many-to-one association to Genre
	@ManyToOne
	@JoinColumn(name="genres_id")
	private Genre genre;

	//bi-directional many-to-one association to Type
	@ManyToOne
	private Type type;

	public Song() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilepath() {
		return this.filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public List<AlbumsHasSong> getAlbumsHasSongs() {
		return this.albumsHasSongs;
	}

	public void setAlbumsHasSongs(List<AlbumsHasSong> albumsHasSongs) {
		this.albumsHasSongs = albumsHasSongs;
	}

	public AlbumsHasSong addAlbumsHasSong(AlbumsHasSong albumsHasSong) {
		getAlbumsHasSongs().add(albumsHasSong);
		albumsHasSong.setSong(this);

		return albumsHasSong;
	}

	public AlbumsHasSong removeAlbumsHasSong(AlbumsHasSong albumsHasSong) {
		getAlbumsHasSongs().remove(albumsHasSong);
		albumsHasSong.setSong(null);

		return albumsHasSong;
	}

	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}