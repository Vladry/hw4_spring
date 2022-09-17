package com.homework4;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@SpringBootApplication
@EnableJpaAuditing
@EnableTransactionManagement
public class Application implements ApplicationRunner {
    @PersistenceUnit
    private EntityManagerFactory emf;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        EntityManager em = emf.createEntityManager();
        em.close();
    }

}
