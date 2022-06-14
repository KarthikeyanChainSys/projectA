package com.chainsys.springproject.beans;

public class Wheel {
	public void rotate() {
		System.out.println("Wheel is rotated : " + hashCode());
	}
	public Wheel() {
		System.out.println("Wheel object created : " + hashCode());
	}
}
