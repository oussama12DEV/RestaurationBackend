package org.example.backendrestauration.Service;

import jakarta.transaction.Transactional;
import org.example.backendrestauration.Dtos.MenuDTO;
import org.example.backendrestauration.Entites.Item;
import org.example.backendrestauration.Entites.Menu;
import org.example.backendrestauration.Exception.ItemNotFoundException;
import org.example.backendrestauration.Exception.MenuNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public interface Iitem {
    Item getitem(Long id) throws ItemNotFoundException;
    Item saveitem(Long idmenu,Item item) throws MenuNotFoundException;
    void deleteitem(Long id);
    Item updateitem(Item item);
    List<Item> getallitem();
    void addingredienttoitem(Long iditem,List<Long> idingredient) throws ItemNotFoundException;
    List<MenuDTO> GetMenuDto();
    Page<Item> geItemPage(Long menuid, int page, int size);
}
