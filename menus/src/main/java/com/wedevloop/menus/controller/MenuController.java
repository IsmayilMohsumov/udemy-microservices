package com.wedevloop.menus.controller;

import com.wedevloop.menus.constants.MenuConstants;
import com.wedevloop.menus.entity.Menu;
import com.wedevloop.menus.service.IMenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
@AllArgsConstructor
public class MenuController {
    private IMenuService menuService;

    @PostMapping
    public ResponseEntity<String> createMenu(@RequestBody Menu menu) {
        menuService.saveMenu(menu);
        return ResponseEntity.ok(MenuConstants.MENU_CREATED_MESSAGE);
    }


    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus() {
        return ResponseEntity.ok(menuService.getAllMenus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // TODO:  UPDATE  ve DELETE
}
