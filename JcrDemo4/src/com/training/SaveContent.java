package com.training;
import javax.jcr.Repository; 
import javax.jcr.Session; 
import javax.jcr.SimpleCredentials;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jcr.Node; 
import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.jackrabbit.ocm.manager.ObjectContentManager;
import org.apache.jackrabbit.ocm.manager.impl.ObjectContentManagerImpl;
import org.apache.jackrabbit.ocm.mapper.Mapper;
import org.apache.jackrabbit.ocm.mapper.impl.annotation.AnnotationMapperImpl;

public class SaveContent {

	public static void main(String[] args) throws Exception { 
	    Repository repository = JcrUtils.getRepository();
	        Session session = repository.login( 
	        new SimpleCredentials("admin", "admin".toCharArray()));
	        try { 
	        	List<Class> classes = new ArrayList<Class>();   
	        	classes.add(Film.class); // Call this method for each persistent class
	        	classes.add(Review.class);
	        	
	        	Mapper mapper = new AnnotationMapperImpl(classes);
	        	ObjectContentManager ocm =  new ObjectContentManagerImpl(session, mapper);  

	        	
	        	Review review1 = new Review();
	        	review1.setPath("/review1");
	        	review1.setTitle("review by amar");
	        	review1.setPubDate(new Date());
	        	review1.setContent("it grosses Rs 150 crore collection ");
	        	
	        	Review review2 = new Review();
	        	review2.setPath("/review2");
	        	review2.setTitle("review by govind");
	        	review2.setPubDate(new Date());
	        	review2.setContent("scored 2 national wards and the raing is 4.5/5");
	        	
	        	Review review3 = new Review();
	        	review3.setPath("/review3");
	        	review3.setTitle("review by gopal");
	        	review3.setPubDate(new Date());
	        	review3.setContent("Kamalhassan conferred best actor award from vijay tv");
	        	
	        	List<Review> lst = new ArrayList<Review>();
	        	lst.add(review1);
	        	lst.add(review2);
	        	lst.add(review3);
	        	
	        	Film film = new Film();
	        	film.setPath("/viswaroopam");
	        	film.setDebut("Kamalhassan, pooja");
	        	film.setDirector("Kamalhassan");
	        	film.setReviews(lst);
	        	ocm.insert(film);
	        	
	        	ocm.save();

	        	System.out.println("published");
	        	
	        	
	        	
	        } finally { 
	            session.logout(); 
	        } 
	    } 
}
