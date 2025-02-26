package com.wedevloop.menus.repository;

import com.wedevloop.menus.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
