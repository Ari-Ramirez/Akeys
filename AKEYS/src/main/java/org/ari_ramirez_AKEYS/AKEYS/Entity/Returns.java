package org.ari_ramirez_AKEYS.AKEYS.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Returns {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int returnNumber;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
