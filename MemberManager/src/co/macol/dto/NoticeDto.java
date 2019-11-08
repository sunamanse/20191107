package co.macol.dto;

import java.sql.Date;

public class NoticeDto {
	private int nId;
	private String nTitle;
	private String nCon;
	private Date nDate;
	private int nHit;
	
	public NoticeDto() {
		// TODO Auto-generated constructor stub
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnCon() {
		return nCon;
	}

	public void setnCon(String nCon) {
		this.nCon = nCon;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}

	public int getnHit() {
		return nHit;
	}

	public void setnHit(int nHit) {
		this.nHit = nHit;
	}
	
	
	
	
}
