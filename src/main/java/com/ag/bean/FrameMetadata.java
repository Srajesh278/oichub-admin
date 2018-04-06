package com.ag.bean;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.ag.model.TblInvBrand;
import com.ag.model.TblInvCategory;
import com.ag.model.TblInvColor;
import com.ag.model.TblInvFrameMetadata;
import com.ag.model.TblInvFrametype;
import com.ag.model.TblInvGender;
import com.ag.model.TblInvMaterial;
import com.ag.model.TblInvShape;
import com.ag.service.TblInvFrameMetadataService;
import com.fasterxml.uuid.Generators;


@Service
@ManagedBean(name="frameMetadata")
@ViewScoped
public class FrameMetadata implements ApplicationContextAware{	
		
	private TblInvFrameMetadataService frameMetaDataService;
	private TblInvFrameMetadata tblInvFrameMetadata; 
	public static ApplicationContext ac;
	private List<TblInvFrameMetadata> tblInvFrameMetadataList;
	
	private List<TblInvFrameMetadata> errorframesList;
	
	
	private List<String> errorString = new ArrayList<>();	
	
	private String brand;
	private String category;
	private String templecolor;
	private String framecolor;
	private String glasscolor;	
	private String frameMetadata;
	private String frametype;
	private String gender;
	private String framematerial;
	private String templematerial;
	private String shape;
	
	/** The view flag used to render panel properly **/
	private boolean viewForm;
	
	@PostConstruct
    private void init()  {		
		viewForm = true;
		frameMetaDataService = (TblInvFrameMetadataService) ac.getBean("frameMetaDataService");	
		tblInvFrameMetadataList = frameMetaDataService.getAllFrameMetaData();
		//errorframesList = new ArrayList<>();
		initializeObjects();
		
   }
	
	public void clearErrorFramesList()
	{
		errorframesList = new ArrayList<>();

	}
	
	
	/**
	 * Method used to initialize objects
	 */
	public void initializeObjects() {		
		viewForm = true;		
		tblInvFrameMetadata = new TblInvFrameMetadata();
		errorframesList = new ArrayList<>();
	}
	
