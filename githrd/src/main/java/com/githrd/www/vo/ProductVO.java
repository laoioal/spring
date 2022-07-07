package com.githrd.www.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductVO {
	private int cno, pno, fno, cnt, step;
	private long price;
	private String cname, sdate, pname, summary, manuf_co, oname, sname, dir;
	private Date reldate;
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public void setSdate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");
		sdate = form.format(reldate);
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getManuf_co() {
		return manuf_co;
	}
	public void setManuf_co(String manuf_co) {
		this.manuf_co = manuf_co;
	}
	public Date getReldate() {
		return reldate;
	}
	public void setReldate(Date reldate) {
		this.reldate = reldate;
		setSdate();
	}
	@Override
	public String toString() {
		return "ProductVO [cno=" + cno + ", pno=" + pno + ", fno=" + fno + ", cnt=" + cnt + ", step=" + step
				+ ", price=" + price + ", cname=" + cname + ", sdate=" + sdate + ", pname=" + pname + ", summary="
				+ summary + ", manuf_co=" + manuf_co + ", oname=" + oname + ", sname=" + sname + ", dir=" + dir
				+ ", reldate=" + reldate + "]";
	}
}
