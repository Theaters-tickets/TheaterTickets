package com.netcracker.theater.rtickets.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "parameter")
public class Parameter {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    @Column
    private String name;

    @Column
    private String criterion;

    public Parameter() {
    }

    public Parameter(String name, String criterion) {
        this.name = name;
        this.criterion = criterion;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", criterion='" + criterion + '\'' +
                '}';
    }
}
