package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService{
	
	@Autowired
	EmployeRepository emplRepository;
	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

	@Override
	public List<Employe> retrieveAllEmployes() {
		List<Employe> employes=null;
		try {
			l.info("In method retrieveAllEmployes");
			employes = (List<Employe>) emplRepository.findAll();
			for (Employe employe : employes) {
			} 
			l.info("OUTof  method retrieveAllEmployes with SUCCESS");
		} catch (Exception e) {
			l.error("OUT of  method retrieveAllEmployes with ERROR : " + e);

		}
		return employes;
	}

	@Override
	public Employe addEmploye(Employe e) {

		l.info("In method addEmploye");
		Employe e_saved = emplRepository.save(e); 
		l.info("OUT of  method addEmploye with SUCCESS");	
		return e_saved;
	}

	@Override
	public void deleteEmploye(String id) {
		l.info("In method deleteEmploye");
		emplRepository.deleteById(Long.parseLong(id)); 
		l.info("OUT of  method deleteEmploye with SUCCESS");
	}

	@Override
	public Employe updateEmploye(Employe e) {
		l.info("In method updateEmploye");
		Employe e_saved = emplRepository.save(e); 
		l.info("OUT of  method updateEmploye with SUCCESS");
		return e_saved; 
	}

	@Override
	public Employe retrieveEmploye(String id) {
		Employe em = null;
		try{
		l.info("In method retrieveEmploye");
		 em = emplRepository.findById(Long.parseLong(id)).get();
		 l.info(em);
		l.info("OUT of  method retrieveEmploye with SUCCESS");
		} catch (Exception e) {
			l.error("error in retrieveEmploye : " + e);
		}
		return em; 
	}

}
