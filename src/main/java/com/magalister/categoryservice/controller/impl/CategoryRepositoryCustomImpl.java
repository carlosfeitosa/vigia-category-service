package com.magalister.categoryservice.controller.impl;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.magalister.categoryservice.controller.CategoryRepositoryCustom;
import com.magalister.categoryservice.model.Category;

/**
 * Category custom repository
 * 
 * @author Carlos Feitosa (carlos.feitosa.nt@gmail.com)
 * @since 2019-08-25
 *
 */
@Repository
@Transactional
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

	@PersistenceContext
	EntityManager em;

	@Override
	public Category save(Category entity, boolean updateLastUpdate) {

		if (updateLastUpdate) {

			entity.setLastUpdate(Calendar.getInstance().getTime());
		}

		em.persist(entity);
		return entity;
	}
}
