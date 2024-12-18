package org.example;

import org.example.DTO.Message;
import org.example.model.User;
import org.example.repository.EnrichmentRepository;
import org.example.repository.MsisdnEnrichmentRepository;
import org.example.repository.UsersRepository;
import org.example.service.EnrichmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

public class EnrichmentServiceTest {

  private EnrichmentService enrichmentService;
  private UsersRepository userRepository;

  @BeforeEach
  void setUp() {
    userRepository = new UsersRepository();
    List<EnrichmentRepository> strategies = List.of(new MsisdnEnrichmentRepository());
    enrichmentService = new EnrichmentService(strategies, userRepository);
  }

  @Test
  void testMsisdnEnrichmentSuccessFirst() {
    userRepository.updateUserByMsisdn("79152347890", new User("Анна", "Петровна"));

    Map<String, String> content = new ConcurrentHashMap<>();
    content.put("msisdn", "79152347890");
    Message message = new Message(content, Message.EnrichmentType.MSISDN);
    Message enrichedMessage = enrichmentService.enrich(message);

    assertEquals("Анна", enrichedMessage.getContent().get("firstName"));
    assertEquals("Петровна", enrichedMessage.getContent().get("lastName"));
  }

  @Test
  void testMsisdnEnrichmentSuccessSecond() {
    userRepository.updateUserByMsisdn("79152347890", new User("Анна", "Петровна"));

    Map<String, String> content = new ConcurrentHashMap<>();
    content.put("msisdn", "79152347890");
    content.put("action", "button_click");
    content.put("page", "book_card");

    Message message = new Message(content, Message.EnrichmentType.MSISDN);
    Message enrichedMessage = enrichmentService.enrich(message);

    assertEquals("Анна", enrichedMessage.getContent().get("firstName"));
    assertEquals("Петровна", enrichedMessage.getContent().get("lastName"));
    assertEquals("button_click", enrichedMessage.getContent().get("action"));
    assertEquals("book_card", enrichedMessage.getContent().get("page"));
  }

  @Test
  void testMsisdnEnrichmentUserFirstNameNull() {
    userRepository.updateUserByMsisdn("79152347890", new User(null, "Петровна"));

    Map<String, String> content = new ConcurrentHashMap<>();
    content.put("msisdn", "79152347890");
    Message message = new Message(content, Message.EnrichmentType.MSISDN);
    Message enrichedMessage = enrichmentService.enrich(message);

    assertNull(enrichedMessage.getContent().get("firstName"));
    assertNull(enrichedMessage.getContent().get("lastName"));
  }

  @Test
  void testMsisdnEnrichmentUserLastNameNull() {
    userRepository.updateUserByMsisdn("79152347890", new User("Анна", null));

    Map<String, String> content = new ConcurrentHashMap<>();
    content.put("msisdn", "79152347890");
    Message message = new Message(content, Message.EnrichmentType.MSISDN);
    Message enrichedMessage = enrichmentService.enrich(message);

    assertNull(enrichedMessage.getContent().get("firstName"));
    assertNull(enrichedMessage.getContent().get("lastName"));
  }

  @Test
  void testMsisdnEnrichmentUserContentNull() {
    userRepository.updateUserByMsisdn("79152347890", new User(null, null));

    Map<String, String> content = new ConcurrentHashMap<>();
    content.put("msisdn", "79152347890");
    Message message = new Message(content, Message.EnrichmentType.MSISDN);
    Message enrichedMessage = enrichmentService.enrich(message);

    assertNull(enrichedMessage.getContent().get("firstName"));
    assertNull(enrichedMessage.getContent().get("lastName"));
  }

  @Test
  void testMsisdnEnrichmentUserNotFound() {
    Map<String, String> content = new ConcurrentHashMap<>();
    content.put("msisdn", "79152347890");

    Message message = new Message(content, Message.EnrichmentType.MSISDN);
    Message enrichedMessage = enrichmentService.enrich(message);

    assertNull(enrichedMessage.getContent().get("firstName"));
    assertNull(enrichedMessage.getContent().get("lastName"));
  }

  @Test
  void testMsisdnEnrichmentMsisdnContentNull() {
    Map<String, String> content = new HashMap<>();
    content.put("msisdn", null);

    Message message = new Message(content, Message.EnrichmentType.MSISDN);
    Message enrichedMessage = enrichmentService.enrich(message);

    assertNull(enrichedMessage.getContent().get("firstName"));
    assertNull(enrichedMessage.getContent().get("lastName"));
  }

  @Test
  void testMsisdnEnrichmentMsisdnMissing() {
    Map<String, String> content = new ConcurrentHashMap<>();
    Message message = new Message(content, Message.EnrichmentType.MSISDN);
    Message enrichedMessage = enrichmentService.enrich(message);

    assertNull(enrichedMessage.getContent().get("firstName"));
    assertNull(enrichedMessage.getContent().get("lastName"));
  }

  @Test
  void testMsisdnEnrichmentFieldsOverrideSuccess() {
    userRepository.updateUserByMsisdn("79152347890", new User("Анна", "Петровна"));

    Map<String, String> content = new ConcurrentHashMap<>();
    content.put("msisdn", "1234567890");
    Message message = new Message(content, Message.EnrichmentType.MSISDN);
    content.put("firstName", "Ксения");
    content.put("lastName", "Шарафудинова");
    message.setContent(content);
    Message enrichedMessage = enrichmentService.enrich(message);

    assertEquals("Ксения", enrichedMessage.getContent().get("firstName"));
    assertEquals("Шарафудинова", enrichedMessage.getContent().get("lastName"));
  }

  @Test
  void testMsisdnEnrichmentFieldsOverrideNotSuccess() {
    userRepository.updateUserByMsisdn("79152347890", new User("Анна", "Петровна"));
    Map<String, String> content = new ConcurrentHashMap<>();
    content.put("msisdn", "1234567890");
    content.put("firstName", "Ксения");
    content.put("lastName", "Шарафудинова");

    Message message = new Message(content, Message.EnrichmentType.MSISDN);

    Message enrichedMessage = enrichmentService.enrich(message);

    assertNotEquals("Анна", enrichedMessage.getContent().get("firstName"));
    assertNotEquals("Петровна", enrichedMessage.getContent().get("lastName"));
  }
}