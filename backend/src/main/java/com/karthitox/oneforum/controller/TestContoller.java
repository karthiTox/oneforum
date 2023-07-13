package com.karthitox.oneforum.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestContoller {

  @GetMapping("/x")
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Hello from testing endpoint");
  }

}