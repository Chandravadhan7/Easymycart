package com.xyz.easymycart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.xyz.easymycart")
public class EasyMyCartApplication {

  public static void main(String[] args) {
    SpringApplication.run(EasyMyCartApplication.class, args);
  }
}
