package org.example.backendrestauration.Dao;

import org.example.backendrestauration.Entites.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface OrderItemRepository extends JpaRepository<OrderItem,Long>
{

}
