package com.chainsys.springproject.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
// Not working from java 9 and higher versions
public class Annotationlc {
	public Annotationlc() {
		System.out.println("Annotationlc object created : " + hashCode());
	}
	@PostConstruct
	public void start() {
		System.out.println("Start Annotationlc...");
	}
	@PreDestroy
	public void stop() {
		System.out.println("Stop Annotationlc...");
	}
	public void print() {
		System.out.println("Print Annotationlc called");
	}
}
