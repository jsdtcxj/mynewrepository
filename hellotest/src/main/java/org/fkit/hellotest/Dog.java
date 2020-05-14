package org.fkit.hellotest;

public class Dog implements Annimal, Pet, Area{

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return Pet.super.getName();
	}

	public static void main(String[] args) {
		Dog d = new Dog();
		System.out.println(d.getName());
		System.out.println(d.getLocation());
	}
}
