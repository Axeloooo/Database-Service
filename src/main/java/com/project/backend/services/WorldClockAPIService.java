package com.project.backend.services;

import com.project.backend.schemas.WorldClockAPISchema;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
public class WorldClockAPIService {
    public WorldClockAPISchema getWorldClockAPI() {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "http://worldclockapi.com/api/json/utc/now";
        return restTemplate.getForObject(url, WorldClockAPISchema.class);
    }

}
