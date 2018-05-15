package br.pucpr.sample;

public class Dog {
	private String name;
	private Race race;
	private int age;
	private double price;
	private boolean diseased = false;
	
	public Dog(String name, Race race, int age, double price) {
		super();
		this.name = name;
		this.race = race;
		this.age = age;
		this.price = price;
	}
	
	public Dog(String name, Race race, int age) {
		super();
		this.name = name;
		this.race = race;
		this.age = age;
		this.price = 0;
		this.diseased = true;
	}

	public String getName() {
		return name;
	}

	public Race getRace() {
		return race;
	}

	public double getPrice() {
		return price;
	}

	public boolean isDiseased() {
		return diseased;
	}

	public int getAge() {
		return age;
	}
}
