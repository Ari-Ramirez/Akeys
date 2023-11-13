package org.ari_ramirez_AKEYS.AKEYS.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String productId;

    private String name;

    private double price;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
