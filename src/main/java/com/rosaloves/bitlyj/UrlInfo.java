package com.rosaloves.bitlyj;

/**
 * 
 * $Id$
 * 
 * @author clewis Jul 17, 2010
 *
 */
public class UrlInfo {
	
	private final Url url;
	
	private final String createdBy;
	
	private final String title;

	UrlInfo(Url url, String createdBy, String title) {
		super();
		this.url = url;
		this.createdBy = createdBy;
		this.title = title;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getTitle() {
		return title;
	}

	public Url getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "Info [createdBy=" + createdBy + ", title=" + title + ", url="
				+ url + "]";
	}

}
