package org.example.backendrestauration.Web;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.backendrestauration.Dao.ItemRepository;
import org.example.backendrestauration.Dao.MenuRepository;
import org.example.backendrestauration.Dtos.MenuDTO;
import org.example.backendrestauration.Entites.Item;
import org.example.backendrestauration.Entites.Menu;
import org.example.backendrestauration.Exception.ItemNotFoundException;
import org.example.backendrestauration.Exception.MenuNotFoundException;
import org.example.backendrestauration.Service.IService;
import org.example.backendrestauration.Service.Iitem;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")

public class ItemController {
    private final MenuRepository menuRepository;
    private Iitem iitem;
private IService iService;
private ItemRepository itemRepository;
@GetMapping("/itemss/{id}")
    public Item Getitem( @PathVariable(name = "id") Long id) throws ItemNotFoundException {
    return iitem.getitem(id);
    }

    @GetMapping("/itemss")
    public List<Item> getallitems() {
        return iitem.getallitem();
    }
    @PostMapping("/itemss/{idmenu}")
    public Item saveitem(@PathVariable(name = "idmenu") Long idmenu, @RequestParam("file") MultipartFile file,  @RequestParam("items") String item) throws Exception {
        Item items = new ObjectMapper().readValue(item, Item.class);
        String folder = System.getProperty("user.home")+"/restauration/items/";
        String filename = items.getName().replace(" ", "") + ".jpg";
        Path path = Paths.get(folder + filename);
        Files.write(path, file.getBytes());
        items.setImage(filename);
        return iitem.saveitem(idmenu,items);
    }
    @PutMapping("/itemss/{id}")
    public Item updateitem(@PathVariable(name = "id") Long id,@RequestBody Item item) throws ItemNotFoundException {
        item.setId(id);
        Item item1 = itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item not found"));
        item.setMenus(item1.getMenus());
        item.setImage(item1.getImage());
         return iitem.updateitem(item);
    }
    @DeleteMapping("/itemss/{id}")
    public void deletitem(@PathVariable(name = "id") Long id) {
        iitem.deleteitem(id);
    }
    @PostMapping("/itemss/addingredient/{iditem}")
    public Item addingredient( @PathVariable Long iditem ,@RequestBody infoitem infoitem) throws ItemNotFoundException {
        iitem.addingredienttoitem(iditem,infoitem.getIdingredient());
        return itemRepository.findById(iditem).get();
    }
    @GetMapping("/menu")
    public List<MenuDTO> getmenu() {
         return iitem.GetMenuDto();
    }
    @GetMapping("/menu/{id}")
    public Menu getmenu(@PathVariable Long id) {
        return menuRepository.findById(id).get();
    }
    @GetMapping(value = "/imagemenu/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getimage(@PathVariable Long id) throws Exception{
    Menu menu = menuRepository.findById(id).get();
    return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/restauration/menu/"+menu.getImage()));

    }

    @GetMapping(value = "/imagesitems/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getimageitems(@PathVariable Long id) throws Exception{
       Item items = itemRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/restauration/items/"+items.getImage()));

    }
    @GetMapping("/menuss/{menuid}/items")
    public Page<Item> getialltems(@PathVariable Long menuid,
                                  @RequestParam(name = "page",defaultValue = "0") int page,
                                  @RequestParam(name = "size",defaultValue = "9") int size)  {
        return iitem.geItemPage(menuid,page,size);
    }
}
@Data
class infoitem{
    private Long iditem;
    private List<Long> idingredient=new ArrayList<>();
}