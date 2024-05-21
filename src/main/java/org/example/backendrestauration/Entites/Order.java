package org.example.backendrestauration.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private double total;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Payment payment;
    @OneToMany(mappedBy = "orders")
    private Collection<OrderItem> orderItems;


}
