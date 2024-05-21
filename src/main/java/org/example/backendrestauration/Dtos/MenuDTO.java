package org.example.backendrestauration.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backendrestauration.Entites.Item;

import java.util.ArrayList;
import java.util.Collection;

@Data

public class MenuDTO {
    private Long id;
    private String name;
    private String image;
    private Collection<ItemDTO> items=new ArrayList<>();
}
