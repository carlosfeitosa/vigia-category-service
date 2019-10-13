package com.magalister.categoryservice.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.magalister.categoryservice.model.enums.CategoryType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Category model.
 * 
 * @author Carlos Feitosa (carlos.feitosa.nt@gmail.com)
 * @since 2019-08-25
 *
 */
@Data
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "type", "parent_id" }) })
public class Category {

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private int type;

	@ManyToOne
	private Category parent;

	@OneToMany(mappedBy = "parent")
	private Collection<Category> children;

	@NonNull
	private String name;

	@Basic
	private String description;

	@Basic(optional = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;

	public Category() {

		super();
	}

	public Category(String name, CategoryType type) {

		this.name = name;
		this.type = type.getCode();
	}

	public Category(String name, CategoryType type, String description) {

		this.name = name;
		this.type = type.getCode();
		this.description = description;
	}

	public Category(String name, CategoryType type, Category parent) {

		this.name = name;
		this.type = type.getCode();
		this.parent = parent;
	}

	public Category(String name, CategoryType type, Category parent, String description) {

		this.name = name;
		this.type = type.getCode();
		this.parent = parent;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	/**
	 * Get type and convert (int) to it's Enum.
	 * 
	 * @return CategoryType (Enum)
	 */
	public CategoryType getTypeEnum() {

		return CategoryType.fromCode(this.type);
	}

	/**
	 * Set type (int) from it's Enum.
	 * 
	 * @param type
	 */
	public void setType(CategoryType type) {

		this.type = type.getCode();
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public Collection<Category> getChildren() {
		return children;
	}

	public void setChildren(Collection<Category> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {

		return String.format("[%d] %s [%s](%s)", id, name, CategoryType.fromCode(type).getDescription(), description);
	}
}
