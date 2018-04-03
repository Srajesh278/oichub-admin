package com.ag.dao;

import java.util.List;

import com.ag.model.TblInvDistFrame;
import com.ag.model.TblInvFrameMetadata;
import com.ag.model.TblUser;

public interface TblInvDistFrameDAO extends GenericDAO<TblInvDistFrame, String>{

	void removeDistFrame(int userId, int frameMetaDataId);

	List<TblInvDistFrame> getFrameDistListByFrameMetaDAta(TblInvFrameMetadata frameMetaData);


	List<TblInvDistFrame> getFrameDistListByUser(TblUser user);

}