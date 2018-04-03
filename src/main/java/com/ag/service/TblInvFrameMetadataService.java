package com.ag.service;

import java.util.List;

import com.ag.model.FrameType;
import com.ag.model.TblInvBrand;
import com.ag.model.TblInvCategory;
import com.ag.model.TblInvColor;
import com.ag.model.TblInvDistFrame;
import com.ag.model.TblInvFocaltype;
import com.ag.model.TblInvFrameMetadata;
import com.ag.model.TblInvFrametype;
import com.ag.model.TblInvGender;
import com.ag.model.TblInvMaterial;
import com.ag.model.TblInvShape;
import com.ag.model.TblUser;

public interface TblInvFrameMetadataService {
	
	 public List<FrameType> listFrameTypes();

	List<TblInvFrameMetadata> listFrameMetadata();

	TblInvBrand getBrand(String string);

	TblInvCategory getCategory(String string);

	TblInvColor getColor(String string);

	TblInvFocaltype getFoculType(String string);

	TblInvGender getGender(String string);

	TblInvMaterial getMaterial(String string);

	TblInvShape getShape(String string);

	TblInvFrametype getFrameType(String string);

	void save(TblInvFrameMetadata frameMetaData);	

	List<TblInvFrameMetadata> getAllFrameMetaData();

	public void remove(TblInvFrameMetadata tblInvFrameMetadata);

	List<TblInvFrametype> getAllFrameType(TblInvFrametype tblInvFrametype);

	List<TblInvBrand> getAllBrand(TblInvBrand tblInvBrand);

	List<TblInvCategory> getAllCategory(TblInvCategory tblInvCategory);

	List<TblInvColor> getAllColor(TblInvColor tblInvColor);

	List<TblInvFocaltype> getAllFoculType(TblInvFocaltype tblInvFocaltype);

	List<TblInvGender> getAllGender(TblInvGender tblInvGender);

	List<TblInvMaterial> getAllMaterial(TblInvMaterial tblInvMaterial);

	List<TblInvShape> getAllShape(TblInvShape shape);
	
	List<TblUser> getAllUser();
	
	List<TblUser> listofDistributors();	

	TblUser getUser(String string);

	void saveDistFrame(TblInvDistFrame tblInvDistFrame);
	
	void removeDistFrame(int userId, int frameMetaDataId);

	List<TblInvFrameMetadata> listAllFrameMetadata(String key, String value);

	List<TblInvDistFrame> listOfDistFrameByFrameMetadata(TblInvFrameMetadata frameMetaData);

	List<TblInvDistFrame> getFrameDistListByUser(TblUser user);

	TblInvFrameMetadata getFrameMetaData(String key, String value);

	



}
