package org.example.backendrestauration.Dao;

import org.example.backendrestauration.Entites.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
public interface IngredientRepository extends JpaRepository<Ingredients,Long>
{

}
