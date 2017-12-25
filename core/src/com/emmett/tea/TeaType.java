package com.emmett.tea;

public enum TeaType {

	ENGLISH_BREAKFAST("English Breakfast"),
	EARL_GREY("Earl Grey"),
	IRISH_BREAKFAST("Irish Breakfast"),
	HOT_WATER("Hot Water");

	private String name;

	TeaType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
