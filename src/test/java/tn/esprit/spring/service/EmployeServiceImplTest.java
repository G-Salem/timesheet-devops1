package tn.esprit.spring.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class EmployeServiceImplTest  {
	@Autowired
	IEmployeService es;
	
	@Test
	@Order(1)
	public void retrieveAllEmployesTest() {
		List<Employe> listEmployes = es.retrieveAllEmployes();
		Assertions.assertEquals(0, listEmployes.size());
	}
	
	@Test
	@Order(2)
	public void addEmployeTest() {
		Employe e = new Employe ("qqq","qqqqq","qqqmq@ahmed.com","password",true,Role.CHEF_DEPARTEMENT);
		Employe employeAdded = es.addEmploye(e);
		Assertions.assertEquals(e.getNom(),employeAdded.getNom());
	}

	@Test
	@Order(3)
	public void updateEmployeTest() {
		Employe e = new Employe (1L,"zzzz","zzzz","zzzz@ahmed.com","password",true,Role.CHEF_DEPARTEMENT);
		Employe employeAdded = es.addEmploye(e);
		Assertions.assertEquals(e.getNom(),employeAdded.getNom());
	}
	
	
	@Test
	@Order(4)
	public void retrieveEmployeTest() {
		Employe emplRetrieved = es.retrieveEmploye("1");
		Assertions.assertEquals(1L, emplRetrieved.getId().longValue());		
	}
	@Test
	@Order(5)
	public void deleteEmployeTest() {
		es.deleteEmploye("1");
		Assertions.assertNull(es.retrieveEmploye("1"));

	}


}
