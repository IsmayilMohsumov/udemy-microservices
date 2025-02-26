package com.wedevloop.menus.service;

import com.wedevloop.menus.entity.Menu;

import java.util.List;
import java.util.Optional;

public interface IMenuService {
    Menu saveMenu(Menu menu);

    List<Menu> getAllMenus();
    Optional<Menu> getMenuById(Long id);
}
