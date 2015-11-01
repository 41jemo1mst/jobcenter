/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hft.stuttgart.entities.persistence;

import de.hft.stuttgart.entities.Account;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author stanislawfreund
 */
public class PersistenceTest {

  EntityManagerFactory emf;
  EntityManager em;
  Account account;

  @Before
  public void setUp() {
    emf = Persistence.createEntityManagerFactory("test");
    em = emf.createEntityManager();
    account = new Account();
    em.getTransaction().begin();
  }

  @After
  public void tearDown() {
    em.close();
  }

  @Test
  public void testPersistance() {
    account.setName("Stanislaw");
    account.setAge(27);
    em.persist(account);
    em.getTransaction().commit();

  }

}
