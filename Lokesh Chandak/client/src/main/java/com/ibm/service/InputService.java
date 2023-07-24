package com.ibm.service;

import java.util.List;

public interface InputService {

  int getPositiveIntChoice(String string);

  int getIntChoice(String string, List<Integer> validChoices);

  String getStringChoice(String string, List<String> validChoices);

  void skipLine();

}