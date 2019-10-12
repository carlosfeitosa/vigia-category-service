package com.magalister.categoryservice.controller;

import com.magalister.categoryservice.model.Category;

/**
 * Interface for category custom repository.
 * 
 * @author Carlos Feitosa (carlos.feitosa.nt@gmail.com)
 * @since 2019-08-25
 *
 */
public interface CategoryRepositoryCustom {
	
	/**
	 * Custom save that update lastUpdate.
	 * 
	 * @param category
	 * @param true for use current timestamp
	 * 
	 * @return category
	 */
	Category save(Category entity, boolean updateLastUpdate);
}
