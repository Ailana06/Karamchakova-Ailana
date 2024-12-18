package org.example.repository;

import org.example.model.User;

public interface UserRepository {
  User findByMsisdn(String msisdn);
  void updateUserByMsisdn(String msisdn, User user);
}
