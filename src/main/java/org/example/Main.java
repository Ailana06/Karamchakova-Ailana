package org.example;

import org.example.DTO.Message;
import org.example.model.User;
import org.example.repository.MsisdnEnrichmentRepository;
import org.example.repository.UsersRepository;
import org.example.service.EnrichmentService;
import org.example.repository.EnrichmentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    UsersRepository userRepository = new UsersRepository();
    List<EnrichmentRepository> enrichment = List.of(new MsisdnEnrichmentRepository());

    EnrichmentService enrichmentService = new EnrichmentService(enrichment, userRepository);

    userRepository.updateUserByMsisdn("79152347890", new User("Анна", "Петровна"));
    userRepository.updateUserByMsisdn("79876543211", new User("Иван", "Сидоров"));
    userRepository.updateUserByMsisdn("79265551234", new User("Алексей", "Иванов"));

    Map<String, String> contentOne = new HashMap<>();
    contentOne.put("msisdn", "79152347890");
    Message message1 = new Message(contentOne, Message.EnrichmentType.MSISDN);
    Message enrichedMessage1 = enrichmentService.enrich(message1);
    System.out.println("Message 1: " + enrichedMessage1.getContent());


    Map<String, String> contentTwo = new HashMap<>();
    contentTwo.put("msisdn", "79876543211");
    Message message2 = new Message(contentTwo, Message.EnrichmentType.MSISDN);
    Message enrichedMessage2 = enrichmentService.enrich(message2);
    System.out.println("Message 2: " + enrichedMessage2.getContent());

    Map<String, String> contentThree = new HashMap<>();
    contentThree.put("msisdn", null);
    Message message3 = new Message(contentThree, Message.EnrichmentType.MSISDN);
    Message enrichedMessage3 = enrichmentService.enrich(message3);
    System.out.println("Message 3: " + enrichedMessage3.getContent());
  }
}