package com.deuvarney.application;


import java.util.Date;

import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.POST;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deuvarney.model.Position;
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
	
	
	@RequestMapping(value="/profile/{userName}", method=RequestMethod.POST)
	public ProfileData postProfile(
			//@ApiParam(value="Last Name of the user", required=true)
			@PathVariable("userName") final String userName, 
			//@ApiParam(value="Profile request object", required=true)
			@RequestBody(required=true) ProfileData profileData
			){
			System.out.println(profileData.toString());
		
		return profileService.postProfile( profileData);
	}
	
	@RequestMapping(value="/profile/addPosition", method=RequestMethod.GET)
	public String getAddPositionHTML(HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		return "<div class='box addPosition'>"
					+ "<div class='row'>"
						+ "<div class='col-xs-4'>"
							+ "<h4>Title</h4>"
						+ "</div>"
						+ "<div class='col-xs-8'>"
							+ "<input placeHolder='Your Position' name='title'/>"
						+ "</div>"
					+ "</div>"
					+ "<div class='row'>"
						+ "<div class='col-xs-4'>"
							+ "<h4>Employer</h4>"
						+ "</div>"
						+ "<div class='col-xs-8'>"
							+ "<input placeHolder='Your Company' name='employer'/>"
						+ "</div>"
					+ "</div>"
					+ "<div class='row'>"
						+ "<div class='col-xs-3'>"
							+ "<h4>Start Date</h4>"
						+ "</div>"
						+ "<div class='col-xs-3'>"
							+ "<select name='startMonth'>"
								+ "<option value='january'>January</option>"
								+ "<option value='february'>February</option>"
								+ "<option value='march'>March</option>"
								+ "<option value='april'>April</option>"
								+ "<option value='may'>May</option>"
								+ "<option value='june'>June</option>"
								+ "<option value='july'>July</option>"
								+ "<option value='august'>August</option>"
								+ "<option value='september'>September</option>"
								+ "<option value='october'>October</option>"
								+ "<option value='november'>November</option>"
								+ "<option value='december'>December</option>"
							+ "</select>"
							+ "<input type='number' name='startYear' min='1950' max='2016' placeHolder='Year'>"
						+ "</div>"
						+ "<div class='col-xs-3'>"
							+ "<h4>End Date</h4>"
						+ "</div>"
						+ "<div class='col-xs-3'>"
							+ "<select name='endMonth'>"
								+ "<option value='january'>January</option>"
								+ "<option value='february'>February</option>"
								+ "<option value='march'>March</option>"
								+ "<option value='april'>April</option>"
								+ "<option value='may'>May</option>"
								+ "<option value='june'>June</option>"
								+ "<option value='july'>July</option>"
								+ "<option value='august'>August</option>"
								+ "<option value='september'>September</option>"
								+ "<option value='october'>October</option>"
								+ "<option value='november'>November</option>"
								+ "<option value='december'>December</option>"
							+ "</select>"
							+ "<input type='number' name='endYear' min='1950' max='2016' placeHolder='Year'>"
						+ "</div>"
					+ "</div>"
				+ "<div class='row'>"
					+ "<div class='col-xs-4'>"
						+ "<h4>Location</h4>"
					+ "</div>"
					+ "<div class='col-xs-8'>"
						+ "<input name='location' placeHolder='City,State'/>"
					+ "</div>"
				+ "</div>"
				+ "<h4>Description</h4>"
				+ "<textarea name='description' placeHolder='Tell us about your position'/>"
				+ "<br>"
				+ "<button class='savePosition btn btn-success'>Submit</button>"
				+ "<button class='cancelPosition btn btn-default'>Cancel</button>"
			+ "</div>";
	}
	
	@RequestMapping(value="/profile/{userName}/position", method=RequestMethod.POST)
	public Position addPosition(HttpServletResponse response,
			@PathVariable("userName") String userName,
				@RequestBody(required=true) Position position						
			){
		response.setHeader("Access-Control-Allow-Origin", "*");
		//res.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		return profileService.addPosition(userName, position);
	}
	//Use this for browser support
	@RequestMapping(value="/profile/{userName}/position", method=RequestMethod.OPTIONS)
	public void addPosition(HttpServletResponse response,
			@PathVariable("userName") String userName
				//@RequestBody(required=true) Position position						
			){
		response.setHeader("Access-Control-Allow-Origin", "*");
		//res.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		//return profileService.addPosition(userName, position);
	}
	
	@RequestMapping(value="/profile/{userName}/position", method=RequestMethod.DELETE)
	public ProfileData removePosition(HttpServletResponse response,
			@PathVariable("userName") String userName,
				@RequestBody(required=true) String positionId						
			){
		response.setHeader("Access-Control-Allow-Origin", "*");
		//res.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		return profileService.removePosition(userName, positionId);
	}
	
	@RequestMapping(value="/profile/{userName}/position", method=RequestMethod.PUT)
	public Position updatePosition(HttpServletResponse response,
			@PathVariable("userName") String userName,
				@RequestBody(required=true) Position position						
			){
		response.setHeader("Access-Control-Allow-Origin", "*");
		//res.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		System.out.println(position); 
		//return position;
		return profileService.updatePosition(userName, position);
		//return null;
	}
	
	@RequestMapping(value="/profile/{userName}/position", method=RequestMethod.GET)
	public Position getPosition(HttpServletResponse response,
			@PathVariable("userName") String userName,
				@RequestParam(required=true, name="positionId") String positionId						
			){
		response.setHeader("Access-Control-Allow-Origin", "*");
		//res.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type");
		return profileService.getPosition(userName, positionId);
	}
	
}
