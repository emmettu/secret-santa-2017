package com.emmett.tea;

public class TeaData {

	private double milk;
	private TeaType type;
	private boolean receivingMilk;

	public TeaData() {
		this.type = TeaType.HOT_WATER;
		this.milk = 0.0;
		this.receivingMilk = false;
	}

	public void addMilk(double milk) {
		this.milk += milk;
	}

	public void setMilk(double milk) {
		this.milk = milk;
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

}
