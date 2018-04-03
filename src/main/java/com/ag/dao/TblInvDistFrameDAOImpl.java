package com.ag.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.ag.model.TblInvDistFrame;
import com.ag.model.TblInvFrameMetadata;
import com.ag.model.TblUser;

public class TblInvDistFrameDAOImpl extends GenericDAOImpl<TblInvDistFrame, String> implements TblInvDistFrameDAO {
	
	@Override
   	@SuppressWarnings("unchecked")
   	public List<TblInvDistFrame> getFrameDistListByFrameMetaDAta(TblInvFrameMetadata frameMetaData) { 
   		Session session = currentSession();         
           
           
           Query hqlQuery = session.createQuery("from TblInvDistFrame y where y.tblInvFrameMetadata.id= ?");
   		List<TblInvDistFrame> distFrameList = hqlQuery.setLong(0,frameMetaData.getId()).list();
       
   		return distFrameList.size() > 0 ? distFrameList : null ;          
           
           
   	}
	
	@Override
   	@SuppressWarnings("unchecked")
   	public List<TblInvDistFrame> getFrameDistListByUser(TblUser user) { 
   		Session session = currentSession();         
           
           
           Query hqlQuery = session.createQuery("from TblInvDistFrame y where y.tblUser.id= ?");
   		List<TblInvDistFrame> distFrameList = hqlQuery.setLong(0,user.getId()).list();
       
   		return distFrameList.size() > 0 ? distFrameList : null ;          
           
           
   	}
  
	@Override
   	@SuppressWarnings("unchecked")
	public void removeDistFrame(int userId, int frameMetaDataId)
	{
		Session session = currentSession();
		session.createSQLQuery("SET FOREIGN_KEY_CHECKS=0").executeUpdate();
		Query q = session.createQuery("delete TblInvDistFrame y where y.tblUser.id ="+userId+" and y.tblInvFrameMetadata.id="+frameMetaDataId);
		q.executeUpdate();
		session.createSQLQuery("SET FOREIGN_KEY_CHECKS=1").executeUpdate();
	}
	
}
