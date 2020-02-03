package com.example.demo;


import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String password;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Transient
    private String no;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="street", column = @Column(name="home_street"))
    })
    private Address address;

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<Study>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addStudy(Study study) {
        this.getStudies().add(study);
        study.setOwner(this);
    }

    public void removeStudy(Study study){
        this.getStudies().remove(study);
        study.setOwner(null);
    }
}
