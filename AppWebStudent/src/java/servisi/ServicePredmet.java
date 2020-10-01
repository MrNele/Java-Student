/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servisi;

import domain.Predmet;

/**
 *
 * @author Nemanja
 */
public interface ServicePredmet {
    Predmet findBySifra(String sifra) throws Exception;
}
