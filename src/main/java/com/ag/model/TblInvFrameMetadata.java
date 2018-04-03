package com.ag.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TblInvFrameMetadata generated by hbm2java
 */
@Entity
@Table(name = "tbl_inv_frame_metadata", catalog = "3d_customer_api")
@ManagedBean
public class TblInvFrameMetadata implements java.io.Serializable {

	private Integer id;
	private TblInvBrand tblInvBrand;
	private TblInvCategory tblInvCategory;
	private TblInvColor tblInvColorByGlassColorId;
	private TblInvColor tblInvColorByTempleColorId;
	private TblInvColor tblInvColorByFrameColorId;
	private TblInvFocaltype tblInvFocaltype;
	private TblInvFrameMetadata tblInvFrameMetadata;
	private TblInvFrametype tblInvFrametype;
	private TblInvGender tblInvGender;
	private TblInvMaterial tblInvMaterialByFrameMaterialId;
	private TblInvMaterial tblInvMaterialByTempleMaterialId;
	private TblInvShape tblInvShape;
	private String displayFramecolorText;
	private String displayTemplecolorText;
	private String displayGlasscolorText;
	private String displayMaterialText;
	private String materialReflection;
	private String modelNumber;
	private String productName;
	private String description;
	private Integer price;
	private String priceUnit;
	private String size;
	private String sizeActual;
	private String weight;
	private Integer weightActualGrams;
	private String internalId;
	private byte isDeleted;
	private Date createDatetime;
	private Date updateDatetime;
	private String uuid;
	private Byte is3dcreated;
	private String lookzId;
	private String imagePath;
	private Byte isTryonCreated;
	private String priceRange;
	private Set<TblOrderitems> tblOrderitemses = new HashSet<TblOrderitems>(0);
	private Set<TblInvDistFrame> tblInvDistFrames = new HashSet<TblInvDistFrame>(0);
	private Set<TblInvFrameMetadata> tblInvFrameMetadatas = new HashSet<TblInvFrameMetadata>(0);

	public TblInvFrameMetadata() {
	}

	public TblInvFrameMetadata(TblInvBrand tblInvBrand, TblInvCategory tblInvCategory,
			TblInvColor tblInvColorByGlassColorId, TblInvColor tblInvColorByTempleColorId,
			TblInvColor tblInvColorByFrameColorId, TblInvFrametype tblInvFrametype, TblInvGender tblInvGender,
			TblInvMaterial tblInvMaterialByFrameMaterialId, TblInvMaterial tblInvMaterialByTempleMaterialId,
			TblInvShape tblInvShape, String modelNumber, String size, byte isDeleted, Date createDatetime) {
		this.tblInvBrand = tblInvBrand;
		this.tblInvCategory = tblInvCategory;
		this.tblInvColorByGlassColorId = tblInvColorByGlassColorId;
		this.tblInvColorByTempleColorId = tblInvColorByTempleColorId;
		this.tblInvColorByFrameColorId = tblInvColorByFrameColorId;
		this.tblInvFrametype = tblInvFrametype;
		this.tblInvGender = tblInvGender;
		this.tblInvMaterialByFrameMaterialId = tblInvMaterialByFrameMaterialId;
		this.tblInvMaterialByTempleMaterialId = tblInvMaterialByTempleMaterialId;
		this.tblInvShape = tblInvShape;
		this.modelNumber = modelNumber;
		this.size = size;
		this.isDeleted = isDeleted;
		this.createDatetime = createDatetime;
	}

