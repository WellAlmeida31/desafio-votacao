package br.com.dbserver.assembleia;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
@EnableKafka
public class AssembleiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssembleiaApplication.class, args);
	}

}
