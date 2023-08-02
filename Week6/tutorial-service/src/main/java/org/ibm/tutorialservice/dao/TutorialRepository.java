package org.ibm.tutorialservice.dao;

import org.ibm.tutorialservice.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer>{

  //Override the default REST endpoint for saving entities of type Tutorial
  @Override
  @RestResource(exported = false)
  <S extends Tutorial> S save(S entity);


}