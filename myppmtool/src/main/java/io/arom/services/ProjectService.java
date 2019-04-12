package io.arom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.arom.domain.Project;
import io.arom.exceptions.ProjectIdException;
import io.arom.repositories.ProjectRepositories;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepositories projectRepositories;

	public Project saveOrUpdateProject(Project project) {

		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepositories.save(project);

		} catch (Exception e) {
			throw new ProjectIdException(
					"project ID " + project.getProjectIdentifier().toUpperCase() + " already exsist");
		}
	}

	public Project findProjectByIdentifier(String projectId) {

		Project project = projectRepositories.findByprojectIdentifier(projectId.toUpperCase());
		if (project == null) {
			throw new ProjectIdException("project ID " + projectId + " does not exsist");
		}
		return project;
	}

}
