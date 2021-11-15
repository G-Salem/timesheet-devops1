package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	// TODO Logger à ajouter  
	
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
			l.info("In method retrieveAllUsers");
			users = (List<User>) userRepository.findAll();
			l.debug("connexion a la db OKKK");
			for (User user : users) {
			} 
			l.info("OUTof  method retrieveAllUsers with SUCCESS");
		}catch (Exception e) {
			l.error("OUT of  method retrieveAllUsers with ERROR : " + e);

		}

		return users;
	}


	@Override
	public User addUser(User u) {
		l.info("In method addUser");
		User u_saved = userRepository.save(u); 
		l.info("OUT of  method addUser with SUCCESS");

		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		l.info("In method updateUser");
		User u_saved = userRepository.save(u); 
		l.info("OUT of  method updateUser with SUCCESS");
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
			l.info("In method deleteUser");
			userRepository.deleteById(Long.parseLong(id)); 
			l.info("OUT of  method deleteUser with SUCCESS");
		
	}

	@Override
	public User retrieveUser(String id) {
		User u = null;
		try{
		l.info("In method retrieveUser");
		 u =  userRepository.findById(Long.parseLong(id)).get(); 
		l.info("OUT of  method retrieveUser with SUCCESS");
		} catch (Exception e) {
			l.error("error in retrieveUser : " + e);
		}
		return u; 
	}

}
