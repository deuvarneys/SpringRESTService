package com.deuvarney.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.deuvarney.config.ProfileMongoConfig;
import com.deuvarney.model.Position;
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
	
	public Position getPositionData(String positionId){
		//Criteria criteria = Criteria.where("_id").is(new ObjectId(positionId));
		//Query searchPositionQuery = new Query(criteria);
		
		return mongoOperation.findById(positionId, Position.class);
		
	}
	
	public ProfileData getProfile(String userName){
		// query to search user
		Query searchUserQuery = new Query(Criteria.where("userName").is(userName));
		profileData = mongoOperation.findOne(searchUserQuery, ProfileData.class);
		//System.out.println(profileData.toString());
		List<Position> positions =  new ArrayList<Position>();
		for(Object positionId : profileData.getPositionsIds()){
			positions.add(getPositionData((String) positionId));
		}
		profileData.setPositions(positions);
		return profileData;
	}
	
	public ProfileData postProfile(ProfileData profileData){
		//ProfileData profileData = new ProfileData(firstName, lastName, description);
		mongoOperation.save(profileData);
		return profileData;
	}
	
	public Position  addPosition(String userName, Position position){
		System.out.println("UserName: " + userName + " Position: " + position.toString());
		
		Query searchUserQuery = new Query(Criteria.where("userName").is(userName));
		profileData = mongoOperation.findOne(searchUserQuery, ProfileData.class);
		System.out.println("Before Saved Profile data: " + profileData.toString());
		mongoOperation.save(position);
		System.out.println("Saved position: " + position.toString());
		profileData.addPositionId(position.getId());
		System.out.println("Saved Profile data: " + profileData.toString());
		mongoOperation.save(profileData);
		
		
		
		return position;
		
	}

	public ProfileData removePosition(String userName, String positionId) {
		//Remove from Positions colection
		mongoOperation.remove(mongoOperation.findById(positionId, Position.class));
		
		Query searchUserQuery = new Query(Criteria.where("userName").is(userName));
		profileData = mongoOperation.findOne(searchUserQuery, ProfileData.class);
		List<String> positionIds = profileData.getPositionsIds();
		//int positionIndex = positionIds.indexOf(positionId);
		if(!positionIds.remove(positionId)){
			System.out.println("Position id was not in profile position id list: " + positionId);
		}
		mongoOperation.save(profileData);
		
		return profileData;
	}

	public Position updatePosition(String userName, Position position) {
		mongoOperation.save(position);
		return position;
	}

	public Position getPosition(String userName, String positionId) {
		Query searchUserQuery = new Query(Criteria.where("userName").is(userName));
		ProfileData profileData = mongoOperation.findOne(searchUserQuery, ProfileData.class);
		if(profileData.getPositionsIds().indexOf(positionId) != -1){
			return mongoOperation.findById(positionId, Position.class);
		}
		return null;
	}

}
