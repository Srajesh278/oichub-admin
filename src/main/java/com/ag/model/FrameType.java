package com.ag.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * TblInvFrametype generated by hbm2java
 */
@Entity
@ManagedBean(name="frameType")
@Table(name = "tbl_inv_frametype", catalog = "3d_customer_api", uniqueConstraints = @UniqueConstraint(columnNames = "frametype"))
public class FrameType implements java.io.Serializable {
	
	private Integer id;
	private String frametype;
	private String frametypeIconUrl;
	private int order;
	private byte isDeleted;
	private Date createDatetime;
	private Date updateDatetime;
	/*private Set<TblInvFrameMetadata> tblInvFrameMetadatas = new HashSet<TblInvFrameMetadata>(0);

	public TblInvFrametype() {
	}

	public TblInvFrametype(String frametype, int order, byte isDeleted, Date createDatetime) {
		this.frametype = frametype;
		this.order = order;
		this.isDeleted = isDeleted;
		this.createDatetime = createDatetime;
	}

	public TblInvFrametype(String frametype, String frametypeIconUrl, int order, byte isDeleted, Date createDatetime,
			Date updateDatetime, Set<TblInvFrameMetadata> tblInvFrameMetadatas) {
		this.frametype = frametype;
		this.frametypeIconUrl = frametypeIconUrl;
		this.order = order;
		this.isDeleted = isDeleted;
		this.createDatetime = createDatetime;
		this.updateDatetime = updateDatetime;
		this.tblInvFrameMetadatas = tblInvFrameMetadatas;
	}*/

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "frametype", unique = true, nullable = false, length = 100)
	public String getFrametype() {
		return this.frametype;
	}

	public void setFrametype(String frametype) {
		this.frametype = frametype;
	}

	@Column(name = "frametype_icon_url", length = 200)
	public String getFrametypeIconUrl() {
		return this.frametypeIconUrl;
	}

	public void setFrametypeIconUrl(String frametypeIconUrl) {
		this.frametypeIconUrl = frametypeIconUrl;
	}

	@Column(name = "order", nullable = false)
	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Column(name = "is_deleted", nullable = false)
	public byte getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_datetime", nullable = false, length = 19)
	public Date getCreateDatetime() {
		return this.createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_datetime", length = 19)
	public Date getUpdateDatetime() {
		return this.updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblInvFrametype")
	public Set<TblInvFrameMetadata> getTblInvFrameMetadatas() {
		return this.tblInvFrameMetadatas;
	}

	public void setTblInvFrameMetadatas(Set<TblInvFrameMetadata> tblInvFrameMetadatas) {
		this.tblInvFrameMetadatas = tblInvFrameMetadatas;
	}*/

}
