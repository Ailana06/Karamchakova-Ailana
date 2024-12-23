package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

  @Test
  void testUserCreation() {
    User user = new User("Анна", "Петровна");
    assertEquals("Анна", user.getFirstName());
    assertEquals("Петровна", user.getLastName());
  }

  @Test
  void testSetFirstName() {
    User user = new User("Анна", "Петровна");
    user.setFirstName("Ксения");
    assertEquals("Ксения", user.getFirstName());
  }

  @Test
  void testSetLastName() {
    User user = new User("Анна", "Петровна");
    user.setLastName("Иванова");
    assertEquals("Иванова", user.getLastName());
  }

  @Test
  void testGetFirstName() {
    User user = new User("Анна", "Петровна");
    assertEquals("Анна", user.getFirstName());
  }

  @Test
  void testGetLastName() {
    User user = new User("Анна", "Петровна");
    assertEquals("Петровна", user.getLastName());
  }

  @Test
  void testUserWithEmptyName() {
    User user = new User("", "");
    assertEquals("", user.getFirstName());
    assertEquals("", user.getLastName());
  }

  @Test
  void testUserWithNullName() {
    User user = new User(null, null);
    assertNull(user.getFirstName());
    assertNull(user.getLastName());
  }

  @Test
  void testUserWithFirstNameNull() {
    User user = new User(null, "Петровна");
    assertNull(user.getFirstName());
    assertEquals("Петровна", user.getLastName());
  }

  @Test
  void testUserWithLastNameNull() {
    User user = new User("Анна", null);
    assertEquals("Анна", user.getFirstName());
    assertNull(user.getLastName());
  }

}