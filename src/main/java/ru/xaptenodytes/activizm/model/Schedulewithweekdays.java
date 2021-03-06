package ru.xaptenodytes.activizm.model;

// Generated 01.06.2015 21:49:07 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Schedulewithweekdays generated by hbm2java
 */
@Entity
@Table(name = "schedulewithweekdays", catalog = "activizm", uniqueConstraints = @UniqueConstraint(columnNames = "userId"))
public class Schedulewithweekdays implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1427955029840994396L;
	private Integer sheldueWithWeekdaysId;
	private int userId;
	private Double mapPointX;
	private Double mapPointY;
	private Integer radius;
	private Integer weekday;
	private Date beginTime;
	private Date endTime;
	private User users;

	public Schedulewithweekdays() {
	}

	public Schedulewithweekdays(int userId) {
		this.userId = userId;
	}

	public Schedulewithweekdays(int userId, Double mapPointX, Double mapPointY,
			Integer radius, Integer weekday, Date beginTime, Date endTime,
			User users) {
		this.userId = userId;
		this.mapPointX = mapPointX;
		this.mapPointY = mapPointY;
		this.radius = radius;
		this.weekday = weekday;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sheldueWithWeekdaysId", unique = true, nullable = false)
	public Integer getSheldueWithWeekdaysId() {
		return this.sheldueWithWeekdaysId;
	}

	public void setSheldueWithWeekdaysId(Integer sheldueWithWeekdaysId) {
		this.sheldueWithWeekdaysId = sheldueWithWeekdaysId;
	}

	@Column(name = "userId", unique = true, nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	@Column(name = "Weekday")
	public Integer getWeekday() {
		return this.weekday;
	}

	public void setWeekday(Integer weekday) {
		this.weekday = weekday;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "beginTime", length = 19)
	public Date getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endTime", length = 19)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "phones")
	public User getUsers() {
		return this.users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

}
