package com.netcracker.theater.rtickets.data.storage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "template_id")
    private Set<Parameter> parameters = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public void addParameter(Parameter parameter)
    {
        if (parameters == null) parameters = new HashSet<>();
        parameters.add(parameter);
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


}
