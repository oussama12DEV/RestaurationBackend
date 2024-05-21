package org.example.backendrestauration.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.backendrestauration.Dao.IngredientDishsRepository;
import org.example.backendrestauration.Dao.IngredientRepository;
import org.example.backendrestauration.Dao.ItemRepository;
import org.example.backendrestauration.Dao.MenuRepository;
import org.example.backendrestauration.Dtos.MenuDTO;
import org.example.backendrestauration.Entites.Ingredients;
import org.example.backendrestauration.Entites.IngredientsItem;
import org.example.backendrestauration.Entites.Item;
import org.example.backendrestauration.Entites.Menu;
import org.example.backendrestauration.Exception.IngredientNotFoundException;
import org.example.backendrestauration.Exception.ItemNotFoundException;
import org.example.backendrestauration.Exception.MenuNotFoundException;
import org.example.backendrestauration.mapper.RestaurationMapperImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
@AllArgsConstructor
public class IitemImpl implements Iitem {
    private IngredientDishsRepository ingredientDishsRepository;
    private IngredientRepository ingredientRepository;
    private ItemRepository itemRepository;
    private MenuRepository menuRepository;
    private RestaurationMapperImpl restaurationMapper;
    @Override
    public Item getitem(Long id) throws ItemNotFoundException {
       Item item=itemRepository.findById(id).orElseThrow(()->new ItemNotFoundException("Item not found"));
        return item;
    }

    @Override
    public Item saveitem(Long idmenu,Item item) throws MenuNotFoundException {
          Menu menu = menuRepository.findById(idmenu).orElseThrow(()->new MenuNotFoundException("Menu not found"));
          item.setMenus(menu);
        return itemRepository.save(item);
    }

    @Override
    public void deleteitem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item updateitem(Item item) {
        item.setName(item.getName());
        item.setPrice(item.getPrice());
        item.setAvailable(item.isAvailable());
        item.setOffre(item.isOffre());
        itemRepository.save(item);
        return item;
    }

    @Override
    public List<Item> getallitem() {
        List<Item> all = itemRepository.findAll();
        return all;
    }

    @Override
    public void addingredienttoitem(Long iditem, List<Long> idingredient) throws ItemNotFoundException{
      Item item = itemRepository.findById(iditem).orElseThrow(()->new ItemNotFoundException("Item not found"));
      idingredient.stream().forEach(id->{
          Ingredients ingredients= new Ingredients();
          //je fait try catch parsque je ne peux pas utiliser le throw a l'intérieur de  stream
          try {
              ingredients = ingredientRepository.findById(id).orElseThrow(()->new IngredientNotFoundException("Ingredient not found"));
          } catch (IngredientNotFoundException e) {
              e.printStackTrace();
          }
            IngredientsItem ingredientsItem = new IngredientsItem();
            ingredientsItem.setDishes(item);
            ingredientsItem.setIngredients(ingredients);
            ingredientDishsRepository.save(ingredientsItem);
      });


    }

    @Override
    public List<MenuDTO> GetMenuDto() {
     List<Menu> all = menuRepository.findAll();
        List<MenuDTO> menuDTOStream = all.stream().map(menu -> restaurationMapper.toMenu(menu)).collect(Collectors.toList());
        return menuDTOStream;
    }

    @Override
    public Page<Item> geItemPage(Long menuid, int page, int size) {
        Menu menu = menuRepository.findById(menuid).get();
        Page<Item> itemByMenusId = itemRepository.findItemByMenus_Id(menu.getId(), PageRequest.of(page,size));
        return itemByMenusId;
    }
}
