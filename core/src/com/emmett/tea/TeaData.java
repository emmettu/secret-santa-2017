package com.emmett.tea;

public class TeaData {

	private double milk;
	private double sugar;
	private TeaType type;
	private boolean receivingMilk;
	private boolean receivingSugar;

	public TeaData() {
		this.type = TeaType.HOT_WATER;
		this.milk = 0.0;
		this.receivingMilk = false;
		this.receivingSugar = false;
	}

	public void addMilk(double milk) {
		this.milk += milk;
	}

	public void addSugar(double sugar) {
		this.sugar += sugar;
	}

	public void setMilk(double milk) {
		this.milk = milk;
	}

	public void setSugar(double sugar) {
		this.sugar = sugar;
	}

	public TeaType getType() {
		return type;
	}

	public void setType(TeaType type) {
		if (this.type == TeaType.HOT_WATER) {
			this.type = type;
		}
	}

	public boolean isReceivingMilk() {
		return this.receivingMilk;
	}

	public void receivingMilk() {
		this.receivingMilk = true;
	}

	public void notReceivingMilk() {
		this.receivingMilk = false;
	}

	public double milkLevel() {
		return milk;
	}

	public boolean isReceivingSugar() {
		return this.receivingSugar;
	}

	public void receivingSugar() {
		this.receivingSugar = true;
	}

	public void notReceivingSugar() {
		this.receivingSugar = false;
	}

	public double sugarLevel() {
		return sugar;
	}

}
