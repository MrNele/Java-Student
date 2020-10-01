/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationcontroller;

import action.AbstractAction;
import action.impl.PregledStudentaAction;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nemanja
 */
public class ApplicationController {
    public String handleRequest(HttpServletRequest request) {
        String page = "/pages/welcome.jsp";
        String pathInfo = request.getPathInfo();

        if (pathInfo.equalsIgnoreCase("/prikaziStudenta")) {
            AbstractAction action = new PregledStudentaAction();
            try {
                action.executeAction(request);
                page = "/pages/welcome.jsp";
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                page = "/pages/error.jsp";
                request.setAttribute("error", ex.getMessage());
            }
        }
        return page;
    }
    
}
