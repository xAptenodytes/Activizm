package ru.xaptenodytes.activizm.dao;

import ru.xaptenodytes.activizm.model.Community;

public interface CommunityDAO {
	public Community getCommunityById(Integer id);
	
	public Community getCommunityByName(String communityName);
}
