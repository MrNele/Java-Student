<%-- 
    Document   : welcome
    Created on : Jul 8, 2019, 4:49:05 PM
    Author     : Jelena
--%>

<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="domain.Prijava"%>
<%@page import="java.util.List"%>
<%@page import="domain.Predmet"%>
<%@page import="domain.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pocetna</title>
    </head>
    <body>
        <h1>Hello!</h1>
        <form action="../action/prikaziStudenta" method="POST">
            <%
                if (request.getAttribute("error") != null) {
            %>
            <div>
                error: <%= request.getAttribute("error").toString()%>
            </div>
            <%
                }
            %>

            <table border="0">
                <tbody>
                    <tr>
                        <td>Broj indeksa studenta:</td>
                        <td><input type="text" name="brojIndeksa" <% if(request.getParameter("brojIndeksa")!=null)%> value="<%= request.getParameter("brojIndeksa")%>" size="50" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Submit"/></td>
                    </tr>
                </tbody>
            </table>
            <%
                if (request.getParameter("brojIndeksa") != null) {
            %> 

            <table style="margin-top: 20px" border="1">
                <thead>
                    <tr>
                        <th>Broj indeksa</th>
                        <th>Ime</th>
                        <th>Prezime</th>
                        <th>Broj ESPB</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Student student = (Student) request.getAttribute("student");
                        int brojESPB = (Integer) request.getAttribute("brojESPB");
                    %>
                    <tr>
                        <td><%=student.getBrojIndeksa()%></td>
                        <td><%=student.getIme()%></td>
                        <td><%=student.getPrezime()%></td>
                        <td><%=brojESPB%></td>
                    </tr>
                </tbody> 
            </table>

            <table style="margin-top: 20px" border="1">
                <thead>
                    <tr>
                        <th>Redni broj</th>
                        <th>Naziv predmeta</th>
                        <th>Broj ESPB</th>
                        <th>Ocena</th>
                        <th>Datum</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int redniBroj = 0;
                        List<Prijava> polozenePrijave = (List<Prijava>) request.getAttribute("polozenePrijave");
                        for (Prijava prijava : polozenePrijave) {
                            redniBroj++;
                    %>
                    <tr>
                        <td><%=redniBroj%></td>
                        <td><%=prijava.getPredmet().getNaziv()%></td>
                        <td><%=prijava.getPredmet().getBrojESPB()%></td>
                        <td><%=prijava.getOcena()%></td>
                        <td><%
                            Date datum = prijava.getPrijavaPK().getDatum();
                            SimpleDateFormat sdf = new SimpleDateFormat();
                            String dateformat = "";
                            sdf.applyPattern("dd-MM-yyyy");
                            dateformat = sdf.format(datum);
                            %>
                            <%=dateformat%></td>
                    </tr>
                    <% } %>
                </tbody> 
            </table>
            <% }%>
        </form>
    </body>
</html>
