package com.example.service;

import java.util.List;

import com.example.model.Tutorial;

public interface TutorialService {
  public Tutorial createTutorial();
  public void publishTutorial(Tutorial tutorial);
  public List<Tutorial> getAllTutorials();
  public Tutorial getTutorialById(int id);
  public Tutorial updateTutorialTitle(int id, String title);
  public Tutorial updateTutorialDescription(int id, String description);
  public void deleteTutorial(int id);
  public List<Tutorial> findPublishedTutorials();
  public List<Tutorial> findUnpublishedTutorials();
  public List<Tutorial> findByTitleContaining(String title);
}
