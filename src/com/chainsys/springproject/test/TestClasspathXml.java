package com.chainsys.springproject.test;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.springproject.autowire.Car;
import com.chainsys.springproject.autowire.CarServices;
import com.chainsys.springproject.beans.Actor;
import com.chainsys.springproject.beans.Calender;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.beans.Lunch;
import com.chainsys.springproject.beans.ScoreBoard;
import com.chainsys.springproject.lifecycle.Annotationlc;
import com.chainsys.springproject.lifecycle.InitDesposeBean;
import com.chainsys.springproject.lifecycle.LifeCycleBean;

public class TestClasspathXml {
	public static void testA() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("tom");
		emp.print();
	}

	public static void testB() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		// Employee emp = ac.getBean (Employee.class);
		Employee emp = (Employee) ac.getBean("emp");
		emp.setId(2);
		emp.setName("jerry");
		emp.print();
		Customer c = ac.getBean(Customer.class);
		c.setId(3);
		c.setName("tommy");
		c.print();
	}

	public static void testlazyinit() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp = ac.getBean(Employee.class);
		Customer c = ac.getBean(Customer.class);
// lazy-init="true" for customer . An object is created now(firstcall to getBean() method for Customer.class)
		Employee emp2 = ac.getBean(Employee.class);
		Customer c2 = ac.getBean(Customer.class);
		System.out.println(emp.hashCode());
		System.out.println(emp2.hashCode());
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
	}
	
	public static void testPrototype() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Actor hero = ac.getBean(Actor.class);
		Actor heroin = ac.getBean(Actor.class);
		Actor villan = ac.getBean(Actor.class);
		Actor comedian = ac.getBean(Actor.class);
		System.out.println(hero.hashCode());
		System.out.println(heroin.hashCode());
		System.out.println(villan.hashCode());
		System.out.println(comedian.hashCode());
	}
	public static void testBeanWithConstructor() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	}
	public static void testFactoryMethod() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ScoreBoard sb = ac.getBean("sb1",ScoreBoard.class);
		sb.targetScore = 183;
		System.out.println(sb.targetScore);
		ScoreBoard sb2 = ac.getBean("sb2",ScoreBoard.class);
		System.out.println(sb2.targetScore);
	}
	public static void testCalenderFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calender today = ac.getBean(Calender.class);
		today.day = 25;
		today.month = "November";
		today.year = 2022;
		System.out.println(today.day);
		System.out.println(today.month);
		System.out.println(today.year);
	}
	
	public static void testLunchFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("lunch.xml");
		Lunch nvsilunch = ac.getBean("nvsilunch", Lunch.class);
		Lunch vsilunch = ac.getBean("vsilunch", Lunch.class);
		Lunch nilunch = ac.getBean("nilunch", Lunch.class);
		Lunch chlunch = ac.getBean("chlunch", Lunch.class);
		nvsilunch.serve();
		System.out.println("------------");
		vsilunch.serve();
		System.out.println("------------");
		nilunch.serve();
		System.out.println("------------");
		chlunch.serve();
	}
	
	public static void testSetterDI() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp = ac.getBean("emp3",Employee.class);
        emp.print();
	}
	
	public static void testLifeCycle() {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("lc.xml");
		LifeCycleBean life = ac.getBean(LifeCycleBean.class);
		life.print();
		life = null;
		//System.gc();
		ac.close();
		ac=null;
	}
	public static void testInitDestroyBean() { 
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("lc.xml");
		InitDesposeBean init = ac.getBean(InitDesposeBean.class);
		init.print();
	}
	public static void testAnnotationlc() { 
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("lc.xml");
		Annotationlc ann = ac.getBean(Annotationlc.class);
		ann.print();
		ann = null;
		ac.close();
	}
	public static void testAutoWire() { 
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("autowire.xml");
		Car car = ac.getBean("car",Car.class);
		car.start();
		car.move();
		car = null;
		ac.close();
	}
	public static void testAutoWireQualifier() {
        ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("autowire.xml");
        CarServices cs = ac.getBean(CarServices.class);
        cs.startTrip();
        cs = null;
        ac.close();
    }
}

