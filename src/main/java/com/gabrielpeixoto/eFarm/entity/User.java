package com.gabrielpeixoto.eFarm.entity;
import com.gabrielpeixoto.eFarm.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Drugstore> drugstores;

    @Column(name = "user_email", unique = true)
    private String email;

    @Column(name = "user_password", unique = true)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;

    public User(String completeName, Integer age, String address, String identityNumber) {
        this.completeName = completeName;
        this.age = age;
        this.address = address;
        this.identityNumber = identityNumber;
    }
}
