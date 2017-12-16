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
@Table(name="loanRate")
public class LoanRateVo {
	@Id
	@Column(name="loanRateId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int loanRateId;
	

	@ManyToOne
	@JoinColumn(name="loanType")
	private LoanVo loanType;
	
	private float loanRate;

	public int getLoanRateId() {
		return loanRateId;
	}

	public void setLoanRateId(int loanRateId) {
		this.loanRateId = loanRateId;
	}

	public LoanVo getLoanType() {
		return loanType;
	}

	public void setLoanType(LoanVo loanType) {
		this.loanType = loanType;
	}

	public float getLoanRate() {
		return loanRate;
	}

	public void setLoanRate(float loanRate) {
		this.loanRate = loanRate;
	}
	
}
