package ru.xaptenodytes.activizm.model;

// Generated 01.06.2015 21:49:07 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Organisationeventtype generated by hbm2java
 */
@Entity
@Table(name = "organisationeventtype", catalog = "activizm", uniqueConstraints = @UniqueConstraint(columnNames = "EventTypeId"))
public class Organisationeventtype implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8818291422129208982L;
	private Integer connectionId;
	private Community Community;
	private int eventTypeId;
	private Eventtype eventtype;

	public Organisationeventtype() {
	}

	public Organisationeventtype(Community Community, int eventTypeId) {
		this.Community = Community;
		this.eventTypeId = eventTypeId;
	}

	public Organisationeventtype(Community Community, int eventTypeId,
			Eventtype eventtype) {
		this.Community = Community;
		this.eventTypeId = eventTypeId;
		this.eventtype = eventtype;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "connectionId", unique = true, nullable = false)
	public Integer getConnectionId() {
		return this.connectionId;
	}

	public void setConnectionId(Integer connectionId) {
		this.connectionId = connectionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ComunityId", nullable = false)
	public Community getCommunity() {
		return this.Community;
	}

	public void setCommunity(Community Community) {
		this.Community = Community;
	}

	@Column(name = "EventTypeId", unique = true, nullable = false)
	public int getEventTypeId() {
		return this.eventTypeId;
	}

	public void setEventTypeId(int eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "organisationeventtype")
	public Eventtype getEventtype() {
		return this.eventtype;
	}

	public void setEventtype(Eventtype eventtype) {
		this.eventtype = eventtype;
	}

}
