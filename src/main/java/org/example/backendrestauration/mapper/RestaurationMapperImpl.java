package org.example.backendrestauration.mapper;

import org.example.backendrestauration.Dtos.ItemDTO;
import org.example.backendrestauration.Dtos.MenuDTO;
import org.example.backendrestauration.Entites.Item;
import org.example.backendrestauration.Entites.Menu;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class RestaurationMapperImpl {

    public MenuDTO toMenu(Menu menu) {
        if (menu == null) {
            return null;
        }
        MenuDTO menuDTO = new MenuDTO();
        BeanUtils.copyProperties(menu, menuDTO);
        menu.getItems().forEach(item -> menuDTO.getItems().add(toMenu(item)));
        return menuDTO;
    }
    public Menu toMenuDTO(MenuDTO menuDTO) {
        if (menuDTO == null) {
            return null;
        }
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDTO, menu);
        return menu;
    }
    private ItemDTO toMenu(Item item) {
        if (item == null) {
            return null;
        }
        ItemDTO itemDTO = new ItemDTO();
        BeanUtils.copyProperties(item, itemDTO);
        return itemDTO;
    }
}