	int r=1;
	XSSFCellStyle styleForColumn;
	XSSFWorkbook  writeWorkbook;
	boolean errorReport = false;
	boolean successReport = true;
	ExternalContext externalContext;
	FacesContext facesContext;
	public String uploadItem(FileUploadEvent event) throws IOException {
		//initiaion for download
		initializeObjects();
		setErrorReport(false);
		//FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext =  FacesContext.getCurrentInstance();
		//ExternalContext externalContext = facesContext.getExternalContext();
		externalContext =  facesContext.getExternalContext();
		ServletContext servletContext = (ServletContext) externalContext.getContext();
		InputStream ExcelFileToRead = new FileInputStream(
				servletContext.getRealPath("/") + "FrameTemplate.xlsx");
		writeWorkbook = new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet writeSheet = writeWorkbook.getSheetAt(0);	
		XSSFRow  rowForStyle = writeSheet.getRow(1);		
		styleForColumn=rowForStyle.getCell(0).getCellStyle();	
		XSSFRow writeRow = null;			
		writeRow = writeSheet.createRow(r);		
		
		//upload
		InputStream file =event.getFile().getInputstream();
		 XSSFWorkbook workbook = new XSSFWorkbook(file);          
         XSSFSheet sheet = workbook.getSheetAt(0);
         Iterator<Row> rowIterator = sheet.iterator();
         int emptyRow = 0;
         while (rowIterator.hasNext())
         {        	 
        	 XSSFRow row = (XSSFRow) rowIterator.next();               
             Iterator<Cell> cellIterator = row.cellIterator();
              if(row.getRowNum()>0)
              {
            	  tblInvFrameMetadata = new TblInvFrameMetadata();
            	  
            	
            	 TblInvFrameMetadata isframeMetaDataExist = frameMetaDataService.getFrameMetaData("lookzId" ,getCellValue(row.getCell(2)));
            	 if(isframeMetaDataExist!=null)
            	 {
            		 errorString.add("lookzId");
            	 }
            	  
            	  if(row.getCell(2).getStringCellValue() == null || row.getCell(2).getStringCellValue().equals(""))
	  				{
            		  emptyRow++;
            		  if(emptyRow>3){
            			  break;
            		  }
            		  continue;
	  				}
            	  emptyRow = 0;
            	  UUID uuid = Generators.timeBasedGenerator().generate();
     			 tblInvFrameMetadata.setUuid(uuid.toString());
            	  while (cellIterator.hasNext())
                  {
            		  Cell cell = cellIterator.next(); 
            		  System.out.println(cell.getCellType());
            		 int i = cell.getColumnIndex();
            		 
            		 switch(i)
            		 {
            		
            		 case 2:
            			 tblInvFrameMetadata.setLookzId(getCellValue(cell));
            			 break;
            		 case 3:
            			 tblInvFrameMetadata.setInternalId(getCellValue(cell));
            			 break;
            		 case 4:
            			 tblInvFrameMetadata.setModelNumber(getCellValue(cell));
            			 break;
            		 case 5:
            			 tblInvFrameMetadata.setProductName(getCellValue(cell));
            			 break;
            		 case 6:
            			 TblInvCategory category = frameMetaDataService.getCategory(getCellValue(cell));
            			 tblInvFrameMetadata.setTblInvCategory(category != null ? category : new TblInvCategory());
            			 if(category != null)
            			 {
            			 	 tblInvFrameMetadata.setTblInvCategory(category);
            			 }
            			 else
            			 {
            				 TblInvCategory value = new TblInvCategory();
            				 value.setCategory(getCellValue(cell));
            				 tblInvFrameMetadata.setTblInvCategory(value);
            				 errorString.add("category");
            			 }
            			  break;
            		 case 7:
            			 TblInvFrametype frameType = frameMetaDataService.getFrameType(getCellValue(cell));
            			 if(frameType != null)
            			 {
            			 	 tblInvFrameMetadata.setTblInvFrametype(frameType);
            			 }
            			 else
            			 {
            				 TblInvFrametype value = new TblInvFrametype();
            				 value.setFrametype(getCellValue(cell));
            				 tblInvFrameMetadata.setTblInvFrametype(value);
            				 errorString.add("frameType");
            			 }
            			 break;
            		 case 8:
            			 TblInvBrand brand = frameMetaDataService.getBrand(getCellValue(cell));
            			 if(brand != null)
            			 {
            			 	 tblInvFrameMetadata.setTblInvBrand(brand);
            			 }
            			 else
            			 {
            				 TblInvBrand value = new TblInvBrand();
            				 value.setBrand(getCellValue(cell));
            				 tblInvFrameMetadata.setTblInvBrand(value);
            				 errorString.add("brand");
            			 }
            			 break;
            		 case 9:
            			 TblInvShape shape = frameMetaDataService.getShape(getCellValue(cell));
            			 if(shape != null)
            			 {
            			 	 tblInvFrameMetadata.setTblInvShape(shape);
            			 }
            			 else
            			 {
            				 TblInvShape value = new TblInvShape();
            				 value.setShape(getCellValue(cell));
            				 tblInvFrameMetadata.setTblInvShape(value);
            				 errorString.add("shape");
            			 }
            			 break;
            			 
            		 case 10:
            			 TblInvColor frameColor = frameMetaDataService.getColor(getCellValue(cell));
            			               			 
            			 if(frameColor != null)
            			 {
            			 	 tblInvFrameMetadata.setTblInvColorByFrameColorId(frameColor);
            			 }
            			 else
            			 {
            				 TblInvColor value =  new TblInvColor();
            				 value.setColor(getCellValue(cell));
            				 tblInvFrameMetadata.setTblInvColorByFrameColorId(value);
            				 errorString.add("frameColor");
                			 tblInvFrameMetadata.setDisplayFramecolorText(getCellValue(cell));
            			 }
            			 
            			 break;
            		 case 11:
            			 TblInvColor templeColor = frameMetaDataService.getColor(getCellValue(cell));
            			           			 
            			 if(templeColor != null)
            			 {
            			 	 tblInvFrameMetadata.setTblInvColorByTempleColorId(templeColor);
            			 }
            			 else
            			 {
            				 TblInvColor value =  new TblInvColor();
            				 value.setColor(getCellValue(cell));
            				 tblInvFrameMetadata.setTblInvColorByTempleColorId(value);
            				 errorString.add("templeColor");
                			 tblInvFrameMetadata.setDisplayTemplecolorText(getCellValue(cell));
            			 }
            			 break;
            		 case 12:
            			 TblInvColor glassColor = frameMetaDataService.getColor(getCellValue(cell));
            			
            			 
            			 if(glassColor != null)
            			 {
            			 	 tblInvFrameMetadata.setTblInvColorByGlassColorId(glassColor);
            			 }
            			 else
            			 {
            				 TblInvColor value =  new TblInvColor();
            				 value.setColor(getCellValue(cell));
            				 tblInvFrameMetadata.setTblInvColorByGlassColorId(value);
            				 errorString.add("glassColor");
                			 tblInvFrameMetadata.setDisplayGlasscolorText(getCellValue(cell));
            			 }
            			 
            			 
            			 break;
            		 case 13:            			 
            			 TblInvMaterial frameMaterial = frameMetaDataService.getMaterial(getCellValue(cell));
            			 if(frameMaterial != null)
            			 {
            			 	 tblInvFrameMetadata.setTblInvMaterialByFrameMaterialId(frameMaterial);
            			 }
            			 else
            			 {
            				 TblInvMaterial value =  new TblInvMaterial();
            				 value.setMaterial(getCellValue(cell));
            				 tblInvFrameMetadata.setTblInvMaterialByFrameMaterialId(value);
            				 errorString.add("frameMaterial"); 
            			 }
            			 break;
            		 case 14:
            			 TblInvMaterial templeMaterial = frameMetaDataService.getMaterial(getCellValue(cell));
            			 tblInvFrameMetadata.setTblInvMaterialByTempleMaterialId(templeMaterial != null ? templeMaterial : new TblInvMaterial());
            			 if(templeMaterial != null)
            			 {
            			 	 tblInvFrameMetadata.setTblInvMaterialByTempleMaterialId(templeMaterial);
            			 }
            			 else
            			 {
            				 TblInvMaterial value =  new TblInvMaterial();
            				 value.setMaterial(getCellValue(cell));
            				 tblInvFrameMetadata.setTblInvMaterialByTempleMaterialId(value);
            				 errorString.add("templeMaterial"); 
            			 }
            			 
            			 break;
            		 case 15:
            			 tblInvFrameMetadata.setMaterialReflection(getCellValue(cell));
            			 break;
            		 case 16:
            			 TblInvGender gender = frameMetaDataService.getGender(getCellValue(cell));
            			 if(gender != null)
            			 {
            			 tblInvFrameMetadata.setTblInvGender(gender);
            			 }
            			 else
            			 {
            				 TblInvGender value = new TblInvGender();
            				 value.setGender(getCellValue(cell));
            				 tblInvFrameMetadata.setTblInvGender(value);
            				 errorString.add("gender"); 
            			 }
            			 break;
            		 case 17:
            			 tblInvFrameMetadata.setDescription(getCellValue(cell));
            			 break;
            		 case 18:
            			try{ tblInvFrameMetadata.setPrice(getNumberCellValue(cell));}catch (Exception e) {
            				
						}
            			 break;
            		 case 19:
            			 tblInvFrameMetadata.setPriceUnit(getCellValue(cell));
            			 break;
            		 case 20:
            			 tblInvFrameMetadata.setSize(getCellValue(cell));
            			 break;
            		 case 21:
            			 tblInvFrameMetadata.setSizeActual(getCellValue(cell));
            			 break;
            		 case 22:
            			 tblInvFrameMetadata.setWeight(getCellValue(cell));
            			 break;
            		 case 23:
            			try{ tblInvFrameMetadata.setWeightActualGrams(getNumberCellValue(cell));}
            			catch (Exception e) {
						}
            			 break;
            		 case 24:
            			 break;
            		 case 25:
            			 tblInvFrameMetadata.setImagePath(getCellValue(cell));
            			 break;            			 
            		 }
            		  
                  }
            	  tblInvFrameMetadata.setIsDeleted((byte)0);
            	  tblInvFrameMetadata.setCreateDatetime(new Date());
            	  
            	  if(errorString.size() > 0)
            	  {
            		  writeRow = writeSheet.createRow(r);
            		  writeExcelFile(tblInvFrameMetadata, writeRow, row);
            		  r++;
            	  }
            	  else
            	  {
            	  frameMetaDataService.save(tblInvFrameMetadata);
        		  tblInvFrameMetadataList.add(tblInvFrameMetadata);
            	  }
              }
                            
         }        
             
         r = 1;         
		return null;		
	}	

