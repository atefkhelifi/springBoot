package tn.esprit.spring.entities;

import javax.faces.bean.ManagedBean;

@ManagedBean  

public class Rating {
	private Integer rating;  
	public Integer getRating() {  
	return rating;  
	}  
	public void setRating(Integer rating) {  
	this.rating = rating;  
	}  
}
