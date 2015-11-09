/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hft.stuttgart.persistence;

import de.hft.stuttgart.entities.Job;
import java.util.List;

/**
 *
 * @author stanislawfreund
 */
public interface JobPersistence {
  public List<Job> findJobsByKeywordAndLocation(String keyword, String location);
}
