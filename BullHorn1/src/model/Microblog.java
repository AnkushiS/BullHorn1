package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MICROBLOG database table.
 * 
 */
@Entity
@Table(name="Microblog", schema="TESTDB")
@NamedQuery(name="Microblog.findAll", query="SELECT m FROM Microblog m")
public class Microblog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private long userId;

	@Column(name="USER_TEXT")
	private String userText;

	public Microblog() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserText() {
		return this.userText;
	}

	public void setUserText(String userText) {
		this.userText = userText;
	}

}