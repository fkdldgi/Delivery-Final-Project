package com.jhta.delivery.vo;

//null값이 들어오면 자바에서 오류를 잡아 진행이 되지 않아 null값이 들어가지 않게 수정
public class AddressVo {
	private String buildingCode="";
	private String zonecode="";
	private String address="";
	private String addressEnglish="";
	private String addressType="";
	private String userSelectedType="";
	private String userLanguageType="";
	private String roadAddress="";
	private String roadAddressEnglish="";
	private String jibunAddress="";
	private String jibunAddressEnglish="";
	private String buildingName="";
	private String apartment="";
	private String sido="";
	private String sigungu="";
	private String sigunguCode="";
	private String roadnameCode="";
	private String bcode="";
	private String roadname="";
	private String bname="";
	private String bname1="";
	private String bname2="";
	private String hname="";
	private String query="";
	private double addr_x=0;
	private double addr_y=0;
	
	public AddressVo() {}

	public AddressVo(String buildingCode, String zonecode, String address, String addressEnglish, String addressType,
			String userSelectedType, String userLanguageType, String roadAddress, String roadAddressEnglish,
			String jibunAddress, String jibunAddressEnglish, String buildingName, String apartment, String sido,
			String sigungu, String sigunguCode, String roadnameCode, String bcode, String roadname, String bname,
			String bname1, String bname2, String hname, String query, double addr_x, double addr_y) {
		super();
		if(buildingCode!=null)	this.buildingCode = buildingCode;
		if(zonecode!=null) this.zonecode = zonecode;
		if(address!=null) this.address = address;
		if(addressEnglish!=null) this.addressEnglish = addressEnglish;
		if(addressType!=null) this.addressType = addressType;
		if(userSelectedType!=null) this.userSelectedType = userSelectedType;
		if(userLanguageType!=null) this.userLanguageType = userLanguageType;
		if(roadAddress!=null) this.roadAddress = roadAddress;
		if(roadAddressEnglish!=null) this.roadAddressEnglish = roadAddressEnglish;
		if(jibunAddress!=null) this.jibunAddress = jibunAddress;
		if(jibunAddressEnglish!=null) this.jibunAddressEnglish = jibunAddressEnglish;
		if(buildingName!=null) this.buildingName = buildingName;
		if(apartment!=null) this.apartment = apartment;
		if(sido!=null) this.sido = sido;
		if(sigungu!=null) this.sigungu = sigungu;
		if(sigunguCode!=null) this.sigunguCode = sigunguCode;
		if(roadnameCode!=null) this.roadnameCode = roadnameCode;
		if(bcode!=null) this.bcode = bcode;
		if(roadname!=null) this.roadname = roadname;
		if(bname!=null) this.bname = bname;
		if(bname1!=null) this.bname1 = bname1;
		if(bname2!=null) this.bname2 = bname2;
		if(hname!=null) this.hname = hname;
		if(query!=null) this.query = query;
		if(addr_x!=0) this.addr_x = addr_x;
		if(addr_y!=0) this.addr_y = addr_y;
	}

	public String getBuildingCode() {
		return buildingCode;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	public String getZonecode() {
		return zonecode;
	}

	public void setZonecode(String zonecode) {
		this.zonecode = zonecode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressEnglish() {
		return addressEnglish;
	}

	public void setAddressEnglish(String addressEnglish) {
		this.addressEnglish = addressEnglish;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getUserSelectedType() {
		return userSelectedType;
	}

	public void setUserSelectedType(String userSelectedType) {
		this.userSelectedType = userSelectedType;
	}

	public String getUserLanguageType() {
		return userLanguageType;
	}

	public void setUserLanguageType(String userLanguageType) {
		this.userLanguageType = userLanguageType;
	}

	public String getRoadAddress() {
		return roadAddress;
	}

	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}

	public String getRoadAddressEnglish() {
		return roadAddressEnglish;
	}

	public void setRoadAddressEnglish(String roadAddressEnglish) {
		this.roadAddressEnglish = roadAddressEnglish;
	}

	public String getJibunAddress() {
		return jibunAddress;
	}

	public void setJibunAddress(String jibunAddress) {
		this.jibunAddress = jibunAddress;
	}

	public String getJibunAddressEnglish() {
		return jibunAddressEnglish;
	}

	public void setJibunAddressEnglish(String jibunAddressEnglish) {
		this.jibunAddressEnglish = jibunAddressEnglish;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}

	public String getSigunguCode() {
		return sigunguCode;
	}

	public void setSigunguCode(String sigunguCode) {
		this.sigunguCode = sigunguCode;
	}

	public String getRoadnameCode() {
		return roadnameCode;
	}

	public void setRoadnameCode(String roadnameCode) {
		this.roadnameCode = roadnameCode;
	}

	public String getBcode() {
		return bcode;
	}

	public void setBcode(String bcode) {
		this.bcode = bcode;
	}

	public String getRoadname() {
		return roadname;
	}

	public void setRoadname(String roadname) {
		this.roadname = roadname;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBname1() {
		return bname1;
	}

	public void setBname1(String bname1) {
		this.bname1 = bname1;
	}

	public String getBname2() {
		return bname2;
	}

	public void setBname2(String bname2) {
		this.bname2 = bname2;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public double getAddr_x() {
		return addr_x;
	}

	public void setAddr_x(double addr_x) {
		this.addr_x = addr_x;
	}

	public double getAddr_y() {
		return addr_y;
	}

	public void setAddr_y(double addr_y) {
		this.addr_y = addr_y;
	}
	
	
}
