package com.ag.dao;

import java.util.List;


import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ag.model.FrameType;
import com.ag.model.TblInvFrameMetadata;

@Repository
public class TblInvFrameMetadataDAOImpl extends GenericDAOImpl<TblInvFrameMetadata, String> implements TblInvFrameMetadataDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(TblInvFrameMetadataDAOImpl.class);
	 
	@Autowired
    private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }   

	@Override
	public List<FrameType> listFrames() {
		// TODO Auto-generated method stub
        Session session = this.sessionFactory.getCurrentSession();
		 @SuppressWarnings("unchecked")
		List<FrameType> frameTypeList = session.createQuery("from com.journaldev.springhibernate.model.FrameType").list();
	        for(FrameType ft : frameTypeList){
	            logger.info("Frametype List::"+ft);
	            System.out.println("Frametype List::"+ft);
	        }
	        return frameTypeList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TblInvFrameMetadata> listFrameMetadata() {
        Session session = this.sessionFactory.getCurrentSession();
		List<TblInvFrameMetadata> frameMetaDataList =  session.createCriteria(TblInvFrameMetadata.class)
				.addOrder(Order.desc("createDatetime")).list();
		return frameMetaDataList;
	}

	
}
