package com.netcracker.theater.rtickets.data.storage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "role_admin")
public class RoleAdmin {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    private String name;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "role_id")
//    private Set<User> users=new HashSet<>();
//
//    public void addUser(User user)
//    {
//        if (users == null) users = new HashSet<>();
//        users.add(user);
//    }


}
