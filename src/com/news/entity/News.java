package com.news.entity;

import java.util.Date;

public class News {
	private int nid;
	private int ntid;
	private String title;
	private String aurthor;
	private Date createdate;
	private String content;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public int getNtid() {
		return ntid;
	}
	public void setNtid(int ntid) {
		this.ntid = ntid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAurthor() {
		return aurthor;
	}
	public void setAurthor(String aurthor) {
		this.aurthor = aurthor;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public News() {
		super();
	}
	
	
}
