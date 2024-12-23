package org.example.repository;

import org.example.DTO.Message;
import org.example.model.User;

import java.util.Map;

public class MsisdnEnrichmentRepository implements EnrichmentRepository {
  @Override
  public void enrich(Message message, UserRepository userRepository) {
    Map<String, String> content = message.getContent();
    String msisdn = content.get("msisdn");
    if (msisdn != null) {
      User user = userRepository.findByMsisdn(msisdn);
      if (user != null && user.getFirstName() != null && user.getLastName() != null) {
        content.put("firstName", user.getFirstName());
        content.put("lastName", user.getLastName());
      }
    }
  }

  @Override
  public boolean canEnrich(Message.EnrichmentType enrichmentType) {
    return enrichmentType == Message.EnrichmentType.MSISDN;
  }
}