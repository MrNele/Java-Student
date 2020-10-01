/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servisi;

import domain.Student;

/**
 *
 * @author Nemanja
 */
public interface ServiceStudent {
    Student findByIndex(String brojIndeksa) throws Exception;
}
