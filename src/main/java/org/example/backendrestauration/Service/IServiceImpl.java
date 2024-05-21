package org.example.backendrestauration.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.backendrestauration.Dao.*;
import org.example.backendrestauration.Entites.*;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
@AllArgsConstructor
public class IServiceImpl implements IService {

    private MenuRepository menuRepository;
    private IngredientRepository ingredientRepository;
    private ItemRepository dishRepository;




    @Override
    public void InitializeMenu(){
        Stream.of("Boissons", "Plats", "Plat_Marocains", "Desserts", "Entrées", "Pizzas", "Burgers", "Salades", "Sandwichs", "Pâtes", "Soupes", "Tacos")
                .forEach(cat -> {
                    Menu menu = new Menu();
                    menu.setName(cat);
                    menu.setImage(cat.replaceAll("_", "") + ".jpg");
                    menuRepository.save(menu);
                });
    }



    @Override
    public void InitializeIngredients() {
          Stream.of("Tomate", "Oignon", "Poulet", "Viande", "Fromage", "Salade", "Pain", "Pâtes", "Riz", "Sauce", "Poisson", "Fruits de mer", "Légumes", "Fruits", "Herbes", "Épices", "Huile", "Beurre", "Crème", "Œufs", "Farine", "Sucre", "Sel", "Poivre", "Vinaigre", "Moutarde", "Ketchup", "Mayonnaise", "Soy Sauce", "Worcestershire Sauce", "Tabasco", "Piment", "Piment de Cayenne", "Paprika")
                .forEach(ing -> {
                     Ingredients ingredient = new Ingredients();
                    ingredient.setName(ing);
                    ingredientRepository.save(ingredient);
                });
    }

