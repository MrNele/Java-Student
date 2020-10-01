/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.impl;

import action.AbstractAction;
import domain.Prijava;
import domain.Student;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import service.impl.ServicePrijavaImpl;
import service.impl.ServiceStudentImpl;
import servisi.ServicePrijava;
import servisi.ServiceStudent;

/**
 *
 * @author Nemanja
 */
public class PregledStudentaAction extends AbstractAction {
    private final ServiceStudent serviceStudent;
    private final ServicePrijava servicePrijava;
    
    public PregledStudentaAction() {
        serviceStudent=new ServiceStudentImpl();
        servicePrijava=new ServicePrijavaImpl();
    }

    @Override
    public void executeAction(HttpServletRequest request) throws Exception {
        String brojIndeksa = request.getParameter("brojIndeksa");
        Student student = serviceStudent.findByIndex(brojIndeksa);
        List<Prijava> prijave = servicePrijava.findByIndex(brojIndeksa);
        List<Prijava> polozenePrijave = new ArrayList();
        int brojESPB = 0;
        
        for (Prijava prijava : prijave) {
            if (prijava.getOcena()>5) {
            brojESPB = brojESPB + prijava.getPredmet().getBrojESPB();
            polozenePrijave.add(prijava);
            }
        }
        request.setAttribute("student", student);
        request.setAttribute("brojESPB", brojESPB);
        request.setAttribute("polozenePrijave", polozenePrijave);
    }
}
