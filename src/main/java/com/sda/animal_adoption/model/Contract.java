package com.sda.animal_adoption.model;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_adoption", referencedColumnName = "id")
    private Adoption adoption;
    @Column
    private Date date;
    @Column
    private String comments;

    public Contract() {
    }

    public Contract(Long id, Adoption adoption, Date date, String comments) {
        this.id = id;
        this.adoption = adoption;
        this.date = date;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Adoption getAdoption() {
        return adoption;
    }

    public void setAdoption(Adoption adoption) {
        this.adoption = adoption;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
