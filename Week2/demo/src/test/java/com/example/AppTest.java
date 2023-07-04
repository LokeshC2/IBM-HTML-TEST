package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

  /**
   * Rigorous Test :-)
   */
  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  @Test
  public void testSum() {
    Sum s = new Sum(1, 2);
    assertTrue(s.ans == 1);
  }

  @Test
  public void testSum2() {
    Sum s = new Sum(2, 2);
    assertTrue(s.ans == 3);
  }

}
