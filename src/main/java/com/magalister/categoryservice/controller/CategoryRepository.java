package com.magalister.categoryservice.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.magalister.categoryservice.model.Category;

/**
 * Category repository
 * 
 * @author Carlos Feitosa (carlos.feitos.nt@gmail.com)
 * @since 2019-08-25
 *
 */
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryRepositoryCustom {

}
