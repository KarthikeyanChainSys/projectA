package com.chainsys.springproject.beans;

public class Lunch {
	private Starters entree;
	private MainCourse mainfood;
	private Desset sweets;
	// Constructor based Dependency Injection
	public Lunch(Starters s, MainCourse m, Desset d) {
		System.out.println("Lunch is ready");
		entree = s;
		mainfood = m;
		sweets = d;
	}
	public void serve() {
		System.out.println(entree.name);
		System.out.println(mainfood.name);
		System.out.println(sweets.name);
	}
}
/*
 *  Lunch
 *  Starters, Chicken, Soup, Vegroll 
 *  Maincourse, South Indian, NorthIndian, Chinese 
 *  Deserts, Icecream, Sweets, Cakes I
 */