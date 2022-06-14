package com.chainsys.springproject.beans;

public abstract class Desset {
	public String name;
}

class Icecream extends Desset {
	public Icecream() {
	name = "Chocolate";
}
}

class Sweets extends Desset {
	public Sweets() {
	name = "Rasagulla";
}
}
class Cakes extends Desset {
	public Cakes() {
		name = "Russianvelvet";
	}
	public Cakes (String name) { 
		this.name = name;
	}
}

	


