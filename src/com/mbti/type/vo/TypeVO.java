package com.mbti.type.vo;

public class TypeVO {

	private Long no;
	private String type, image, content, gType, gImage, bType, bImage;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getgType() {
		return gType;
	}
	public void setgType(String gType) {
		this.gType = gType;
	}
	public String getgImage() {
		return gImage;
	}
	public void setgImage(String gImage) {
		this.gImage = gImage;
	}
	public String getbType() {
		return bType;
	}
	public void setbType(String bType) {
		this.bType = bType;
	}
	public String getbImage() {
		return bImage;
	}
	public void setbImage(String bImage) {
		this.bImage = bImage;
	}
	
	@Override
	public String toString() {
		return "TypeVO [no=" + no + ", type=" + type + ", image=" + image + ", content=" + content + ", gType=" + gType
				+ ", gImage=" + gImage + ", bType=" + bType + ", bImage=" + bImage + "]";
	}
	
}
