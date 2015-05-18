package ru.xaptenodytes.activizm.model;

// Generated 18.05.2015 14:47:17 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SchedulewithdateId generated by hbm2java
 */
@Embeddable
public class ScheduleWithDateId implements java.io.Serializable {

	private int activistId;
	private Double mapPointX;
	private Double mapPointY;
	private Integer radius;
	private Date beginDate;
	private Date endDate;

	public ScheduleWithDateId() {
	}

	public ScheduleWithDateId(int activistId) {
		this.activistId = activistId;
	}

	public ScheduleWithDateId(int activistId, Double mapPointX,
			Double mapPointY, Integer radius, Date beginDate, Date endDate) {
		this.activistId = activistId;
		this.mapPointX = mapPointX;
		this.mapPointY = mapPointY;
		this.radius = radius;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	@Column(name = "ActivistId", unique = true, nullable = false)
	public int getActivistId() {
		return this.activistId;
	}

	public void setActivistId(int activistId) {
		this.activistId = activistId;
	}

	@Column(name = "MapPointX", precision = 22, scale = 0)
	public Double getMapPointX() {
		return this.mapPointX;
	}

	public void setMapPointX(Double mapPointX) {
		this.mapPointX = mapPointX;
	}

	@Column(name = "MapPointY", precision = 22, scale = 0)
	public Double getMapPointY() {
		return this.mapPointY;
	}

	public void setMapPointY(Double mapPointY) {
		this.mapPointY = mapPointY;
	}

	@Column(name = "Radius")
	public Integer getRadius() {
		return this.radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}

	@Column(name = "beginDate", length = 19)
	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Column(name = "EndDate", length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ScheduleWithDateId))
			return false;
		ScheduleWithDateId castOther = (ScheduleWithDateId) other;

		return (this.getActivistId() == castOther.getActivistId())
				&& ((this.getMapPointX() == castOther.getMapPointX()) || (this
						.getMapPointX() != null
						&& castOther.getMapPointX() != null && this
						.getMapPointX().equals(castOther.getMapPointX())))
				&& ((this.getMapPointY() == castOther.getMapPointY()) || (this
						.getMapPointY() != null
						&& castOther.getMapPointY() != null && this
						.getMapPointY().equals(castOther.getMapPointY())))
				&& ((this.getRadius() == castOther.getRadius()) || (this
						.getRadius() != null && castOther.getRadius() != null && this
						.getRadius().equals(castOther.getRadius())))
				&& ((this.getBeginDate() == castOther.getBeginDate()) || (this
						.getBeginDate() != null
						&& castOther.getBeginDate() != null && this
						.getBeginDate().equals(castOther.getBeginDate())))
				&& ((this.getEndDate() == castOther.getEndDate()) || (this
						.getEndDate() != null && castOther.getEndDate() != null && this
						.getEndDate().equals(castOther.getEndDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getActivistId();
		result = 37 * result
				+ (getMapPointX() == null ? 0 : this.getMapPointX().hashCode());
		result = 37 * result
				+ (getMapPointY() == null ? 0 : this.getMapPointY().hashCode());
		result = 37 * result
				+ (getRadius() == null ? 0 : this.getRadius().hashCode());
		result = 37 * result
				+ (getBeginDate() == null ? 0 : this.getBeginDate().hashCode());
		result = 37 * result
				+ (getEndDate() == null ? 0 : this.getEndDate().hashCode());
		return result;
	}

}