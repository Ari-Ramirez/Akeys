package org.ari_ramirez_AKEYS.AKEYS.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private  String password;
    @Column(name = "first_name")
    private String firstName;
    private String lastName;



    public String getFirstName() {
        return this.firstName;
    }

}
