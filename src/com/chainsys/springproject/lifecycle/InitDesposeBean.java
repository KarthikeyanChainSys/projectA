package com.chainsys.springproject.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.config.BeanPostProcessor; // Refer AOP

public class InitDesposeBean implements DisposableBean, InitializingBean {
	private String city;
	private long pinCode;
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}
	// Called after setters
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet called");
	}
	// Similar to destroy-method
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy  method called");
	}
	public InitDesposeBean() {
		System.out.println("InitDesponseBean object created : " + hashCode());
	}
	// After Constructor
	public void setUp() {
		System.out.println("Starting InitDesponseBean...");
	}
	public void close() {
		System.out.println("Closing InitDesponseBean...");
	}
	public void print() {
		System.out.println("Print Called InitDesponseBean");
	}
}
