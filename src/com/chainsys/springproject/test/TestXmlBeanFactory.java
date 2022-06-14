package com.chainsys.springproject.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
public class TestXmlBeanFactory {
	public static void testA() {
		//ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ClassPathResource res = new ClassPathResource("beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory (res);
		Employee emp = factory.getBean("emp2", Employee.class);
		emp.setId(1);
		emp.setName("Tommy");
		emp.print();
		System.out.println(factory.isSingleton("emp"));
		// instanceof - to check Employee object, it returns boolean type (true or false)
		System.out.println(factory.getBean("emp") instanceof Employee);
		System.out.println(factory.getBean("emp") instanceof Customer);
		System.out.println(factory.isPrototype("emp"));
		// isTypeMatch and instanceof both are similar
		System.out.println(factory.isTypeMatch("emp", Employee.class));
	}
}
