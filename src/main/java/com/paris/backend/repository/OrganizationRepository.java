package com.paris.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.paris.backend.model.Organization;

@Repository("organizationRepository")
public interface OrganizationRepository extends JpaRepository<Organization, Integer>{

	@Transactional
	List<Organization> removeById(int id);
	
	List<Organization> findOrganizationById(int id);

}