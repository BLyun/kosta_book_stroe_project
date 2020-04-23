package kbs.mvc.model.domain;

import java.util.Date;

public class QnA {
	private int reviewNo;
	private Date regDt;
	private String qaContent;
	private String customerId;
	private int readNum;
	private String title;
	private String reply;
	
	
	
	public QnA() {	}
	
	
	public QnA(int reviewNo, Date regDt, String qaContent, String customerId, int readNum, String title) {
		super();
		this.reviewNo = reviewNo;
		this.regDt = regDt;
		this.qaContent = qaContent;
		this.customerId = customerId;
		this.readNum = readNum;
		this.title = title;
	}

	public QnA(int reviewNo, Date regDt, String qaContent, String customerId, int readNum, String title, String reply) {
		super();
		this.reviewNo = reviewNo;
		this.regDt = regDt;
		this.qaContent = qaContent;
		this.customerId = customerId;
		this.readNum = readNum;
		this.title = title;
		this.reply = reply;
	}




	public int getReviewNo() {
		return reviewNo;
	}



	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}



	public Date getRegDt() {
		return regDt;
	}



	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}



	public String getQaContent() {
		return qaContent;
	}



	public void setQaContent(String qaContent) {
		this.qaContent = qaContent;
	}



	public String getCustomerId() {
		return customerId;
	}



	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}



	public int getReadNum() {
		return readNum;
	}



	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getReply() {
		return reply;
	}



	public void setReply(String reply) {
		this.reply = reply;
	}
	
	
	
}
