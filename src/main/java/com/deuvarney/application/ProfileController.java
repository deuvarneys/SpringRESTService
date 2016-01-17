package com.deuvarney.application;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deuvarney.model.ProfileData;
import com.deuvarney.service.ProfileService;



@RestController
public class ProfileController {
	ProfileService profileService;
	{
		profileService = new ProfileService();
	}
	
	@RequestMapping(value="/profile/{userName}", method=RequestMethod.GET)
	public ProfileData getProfile(@PathVariable String userName){
		System.out.println("UserName IS: " + userName);
		return profileService.getProfile(userName);
	}
	
	@RequestMapping(value="/profiled", method=RequestMethod.GET)
	public String getProfile(){
		//return new ProfileService().getProfile(lastName);
		return "What the ping-ping";
	}
	
	
	@RequestMapping(value="/profile/{lastName}", method=RequestMethod.POST)
	public ProfileData postProfile(
			//@ApiParam(value="Last Name of the user", required=true)
			@PathVariable("lastName") final String lastName, 
			//@ApiParam(value="Profile request object", required=true)
			@RequestBody(required=true) ProfileData profileData
			){
			System.out.println(profileData.toString());
		
		return profileService.postProfile( profileData);
	}
	
}
