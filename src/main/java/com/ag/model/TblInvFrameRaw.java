package com.ag.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * TblInvFrameRaw generated by hbm2java
 */
@Entity
@Table(name = "tbl_inv_frame_raw", catalog = "3d_customer_api", uniqueConstraints = @UniqueConstraint(columnNames = "uuid"))
public class TblInvFrameRaw implements java.io.Serializable {

	private int id;
	private String uuid;
	private String lookzId;
	private String internalId;
	private String modelNumber;
	private String productName;
	private String category;
	private String frametype;
	private String brand;
	private String shape;
	private String frameColor;
	private String templeColor;
	private String glassColor;
	private String frameMaterial;
	private String templeMaterial;
	private String materialReflection;
	private String gender;
	private String description;
	private Integer price;
	private String priceUnit;
	private String size;
	private String sizeActual;
	private String weight;
	private Integer weightActualGrams;
	private Integer quantity;
	private String path;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String img5;
	private String status;
	private String remarks;
	private String imagePath;

	public TblInvFrameRaw() {
	}

	public TblInvFrameRaw(int id, String lookzId, String status) {
		this.id = id;
		this.lookzId = lookzId;
		this.status = status;
	}

	public TblInvFrameRaw(int id, String uuid, String lookzId, String internalId, String modelNumber,
			String productName, String category, String frametype, String brand, String shape, String frameColor,
			String templeColor, String glassColor, String frameMaterial, String templeMaterial,
			String materialReflection, String gender, String description, Integer price, String priceUnit, String size,
			String sizeActual, String weight, Integer weightActualGrams, Integer quantity, String path, String img1,
			String img2, String img3, String img4, String img5, String status, String remarks, String imagePath) {
		this.id = id;
		this.uuid = uuid;
		this.lookzId = lookzId;
		this.internalId = internalId;
		this.modelNumber = modelNumber;
		this.productName = productName;
		this.category = category;
		this.frametype = frametype;
		this.brand = brand;
		this.shape = shape;
		this.frameColor = frameColor;
		this.templeColor = templeColor;
		this.glassColor = glassColor;
		this.frameMaterial = frameMaterial;
		this.templeMaterial = templeMaterial;
		this.materialReflection = materialReflection;
		this.gender = gender;
		this.description = description;
		this.price = price;
		this.priceUnit = priceUnit;
		this.size = size;
		this.sizeActual = sizeActual;
		this.weight = weight;
		this.weightActualGrams = weightActualGrams;
		this.quantity = quantity;
		this.path = path;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.img5 = img5;
		this.status = status;
		this.remarks = remarks;
		this.imagePath = imagePath;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "uuid", unique = true, length = 50)
	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Column(name = "lookz_id", nullable = false, length = 50)
	public String getLookzId() {
		return this.lookzId;
	}

	public void setLookzId(String lookzId) {
		this.lookzId = lookzId;
	}

	@Column(name = "internal_id", length = 100)
	public String getInternalId() {
		return this.internalId;
	}

	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}

	@Column(name = "model_number", length = 100)
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

	@Column(name = "category", length = 100)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "frametype", length = 100)
	public String getFrametype() {
		return this.frametype;
	}

	public void setFrametype(String frametype) {
		this.frametype = frametype;
	}

	@Column(name = "brand", length = 100)
	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "shape", length = 100)
	public String getShape() {
		return this.shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	@Column(name = "frame_color", length = 100)
	public String getFrameColor() {
		return this.frameColor;
	}

	public void setFrameColor(String frameColor) {
		this.frameColor = frameColor;
	}

	@Column(name = "temple_color", length = 100)
	public String getTempleColor() {
		return this.templeColor;
	}

	public void setTempleColor(String templeColor) {
		this.templeColor = templeColor;
	}

	@Column(name = "glass_color", length = 100)
	public String getGlassColor() {
		return this.glassColor;
	}

	public void setGlassColor(String glassColor) {
		this.glassColor = glassColor;
	}

	@Column(name = "frame_material", length = 100)
	public String getFrameMaterial() {
		return this.frameMaterial;
	}

	public void setFrameMaterial(String frameMaterial) {
		this.frameMaterial = frameMaterial;
	}

	@Column(name = "temple_material", length = 100)
	public String getTempleMaterial() {
		return this.templeMaterial;
	}

	public void setTempleMaterial(String templeMaterial) {
		this.templeMaterial = templeMaterial;
	}

	@Column(name = "material_reflection", length = 50)
	public String getMaterialReflection() {
		return this.materialReflection;
	}

	public void setMaterialReflection(String materialReflection) {
		this.materialReflection = materialReflection;
	}

	@Column(name = "gender", length = 100)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	@Column(name = "size", length = 20)
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

	@Column(name = "quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "path", length = 200)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "img1", length = 200)
	public String getImg1() {
		return this.img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	@Column(name = "img2", length = 200)
	public String getImg2() {
		return this.img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	@Column(name = "img3", length = 200)
	public String getImg3() {
		return this.img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	@Column(name = "img4", length = 200)
	public String getImg4() {
		return this.img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
	}

	@Column(name = "img5", length = 200)
	public String getImg5() {
		return this.img5;
	}

	public void setImg5(String img5) {
		this.img5 = img5;
	}

	@Column(name = "status", nullable = false, length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "remarks", length = 200)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "image_path", length = 200)
	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
