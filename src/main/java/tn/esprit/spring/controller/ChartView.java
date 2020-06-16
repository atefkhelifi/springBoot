package tn.esprit.spring.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Livreur;
import tn.esprit.spring.repository.LivreurRepository;

@Named
@RequestScoped
public class ChartView implements Serializable{
@Autowired
LivreurRepository livreurRepo;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BarChartModel barModel;

	/**
	 * @return the barModel
	 */
	public BarChartModel getBarModel() {
		return barModel;
	}

	/**
	 * @param barModel the barModel to set
	 */
	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}
	@PostConstruct
	public void init() {

		createBarModels();
		// createBarModels2();

	}
	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();
		List<Livreur> livreur = livreurRepo.findAll();
		ChartSeries boys = new ChartSeries();
		boys.setLabel("Livreurs");
		

		
		  for (Livreur livreurs : livreur) { boys.set(livreurs.getNomLivreur(),
		  livreurRepo.getAllLivraison(livreurs.getLivreurId()).size());
		  
		  }
		 
		
		model.addSeries(boys);

		return model;
	}
	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Meilleurs livreurs");
		barModel.setAnimate(true);
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("livreur");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Nombre de livraisons");
		yAxis.setMin(0);
		yAxis.setMax(6);
	}
	
	private void createBarModels() {
		createBarModel();
	
	}
}
