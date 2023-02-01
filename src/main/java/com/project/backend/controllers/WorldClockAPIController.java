package com.project.backend.controllers;

import com.project.backend.services.WorldClockAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worldclockapi")
public class WorldClockAPIController {
    @Autowired
    private WorldClockAPIService worldClockAPIService;

    @GetMapping(value = "/get", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getWorldClockAPI() {
        try{
            return ResponseEntity.ok().body(worldClockAPIService.getWorldClockAPI());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }
}
