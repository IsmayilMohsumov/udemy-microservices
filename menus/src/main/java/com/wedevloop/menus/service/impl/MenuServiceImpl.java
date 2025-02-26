package com.wedevloop.menus.service.impl;

import com.wedevloop.menus.entity.Menu;
import com.wedevloop.menus.repository.MenuRepository;
import com.wedevloop.menus.service.IMenuService;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.misc.MultiMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements IMenuService {
    private MenuRepository menuRepository;

    @Override
    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }
}
