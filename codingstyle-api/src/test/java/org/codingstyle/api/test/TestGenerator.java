package org.codingstyle.api.test;

import org.codingstyle.api.repository.ProjectRepository;
import org.codingstyle.core.model.Project;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import static org.codingstyle.api.test.TestTools.randomString;

@Service
public class TestGenerator {
    @Inject private ProjectRepository projectRepository;

    public Project project() {
        Project project = new Project();
        project.setExternId(TestTools.randomString());
        project.setName(TestTools.randomString());
        return this.projectRepository.save(project);
    }
}
