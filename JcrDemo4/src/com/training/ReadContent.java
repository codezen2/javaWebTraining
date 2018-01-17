package com.training;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;


import org.apache.jackrabbit.commons.JcrUtils;

import org.apache.jackrabbit.ocm.manager.ObjectContentManager;
import org.apache.jackrabbit.ocm.manager.impl.ObjectContentManagerImpl;
import org.apache.jackrabbit.ocm.mapper.Mapper;
import org.apache.jackrabbit.ocm.mapper.impl.annotation.AnnotationMapperImpl;
import org.apache.jackrabbit.ocm.query.Filter;
import org.apache.jackrabbit.ocm.query.Query;
import org.apache.jackrabbit.ocm.query.QueryManager;

public class ReadContent {

	public static void main(String[] args) throws Exception {
		Repository repository = JcrUtils.getRepository();
		Session session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));

		List<Class> classes = new ArrayList<Class>();
		classes.add(Film.class); // Call this method for each persistent class
    	classes.add(Review.class);// Call this method for each persistent
											// class

		Mapper mapper = new AnnotationMapperImpl(classes);
		ObjectContentManager ocm = new ObjectContentManagerImpl(session, mapper);
		// Retrieve 
    	System.out.println("Retrieve a press release from the repository");
    	Film film = (Film) ocm.getObject("/viswaroopam");
    	System.out.println("title : " + film.getFilmTitle());
    	System.out.println("debut : " + film.getDebut());
    	System.out.println("director" + film.getDirector());
    	System.out.println("-----------------------------------------------------------");
    	List<Review> lst = film.getReviews();
    	for(Review rev: lst){
    		System.out.println(rev.title);
    		System.out.println(rev.content);
    		System.out.println(rev.getPubDate());
    		System.out.println("-----------------------------------------------------");
    	}
    	
    	 
    	
    	session.logout(); 
	}

}
