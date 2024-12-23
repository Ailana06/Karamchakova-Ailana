package org.example.service;

import org.example.DTO.Message;
import org.example.repository.UserRepository;
import org.example.repository.EnrichmentRepository;

import java.util.List;

public class EnrichmentService {
  private final List<EnrichmentRepository> enrichmentRepositories;
  private final UserRepository userRepository;

  public EnrichmentService(List<EnrichmentRepository> enrichmentStrategies, UserRepository userRepository) {
    this.enrichmentRepositories = enrichmentStrategies;
    this.userRepository = userRepository;
  }

  public Message enrich(Message message) {
    for(EnrichmentRepository strategy : enrichmentRepositories){
      if(strategy.canEnrich(message.getEnrichmentType())){
        strategy.enrich(message, userRepository);
        break;
      }
    }
    return message;
  }
}
