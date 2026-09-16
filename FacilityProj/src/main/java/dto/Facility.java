package dto;

public class Facility {
	String facId;
	String facType;
	String facTypeName;
	String facNm;
	Integer price;
	String availableTime;
	String etc;
	
	public Facility() {
		super();
	}
	
	public Facility(String facId, String facType, String facTypeName, String facNm, Integer price, String availableTime,
			String etc) {
		super();
		this.facId = facId;
		this.facType = facType;
		this.facTypeName = facTypeName;
		this.facNm = facNm;
		this.price = price;
		this.availableTime = availableTime;
		this.etc = etc;
	}
	public String getFacId() {
		return facId;
	}
	public void setFacId(String facId) {
		this.facId = facId;
	}
	public String getFacType() {
		return facType;
	}
	public void setFacType(String facType) {
		this.facType = facType;
	}
	public String getFacTypeName() {
		return facTypeName;
	}
	public void setFacTypeName(String facTypeName) {
		this.facTypeName = facTypeName;
	}
	public String getFacNm() {
		return facNm;
	}
	public void setFacNm(String facNm) {
		this.facNm = facNm;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}

	@Override
	public String toString() {
		return "Facility [facId=" + facId + ", facType=" + facType + ", facTypeName=" + facTypeName + ", facNm=" + facNm + ", price="
				+ price + ", availableTime=" + availableTime + ", etc=" + etc 
				+ "]";
	}
	
	
}
