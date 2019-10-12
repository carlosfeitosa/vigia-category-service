package com.magalister.categoryservice.model.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Category type enum.
 * 
 * @author Carlos Feitosa (carlos.feitosa.nt@gmail.com)
 * @since 2019-08-25
 *
 */
public enum CategoryType {

	CREDIT(1, "Categoria de crédito"), DEBIT(2, "Categoria de débito"), UNKNOW(0, "Desconhecido");

	// map for provide direct access to Enum by it's code (fromCode method)
	private static final Map<Integer, CategoryType> internalMap = new HashMap<>();

	// populating internal map with all Enums
	static {

		for (CategoryType type : CategoryType.values()) {
			internalMap.put(type.getCode(), type);
		}
	}

	private int code;
	private String description;

	private CategoryType(int code, String description) {

		this.code = code;
		this.description = description;
	}

	public int getCode() {

		return this.code;
	}

	public String getDescription() {

		return this.description;
	}

	public static CategoryType fromCode(int code) {

		if (internalMap.containsKey(code)) {
			return internalMap.get(code);
		} else {
			return CategoryType.UNKNOW;
		}
	}
}
