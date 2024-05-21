package org.example.backendrestauration.Dao;

import org.example.backendrestauration.Entites.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface OrderRepository extends JpaRepository<Order,Long>
{

}