	public TblInvFrameMetadata(TblInvBrand tblInvBrand, TblInvCategory tblInvCategory,
			TblInvColor tblInvColorByGlassColorId, TblInvColor tblInvColorByTempleColorId,
			TblInvColor tblInvColorByFrameColorId, TblInvFocaltype tblInvFocaltype,
			TblInvFrameMetadata tblInvFrameMetadata, TblInvFrametype tblInvFrametype, TblInvGender tblInvGender,
			TblInvMaterial tblInvMaterialByFrameMaterialId, TblInvMaterial tblInvMaterialByTempleMaterialId,
			TblInvShape tblInvShape, String displayFramecolorText, String displayTemplecolorText,
			String displayGlasscolorText, String displayMaterialText, String materialReflection, String modelNumber,
			String productName, String description, Integer price, String priceUnit, String size, String sizeActual,
			String weight, Integer weightActualGrams, String internalId, byte isDeleted, Date createDatetime,
			Date updateDatetime, String uuid, Byte is3dcreated, String lookzId, String imagePath, Byte isTryonCreated,
			String priceRange, Set<TblOrderitems> tblOrderitemses, Set<TblInvDistFrame> tblInvDistFrames,
			Set<TblInvFrameMetadata> tblInvFrameMetadatas) {
		this.tblInvBrand = tblInvBrand;
		this.tblInvCategory = tblInvCategory;
		this.tblInvColorByGlassColorId = tblInvColorByGlassColorId;
		this.tblInvColorByTempleColorId = tblInvColorByTempleColorId;
		this.tblInvColorByFrameColorId = tblInvColorByFrameColorId;
		this.tblInvFocaltype = tblInvFocaltype;
		this.tblInvFrameMetadata = tblInvFrameMetadata;
		this.tblInvFrametype = tblInvFrametype;
		this.tblInvGender = tblInvGender;
		this.tblInvMaterialByFrameMaterialId = tblInvMaterialByFrameMaterialId;
		this.tblInvMaterialByTempleMaterialId = tblInvMaterialByTempleMaterialId;
		this.tblInvShape = tblInvShape;
		this.displayFramecolorText = displayFramecolorText;
		this.displayTemplecolorText = displayTemplecolorText;
		this.displayGlasscolorText = displayGlasscolorText;
		this.displayMaterialText = displayMaterialText;
		this.materialReflection = materialReflection;
		this.modelNumber = modelNumber;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.priceUnit = priceUnit;
		this.size = size;
		this.sizeActual = sizeActual;
		this.weight = weight;
		this.weightActualGrams = weightActualGrams;
		this.internalId = internalId;
		this.isDeleted = isDeleted;
		this.createDatetime = createDatetime;
		this.updateDatetime = updateDatetime;
		this.uuid = uuid;
		this.is3dcreated = is3dcreated;
		this.lookzId = lookzId;
		this.imagePath = imagePath;
		this.isTryonCreated = isTryonCreated;
		this.priceRange = priceRange;
		this.tblOrderitemses = tblOrderitemses;
		this.tblInvDistFrames = tblInvDistFrames;
		this.tblInvFrameMetadatas = tblInvFrameMetadatas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id", nullable = false)
	public TblInvBrand getTblInvBrand() {
		return this.tblInvBrand;
	}

	public void setTblInvBrand(TblInvBrand tblInvBrand) {
		this.tblInvBrand = tblInvBrand;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public TblInvCategory getTblInvCategory() {
		return this.tblInvCategory;
	}

	public void setTblInvCategory(TblInvCategory tblInvCategory) {
		this.tblInvCategory = tblInvCategory;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "glass_color_id", nullable = false)
	public TblInvColor getTblInvColorByGlassColorId() {
		return this.tblInvColorByGlassColorId;
	}

	public void setTblInvColorByGlassColorId(TblInvColor tblInvColorByGlassColorId) {
		this.tblInvColorByGlassColorId = tblInvColorByGlassColorId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "temple_color_id", nullable = false)
	public TblInvColor getTblInvColorByTempleColorId() {
		return this.tblInvColorByTempleColorId;
	}

	public void setTblInvColorByTempleColorId(TblInvColor tblInvColorByTempleColorId) {
		this.tblInvColorByTempleColorId = tblInvColorByTempleColorId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "frame_color_id", nullable = false)
	public TblInvColor getTblInvColorByFrameColorId() {
		return this.tblInvColorByFrameColorId;
	}

	public void setTblInvColorByFrameColorId(TblInvColor tblInvColorByFrameColorId) {
		this.tblInvColorByFrameColorId = tblInvColorByFrameColorId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "focal_type_id")
	public TblInvFocaltype getTblInvFocaltype() {
		return this.tblInvFocaltype;
	}

	public void setTblInvFocaltype(TblInvFocaltype tblInvFocaltype) {
		this.tblInvFocaltype = tblInvFocaltype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_frameid")
	public TblInvFrameMetadata getTblInvFrameMetadata() {
		return this.tblInvFrameMetadata;
	}

	public void setTblInvFrameMetadata(TblInvFrameMetadata tblInvFrameMetadata) {
		this.tblInvFrameMetadata = tblInvFrameMetadata;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "frametype_id", nullable = false)
	public TblInvFrametype getTblInvFrametype() {
		return this.tblInvFrametype;
	}

	public void setTblInvFrametype(TblInvFrametype tblInvFrametype) {
		this.tblInvFrametype = tblInvFrametype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gender_id", nullable = false)
	public TblInvGender getTblInvGender() {
		return this.tblInvGender;
	}

	public void setTblInvGender(TblInvGender tblInvGender) {
		this.tblInvGender = tblInvGender;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "frame_material_id", nullable = false)
	public TblInvMaterial getTblInvMaterialByFrameMaterialId() {
		return this.tblInvMaterialByFrameMaterialId;
	}

	public void setTblInvMaterialByFrameMaterialId(TblInvMaterial tblInvMaterialByFrameMaterialId) {
		this.tblInvMaterialByFrameMaterialId = tblInvMaterialByFrameMaterialId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "temple_material_id", nullable = false)
	public TblInvMaterial getTblInvMaterialByTempleMaterialId() {
		return this.tblInvMaterialByTempleMaterialId;
	}

	public void setTblInvMaterialByTempleMaterialId(TblInvMaterial tblInvMaterialByTempleMaterialId) {
		this.tblInvMaterialByTempleMaterialId = tblInvMaterialByTempleMaterialId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shape_id", nullable = false)
	public TblInvShape getTblInvShape() {
		return this.tblInvShape;
	}

	public void setTblInvShape(TblInvShape tblInvShape) {
		this.tblInvShape = tblInvShape;
	}

	@Column(name = "display_framecolor_text", length = 100)
	public String getDisplayFramecolorText() {
		return this.displayFramecolorText;
	}

	public void setDisplayFramecolorText(String displayFramecolorText) {
		this.displayFramecolorText = displayFramecolorText;
	}

	@Column(name = "display_templecolor_text", length = 100)
	public String getDisplayTemplecolorText() {
		return this.displayTemplecolorText;
	}

	public void setDisplayTemplecolorText(String displayTemplecolorText) {
		this.displayTemplecolorText = displayTemplecolorText;
	}

	@Column(name = "display_glasscolor_text", length = 100)
	public String getDisplayGlasscolorText() {
		return this.displayGlasscolorText;
	}

	public void setDisplayGlasscolorText(String displayGlasscolorText) {
		this.displayGlasscolorText = displayGlasscolorText;
	}

	@Column(name = "display_material_text", length = 100)
	public String getDisplayMaterialText() {
		return this.displayMaterialText;
	}

	public void setDisplayMaterialText(String displayMaterialText) {
		this.displayMaterialText = displayMaterialText;
	}

	@Column(name = "material_reflection", length = 50)
	public String getMaterialReflection() {
		return this.materialReflection;
	}

	public void setMaterialReflection(String materialReflection) {
		this.materialReflection = materialReflection;
	}

	@Column(name = "model_number", nullable = false, length = 100)
	public String getModelNumber() {
		return this.modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	@Column(name = "product_name", length = 100)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "price_unit", length = 20)
	public String getPriceUnit() {
		return this.priceUnit;
	}

	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}

	@Column(name = "size", nullable = false, length = 20)
	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Column(name = "size_actual", length = 50)
	public String getSizeActual() {
		return this.sizeActual;
	}

	public void setSizeActual(String sizeActual) {
		this.sizeActual = sizeActual;
	}

	@Column(name = "weight", length = 50)
	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Column(name = "weight_actual_grams")
	public Integer getWeightActualGrams() {
		return this.weightActualGrams;
	}

	public void setWeightActualGrams(Integer weightActualGrams) {
		this.weightActualGrams = weightActualGrams;
	}

	@Column(name = "internal_id", length = 50)
	public String getInternalId() {
		return this.internalId;
	}

	public void setInternalId(String internalId) {
		this.internalId = internalId;
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

	@Column(name = "uuid", length = 50)
	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Column(name = "is_3DCreated")
	public Byte getIs3dcreated() {
		return this.is3dcreated;
	}

	public void setIs3dcreated(Byte is3dcreated) {
		this.is3dcreated = is3dcreated;
	}

	@Column(name = "lookz_id", length = 50)
	public String getLookzId() {
		return this.lookzId;
	}

	public void setLookzId(String lookzId) {
		this.lookzId = lookzId;
	}

	@Column(name = "image_path", length = 200)
	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Column(name = "is_tryonCreated")
	public Byte getIsTryonCreated() {
		return this.isTryonCreated;
	}

	public void setIsTryonCreated(Byte isTryonCreated) {
		this.isTryonCreated = isTryonCreated;
	}

	@Column(name = "price_range", length = 50)
	public String getPriceRange() {
		return this.priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblInvFrameMetadata")
	public Set<TblOrderitems> getTblOrderitemses() {
		return this.tblOrderitemses;
	}

	public void setTblOrderitemses(Set<TblOrderitems> tblOrderitemses) {
		this.tblOrderitemses = tblOrderitemses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblInvFrameMetadata")
	public Set<TblInvDistFrame> getTblInvDistFrames() {
		return this.tblInvDistFrames;
	}

	public void setTblInvDistFrames(Set<TblInvDistFrame> tblInvDistFrames) {
		this.tblInvDistFrames = tblInvDistFrames;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblInvFrameMetadata")
	public Set<TblInvFrameMetadata> getTblInvFrameMetadatas() {
		return this.tblInvFrameMetadatas;
	}

	public void setTblInvFrameMetadatas(Set<TblInvFrameMetadata> tblInvFrameMetadatas) {
		this.tblInvFrameMetadatas = tblInvFrameMetadatas;
	}

}
