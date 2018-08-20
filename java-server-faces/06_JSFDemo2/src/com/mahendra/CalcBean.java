package com.mahendra;

import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.FacesEvent;

@ManagedBean
@RequestScoped
public class CalcBean {

	private Date dob;
	private Date exp;
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getExp() {
		return exp;
	}
	public void setExp(Date exp) {
		this.exp = exp;
	}
	
	public void calc(FacesEvent e) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dob);
		cal.add(Calendar.YEAR, 80);
		setExp(cal.getTime());
	}
}
