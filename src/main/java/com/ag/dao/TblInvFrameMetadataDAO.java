package com.ag.dao;

import java.util.List;

import com.ag.model.FrameType;
import com.ag.model.TblInvFrameMetadata;

public interface TblInvFrameMetadataDAO extends GenericDAO<TblInvFrameMetadata, String>{	

    public List<FrameType> listFrames();
    
    public List<TblInvFrameMetadata> listFrameMetadata();

}
