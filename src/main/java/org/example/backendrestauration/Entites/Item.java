package org.example.backendrestauration.Entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String description;
   private String image;
   private double price;
   private boolean available;
   private boolean offre;
   @Transient
   private int quantite=1;
   @OneToMany(mappedBy = "dishes")
   private Collection<IngredientsItem> ingredientsDishs=new ArrayList<>();
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   @ManyToOne
   private Menu menus;

}
