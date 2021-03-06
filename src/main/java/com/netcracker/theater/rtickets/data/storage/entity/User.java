package com.netcracker.theater.rtickets.data.storage.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    //Added by Ilya
    //To not allow to create users with same login
    @Column(unique = true)
    private String login;

    private String password;

    private String email;

    @Column(name = "Enabled", length = 1, nullable = false)
    private boolean enabled;

    private String name;

    private String last_name;

    private String patronymic;

    private Date birthday;

    private Date ban;

    @ManyToOne
    private RoleAdmin roleAdmin;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private Set<Comment> comments = new HashSet<>();

    /*
    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private Set<Template> templates = new HashSet<>();

     */

    @Builder.Default
    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "repertoire_attended",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "repertoire_id") }
    )
    private Set<Repertoire> repertoire_attended = new HashSet<>();

    @Builder.Default
    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "repertoire_planned",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "repertoire_id") }
    )
    private Set<Repertoire> repertoire_planned = new HashSet<>();

    public void addRepertoireAttended(Repertoire repertoire)
    {
        if (repertoire_attended == null) repertoire_attended = new HashSet<>();
        repertoire_attended.add(repertoire);
    }

    public void addRepertoirePlanned(Repertoire repertoire)
    {
        if (repertoire_planned == null) repertoire_planned = new HashSet<>();
        repertoire_planned.add(repertoire);
    }

    public void addComment(Comment comment)
    {
        if (comments == null) comments = new HashSet<>();
        comments.add(comment);
    }

    /*
    public void addTemplate(Template template)
    {
        if (templates == null) templates = new HashSet<>();
        templates.add(template);
    }

     */

    public String getDotsPassword() {
        return password.replaceAll(".", "*");
    }


    //Added by Ilya
    //For registration
    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String name, String last_name, String patronymic, Date birthday, Date ban, Boolean enabled) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.ban = ban;
        this.enabled = enabled;
    }


}
