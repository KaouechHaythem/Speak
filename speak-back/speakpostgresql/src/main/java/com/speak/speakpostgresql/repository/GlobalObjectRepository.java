package com.speak.speakpostgresql.repository;

import com.speak.speakpostgresql.model.GlobalObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalObjectRepository extends JpaRepository<GlobalObject, String> {
}
