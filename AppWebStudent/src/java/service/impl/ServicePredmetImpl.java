/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Predmet;
import domain.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import servisi.ServicePredmet;

/**
 *
 * @author Nemanja
 */
public class ServicePredmetImpl implements ServicePredmet {

    @Override
    public Predmet findBySifra(String sifra) throws Exception {
        EntityManager entityManager = Persistence.createEntityManagerFactory("AppWebStudentPU")
                .createEntityManager();
        
        Predmet dbPredmet = entityManager.find(Predmet.class, sifra);
        
        if (dbPredmet == null) {
            entityManager.close();
            throw new Exception("Predmet ne postoji");
        }
        entityManager.close();
        return dbPredmet; 
    }
    
}
