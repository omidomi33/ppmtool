package io.arom.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.arom.domain.Project;

@Repository
public interface ProjectRepositories extends CrudRepository<Project, Long> {
	Project findByprojectIdentifier(String projectId);
	@Override
	Iterable<Project> findAll();

}
