package com.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="area1")

public class AreaVo {
	@Id
	@Column(name="areaId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int areaId;
	private String areaName;
	
	@ManyToOne
	@JoinColumn(name="stateId")
	private StateVo stateId;
	
	@ManyToOne
	@JoinColumn(name="cityId")
	private CityVo cityId;

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public StateVo getStateId() {
		return stateId;
	}

	public void setStateId(StateVo stateId) {
		this.stateId = stateId;
	}

	public CityVo getCityId() {
		return cityId;
	}

	public void setCityId(CityVo cityId) {
		this.cityId = cityId;
	}
	

}
