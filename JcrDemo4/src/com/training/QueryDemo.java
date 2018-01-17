package com.training;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jcr.Repository;
import javax.jcr.RepositoryException;
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

public class QueryDemo {

	public static void main(String[] args) throws RepositoryException {
		Repository repository = JcrUtils.getRepository();
		Session session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));

		List<Class> classes = new ArrayList<Class>();
		classes.add(Film.class); // Call this method for each persistent class
    	classes.add(Review.class);// Call this method for each persistent
											// class

		Mapper mapper = new AnnotationMapperImpl(classes);
		ObjectContentManager ocm = new ObjectContentManagerImpl(session, mapper);
		QueryManager queryManager = ocm.getQueryManager(); 
		Filter filter = queryManager.createFilter(Review.class); 
		filter.addEqualTo("title", "review by amar"); 
		Query query = queryManager.createQuery(filter); 
		Collection<Review> col = ocm.getObjects(query);
		for(Review r: col){
			System.out.println(r.getTitle());
			System.out.println(r.getPubDate());
			System.out.println(r.getContent());
		}
		
	}

}
