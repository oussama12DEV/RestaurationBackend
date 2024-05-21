package org.example.backendrestauration.Dao;

import org.example.backendrestauration.Entites.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface MenuRepository extends JpaRepository<Menu,Long>
{

}
