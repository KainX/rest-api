package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.database.DataBase;
import com.example.models.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DataBase.getAllProfiles();
	
	/**
	 * Simulating a data access to a db
	 * @return a list of profiles
	 */
	public List<Profile> getAllProfiles(){		
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {		
		return DataBase.getProfile(profileName);
	}
	
	public Profile addProfile(Profile profile) {		
		return DataBase.addProfile(profile);
	}
	
	public Profile updateProfile(Profile profile) {
		return DataBase.updateProfile(profile);
	}
	
	public void removeProfile(String profileName) {
		DataBase.removeProfile(profileName);
	}

}
