/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hft.stuttgart.service;

import de.hft.stuttgart.entities.Job;
import de.hft.stuttgart.persistence.JobPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stanislawfreund
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class JobService implements JobPersistence {

  @PersistenceContext(unitName = "jobcenterDS")
  private EntityManager em;
  private static final Logger LOGGER = Logger.getLogger(JobService.class.getName());

  @Override
  public List<Job> findJobsByKeywordAndLocation(String keyword, String location) {
    List<Job> jobs = null;
    try {
      jobs = (List<Job>) em.createNamedQuery("Job.findJobsByKeywordAndLocation").setParameter("keyword", keyword).setParameter("location", location).getResultList();
    } catch (NoResultException exeption) {
      Logger.getLogger(JobService.class.getName()).log(Level.INFO, null, exeption);

    }
    return jobs;
  }

}
