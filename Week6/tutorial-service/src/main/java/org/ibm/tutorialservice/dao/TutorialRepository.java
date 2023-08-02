package org.ibm.tutorialservice.dao;

import org.ibm.tutorialservice.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer>{

}