    @Override
    public void InitializeDishe() {

            //List<Menu> menus = menuRepository.findAll();
            menuRepository.findAll().forEach(menu -> {
                //  Menu menu = menus.stream().filter(m -> m.getName().equals(cat.getName())).findFirst().orElse(null);
                Random random = new Random();
                if (menu.getName().equals("Boissons")) {
                    Stream.of("Coca-Cola", "Fanta", "Sprite", "Eau", "Jus d'orange", "Jus de pomme", "Jus de raisin", "Jus de pêche", "Jus de poire", "Jus de fraise", "Jus de banane", "Jus de mangue"
                    ).forEach(dishName -> {
                        Item dish = new Item();
                        dish.setName(dishName);
                        dish.setPrice(20 + (int) (Math.random() * 10));
                        dish.setAvailable(random.nextBoolean());
                        dish.setOffre(random.nextBoolean());
                        dish.setImage(dishName.replaceAll(" ", "") + ".jpg");
                        dish.setMenus(menu);
                        dishRepository.save(dish);

                    });

                } else if (menu.getName().equals("Plats")) {
                    Stream.of("Plat Chiken", "Plat Fish", "Plat Meat", "Plat Vegetarian", "Plat Vegan", "Plat Seafood", "Plat Pasta", "Plat Rice")
                            .forEach(dishName -> {
                                Item dish = new Item();
                                dish.setName(dishName);
                                dish.setPrice(40 + (int) (Math.random() * 10));
                                dish.setAvailable(random.nextBoolean());
                                dish.setOffre(random.nextBoolean());
                                dish.setImage(dishName.replaceAll(" ", "") + ".jpg");
                                dish.setMenus(menu);
                                dishRepository.save(dish);

                            });

                } else if (menu.getName().equals("Plat_Marocains")) {
                    Stream.of("Tajine", "Couscous", "Pastilla", "Harira", "Bissara", "Rfissa", "Chorba", "Zaalouk", "Chakchouka", "Méchoui", "Mrouzia", "Tanjia", "Pastilla")
                            .forEach(dishName -> {
                                Item dish = new Item();
                                dish.setName(dishName);

                                dish.setPrice(50 + (int) (Math.random() * 10));
                                dish.setAvailable(random.nextBoolean());
                                dish.setOffre(random.nextBoolean());
                                dish.setImage(dishName.replaceAll(" ", "") + ".jpg");
                                dish.setMenus(menu);
                                dishRepository.save(dish);

                            });
                } else if (menu.getName().equals("Desserts")) {
                    Stream.of("Tiramisu", "Mousse au chocolat", "Crème brûlée", "Tarte au citron meringuée", "Fondant au chocolat", "Île flottante", "Panna cotta"
                    ).forEach(dishName -> {
                        Item dish = new Item();
                        dish.setName(dishName);
                        dish.setPrice(25 + (int) (Math.random() * 10));
                        dish.setAvailable(random.nextBoolean());
                        dish.setOffre(random.nextBoolean());
                        dish.setImage(dishName.replaceAll(" ", "") + ".jpg");
                        dish.setMenus(menu);
                        dishRepository.save(dish);

                    });
                } else if (menu.getName().equals("Entrées")) {
                    Stream.of("Salade", "Soupe", "Tartare", "Carpaccio", "Ceviche", "Gaspacho", "Vichyssoise", "Velouté")
                            .forEach(dishName -> {
                                Item dish = new Item();
                                dish.setName(dishName);
                                dish.setPrice(20 + (int) (Math.random() * 10));
                                dish.setAvailable(random.nextBoolean());
                                dish.setOffre(random.nextBoolean());
                                dish.setImage(dishName.replaceAll(" ", "") + ".jpg");
                                dish.setMenus(menu);
                                dishRepository.save(dish);

                            });
                } else if (menu.getName().equals("Pizzas")) {
                    Stream.of("Pizza Margherita", "Pizza Reine", "Pizza 4 fromages", "Pizza Végétarienne", "Pizza Hawaïenne", "Pizza Frutti di Mare", "Pizza Thone")
                            .forEach(dishName -> {
                                Item dish = new Item();
                                dish.setName(dishName);
                                dish.setPrice(30 + (int) (Math.random() * 10));
                                dish.setAvailable(random.nextBoolean());
                                dish.setOffre(random.nextBoolean());
                                dish.setImage(dishName.replaceAll(" ", "") + ".jpg");
                                dish.setMenus(menu);
                                dishRepository.save(dish);

                            });

                } else if (menu.getName().equals("Burgers")) {
                    Stream.of("Burger Cheese", "Burger Fish", "Burger Meat", "Burger Vegetarian", "Burger Vegan", "Burger Seafood", "Burger Pasta", "Burger Rice")
                            .forEach(dishName -> {
                                Item dish = new Item();
                                dish.setName(dishName);
                                dish.setPrice(40 + (int) (Math.random() * 10));
                                dish.setAvailable(random.nextBoolean());
                                dish.setOffre(random.nextBoolean());
                                dish.setImage(dishName.replaceAll(" ", "") + ".jpg");
                                dish.setMenus(menu);
                                dishRepository.save(dish);

                            });

                } else if (menu.getName().equals("Salades")) {
                    Stream.of("Salade César", "Salade Niçoise", "Salade Caprese", "Salade Grecque", "Salade Waldorf", "Salade Landaise", "Salade Lyonnaise", "Salade Piémontaise")
                            .forEach(dishName -> {
                                Item dish = new Item();
                                dish.setPrice(20 + (int) (Math.random() * 10));
                                dish.setAvailable(random.nextBoolean());
                                dish.setOffre(random.nextBoolean());
                                dish.setName(dishName);
                                dish.setImage(dishName.replaceAll(" ", "") + ".jpg");
                                dish.setMenus(menu);
                                dishRepository.save(dish);

                            });
                } else if (menu.getName().equals("Sandwichs")) {
                    Stream.of("Sandwich Thon", "Sandwich Poulet", "Sandwich Fromage", "Sandwich Végétarien", "Sandwich Vegan", "Sandwich Saumon", "Sandwich Jambon", "Sandwich Oeuf", "Sandwich Salami", "Sandwich Merguez", "Sandwich Kefta", "Sandwich Escalope")
                            .forEach(dishName -> {
                                Item dish = new Item();
                                dish.setName(dishName);
                                dish.setPrice(20 + (int) (Math.random() * 10));
                                dish.setAvailable(random.nextBoolean());
                                dish.setOffre(random.nextBoolean());
                                dish.setImage(dishName.replaceAll(" ", "") + ".jpg");
                                dish.setMenus(menu);
                                dishRepository.save(dish);

                            });
                } else if (menu.getName().equals("Pâtes")) {
                    Stream.of("Pâtes Carbonara", "Pâtes Bolognaise", "Pâtes Arrabiata", "Pâtes Pesto", "Pâtes Alfredo", "Pâtes Puttanesca", "Pâtes Amatriciana")
                            .forEach(dishName -> {
                                Item dish = new Item();
                                dish.setName(dishName);
                                dish.setPrice(30 + (int) (Math.random() * 10));
                                dish.setAvailable(random.nextBoolean());
                                dish.setOffre(random.nextBoolean());
                                dish.setImage(dishName.replaceAll(" ", "") + ".jpg");
                                dish.setMenus(menu);
                                dishRepository.save(dish);

                            });
                } else if (menu.getName().equals("Soupes")) {
                    Stream.of("Soupe à l'oignon", "Soupe de poisson", "Soupe de légumes", "Soupe de potiron", "Soupe de tomates", "Soupe de champignons", "Soupe de courgettes", "Soupe de carottes", "Soupe de brocolis", "Soupe de choux", "Soupe de lentilles")
                            .forEach(dishName -> {
                                Item dish = new Item();
                                dish.setName(dishName);
                                dish.setPrice(20 + (int) (Math.random() * 10));
                                dish.setAvailable(random.nextBoolean());
                                dish.setOffre(random.nextBoolean());
                                dish.setImage(dishName.replaceAll(" ", "") + ".jpg");
                                dish.setMenus(menu);
                                dishRepository.save(dish);

                            });

                } else if (menu.getName().equals("Tacos")) {
                    Stream.of("Tacos Poulet", "Tacos Viande", "Tacos Végétarien", "Tacos Vegan", "Tacos Saumon", "Tacos Jambon", "Tacos Salami", "Tacos Merguez", "Tacos Kefta", "Tacos Escalope")
                            .forEach(dishName -> {
                                Item dish = new Item();
                                dish.setName(dishName);
                                dish.setPrice(20 + (int) (Math.random() * 10));
                                dish.setAvailable(random.nextBoolean());
                                dish.setOffre(random.nextBoolean());
                                dish.setImage(dishName.replaceAll(" ", "") + ".jpg");
                                dish.setMenus(menu);
                                dishRepository.save(dish);

                            });
                }

            });
        }
    }



