package com.ag.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ag.dao.TblInvBrandDAO;
import com.ag.dao.TblInvCategoryDAO;
import com.ag.dao.TblInvColorDAO;
import com.ag.dao.TblInvDistFrameDAO;
import com.ag.dao.TblInvFocaltypeDAO;
import com.ag.dao.TblInvFrameMetadataDAO;
import com.ag.dao.TblInvFrametypeDAO;
import com.ag.dao.TblInvGenderDAO;
import com.ag.dao.TblInvMaterialDAO;
import com.ag.dao.TblInvShapeDAO;
import com.ag.dao.TblUserDAO;
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

@Service
@ManagedBean(name="frameTypeServiceImpl")
@SessionScoped
public class TblInvFrameMetadataServiceImpl implements TblInvFrameMetadataService, ApplicationContextAware{
	
	private TblInvFrameMetadataDAO frameMetadataDAO;
	private TblInvBrandDAO tblInvBrandDAO ;
	private TblInvCategoryDAO tblInvCategoryDAO;
	private TblInvColorDAO tblInvColorDAO; 
	private TblInvFocaltypeDAO tblInvFocaltypeDAO;
	private TblInvFrametypeDAO tblInvFrametypeDAO;
	private TblInvGenderDAO tblInvGenderDAO;
	private TblInvMaterialDAO tblInvMaterialDAO;
	private TblInvShapeDAO tblInvShapeDAO;
	private TblUserDAO tblUserDAO;
	private TblInvDistFrameDAO tblInvDistFrameDAO;
	
	
	private List<TblInvBrand> tblInvBrandList = new ArrayList<>();
	private List<TblInvCategory> tblInvCategoryList = new ArrayList<>();
	private List<TblInvColor> tblInvColorList = new ArrayList<>();
	private List<TblInvFocaltype> tblInvFocaltypeList = new ArrayList<>();
	private List<TblInvFrameMetadata> tblInvFrameMetadataList = new ArrayList<>();
	private List<TblInvFrametype> tblInvFrametypeList = new ArrayList<>();
	private List<TblInvGender> tblInvGenderList = new ArrayList<>();
	private List<TblInvMaterial> tblInvMaterialList = new ArrayList<>();
	private List<TblInvShape> tblInvShapeList = new ArrayList<>();
	
	private Map<String,TblInvBrand> tblInvBrandMap = new HashMap<>();
	private Map<String,TblInvCategory> tblInvCategoryMap = new HashMap<>();
	private Map<String,TblInvColor> tblInvColorMap = new HashMap<>();
	private Map<String,TblInvFocaltype> tblInvFocaltypeMap = new HashMap<>();
	private Map<String,TblInvFrameMetadata> tblInvFrameMetadataMap = new HashMap<>();
	private Map<String,TblInvFrametype> tblInvFrametypeMap = new HashMap<>();
	private Map<String,TblInvGender> tblInvGenderMap = new HashMap<>();
	private Map<String,TblInvMaterial> tblInvMaterialMap = new HashMap<>();
	private Map<String,TblInvShape> tblInvShapeMap = new HashMap<>();
	
	public static ApplicationContext ac;
	
	@PostConstruct
    private void init()  {
		frameMetadataDAO = (TblInvFrameMetadataDAO) ac.getBean("frameMetadataDAO");	
    }
	
    public void setFrameTypeDAO(TblInvFrameMetadataDAO frameMetadataDAO) {
        this.frameMetadataDAO = frameMetadataDAO;
    }
	
	@Override
    @Transactional
    public List<FrameType> listFrameTypes() {
        return this.frameMetadataDAO.listFrames();
    }
	
	@Override
    @Transactional
	public List<TblInvFrameMetadata> listFrameMetadata() 
	{
		 return this.frameMetadataDAO.listFrameMetadata();
	}	
	
	@Override
    @Transactional
    public TblInvFrametype getFrameType(String string)
    {
	return tblInvFrametypeDAO.get("frametype", string);	
    }	
	@Override
    @Transactional
    public TblInvBrand getBrand(String string)
    {
	return tblInvBrandDAO.get("brand", string);	
    }
	@Override
    @Transactional
    public TblInvCategory getCategory(String string)
    {
	return tblInvCategoryDAO.get("category", string);	
    }
	@Override
    @Transactional
    public TblInvColor getColor(String string)
    {
	return tblInvColorDAO.get("color", string);	
    }
	@Override
    @Transactional
    public TblInvFocaltype getFoculType(String string)
    {
	return tblInvFocaltypeDAO.get("focalType", string);	
    }
	@Override
    @Transactional
	public TblInvFrameMetadata getFrameMetaData(String key , String value)
    {
	return frameMetadataDAO.get(key, value);	
    }
	@Override
    @Transactional
    public TblInvGender getGender(String string)
    {
	return tblInvGenderDAO.get("gender", string);	
    }
	@Override
    @Transactional
    public TblInvMaterial getMaterial(String string)
    {
	return tblInvMaterialDAO.get("material", string);	
    }
	@Override
    @Transactional
    public TblInvShape getShape(String string)
    {
	return tblInvShapeDAO.get("shape", string);	
    }	
	
