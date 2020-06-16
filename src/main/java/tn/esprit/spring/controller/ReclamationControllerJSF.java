package tn.esprit.spring.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Decision;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Livraison;
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.ZoneMap;
import tn.esprit.spring.services.EmployeService;
import tn.esprit.spring.services.ReclamationServiceImpl;

@ViewScoped
@Controller(value = "jsfReclamationController")
@ELBeanName(value = "jsfReclamationController")

public class ReclamationControllerJSF {
	
	@Autowired
	HomeController employeController;
	 @Autowired
	    public JavaMailSender emailSender;
	@Autowired
	private ReclamationServiceImpl reclamationService;
	@Autowired
	EmployeService employeService;
	private String login; 
	private String password;
	private Reclamation reclamation;
	private Employe employe;
	
	//private String email;
	private String titre; 
	private String contenu;
	private Date date =new Date(); 
	private Decision decision;
	
	private Employe client;
	private List <Reclamation> reclamations;
	private String nom;
	private String prenom;

	
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the reclamations
	 */
	public List<Reclamation> getReclamations() {
		reclamations=(List<Reclamation>) reclamationService.afficherAllReclamations();
		return reclamations;
	}

	/**
	 * @param reclamations the reclamations to set
	 */
	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the contenu
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * @param contenu the contenu to set
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the decision
	 */
	public Decision getDecision() {
		return decision;
	}
	public Decision[] getDecisions() {
		return Decision.values();
		}
	/**
	 * @param decision the decision to set
	 */
	public void setDecision(Decision decision) {
		this.decision = decision;
	}

	/**
	 * @return the client
	 */
	public Employe getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Employe client) {
		this.client = client;
	}
	
	public String addReclamation() throws MalformedURLException, IOException, MessagingException, DocumentException{
		String navigateTo = "null";
		if (employeController.getAuthenticatedUser()==null || !employeController.getLoggedIn()) return "/xhtml/login.xhtml";
		client=employeService.authenticate(login, password);
		Document document = new Document();
	    
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld5.pdf"));
	        document.open();
	        //livreur.getZone()==ZoneMap.SFAX_GABES_MAHDIA_MOUNASTIR_SOUSSE
	        if (decision==Decision.autres){
	        document.add(new Paragraph("Mail de Remboursement \n  notre chér Client, " +employeController.getAuthenticatedUser().getNom()+" suite à votre demande du produit , on vous envoie cet E-mail \n" + 
	        		"pour s'excuser à propos du produit que vous avez reçu , En fait c'une faute hors de notre conrole \r\n" + 
	        		"Donc on vous invite à se présenter chez nous avec ce mail pour  \n" + 
	        		"te donner une compensation , encore une fois nous sommes désolés \n" + 
	        		"merci pour votre compréhension \n" + 
	        		"A tres Bientot \n" + 
	        		"\n" + 
	        		"Cordialement "));
	        }
	        else if (decision==Decision.probleme_design) {
	        	document.add(new Paragraph("Mail de Réparation \n   notre chér Client, " +employeController.getAuthenticatedUser().getNom()+" suite à votre demande du produit , on vous envoie cet E-mail \n" + 
	        			"pour s'excuser à propos du produit que vous avez reçu , En fait c'une faute hors de notre conrole \\r\\n\" + \r\n" + 
	        			"Donc on vous invite à se présenter chez nous avec ce mail pour  \n" + 
	        			"te donner une compensation , encore une fois nous sommes désolés \n" + 
	        			"merci pour votre compréhension \n" + 
	        			"A tres Bientot \n" + 
	        			"\n" + 
	        			"Cordialement "));
	        }
	        else if (decision==Decision.probleme_technique) {
	        	document.add(new Paragraph("Mail de Echange \n  notre chér Client, " +employeController.getAuthenticatedUser().getNom()+" suite à votre demande du produit , on vous envoie cet E-mail \n" + 
	        			"pour s'excuser à propos du produit que vous avez reçu , En fait c'une faute hors de notre conrole \n" + 
	        			"Donc on vous invite à se présenter chez nous avec ce mail pour \n" + 
	        			"te donner une compensation , encore une fois nous sommes désolés \n" + 
	        			"merci pour votre compréhension \n" + 
	        			"A tres Bientot  \n" + 
	        			"\n" + 
	        			"Cordialement \" ")); 	
	        }
	        
	        	String imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTyAFL3qzVfL_LLWgB4aKicUhPP_AbbTXB_W8s46Ces4saMdtHw&usqp=CAU";
	        Image image2 = Image.getInstance(new URL(imageUrl));
	      //Fixed Positioning
	        image2.setAbsolutePosition(0f, 0f);
	        //Scale to new height and new width of image
	        image2.scaleAbsolute(70, 40);
	        document.add(image2);
	        document.close();
	        writer.close();
	    

		//livraisonService.addLivraison(new Livraison( lat,lon,contry,localisation));
	
	// Document document = new Document();
     MimeMessage message = emailSender.createMimeMessage();
	 
	    boolean multipart = true;
 
	    MimeMessageHelper helper = new MimeMessageHelper(message, multipart);
 
	    helper.setTo(employeController.getAuthenticatedUser().getEmail());
	    helper.setSubject("Reclamation");
	     
	    helper.setText("Hello, Im testing email with attachments!");
	     
	    String path1 = "C:\\Users\\atefk\\Desktop\\template\\HelloWorld5.pdf";
	   // String path2 = "/home/tran/Downloads/readme.zip";
 
	    // Attachment 1
	    FileSystemResource file1 = new FileSystemResource(new File(path1));
	    helper.addAttachment("file.pdf", file1);
 
	    // Attachment 2
	    //FileSystemResource file2 = new FileSystemResource(new File(path2));
	    //helper.addAttachment("Readme", file2);
 
	    emailSender.send(message);
 
	reclamationService.addReclamation(new Reclamation(	employeController.getAuthenticatedUser().getNom(),employeController.getAuthenticatedUser().getPrenom(),titre,contenu,date,decision));
	return navigateTo;
	}

}
