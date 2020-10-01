/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Student;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import servisi.ServiceStudent;

/**
 *
 * @author Nemanja
 */
public class ServiceStudentImpl implements ServiceStudent {

    @Override
    public Student findByIndex(String brojIndeksa) throws Exception {
        EntityManager entityManager = Persistence.createEntityManagerFactory("AppWebStudentPU")
                .createEntityManager();
        Student dbStudent = entityManager.find(Student.class, brojIndeksa);
        
        if (dbStudent == null) {
            entityManager.close();
            throw new Exception("Student ne postoji");
        }
        entityManager.close();
        return dbStudent; 
    }
    
}
