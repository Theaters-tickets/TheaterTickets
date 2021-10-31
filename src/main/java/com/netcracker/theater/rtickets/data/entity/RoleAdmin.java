package com.netcracker.theater.rtickets.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "role_admin")
public class RoleAdmin {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "role_id")
    private Set<User> users=new HashSet<>();

    public void addUser(User user)
    {
        if (users == null) users = new HashSet<>();
        users.add(user);
    }

    public RoleAdmin() {
    }

    public RoleAdmin(String name) {
        this.name = name;
    }

    public RoleAdmin(String name, Set<User> users) {
        this.name = name;
        this.users = users;
    }

    @Override
    public String toString() {
        return "RoleAdmin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
