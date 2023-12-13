package com.file.uploader.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

  @GetMapping("/ping")
  public Map<String, String> ping() {
    Map<String, String> map = new HashMap<>();
    map.put("message", "pong");
    return map;
  }
}
