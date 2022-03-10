package com.homework2;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@SpringBootApplication
@EnableTransactionManagement
public class HW2_Application implements ApplicationRunner {
    @PersistenceUnit
    private EntityManagerFactory emf;

    public static void main(String[] args) {
        SpringApplication.run(HW2_Application.class, args);}

    @Override
    public void run(ApplicationArguments args) throws Exception {
        EntityManager em = emf.createEntityManager();
        em.close();
    }

}
