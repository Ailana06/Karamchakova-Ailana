package org.example.repository;

import org.example.DTO.Message;

public interface EnrichmentRepository {
  void enrich(Message message, UserRepository userRepository);
  boolean canEnrich(Message.EnrichmentType enrichmentType);
}
