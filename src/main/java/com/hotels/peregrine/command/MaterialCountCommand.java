package com.hotels.peregrine.command;

import java.io.Serializable;

import com.hotels.peregrine.model.ContractDTO;

public class MaterialCountCommand implements Serializable{
	
	private int matNo;
	private String matName;
	private String matKind;
	private ContractDTO contract;
	private int counting;

	public int getMatNo() {
		return matNo;
	}
	public void setMatNo(int matNo) {
		this.matNo = matNo;
	}
	public String getMatName() {
		return matName;
	}
	public void setMatName(String matName) {
		this.matName = matName;
	}
	public String getMatKind() {
		return matKind;
	}
	public void setMatKind(String matKind) {
		this.matKind = matKind;
	}
	public ContractDTO getContract() {
		return contract;
	}
	public void setContract(ContractDTO contract) {
		this.contract = contract;
	}
	public int getCounting() {
		return counting;
	}
	public void setCounting(int counting) {
		this.counting = counting;
	}
	
	
}
