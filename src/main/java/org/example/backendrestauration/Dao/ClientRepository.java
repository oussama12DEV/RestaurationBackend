package org.example.backendrestauration.Dao;

import org.example.backendrestauration.Entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface ClientRepository extends JpaRepository<Client,Long>
{

}
