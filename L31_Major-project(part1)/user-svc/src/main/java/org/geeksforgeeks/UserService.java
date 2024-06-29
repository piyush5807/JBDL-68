package org.geeksforgeeks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public void create(CreateUserRequest request) throws JsonProcessingException {

        User user = request.toUser();
        this.userRepository.save(user);

//         TODO: Publish a message on the kafka topic
        this.kafkaTemplate.send("user-created", objectMapper.writeValueAsString(user));
    }
}
