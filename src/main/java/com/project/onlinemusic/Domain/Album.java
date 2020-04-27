package com.project.onlinemusic.Domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the albums database table.
 * 
 */
@Entity
@Table(name="albums")
@NamedQuery(name="Album.findAll", query="SELECT a FROM Album a")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String count;

	private String directory;

	private String name;

	private String pic;

	private double price;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regtime;

	private String spare;

	private int status;

	//bi-directional many-to-one association to Artist
	@ManyToOne
	@JoinColumn(name="artists_id")
	private Artist artist;

	//bi-directional many-to-one association to AlbumsHasSong
	@OneToMany(mappedBy="album")
	private List<AlbumsHasSong> albumsHasSongs;

	//bi-directional many-to-one association to Song
	@OneToMany(mappedBy="album")
	private List<Song> songs;

	public Album() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCount() {
		return this.count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getDirectory() {
		return this.directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
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

	public String getSpare() {
		return this.spare;
	}

	public void setSpare(String spare) {
		this.spare = spare;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Artist getArtist() {
		return this.artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public List<AlbumsHasSong> getAlbumsHasSongs() {
		return this.albumsHasSongs;
	}

	public void setAlbumsHasSongs(List<AlbumsHasSong> albumsHasSongs) {
		this.albumsHasSongs = albumsHasSongs;
	}

	public AlbumsHasSong addAlbumsHasSong(AlbumsHasSong albumsHasSong) {
		getAlbumsHasSongs().add(albumsHasSong);
		albumsHasSong.setAlbum(this);

		return albumsHasSong;
	}

	public AlbumsHasSong removeAlbumsHasSong(AlbumsHasSong albumsHasSong) {
		getAlbumsHasSongs().remove(albumsHasSong);
		albumsHasSong.setAlbum(null);

		return albumsHasSong;
	}

	public List<Song> getSongs() {
		return this.songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public Song addSong(Song song) {
		getSongs().add(song);
		song.setAlbum(this);

		return song;
	}

	public Song removeSong(Song song) {
		getSongs().remove(song);
		song.setAlbum(null);

		return song;
	}

}