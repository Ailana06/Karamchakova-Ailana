package org.example;

import org.example.DTO.Message;
import org.example.model.User;
import org.example.repository.EnrichmentRepository;
import org.example.repository.MsisdnEnrichmentRepository;
import org.example.repository.UserRepository;
import org.example.repository.UsersRepository;
import org.example.service.EnrichmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnrichmentServiceEndToEndTest {

  private EnrichmentService enrichmentService;
  private UserRepository userRepository;

  @BeforeEach
  void setUp() {
    userRepository = new UsersRepository();
    List<EnrichmentRepository> strategies = List.of(new MsisdnEnrichmentRepository());
    enrichmentService = new EnrichmentService(strategies, userRepository);
  }

  @Test
  void concurrentEnrichmentTest() throws InterruptedException {
    int numThreads = 10;
    int numMessages = 100;
    ExecutorService executor = Executors.newFixedThreadPool(numThreads);
    CountDownLatch latch = new CountDownLatch(numThreads * numMessages);
    AtomicInteger successCount = new AtomicInteger(0);


    IntStream.range(0, numThreads).forEach(thread -> {
      IntStream.range(0, numMessages).forEach(msg -> executor.submit(() -> {
        String msisdn = "79876543211";
        userRepository.updateUserByMsisdn(msisdn, new User("Ксения", "Шарафудинова"));
        Map<String, String> content = new ConcurrentHashMap<>();
        content.put("msisdn", msisdn);
        Message message = new Message(content, Message.EnrichmentType.MSISDN);
        Message enrichedMessage = enrichmentService.enrich(message);
        if (enrichedMessage.getContent().get("firstName") != null) {
          successCount.getAndIncrement();
        }
        latch.countDown();
      }));
    });
    latch.await();
    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.MINUTES);
    assertEquals(numThreads * numMessages, successCount.get());
  }
}