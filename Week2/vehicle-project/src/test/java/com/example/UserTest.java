/*
 * Copyright 2013 ${company}.
 */
package com.example;

import javax.persistence.EntityManager;
import org.junit.Test;

public class UserTest {
	private EntityManager entityManager;

	@Test
	public void shouldStoreUser() {
		User user = new User();
		user.setName("Test Name");

		entityManager.persist(user);
	}
}
