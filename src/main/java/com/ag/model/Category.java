package com.ag.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="tbl_inv_category")
@ManagedBean(name="category")
public class Category {
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
     
    private String category;
     
    private String category_icon_url;
    
    private String order;
    
    private boolean is_deleted;
    
    private Date create_dateTime;
    
    private Date update_dateTime;
    
    public int getId() {
        return id;
    }
 
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory_icon_url() {
		return category_icon_url;
	}

	public void setCategory_icon_url(String category_icon_url) {
		this.category_icon_url = category_icon_url;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public Date getCreate_dateTime() {
		return create_dateTime;
	}

	public void setCreate_dateTime(Date create_dateTime) {
		this.create_dateTime = create_dateTime;
	}

	public Date getUpdate_dateTime() {
		return update_dateTime;
	}

	public void setUpdate_dateTime(Date update_dateTime) {
		this.update_dateTime = update_dateTime;
	}

	public void setId(int id) {
        this.id = id;
    }
 
   
}