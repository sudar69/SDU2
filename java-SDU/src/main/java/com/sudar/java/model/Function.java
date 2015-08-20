package com.sudar.java.model;

public class Function {
		
	private String name;
	
	private String type;
	
	private String description;
	
	private String nameFirstArgument;
	
	private String nameSecondArgument;
	
	private float x1[];
	private float x2[];
	private float y1[][];

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNameFirstArgument() {
		return nameFirstArgument;
	}

	public void setNameFirstArgument(String nameFirstArgument) {
		this.nameFirstArgument = nameFirstArgument;
	}

	public String getNameSecondArgument() {
		return nameSecondArgument;
	}

	public void setNameSecondArgument(String nameSecondArgument) {
		this.nameSecondArgument = nameSecondArgument;
	}

	public float[] getX1() {
		return x1;
	}

	public void setX1(float x1[]) {
		this.x1 = x1;
	}

	public float[] getX2() {
		return x2;
	}

	public void setX2(float x2[]) {
		this.x2 = x2;
	}

	public float[][] getY1() {
		return y1;
	}

	public void setY1(float y1[][]) {
		this.y1 = y1;
	}
	
}
