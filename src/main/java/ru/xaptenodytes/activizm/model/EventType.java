package ru.xaptenodytes.activizm.model;

// Generated 18.05.2015 14:47:17 by Hibernate Tools 4.3.1

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
public class EventType implements java.io.Serializable {

	private Integer eventTypeId;
	private OrganisationEventType organisationEventType;
	private String eventName;
	private Set eventses = new HashSet(0);

	public EventType() {
	}

	public EventType(OrganisationEventType organisationEventType) {
		this.organisationEventType = organisationEventType;
	}

	public EventType(OrganisationEventType organisationEventType,
			String eventName, Set eventses) {
		this.organisationEventType = organisationEventType;
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
	public OrganisationEventType getOrganisationeventtype() {
		return this.organisationEventType;
	}

	public void setOrganisationeventtype(
			OrganisationEventType organisationEventType) {
		this.organisationEventType = organisationEventType;
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