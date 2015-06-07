package my.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
public class BoardAritcle {

	@Id
	@GeneratedValue
	private int id;

	private String title;
	private int grp;
	private int seq;
	private int lvl;

	@Temporal(TemporalType.TIMESTAMP)
	private Date day_write;
	private int num_read;

	private String userId;
	private String nick;
	@Type(type="text")
	private String content;


	//Constructor
	public BoardAritcle() {
	}

	public BoardAritcle(String title, String userId, String nick, String content) {
		super();
		this.title = title;
		this.userId = userId;
		this.nick = nick;
		this.content = content;
	}




	//Get&Setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getGrp() {
		return grp;
	}

	public void setGrp(int grp) {
		this.grp = grp;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public Date getDay_write() {
		return day_write;
	}

	public void setDay_write(Date day_write) {
		this.day_write = day_write;
	}

	public int getNum_read() {
		return num_read;
	}

	public void setNum_read(int num_read) {
		this.num_read = num_read;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardAritcle [id=" + id + ", title=" + title + ", grp=" + grp + ", seq=" + seq + ", lvl=" + lvl + ", day_write=" + day_write + ", num_read=" + num_read
				+ ", userId=" + userId + ", nick=" + nick + ", content=" + content + "]";
	}








}
