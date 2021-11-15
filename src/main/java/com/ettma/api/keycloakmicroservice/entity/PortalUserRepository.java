package com.ettma.api.keycloakmicroservice.entity;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PortalUserRepository extends CrudRepository<PortalUser, Integer>{

	@Query(value = "{call UpdateObjectId(:Ip_UserAd, :Ip_oid, :Op_StatusCode, :Op_Status)}", nativeQuery = true)
	public String findUpdateObjectId(@Param("Ip_UserAd") String ip_UserAd, @Param("Ip_oid") String ip_oid, @Param("Op_StatusCode") int Op_StatusCode, @Param("Op_Status") String Op_StatusMessage);
	
	@Query(value = "{call GetSubscriberUserDetail(:Ip_SubscriberUserId,  :Op_StatusCode, :Op_Status)}", nativeQuery = true)
	public List<String> GetSubscriberUserDetail(@Param("Ip_SubscriberUserId") String ip_SubscriberUserId, @Param("Op_StatusCode") int Op_StatusCode, @Param("Op_Status") String Op_StatusMessage);
	
	
	@Query(value = "{call SubPort_GetToolkitPage(:Ip_UserId,  :Op_StatusCode, :Op_Status)}", nativeQuery = true)
	public String getToolKitsPage(@Param("Ip_UserId") String ip_SubscriberUserId, @Param("Op_StatusCode") int Op_StatusCode, @Param("Op_Status") String Op_StatusMessage);
}
