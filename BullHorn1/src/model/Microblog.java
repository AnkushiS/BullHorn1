package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the MICROBLOG database table.
 * 
 */
@Entity
@Table(name="Microblog" , schema="TESTDB")
@NamedQuery(name="Microblog.findAll", query="SELECT m FROM Microblog m")
public class Microblog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BLOG_ID")
	private long blogId;

	@Temporal(TemporalType.DATE)
	private Date datein;

	@Column(name="USER_NAME")
	private String userName;

	@Column(name="USER_TEXT")
	private String userText;

	public Microblog() {
	}

	public long getBlogId() {
		return this.blogId;
	}

	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	public Date getDatein() {
		return this.datein;
	}

	public void setDatein(Date datein) {
		this.datein = datein;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserText() {
		return this.userText;
	}

	public void setUserText(String userText) {
		this.userText = userText;
	}

}