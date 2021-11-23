package com.netcracker.theater.rtickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class NetcrackerTheaterTicketsApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetcrackerTheaterTicketsApplication.class, args);
    }
}
