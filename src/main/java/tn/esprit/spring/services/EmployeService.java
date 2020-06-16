package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeService {
	@Autowired
	EmployeRepository employeRepository;
	public Employe authenticate(String login, String password) {
		// TODO Auto-generated method stub
		return employeRepository.getEmployeByEmailAndPassword(login, password);
	}
}
