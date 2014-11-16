package org.codingstyle.api.repository;

import org.codingstyle.core.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project findByExternId(String externId);
}
