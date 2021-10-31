package com.netcracker.theater.rtickets.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", length = 16, unique = true, nullable = false)
    private UUID id;

    private String login;

    private String password;

    private String name;

    private String last_name;

    private String patronymic;

    private Date birthday;

    private Date ban;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private Set<Template> templates = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "attended_event",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "performance_id") }
    )
    private Set<Performance> performances_attended = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "planned_event",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "performance_id") }
    )
    private Set<Performance> performances_planned = new HashSet<>();

    public void addPerformancesAttended(Performance performance)
    {
        if (performances_attended == null) performances_attended = new HashSet<>();
        performances_attended.add(performance);
    }

    public void addPerformancesPlanned(Performance performance)
    {
        if (performances_planned == null) performances_planned = new HashSet<>();
        performances_planned.add(performance);
    }

    public void addComment(Comment comment)
    {
        if (comments == null) comments = new HashSet<>();
        comments.add(comment);
    }

    public void addTemplate(Template template)
    {
        if (templates == null) templates = new HashSet<>();
        templates.add(template);
    }

    public User() {
    }

    public User(String login, String password, String name, String last_name, String patronymic, Date birthday, Date ban) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.ban = ban;
    }

    public User(String login, String password, String name, String last_name, String patronymic, Date birthday, Date ban, Set<Comment> comments, Set<Template> templates, Set<Performance> performances_attended, Set<Performance> performances_planned) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.ban = ban;
        this.comments = comments;
        this.templates = templates;
        this.performances_attended = performances_attended;
        this.performances_planned = performances_planned;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", ban=" + ban +
                '}';
    }
}
