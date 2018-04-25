package com.ag.util;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;

import com.ag.model.TblInvFrameMetadata;

public class ParentLookzID {
	
	private TblInvFrameMetadata TblInvFrameMetadata;
	
	private List<String> errorFrameList;
	
	private XSSFRow errorRow;

	public TblInvFrameMetadata getTblInvFrameMetadata() {
		return TblInvFrameMetadata;
	}

	public void setTblInvFrameMetadata(TblInvFrameMetadata tblInvFrameMetadata) {
		TblInvFrameMetadata = tblInvFrameMetadata;
	}

	public List<String> getErrorFrameList() {
		return errorFrameList;
	}

	public void setErrorFrameList(List<String> errorFrameList) {
		this.errorFrameList = errorFrameList;
	}

	public XSSFRow getErrorRow() {
		return errorRow;
	}

	public void setErrorRow(XSSFRow errorRow) {
		this.errorRow = errorRow;
	}

}
