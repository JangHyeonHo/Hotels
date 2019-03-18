package com.hotels.peregrine.model;

import java.io.Serializable;

/**
 * 자재(material) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★matNo</b> 자재 번호 <b>Primary Key</b><br>
 * <b>★matName</b> 자재 명<br>
 * <b>★matKind</b> 자재 종류<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★contract.consNo</b> 계약 업체(contract)테이블 <b>Foreign Key</b><br>
 * @version 1.0
 * */
public class MaterialDTO implements Serializable {
	private int matNo;
	private String matName;
	private String matKind;
	private ContractDTO contract;
	public int getMatNo() {
		return matNo;
	}
	public MaterialDTO setMatNo(int matNo) {
		this.matNo = matNo;
		return this;
	}
	public String getMatName() {
		return matName;
	}
	public MaterialDTO setMatName(String matName) {
		this.matName = matName;
		return this;
	}
	public String getMatKind() {
		return matKind;
	}
	public MaterialDTO setMatKind(String matKind) {
		this.matKind = matKind;
		return this;
	}
	public ContractDTO getContract() {
		return contract;
	}
	public MaterialDTO setContract(ContractDTO contract) {
		this.contract = contract;
		return this;
	}
	
	
}
