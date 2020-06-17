package com.lambdaschool.shoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "roles")
public class Role extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleid;

    @NotNull
    @Column(nullable = false,
            unique = true)
    private String name;

    @OneToMany(mappedBy = "role",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "role",
            allowSetters = true)
    private List<UserRoles> users = new ArrayList<>();

    public Role(@NotNull String name, List<UserRoles> users) {
        this.name = name;
        this.users = users;
    }

    public long getRoleid() {
        return roleid;
    }

    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserRoles> getUsers() {
        return users;
    }

    public void setUsers(List<UserRoles> users) {
        this.users = users;
    }
}
