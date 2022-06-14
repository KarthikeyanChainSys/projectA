package com.chainsys.springproject.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

public class Car {
	@Autowired
	private Engine petrolEngine;
	@Autowired
	private Wheel alloy;

	public Car() {
		System.out.println("Car object created : " + hashCode());
	}
	
	public void begin() {
		System.out.println("Start Annotations...");
	}
	
	public void stop() {
		System.out.println("Stop Annotations...");
	}
	
	public void start() {
		petrolEngine.start();
	}

	public void move() {
		alloy.rotate();
	}
}
@Component("SportsCar")
class SportsCar extends Car {
	public SportsCar() {
		System.out.println("Sports car created : " + hashCode());
	}
}
@Component("SuvCar")
class SuvCar extends Car {
	public SuvCar() {
		System.out.println("Suv car created : " + hashCode());
	}
}