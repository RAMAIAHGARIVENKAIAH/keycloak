package com.ettma.api.keycloakmicroservice.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PortalUser implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	//private int userId;
	//private int user_id;
	
	
	
	@Id
	private String userAd;
	private String firstName;
	private String lastName;
	private String roleName;
	private int subscriberId;
	private String objectId;

	/*
	 * public int getUserId() { return userId; } public void setUserId(int userId) {
	 * this.userId = userId; }
	 */
	public String getUserAd() {
		return userAd;
	}
	public void setUserAd(String userAd) {
		this.userAd = userAd;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(int subscriberId) {
		this.subscriberId = subscriberId;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, objectId, roleName, subscriberId, userAd);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortalUser other = (PortalUser) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(objectId, other.objectId) && Objects.equals(roleName, other.roleName)
				&& subscriberId == other.subscriberId && Objects.equals(userAd, other.userAd) ;
	}
	
	

}
