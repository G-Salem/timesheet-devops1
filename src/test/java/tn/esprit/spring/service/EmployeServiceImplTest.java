package tn.esprit.spring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

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
		Employe e = new Employe ("ahmed","ahmed","ahmed@ahmed.com","password",true,Role.CHEF_DEPARTEMENT);
		Employe employeAdded = es.addEmploye(e);
		Assertions.assertEquals(e.getNom(),employeAdded.getNom());
	}

/*
	
	public void updateEmployeTest() {
		Employe e = new Employe (1,"ahmed","ahmed","ahmed@ahmed.com","password",true,Role.CHEF_DEPARTEMENT);
		Employe employeAdded = es.addEmploye(e);
		Assertions.assertEquals(e.getNom(),employeAdded.getNom());
	}

	
	public void retrieveEmployeTest() {
		Employe employeRetieved = es.retrieveEmploye("2");
		Assertions.assertEquals(2L, employeRetieved.getId());
		}
	
	public void deleteEmployeTest() {
		es.deleteEmploye("7");
		Assertions.assertNull(es.retrieveEmploye("7"));

	}
*/

}
