/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hft.stuttgart.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author stanislawfreund
 */
@Entity
@NamedQueries({
  @NamedQuery(name = "Job.findJobsByKeywordAndLocation", query="SELECT jo FROM Job jo WHERE jo.title = :keyword AND jo.location = :location")
})
public class Job implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String title;

  private String description;

  private String field;

  private String location;

  private String position;

  private String minEducationLevel;

  private Integer minYearsOfExperience;

  private Double minSalary;

  private Double maxSalary;

  private LocalDate startDate;

  private LocalDate applicationDeadline;

  private LocalDate visibilityDeadline;

  private String jobType;

  private String keySkills;

  private String tags;

  private Integer timesOfVisit;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getMinEducationLevel() {
    return minEducationLevel;
  }

  public void setMinEducationLevel(String minEducationLevel) {
    this.minEducationLevel = minEducationLevel;
  }

  public Integer getMinYearsOfExperience() {
    return minYearsOfExperience;
  }

  public void setMinYearsOfExperience(Integer minYearsOfExperience) {
    this.minYearsOfExperience = minYearsOfExperience;
  }

  public Double getMinSalary() {
    return minSalary;
  }

  public void setMinSalary(Double minSalary) {
    this.minSalary = minSalary;
  }

  public Double getMaxSalary() {
    return maxSalary;
  }

  public void setMaxSalary(Double maxSalary) {
    this.maxSalary = maxSalary;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getApplicationDeadline() {
    return applicationDeadline;
  }

  public void setApplicationDeadline(LocalDate applicationDeadline) {
    this.applicationDeadline = applicationDeadline;
  }

  public LocalDate getVisibilityDeadline() {
    return visibilityDeadline;
  }

  public void setVisibilityDeadline(LocalDate visibilityDeadline) {
    this.visibilityDeadline = visibilityDeadline;
  }

  public String getJobType() {
    return jobType;
  }

  public void setJobType(String jobType) {
    this.jobType = jobType;
  }

  public String getKeySkills() {
    return keySkills;
  }

  public void setKeySkills(String keySkills) {
    this.keySkills = keySkills;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public Integer getTimesOfVisit() {
    return timesOfVisit;
  }

  public void setTimesOfVisit(Integer timesOfVisit) {
    this.timesOfVisit = timesOfVisit;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Job)) {
      return false;
    }
    Job other = (Job) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "de.hft.stuttgart.entities.Job[ id=" + id + " ]";
  }

}
