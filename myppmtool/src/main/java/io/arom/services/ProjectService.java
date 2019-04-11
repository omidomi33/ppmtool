package io.arom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.arom.domain.Project;
import io.arom.repositories.ProjectRepositories;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepositories projectRepositories;

	public Project saveOrUpdateProject(Project project) {

		// Logic
		return projectRepositories.save(project);
	}
}
