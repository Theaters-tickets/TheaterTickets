package com.netcracker.theater.rtickets.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "template")
public class Template {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    @Column
    private String name;

    @Column
    private String criterion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "template_id")
    private Set<Parameter> parameters = new HashSet<>();

    public void addParameter(Parameter parameter)
    {
        if (parameters == null) parameters = new HashSet<>();
        parameters.add(parameter);
    }

    public Template() {
    }

    public Template(String name, String criterion) {
        this.name = name;
        this.criterion = criterion;
    }

    public Template(String name, String criterion, Set<Parameter> parameters) {
        this.name = name;
        this.criterion = criterion;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", criterion='" + criterion + '\'' +
                '}';
    }
}
