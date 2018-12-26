package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Chats database table.
 * 
 */
@Entity
@Table(name="Chats")
@NamedQuery(name="Chat.findAll", query="SELECT c FROM Chat c")
public class Chat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ChatId", unique=true, nullable=false)
	private int chatId;

	@Column(length=2147483647)
	private String message;

	@Column(nullable=false)
	private Timestamp sentAt;

	@Column(nullable=false)
	private boolean state;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="recever_Id", referencedColumnName="Id")
	private AspNetUser aspNetUser1;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="sender_Id", referencedColumnName="Id")
	private AspNetUser aspNetUser2;

	public Chat() {
	}

	public int getChatId() {
		return this.chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getSentAt() {
		return this.sentAt;
	}

	public void setSentAt(Timestamp sentAt) {
		this.sentAt = sentAt;
	}

	public boolean getState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public AspNetUser getAspNetUser1() {
		return this.aspNetUser1;
	}

	public void setAspNetUser1(AspNetUser aspNetUser1) {
		this.aspNetUser1 = aspNetUser1;
	}

	public AspNetUser getAspNetUser2() {
		return this.aspNetUser2;
	}

	public void setAspNetUser2(AspNetUser aspNetUser2) {
		this.aspNetUser2 = aspNetUser2;
	}

}