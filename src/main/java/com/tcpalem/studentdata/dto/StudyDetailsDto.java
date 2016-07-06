package com.tcpalem.studentdata.dto;

import java.util.Date;

/**
 * @since 17/06/2016
 * @author somaiah
 *
 */
public class StudyDetailsDto {

	public String uuid;
	public String personid;
	public String college_name;
	public String course;
	public String college_location;
	public String percentage_of_marks;
	public Date year_of_pass;
	public String created_by;
	public String modified_by;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getPersonid() {
		return personid;
	}
	public void setPersonid(String personid) {
		this.personid = personid;
	}
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCollege_location() {
		return college_location;
	}
	public void setCollege_location(String college_location) {
		this.college_location = college_location;
	}
	public String getPercentage_of_marks() {
		return percentage_of_marks;
	}
	public void setPercentage_of_marks(String percentage_of_marks) {
		this.percentage_of_marks = percentage_of_marks;
	}
	public Date getYear_of_pass() {
		return year_of_pass;
	}
	public void setYear_of_pass(Date year_of_pass) {
		this.year_of_pass = year_of_pass;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	
	
	
}
