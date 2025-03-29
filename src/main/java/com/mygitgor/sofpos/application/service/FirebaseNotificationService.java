package com.mygitgor.sofpos.application.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class FirebaseNotificationService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String firebaseApiUrl;

    public FirebaseNotificationService(@Value("${firebase.api.url}") String firebaseApiUrl) {
        this.firebaseApiUrl = firebaseApiUrl;
    }

    public void sendNotification(String token, String title, String message) {
        Map<String, Object> body = Map.of(
                "to", token,
                "notification", Map.of("title", title, "body", message)
        );

        restTemplate.postForEntity(firebaseApiUrl, body, Void.class);
    }
}
