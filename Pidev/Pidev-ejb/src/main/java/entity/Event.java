package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Events database table.
 * 
 */
@Entity
@Table(name="Events")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EventId", unique=true, nullable=false)
	private int eventId;

	@Column(name="Description", length=2147483647)
	private String description;

	@Column(name="End", nullable=false)
	private Timestamp end;

	@Column(name="IsFullDay", nullable=false)
	private short isFullDay;

	@Column(name="Start", nullable=false)
	private Timestamp start;

	@Column(name="Subject", length=2147483647)
	private String subject;

	@Column(name="Themecolor", length=2147483647)
	private String themecolor;

	public Event() {
	}

	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getEnd() {
		return this.end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

	public short getIsFullDay() {
		return this.isFullDay;
	}

	public void setIsFullDay(short isFullDay) {
		this.isFullDay = isFullDay;
	}

	public Timestamp getStart() {
		return this.start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getThemecolor() {
		return this.themecolor;
	}

	public void setThemecolor(String themecolor) {
		this.themecolor = themecolor;
	}

}