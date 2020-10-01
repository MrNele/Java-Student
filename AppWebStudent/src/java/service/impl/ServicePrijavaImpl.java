/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Prijava;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import servisi.ServicePrijava;

/**
 *
 * @author Nemanja
 */
public class ServicePrijavaImpl implements ServicePrijava {

    @Override
    public List<Prijava> findByIndex(String brojIndeksa) throws Exception {
        EntityManager entityManager = Persistence.createEntityManagerFactory("AppWebStudentPU")
                .createEntityManager();
        
        List<Prijava> prijave = entityManager.createQuery("select p from Prijava p where p.prijavaPK.brojIndeksa = :p1")
                .setParameter("p1", brojIndeksa)
                .getResultList();
        
        if (prijave.isEmpty()) {
            entityManager.close();
            throw new Exception("Prijave za zadatog studenta ne postoje");
        }
        entityManager.close();
        return prijave; 
    }
    
}
