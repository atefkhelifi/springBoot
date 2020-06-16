package tn.esprit.spring.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Employe;



public interface EmployeRepository extends CrudRepository<Employe, Integer>  {
	
	
	
    @Query("SELECT e FROM Employe e WHERE e.email=:email and e.password=:password")
    public Employe getEmployeByEmailAndPassword(@Param("email")String login,
    @Param("password")String password);
   

}
