package org.example.backendrestauration.Dao;

import org.example.backendrestauration.Entites.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ItemRepository extends JpaRepository<Item,Long> {
 @RestResource(path = "/invailableProducts")
 public List<Item> findByAvailableIsFalse();

 @RestResource(path = "/byname")
 public List<Item> findByNameContains(@Param("key") String key);

 Page<Item> findItemByMenus_Id(Long menuid, Pageable pageable);
}