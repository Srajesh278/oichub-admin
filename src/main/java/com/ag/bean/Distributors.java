package com.ag.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.ag.model.TblInvDistFrame;
import com.ag.model.TblInvFrameMetadata;
import com.ag.model.TblUser;
import com.ag.service.TblInvFrameMetadataService;

@ManagedBean
@ViewScoped
public class Distributors implements ApplicationContextAware {

	TblInvFrameMetadataService tblInvFrameMetadataService;
	private DualListModel<String> metaDataFrames;
	List<String> sourceFramesList;
	List<String> TargetFramesList;
	Map<String, TblInvFrameMetadata> frameCheckMapTosave;
	TblInvDistFrame tblInvDistFrame;
	List<TblInvFrameMetadata> listofFrames;
	public static ApplicationContext ac;
	List<TblUser> tblUserList;
	TblUser tblUser;

	// private Map<String, TblInvFrameMetadata> framesMAp = new HashMap<>();

	// private String selectedFrame;

	int targetSize;
	// private Map<String, TblUser> TargetDistributorMap = new HashMap<>();

	@PostConstruct
	public void init() {

		sourceFramesList = new ArrayList<String>();
		TargetFramesList = new ArrayList<String>();
		frameCheckMapTosave = new HashMap<>();

		tblInvFrameMetadataService = (TblInvFrameMetadataService) ac.getBean("frameMetaDataService");
		// tblInvDistFrameList = tblInvFrameMetadataService.getAllDistFrames();
		tblUserList = tblInvFrameMetadataService.getAllUser();

		if (listofFrames == null) {
			listofFrames = tblInvFrameMetadataService.getAllFrameMetaData();
		}

		for (TblInvFrameMetadata frames : listofFrames) {
			sourceFramesList.add(frames.getModelNumber());
		}

		metaDataFrames = new DualListModel<String>(sourceFramesList, TargetFramesList);
	}

	public void targetListener(TblUser tblUser) {
		init();
		frameCheckMapTosave = new HashMap<>();
		this.tblUser = tblUser;

		List<TblInvDistFrame> distFrames = tblInvFrameMetadataService.getFrameDistListByUser(tblUser);

		if (distFrames == null) {
			return;
		}
		for (TblInvDistFrame distFrame : distFrames) {
			TblInvFrameMetadata metaDataFrame = distFrame.getTblInvFrameMetadata();

			if (metaDataFrame != null) {
				String modelNumber = metaDataFrame.getModelNumber();
				if (modelNumber != null) {
					if (sourceFramesList.contains(modelNumber)) {
						sourceFramesList.remove(modelNumber);

					}

					TargetFramesList.add(modelNumber);
					frameCheckMapTosave.put(modelNumber, metaDataFrame);

				}

			}

		}

	}

	public void save() {

		List<String> targetValues = metaDataFrames.getTarget();
		for (String frameModel : targetValues) {
			if (!frameCheckMapTosave.containsKey(frameModel)) {
				TblInvFrameMetadata tblInvFrameMetadata = tblInvFrameMetadataService.getFrameMetaData("modelNumber",
						frameModel);
				if (tblInvFrameMetadata != null) {
					TblInvDistFrame distFrame = new TblInvDistFrame();
					distFrame.setTblInvFrameMetadata(tblInvFrameMetadata);
					distFrame.setTblUser(tblUser);
					distFrame.setCreateDatetime(new Date());
					tblInvFrameMetadataService.saveDistFrame(distFrame);
					System.out.println("++++++++++++++++++++" + frameModel + "  added");
				}

			}

		}

		List<String> sourceValues = metaDataFrames.getSource();
		for (String frameModel : sourceValues) {
			if (frameCheckMapTosave.containsKey(frameModel)) {
				TblInvFrameMetadata tblInvFrameMetadata = frameCheckMapTosave.get(frameModel);
				if (tblInvFrameMetadata != null && tblUser != null)
					tblInvFrameMetadataService.removeDistFrame(tblUser.getId(), tblInvFrameMetadata.getId());
				System.out.println("++++++++++++++++++++" + frameModel + "  Removed");
			}

		}

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		ac = applicationContext;
	}

	public List<TblUser> getTblUserList() {
		return tblUserList;
	}

	public void setTblUserList(List<TblUser> tblUserList) {
		this.tblUserList = tblUserList;
	}

	public DualListModel<String> getMetaDataFrames() {
		return metaDataFrames;
	}

	public void setMetaDataFrames(DualListModel<String> metaDataFrames) {
		this.metaDataFrames = metaDataFrames;
	}

	public TblUser getTblUser() {
		return tblUser;
	}

	public void setTblUser(TblUser tblUser) {
		this.tblUser = tblUser;
	}

	public TblInvFrameMetadataService getTblInvFrameMetadataService() {
		return tblInvFrameMetadataService;
	}

	public void setTblInvFrameMetadataService(TblInvFrameMetadataService tblInvFrameMetadataService) {
		this.tblInvFrameMetadataService = tblInvFrameMetadataService;
	}

}