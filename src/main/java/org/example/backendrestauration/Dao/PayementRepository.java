package org.example.backendrestauration.Dao;

import org.example.backendrestauration.Entites.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface PayementRepository extends JpaRepository<Payment,Long>
{

}
