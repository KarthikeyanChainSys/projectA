package com.chainsys.springproject.beans;

public class LunchFactory {
	public Lunch createNonvegSouthIndianLunch() {
		Starters s1 = new Chicken();
		s1.name = "Honey Chicken";
		MainCourse m = new SouthIndian();
		m.name = "Rice";
		Desset d = new Cakes();
		d.name = "Choco Brownie";
		Lunch l = new Lunch(s1, m, d);
		return l;
	}
	public Lunch createVegSouthIndianLunch() {
		Starters s1 = new Vegroll();
		s1.name = "Cabbageroll";
		MainCourse m = new SouthIndian();
		m.name = "Rice";
		Desset d = new Icecream();
		d.name = "Butterscotch";
		Lunch l = new Lunch(s1, m, d);
		return l;
	}
	public Lunch createNorthIndianLunch() {
		Starters s1 = new Soup();
		s1.name = "Sweetcorn";
		MainCourse m = new NorthIndian();
		m.name = "Chappathi";
		Desset d = new Sweets();
		d.name = "Rasagulla";
		Lunch l = new Lunch(s1, m, d);
		return l;
	}
	public Lunch createChineseLunch() {
		Starters s1 = new Vegroll();
		s1.name = "Springroll";
		MainCourse m = new Chinese();
		m.name = "Noodles";
		Desset d = new Icecream();
		d.name = "Snake";
		Lunch l = new Lunch(s1, m, d);
		return l;
	}
}
