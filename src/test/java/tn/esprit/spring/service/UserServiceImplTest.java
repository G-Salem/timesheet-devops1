package tn.esprit.spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceImplTest {
	@Autowired
	IUserService us;
	
	@Test
	@Order(1)
	public void testRetrieveAllUsers() {
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(0, listUsers.size());
	}
	
	@Test
	@Order(2)
	public void testAddUser() throws java.text.ParseException   {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-05-23");
		User u = new User ("samir","999",d,Role.STUDENT);
		User userAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName() , userAdded.getLastName());
	}
	
	@Test
	@Order(3)
	public void testModifyUser()  throws java.text.ParseException   {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-05-23");
		User u = new User (1L,"MO","SALAH",d,Role.STUDENT);
		User userupdated = us.updateUser(u);
		Assertions.assertEquals(u.getLastName() , userupdated.getLastName());
	}
		
	@Test
	@Order(4)
	public void testRetrieveUser() {
		User userRetieved = us.retrieveUser("1");
		Assertions.assertEquals(1L, userRetieved.getId().longValue());
	}
	
	@Test
	@Order(5)
	public void testDeleteUser() {
		us.deleteUser("1");
		Assertions.assertNull(us.retrieveUser("1"));
	}
	 
	 
	
	
}
