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
@Table(name="city1")

public class CityVo {
	@Id
	@Column(name="cityId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cityId;
	
	@Column(name="cityName")
	private String cityName;
	
	
	@ManyToOne
	@JoinColumn(name="stateId")
	private StateVo stateId;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public StateVo getStateId() {
		return stateId;
	}

	public void setStateId(StateVo stateId) {
		this.stateId = stateId;
	}
	
	
	
}
