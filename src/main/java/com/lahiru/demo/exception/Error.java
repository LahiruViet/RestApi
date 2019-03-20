package com.lahiru.demo.exception;

public class Error {

	private Integer code;
	private String description;
	private String url;

	public Error() {
		super();
	}

	public Error(Integer code, String description, String url) {
		super();
		this.code = code;
		this.description = description;
		this.url = url;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Error [code=" + code + ", description=" + description + ", url=" + url + "]";
	}

}
