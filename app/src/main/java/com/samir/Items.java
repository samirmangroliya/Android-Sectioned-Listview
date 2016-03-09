package com.samir;

public class Items implements Item, Comparable<Items> {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSectionItem() {
		return false;
	}

	@Override
	public int compareTo(Items another) {
		return this.getName().compareTo(another.getName());
	}

}