		public String getDownload()
		{
					try{
						r = 1;
				    externalContext.setResponseContentType("application/vnd.ms-excel");
				    externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"ErrorRows.xlsx\"");
				    writeWorkbook.write(externalContext.getResponseOutputStream());
				    facesContext.responseComplete();
				    
					}
					catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				    return null;
		}
	
	
	 public void writeExcelFile(TblInvFrameMetadata tblInvFrameMetadata, XSSFRow row, XSSFRow errorRow) throws IOException {
		        		        
		 		errorframesList.add(tblInvFrameMetadata);
		 		setErrorReport(true);
				int col =2;			
				XSSFCell cell = null;							
				
				cell = row.createCell(col); if(errorString.contains("lookzId")) {cell.setCellStyle(styleForColumn);} cell.setCellValue(tblInvFrameMetadata.getLookzId());col++;
				cell = row.createCell(col); cell.setCellValue(tblInvFrameMetadata.getInternalId());col++;
				cell = row.createCell(col); cell.setCellValue(tblInvFrameMetadata.getModelNumber());col++;
				cell = row.createCell(col); cell.setCellValue(tblInvFrameMetadata.getProductName());col++;
				cell = row.createCell(col);  if(errorString.contains("category")){cell.setCellStyle(styleForColumn);}cell.setCellValue(tblInvFrameMetadata.getTblInvCategory().getCategory());col++;
				cell = row.createCell(col);  if(errorString.contains("frameType")){cell.setCellStyle(styleForColumn);}cell.setCellValue(tblInvFrameMetadata.getTblInvFrametype().getFrametype());col++;
				cell = row.createCell(col); if(errorString.contains("brand")){cell.setCellStyle(styleForColumn);} cell.setCellValue(tblInvFrameMetadata.getTblInvBrand().getBrand());col++;
				cell = row.createCell(col); if(errorString.contains("shape")){cell.setCellStyle(styleForColumn);} cell.setCellValue(tblInvFrameMetadata.getTblInvShape().getShape());col++;
				cell = row.createCell(col); if(errorString.contains("frameColor")){cell.setCellStyle(styleForColumn);} cell.setCellValue(tblInvFrameMetadata.getTblInvColorByFrameColorId().getColor());col++;
				cell = row.createCell(col); if(errorString.contains("templeColor")){cell.setCellStyle(styleForColumn);} cell.setCellValue(tblInvFrameMetadata.getTblInvColorByTempleColorId().getColor());col++;
				cell = row.createCell(col); if(errorString.contains("glassColor")){cell.setCellStyle(styleForColumn);} cell.setCellValue(tblInvFrameMetadata.getTblInvColorByGlassColorId().getColor());col++;
				cell = row.createCell(col); if(errorString.contains("frameMaterial")){cell.setCellStyle(styleForColumn);} cell.setCellValue(tblInvFrameMetadata.getTblInvMaterialByFrameMaterialId().getMaterial());col++;
				cell = row.createCell(col); if(errorString.contains("templeMaterial")){cell.setCellStyle(styleForColumn);} cell.setCellValue(tblInvFrameMetadata.getTblInvMaterialByTempleMaterialId().getMaterial());col++;
				cell = row.createCell(col);  cell.setCellValue(tblInvFrameMetadata.getMaterialReflection());col++;
				cell = row.createCell(col); if(errorString.contains("gender")){cell.setCellStyle(styleForColumn);} cell.setCellValue(tblInvFrameMetadata.getTblInvGender().getGender());col++;
				cell = row.createCell(col); cell.setCellValue(tblInvFrameMetadata.getDescription());col++;
				try{cell = row.createCell(col); cell.setCellValue(getNumberCellValue(errorRow.getCell(col)));col++;}catch (Exception e) {
					// TODO: handle exception
					col++;
				}
				cell = row.createCell(col); cell.setCellValue(tblInvFrameMetadata.getPriceUnit());col++;
				cell = row.createCell(col); cell.setCellValue(tblInvFrameMetadata.getSize());col++;
				cell = row.createCell(col); cell.setCellValue(tblInvFrameMetadata.getSizeActual());col++;
				cell = row.createCell(col); cell.setCellValue(tblInvFrameMetadata.getWeight());col++;
				try{cell = row.createCell(col); cell.setCellValue(getNumberCellValue(errorRow.getCell(col)));col++;}catch (Exception e) {
					// TODO: handle exception
					col++;
				}
				cell = row.createCell(col); cell.setCellValue("");col++;
				cell = row.createCell(col); cell.setCellValue(getCellValue(errorRow.getCell(col)));col++;
				
				errorString = new ArrayList<>();
		   
		}	 
	 
	
	public String getCellValue(Cell cell)
	{
		if(cell != null)
		{
		cell.setCellType(1);;
		return cell.getStringCellValue();
		}
		return "";
	}
	public Integer getNumberCellValue(Cell cell)
	{
		//int i = (int) cell.getNumericCellValue();
		
		return (int) cell.getNumericCellValue();
	}
	public void edit()
	{		
		edit(new TblInvFrameMetadata());		
	}	
	public void edit(TblInvFrameMetadata tblInvFrameMetadata)
	{		
		viewForm = false;		
		
		if(tblInvFrameMetadata !=null)
		{
		brand = tblInvFrameMetadata.getTblInvBrand() != null? tblInvFrameMetadata.getTblInvBrand().getBrand() : "";		
		category = tblInvFrameMetadata.getTblInvCategory() != null ?  tblInvFrameMetadata.getTblInvCategory().getCategory() : "";
		templecolor = tblInvFrameMetadata.getTblInvColorByTempleColorId() != null ? tblInvFrameMetadata.getTblInvColorByTempleColorId().getColor() : "";
		framecolor = tblInvFrameMetadata.getTblInvColorByFrameColorId() != null ? tblInvFrameMetadata.getTblInvColorByFrameColorId().getColor() : "";
		glasscolor = tblInvFrameMetadata.getTblInvColorByGlassColorId() != null ? tblInvFrameMetadata.getTblInvColorByGlassColorId().getColor() : "";
		frametype = tblInvFrameMetadata.getTblInvFrametype() != null ? tblInvFrameMetadata.getTblInvFrametype().getFrametype() : "";
		gender = tblInvFrameMetadata.getTblInvGender() != null ? tblInvFrameMetadata.getTblInvGender().getGender() : "";
		framematerial = tblInvFrameMetadata.getTblInvMaterialByFrameMaterialId() != null ?  tblInvFrameMetadata.getTblInvMaterialByFrameMaterialId().getMaterial() : ""; 
		templematerial = tblInvFrameMetadata.getTblInvMaterialByTempleMaterialId() != null ? tblInvFrameMetadata.getTblInvMaterialByTempleMaterialId().getMaterial() : "";
		shape = tblInvFrameMetadata.getTblInvShape() != null ? tblInvFrameMetadata.getTblInvShape().getShape() : ""; 
		}		
		setTblInvFrameMetadata(tblInvFrameMetadata);		
	}	
	
	public List<TblInvFrameMetadata> getErrorframesList() {
		return errorframesList;
	}

	public void setErrorframesList(List<TblInvFrameMetadata> errorframesList) {
		this.errorframesList = errorframesList;
	}

	public void create()
	{   
		viewForm = false;
		setTblInvFrameMetadata(new TblInvFrameMetadata());
	}
	
	public void save()
	{	  setObjectsToMetaData();
	      UUID uuid = Generators.timeBasedGenerator().generate();
	      tblInvFrameMetadata.setUuid(uuid.toString());
	      tblInvFrameMetadata.setIsDeleted((byte)0);
	      tblInvFrameMetadata.setCreateDatetime(new Date());
		  frameMetaDataService.save(tblInvFrameMetadata);
		  tblInvFrameMetadataList.add(tblInvFrameMetadata);
		  tblInvFrameMetadata.setIsDeleted((byte)0);
    	  tblInvFrameMetadata.setCreateDatetime(new Date());
    	  viewForm = true;
	}
	
	public void update()
	{   setObjectsToMetaData();
	    tblInvFrameMetadata.setIsDeleted((byte)0);
	    tblInvFrameMetadata.setUpdateDatetime(new Date());
		frameMetaDataService.save(tblInvFrameMetadata);
		viewForm = true;
	}	
	public void setObjectsToMetaData()
	{	
		tblInvFrameMetadata.setTblInvBrand(frameMetaDataService.getBrand(brand));
		tblInvFrameMetadata.setTblInvCategory(frameMetaDataService.getCategory(category));
		tblInvFrameMetadata.setTblInvColorByTempleColorId(frameMetaDataService.getColor(templecolor));
		tblInvFrameMetadata.setTblInvColorByGlassColorId(frameMetaDataService.getColor(glasscolor));
		tblInvFrameMetadata.setTblInvColorByFrameColorId(frameMetaDataService.getColor(framecolor));
		tblInvFrameMetadata.setTblInvFrametype(frameMetaDataService.getFrameType(frametype));
		tblInvFrameMetadata.setTblInvGender(frameMetaDataService.getGender(gender));
		tblInvFrameMetadata.setTblInvMaterialByFrameMaterialId(frameMetaDataService.getMaterial(framematerial));
		tblInvFrameMetadata.setTblInvMaterialByTempleMaterialId(frameMetaDataService.getMaterial(templematerial));
		tblInvFrameMetadata.setTblInvShape(frameMetaDataService.getShape(shape));		
	}
	
	public void remove(TblInvFrameMetadata tblInvFrameMetadata)
	{		
		frameMetaDataService.remove(tblInvFrameMetadata.getTblInvFrameMetadata());
		tblInvFrameMetadataList.remove(tblInvFrameMetadata);
	}
	
	/**
	 * Description of the method cancelAction.
	 */
	public void cancelAction() {
		initializeObjects();
		tblInvFrameMetadata=new TblInvFrameMetadata();
	}	
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		 ac = applicationContext;
	}

	public TblInvFrameMetadataService getFrameMetaDataService() {
		return frameMetaDataService;
	}

	public void setFrameMetaDataService(TblInvFrameMetadataService frameMetaDataService) {
		this.frameMetaDataService = frameMetaDataService;
	}

	public TblInvFrameMetadata getTblInvFrameMetadata() {
		return tblInvFrameMetadata;
	}

	public void setTblInvFrameMetadata(TblInvFrameMetadata tblInvFrameMetadata) {
		this.tblInvFrameMetadata = tblInvFrameMetadata;		
		
	}

	public List<TblInvFrameMetadata> getTblInvFrameMetadataList() {
		return tblInvFrameMetadataList;
	}

	public void setTblInvFrameMetadataList(List<TblInvFrameMetadata> tblInvFrameMetadataList) {
		this.tblInvFrameMetadataList = tblInvFrameMetadataList;
	}

	public boolean isViewForm() {
		return viewForm;
	}

	public void setViewForm(boolean viewForm) {
		this.viewForm = viewForm;
	}

	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	public String getFrameMetadata() {
		return frameMetadata;
	}

	public void setFrameMetadata(String frameMetadata) {
		this.frameMetadata = frameMetadata;
		
	}

	public String getFrametype() {
		return frametype;
	}

	public boolean isSuccessReport() {
		return successReport;
	}

	

	public boolean isErrorReport() {
		return errorReport;
	}

	public void setErrorReport(boolean errorReport) {
		this.errorReport = errorReport;
	}

	public void setFrametype(String frametype) {
		this.frametype = frametype;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getTemplecolor() {
		return templecolor;
	}

	public void setTemplecolor(String templecolor) {
		this.templecolor = templecolor;
	}

	public String getFramecolor() {
		return framecolor;
	}

	public void setFramecolor(String framecolor) {
		this.framecolor = framecolor;
	}

	public String getGlasscolor() {
		return glasscolor;
	}

	public void setGlasscolor(String glasscolor) {
		this.glasscolor = glasscolor;
	}

	public String getFramematerial() {
		return framematerial;
	}

	public void setFramematerial(String framematerial) {
		this.framematerial = framematerial;
	}

	public String getTemplematerial() {
		return templematerial;
	}

	public void setTemplematerial(String templematerial) {
		this.templematerial = templematerial;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
