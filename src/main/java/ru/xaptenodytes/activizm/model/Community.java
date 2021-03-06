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
 * Communities generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "communities", catalog = "activizm")
public class Community implements java.io.Serializable {

	private Integer comunityId;
	private Subcommunity subcommunity;
	private String comunityName;
	private Set<Organisationeventtype> organisationeventtypes = new HashSet<>(0);

	public Community() {
	}

	public Community(Subcommunity subcommunity, String comunityName) {
		this.subcommunity = subcommunity;
		this.comunityName = comunityName;
	}

	public Community(Subcommunity subcommunity, String comunityName,
			Set<Organisationeventtype> organisationeventtypes) {
		this.subcommunity = subcommunity;
		this.comunityName = comunityName;
		this.organisationeventtypes = organisationeventtypes;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "subcommunities"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "comunityId", unique = true, nullable = false)
	public Integer getComunityId() {
		return this.comunityId;
	}

	public void setComunityId(Integer comunityId) {
		this.comunityId = comunityId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Subcommunity getSubcommunities() {
		return this.subcommunity;
	}

	public void setSubcommunities(Subcommunity subcommunity) {
		this.subcommunity = subcommunity;
	}

	@Column(name = "comunityName", nullable = false, length = 150)
	public String getComunityName() {
		return this.comunityName;
	}

	public void setComunityName(String comunityName) {
		this.comunityName = comunityName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "communities")
	public Set<Organisationeventtype> getOrganisationeventtypes() {
		return this.organisationeventtypes;
	}

	public void setOrganisationeventtypes(Set<Organisationeventtype> organisationeventtypes) {
		this.organisationeventtypes = organisationeventtypes;
	}

}
