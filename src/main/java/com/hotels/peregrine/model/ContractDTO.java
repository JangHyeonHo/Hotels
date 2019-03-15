package com.hotels.peregrine.model;

import java.util.Date;

/**
 * 계약(contract) 테이블에 관한 것<br>
 * <p>★표시는 not null을 말함<br>
 * <b>변수</b><br>
 * <b>★contNo</b> 계약 번호 <b>Primary Key</b><br>
 * <b>contRegDate</b> 계약 등록일<br>
 * <b>contMatKind</b> 주 납품 자재종류<br>
 * <b>관계 테이블</b><br>
 * 『해당하는 테이블의 이름.getter, setter로 이용할 수 있음』<br>
 * <b>★distributor.disName</b> 유통업체(distributor)테이블 <b>Foreign Key</b><br>
 * @version 1.0
 * */
public class ContractDTO {
	private int contNo;
	private Date contRegDate;
	private String contMatKind;
	private DistributorDTO distributor;
	public int getContNo() {
		return contNo;
	}
	public ContractDTO setContNo(int contNo) {
		this.contNo = contNo;
		return this;
	}
	public Date getContRegDate() {
		return contRegDate;
	}
	public ContractDTO setContRegDate(Date contRegDate) {
		this.contRegDate = contRegDate;
		return this;
	}
	public String getContMatKind() {
		return contMatKind;
	}
	public ContractDTO setContMatKind(String contMatKind) {
		this.contMatKind = contMatKind;
		return this;
	}
	public DistributorDTO getDistributor() {
		return distributor;
	}
	public ContractDTO setDistributor(DistributorDTO distributor) {
		this.distributor = distributor;
		return this;
	}
	
}
