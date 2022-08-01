package com.freedom.datasourcecaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DatasourceCachingApplication {

  public static void main(String[] args) {
    SpringApplication.run(DatasourceCachingApplication.class, args);
  }
}
