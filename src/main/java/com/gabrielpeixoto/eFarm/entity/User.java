package com.gabrielpeixoto.eFarm.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String completeName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "identity", nullable = false)
    private String identityNumber;

    public User(String completeName, Integer age, String address, String identityNumber) {
        this.completeName = completeName;
        this.age = age;
        this.address = address;
        this.identityNumber = identityNumber;
    }
}
