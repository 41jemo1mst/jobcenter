/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hft.stuttgart.controller;

import de.hft.stuttgart.entities.Job;
import de.hft.stuttgart.persistence.JobPersistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author stanislawfreund
 */
@Named(value = "jobBean")
@SessionScoped
public class JobBean implements Serializable {

  @EJB
  private JobPersistence jobService;
  private List<Job> foundJobs;
  private String keyword;
  private String location;
  private static final Logger LOGGER = Logger.getLogger(JobBean.class.getName());

  @PostConstruct
  public void initialize() {
    foundJobs = new ArrayList<>();
  }

  public List<Job> getFoundJobs() {
    return foundJobs;
  }

  public void setFoundJobs(List<Job> foundJobs) {
    this.foundJobs = foundJobs;
  }

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    LOGGER.log(Level.INFO, "Keyword: {0}", keyword);
    this.keyword = keyword;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String findJobsByKeywordAndLocation() {
    foundJobs = jobService.findJobsByKeywordAndLocation(keyword, location);

    LOGGER.log(Level.INFO, "Keyword: {0} Location: {1}", new Object[]{keyword, location});
    for (Job job : foundJobs) {
      LOGGER.log(Level.INFO, "Title: {0} Location: {1}", new Object[]{job.getTitle(), job.getLocation()});
    }
    return "searchResults";
  }
}
