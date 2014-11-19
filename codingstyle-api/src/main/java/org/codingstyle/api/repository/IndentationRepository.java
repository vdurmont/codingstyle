package org.codingstyle.api.repository;

import org.codingstyle.core.model.Indentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndentationRepository extends JpaRepository<Indentation, Integer> {
}
