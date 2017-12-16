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
@Table(name="branch1")
public class BranchVo {
	@Id
	@Column(name="branchId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int branchId;
	private String branchName;
	
	@ManyToOne
	@JoinColumn(name="stateId")
	private StateVo stateId;
	
	@ManyToOne
	@JoinColumn(name="cityId")
	private CityVo cityId;
	
	@ManyToOne
	@JoinColumn(name="areaId")
	private AreaVo areaId;

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
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

	public AreaVo getAreaId() {
		return areaId;
	}

	public void setAreaId(AreaVo areaId) {
		this.areaId = areaId;
	}

	
	
}
