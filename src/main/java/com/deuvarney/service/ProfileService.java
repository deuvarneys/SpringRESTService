package com.deuvarney.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.deuvarney.config.ProfileMongoConfig;
import com.deuvarney.model.ProfileData;

public class ProfileService {
	
	// For XML
	//ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
	
	// For Annotation
	private ApplicationContext ctx;
	
	private MongoOperations mongoOperation;
	
	private ProfileData profileData;
	
	public ProfileService(){
		ctx = new AnnotationConfigApplicationContext(ProfileMongoConfig.class);
		mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	}
	
	public ProfileData getProfile(String userName){
		// query to search user
		Query searchUserQuery = new Query(Criteria.where("userName").is(userName));
		profileData = mongoOperation.findOne(searchUserQuery, ProfileData.class);
		//System.out.println(profileData.toString());
		return profileData;
	}
	
	public ProfileData postProfile(ProfileData profileData){
		//ProfileData profileData = new ProfileData(firstName, lastName, description);
		mongoOperation.save(profileData);
		return profileData;
	}
	
	

}
