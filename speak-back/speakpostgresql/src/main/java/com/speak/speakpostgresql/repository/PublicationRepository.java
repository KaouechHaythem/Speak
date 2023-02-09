package com.speak.speakpostgresql.repository;

import com.speak.speakpostgresql.model.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, String> {
}
