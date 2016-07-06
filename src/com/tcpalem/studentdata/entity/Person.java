package com.tcpalem.studentdata.entity;

import java.util.Date;

/**
 * @since 17/06/2016
 * @author somaiah
 *
 */
public class Person {

	public int uuid;
	public String first_name;
	public String last_name;
	public String middle_name;
	public Date date_of_birth;
	public String mogified_by;
	public String created_by;
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getMogified_by() {
		return mogified_by;
	}
	public void setMogified_by(String mogified_by) {
		this.mogified_by = mogified_by;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	
}
