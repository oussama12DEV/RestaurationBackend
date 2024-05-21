package org.example.backendrestauration.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backendrestauration.Entites.IngredientsItem;
import org.example.backendrestauration.Entites.Menu;

import java.util.ArrayList;
import java.util.Collection;

@Data

public class ItemDTO {
   private Long id;
   private String name;
   private String description;
   private String image;
   private double price;
   private boolean available;
   private boolean offre;

}
