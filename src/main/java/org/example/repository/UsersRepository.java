package org.example.repository;

import org.example.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UsersRepository implements UserRepository {
  private final Map<String, User> users = new ConcurrentHashMap<>();

  @Override
  public User findByMsisdn(String msisdn) {
    return users.get(msisdn);
  }

  @Override
  public void updateUserByMsisdn(String msisdn, User user) {
    users.put(msisdn, user);
  }
}
