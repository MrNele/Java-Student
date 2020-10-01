/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servisi;

import domain.Prijava;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public interface ServicePrijava {
   List<Prijava> findByIndex(String brojIndeksa) throws Exception;
}
