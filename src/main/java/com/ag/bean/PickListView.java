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
@SessionScoped
public class PickListView implements ApplicationContextAware {

	TblInvFrameMetadataService tblInvFrameMetadataService;
	private DualListModel<String> distributors;
	List<String> sourceDistributorList;
	List<String> TargetDistributorList;
	Map<String, TblUser> distCheckMapTosave;
	TblInvFrameMetadata frameMetaMetaData;
	List<TblUser> listofDist;
	public static ApplicationContext ac;
	// private List<TblInvFrameMetadata> tblInvFrameMetadataList;

	private Map<String, TblInvFrameMetadata> framesMAp = new HashMap<>();

	private String selectedFrame;

	int targetSize;
	// private Map<String, TblUser> TargetDistributorMap = new HashMap<>();

	@PostConstruct
	public void init() {

		sourceDistributorList = new ArrayList<String>();
		TargetDistributorList = new ArrayList<String>();
		distCheckMapTosave = new HashMap<>();

		tblInvFrameMetadataService = (TblInvFrameMetadataService) ac.getBean("frameMetaDataService");
		// tblInvFrameMetadataList =
		// tblInvFrameMetadataService.getAllFrameMetaData();

		if (listofDist == null) {
			listofDist = tblInvFrameMetadataService.listofDistributors();
		}

		for (TblUser user : listofDist) {
			sourceDistributorList.add(user.getUsername());
		}

		distributors = new DualListModel<String>(sourceDistributorList, TargetDistributorList);
	}

	public void targetListener(TblInvFrameMetadata frameMetaMetaData) {
		init();
		distCheckMapTosave = new HashMap<>();
		this.frameMetaMetaData = frameMetaMetaData;

		List<TblInvDistFrame> distFrames = tblInvFrameMetadataService.listOfDistFrameByFrameMetadata(frameMetaMetaData);
		if (distFrames == null) {
			return;
		}
		for (TblInvDistFrame distFrame : distFrames) {
			TblUser distributor = distFrame.getTblUser();

			if (distributor != null) {
				String name = distributor.getUsername();
				if (name != null) {
					if (sourceDistributorList.contains(name)) {
						sourceDistributorList.remove(name);

					}

					TargetDistributorList.add(name);
					distCheckMapTosave.put(name, distributor);

				}

			}

		}

	}

	public void save() {

		List<String> targetValues = distributors.getTarget();
		for (String distname : targetValues) {
			if (!distCheckMapTosave.containsKey(distname)) {
				TblUser user = tblInvFrameMetadataService.getUser(distname);
				if (user != null) {
					TblInvDistFrame distFrame = new TblInvDistFrame();
					distFrame.setTblInvFrameMetadata(frameMetaMetaData);
					distFrame.setTblUser(user);
					distFrame.setCreateDatetime(new Date());
					tblInvFrameMetadataService.saveDistFrame(distFrame);
				}

			}

		}

		List<String> sourceValues = distributors.getSource();
		for (String distname : sourceValues) {
			if (distCheckMapTosave.containsKey(distname)) {
				TblUser user = distCheckMapTosave.get(distname);
				if (user != null && frameMetaMetaData != null)
					tblInvFrameMetadataService.removeDistFrame(user.getId(), frameMetaMetaData.getId());
			}

		}

	}

	public TblInvFrameMetadataService getTblInvFrameMetadataService() {
		return tblInvFrameMetadataService;
	}

	public void setTblInvFrameMetadataService(TblInvFrameMetadataService tblInvFrameMetadataService) {
		this.tblInvFrameMetadataService = tblInvFrameMetadataService;
	}

	public int getTargetSize() {
		return targetSize;
	}

	public void setTargetSize(int targetSize) {
		this.targetSize = targetSize;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		ac = applicationContext;
	}

	/*
	 * public List<TblInvFrameMetadata> getTblInvFrameMetadataList() { return
	 * tblInvFrameMetadataList; }
	 * 
	 * 
	 * public void setTblInvFrameMetadataList(List<TblInvFrameMetadata>
	 * tblInvFrameMetadataList) { this.tblInvFrameMetadataList =
	 * tblInvFrameMetadataList; }
	 */

	public String getSelectedFrame() {
		return selectedFrame;
	}

	public void setSelectedFrame(String selectedFrame) {
		this.selectedFrame = selectedFrame;
	}

	public Map<String, TblInvFrameMetadata> getFramesMAp() {
		return framesMAp;
	}

	public void setFramesMAp(Map<String, TblInvFrameMetadata> framesMAp) {
		this.framesMAp = framesMAp;
	}

	public DualListModel<String> getDistributors() {
		return distributors;
	}

	public void setDistributors(DualListModel<String> distributors) {
		this.distributors = distributors;
	}

	public TblInvFrameMetadata getFrameMetaMetaData() {
		return frameMetaMetaData;
	}

	public void setFrameMetaMetaData(TblInvFrameMetadata frameMetaMetaData) {
		this.frameMetaMetaData = frameMetaMetaData;
	}
}