	@Override
    @Transactional
    public TblUser getUser(String string)
    {
	return tblUserDAO.get("username", string);	
    }
	
	@Override
    @Transactional
	public List<TblInvFrameMetadata> listAllFrameMetadata(String key, String value) 
	{
		 return this.frameMetadataDAO.getAll(key,value);
	}	
	
	@Override
    @Transactional
    public List<TblInvFrametype> getAllFrameType(TblInvFrametype tblInvFrametype)
    {	
	
	List<TblInvFrametype> clonedFrameTypes =  new ArrayList<>();
	if((tblInvFrametypeList.size()!=0))
	{
		clonedFrameTypes = tblInvFrametypeList;
	}
	else
	{
		clonedFrameTypes = tblInvFrametypeDAO.getAll();
		tblInvFrametypeList = clonedFrameTypes;
	}
	try{
	for (TblInvFrametype clonedFrameType : clonedFrameTypes)
	{
		String frameType = clonedFrameType.getFrametype();
		tblInvFrametypeMap.put(frameType, clonedFrameType);
		if(tblInvFrametype.getFrametype().equalsIgnoreCase(frameType))
		{
				int index = clonedFrameTypes.indexOf(clonedFrameType);					
				clonedFrameTypes.set(index, tblInvFrametype);
				
		}		
	}
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	
    return clonedFrameTypes;
    }	
	@Override
    @Transactional
    public List<TblInvBrand> getAllBrand(TblInvBrand tblInvBrand)
    {		
	
	List<TblInvBrand> clonedBrands =  new ArrayList<>();
	if((tblInvBrandList.size()!=0))
	{
		clonedBrands = tblInvBrandList;
	}
	else
	{
		clonedBrands = tblInvBrandDAO.getAll();
		tblInvBrandList = clonedBrands;
	}
	try{
	for (TblInvBrand clonedBrand : clonedBrands)
	{
		String brand = clonedBrand.getBrand();
		tblInvBrandMap.put(brand, clonedBrand);
		if(tblInvBrand.getBrand().equalsIgnoreCase(brand))
		{
				int index = clonedBrands.indexOf(clonedBrand);					
				clonedBrands.set(index, tblInvBrand);				
		}		
	}
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	
    return clonedBrands;	
	
	
    }
	@Override
    @Transactional
    public List<TblInvCategory> getAllCategory(TblInvCategory tblInvCategory)
    {
			
	List<TblInvCategory> clonedCategorys =  new ArrayList<>();
	if((tblInvColorList.size()!=0))
	{
		clonedCategorys = tblInvCategoryList;
	}
	else
	{
		clonedCategorys = tblInvCategoryDAO.getAll();
		tblInvCategoryList = clonedCategorys;
	}
	try{
	for (TblInvCategory clonedCategory : clonedCategorys)
	{
		String category = clonedCategory.getCategory();
		tblInvCategoryMap.put(category, clonedCategory);
		if(tblInvCategory.getCategory().equalsIgnoreCase(clonedCategory.getCategory()))
		{
				int index = clonedCategorys.indexOf(clonedCategory);					
				clonedCategorys.set(index, tblInvCategory);				
		}
		
	}
	
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	
   return clonedCategorys;	
   
    }
	@Override
    @Transactional
    public List<TblInvColor> getAllColor(TblInvColor tblInvColor)
    {	
	
	 List<TblInvColor> clonedColors =  new ArrayList<>();
		if((tblInvColorList.size()!=0))
		{
			clonedColors = tblInvColorList;
		}
		else
		{
			clonedColors = tblInvColorDAO.getAll();
			tblInvColorList = clonedColors;
		}
		try{
		for (TblInvColor clonedColor : clonedColors)
		{
			String color= clonedColor.getColor();
			tblInvColorMap.put(color, clonedColor);
			if(tblInvColor.getColor().equalsIgnoreCase(color))
			{
					int index = clonedColors.indexOf(clonedColor);					
					clonedColors.set(index, tblInvColor);
					break;
			}
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	   return clonedColors;	
	
    }
	@Override
    @Transactional
    public List<TblInvFocaltype> getAllFoculType(TblInvFocaltype tblInvFocaltype)
    {		
	
	    List<TblInvFocaltype> cloneFoculTypes =  new ArrayList<>();
		if((tblInvMaterialList.size()!=0))
		{
			cloneFoculTypes = tblInvFocaltypeList;
		}
		else
		{
			cloneFoculTypes = tblInvFocaltypeDAO.getAll();
			tblInvFocaltypeList = cloneFoculTypes;
		}
		try{
		for (TblInvFocaltype cloneFoculType : cloneFoculTypes)
		{
			String FoculType = cloneFoculType.getFocalType();
			tblInvFocaltypeMap.put(FoculType, cloneFoculType);
			
			if(tblInvFocaltype.getFocalType().equalsIgnoreCase(FoculType))
			{
					int index = cloneFoculTypes.indexOf(cloneFoculType);					
					cloneFoculTypes.set(index, tblInvFocaltype);
					break;
			}
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	   return cloneFoculTypes;	
	
    }
	
	
	@Override
    @Transactional
    public List<TblInvFrameMetadata> getAllFrameMetaData()
    {
		if((tblInvFrameMetadataList.size()!=0))
		{
		return tblInvFrameMetadataList;		
		}
		tblInvFrameMetadataList = frameMetadataDAO.getAll();
		
	return tblInvFrameMetadataList;
	
	 /*List<TblInvFrameMetadata> clonedFrameMetaDataList =  new ArrayList<>();
		if((tblInvMaterialList.size()!=0))
		{
			clonedFrameMetaDataList = tblInvFrameMetadataList;
		}
		else
		{
			clonedFrameMetaDataList = frameMetadataDAO.getAll();
			tblInvFrameMetadataList = clonedFrameMetaDataList;
		}
		
		for (TblInvFrameMetadata cloneFrameMetaData : clonedFrameMetaDataList)
		{
			if(tblInvFrameMetadata.getme.equalsIgnoreCase(cloneFrameMetaData.getGender()))
			{
					int index = clonedGenders.indexOf(clonedGender);					
					clonedGenders.set(index, tblInvFrameMetadata);
					break;
			}
		}
		
	   return clonedGenders;*/ 
	
	
    }
	
	
	@Override
    @Transactional
    public List<TblInvGender> getAllGender(TblInvGender tblInvGender)
    {
		
	 List<TblInvGender> clonedGenders =  new ArrayList<>();
	if((tblInvGenderList.size()!=0))
	{
		clonedGenders = tblInvGenderList;
	}
	else
	{
		clonedGenders = tblInvGenderDAO.getAll();
		tblInvGenderList = clonedGenders;
	}
	try{
	for (TblInvGender clonedGender : clonedGenders)
	{
		String gender = clonedGender.getGender();
		tblInvGenderMap.put(gender, clonedGender);
		if(tblInvGender.getGender().equalsIgnoreCase(gender))
		{
				int index = clonedGenders.indexOf(clonedGender);					
				clonedGenders.set(index, tblInvGender);
				break;
		}
	}
  
	}catch (Exception e) {
		// TODO: handle exception
	}
	
	 return clonedGenders;	
	
    }
	
	@Override
    @Transactional
    public List<TblInvMaterial> getAllMaterial(TblInvMaterial tblInvMaterial)
    {
		
	List<TblInvMaterial> clonedMaterials =  new ArrayList<>();
	if((tblInvMaterialList.size()!=0))
	{
		clonedMaterials = tblInvMaterialList;
	}
	else
	{
		clonedMaterials = tblInvMaterialDAO.getAll();
		tblInvMaterialList = clonedMaterials;
	}
	try{
	for (TblInvMaterial clonedMaterial : clonedMaterials)
	{
			String material = clonedMaterial.getMaterial();
			tblInvMaterialMap.put(material, clonedMaterial);
		if(tblInvMaterial.getMaterial().equalsIgnoreCase(material))
		{
			    int index = clonedMaterials.indexOf(clonedMaterial);					
				clonedMaterials.set(index, tblInvMaterial);
				break;
		}
	}
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	
   return clonedMaterials;	
	
    }
	@Override
    @Transactional
    public List<TblInvShape> getAllShape(TblInvShape shape)
    {
		
		List<TblInvShape> clonedShapes =  new ArrayList<>();
		if((tblInvShapeList.size()!=0))
		{
			clonedShapes = tblInvShapeList;
		}
		else
		{
		clonedShapes = tblInvShapeDAO.getAll();
		tblInvShapeList = clonedShapes;
		}
		try{
		for (TblInvShape clonedShape : clonedShapes)
		{
			String shape1 = clonedShape.getShape();
			tblInvShapeMap.put(shape1, clonedShape);
			if(shape.getShape().equalsIgnoreCase(shape1))
			{
					int index = clonedShapes.indexOf(clonedShape);					
					clonedShapes.set(index, shape);
					break;
			}
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	return clonedShapes;	
    }
	
	@Override
    @Transactional
	public List<TblUser> getAllUser() {
		
		return tblUserDAO.getAll();
	}
	
	
	@Override
    @Transactional
    public void save(TblInvFrameMetadata frameMetaData)
    {
		frameMetadataDAO.saveOrUpdate(frameMetaData);
    }
	
	@Override
    @Transactional
    public void saveDistFrame(TblInvDistFrame tblInvDistFrame)
    {
		tblInvDistFrameDAO.saveOrUpdate(tblInvDistFrame);
    }
	
	@Override
    @Transactional
    public void removeDistFrame(int userId, int frameMetaDataId)
    {
		tblInvDistFrameDAO.removeDistFrame(userId, frameMetaDataId);
    }
	
	@Override
    @Transactional
    public void remove(TblInvFrameMetadata frameMetaData)
    {
		frameMetadataDAO.remove(frameMetaData);
    }	
	
	@Override
	@Transactional
	public List<TblUser> listofDistributors()
	{
				
		return this.tblUserDAO.getAll();
				
	} 
	@Override
	@Transactional
	public List<TblInvDistFrame> listOfDistFrameByFrameMetadata(TblInvFrameMetadata frameMetaData) {
		
	return tblInvDistFrameDAO.getFrameDistListByFrameMetaDAta(frameMetaData);
	}
	@Override
	@Transactional
	public List<TblInvDistFrame> getFrameDistListByUser(TblUser user){
		return tblInvDistFrameDAO.getFrameDistListByUser(user);
	}
	

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		 ac = applicationContext;
	}

	public TblInvFrameMetadataDAO getFrameMetadataDAO() {
		return frameMetadataDAO;
	}

	public void setFrameMetadataDAO(TblInvFrameMetadataDAO frameMetadataDAO) {
		this.frameMetadataDAO = frameMetadataDAO;
	}

	public TblInvBrandDAO getTblInvBrandDAO() {
		return tblInvBrandDAO;
	}

	public void setTblInvBrandDAO(TblInvBrandDAO tblInvBrandDAO) {
		this.tblInvBrandDAO = tblInvBrandDAO;
	}

	public TblInvCategoryDAO getTblInvCategoryDAO() {
		return tblInvCategoryDAO;
	}

	public void setTblInvCategoryDAO(TblInvCategoryDAO tblInvCategoryDAO) {
		this.tblInvCategoryDAO = tblInvCategoryDAO;
	}

	public TblInvColorDAO getTblInvColorDAO() {
		return tblInvColorDAO;
	}

	public void setTblInvColorDAO(TblInvColorDAO tblInvColorDAO) {
		this.tblInvColorDAO = tblInvColorDAO;
	}

	public TblInvFocaltypeDAO getTblInvFocaltypeDAO() {
		return tblInvFocaltypeDAO;
	}

	public void setTblInvFocaltypeDAO(TblInvFocaltypeDAO tblInvFocaltypeDAO) {
		this.tblInvFocaltypeDAO = tblInvFocaltypeDAO;
	}

	public TblInvFrametypeDAO getTblInvFrametypeDAO() {
		return tblInvFrametypeDAO;
	}

	public void setTblInvFrametypeDAO(TblInvFrametypeDAO tblInvFrametypeDAO) {
		this.tblInvFrametypeDAO = tblInvFrametypeDAO;
	}

	public TblInvGenderDAO getTblInvGenderDAO() {
		return tblInvGenderDAO;
	}

	public void setTblInvGenderDAO(TblInvGenderDAO tblInvGenderDAO) {
		this.tblInvGenderDAO = tblInvGenderDAO;
	}

	public TblInvMaterialDAO getTblInvMaterialDAO() {
		return tblInvMaterialDAO;
	}

	public void setTblInvMaterialDAO(TblInvMaterialDAO tblInvMaterialDAO) {
		this.tblInvMaterialDAO = tblInvMaterialDAO;
	}
	
	public TblInvShapeDAO getTblInvShapeDAO() {
		return tblInvShapeDAO;
	}

	public void setTblInvShapeDAO(TblInvShapeDAO tblInvShapeDAO) {
		this.tblInvShapeDAO = tblInvShapeDAO;
	}

	public TblUserDAO getTblUserDAO() {
		return tblUserDAO;
	}

	public void setTblUserDAO(TblUserDAO tblUserDAO) {
		this.tblUserDAO = tblUserDAO;
	}

	public TblInvDistFrameDAO getTblInvDistFrameDAO() {
		return tblInvDistFrameDAO;
	}

	public void setTblInvDistFrameDAO(TblInvDistFrameDAO tblInvDistFrameDAO) {
		this.tblInvDistFrameDAO = tblInvDistFrameDAO;
	}

	

	
	

}
