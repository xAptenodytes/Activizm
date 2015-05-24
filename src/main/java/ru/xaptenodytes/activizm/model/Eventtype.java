package ru.xaptenodytes.activizm.model;

// Generated 24.05.2015 22:32:50 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Eventtype generated by hbm2java
 */
@Entity
@Table(name = "eventtype", catalog = "activizm")
public class Eventtype implements java.io.Serializable {

	private Integer eventTypeId;
	private Organisationeventtype organisationeventtype;
	private String eventName;
	private Set eventses = new HashSet(0);

	public Eventtype() {
	}

	public Eventtype(Organisationeventtype organisationeventtype) {
		this.organisationeventtype = organisationeventtype;
	}

	public Eventtype(Organisationeventtype organisationeventtype,
			String eventName, Set eventses) {
		this.organisationeventtype = organisationeventtype;
		this.eventName = eventName;
		this.eventses = eventses;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "organisationeventtype"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "EventTypeId", unique = true, nullable = false)
	public Integer getEventTypeId() {
		return this.eventTypeId;
	}

	public void setEventTypeId(Integer eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Organisationeventtype getOrganisationeventtype() {
		return this.organisationeventtype;
	}

	public void setOrganisationeventtype(
			Organisationeventtype organisationeventtype) {
		this.organisationeventtype = organisationeventtype;
	}

	@Column(name = "EventName", length = 150)
	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "eventtype")
	public Set getEventses() {
		return this.eventses;
	}

	public void setEventses(Set eventses) {
		this.eventses = eventses;
	}

}
