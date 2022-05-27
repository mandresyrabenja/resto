<%-- 
    Document   : additionnonpaye
    Created on : 11 avr. 2022, 14:49:24
    Author     : U
--%>

<%@page import="model.NonPaye"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Addition-non-paye</title>
    </head>
    <body>
        <h1 class="text-center">Additions non payés</h1>
        <div class="container">
            <div clas="row">
                 <div class="col-md-6 offset-3">
                     <table class="table table-bordered text-center">
                            <thead>
                                <tr>
                                    <th >IdCommande</th>
                                    <th>Somme</th>
                                     <th>Total</th>
                                     <th>Reste a payé</th>
                                </tr>
                            </thead>
                            <tbody>
                                 <% String key="nonPaye";
                                 if(request.getAttribute(key)!=null){
                                     NonPaye[] nonPayes=(NonPaye[])request.getAttribute(key);
                              for(int i=0;i<nonPayes.length;i++){
                                 %>
                                <tr>
                                    <td><%=nonPayes[i].getIdCommande() %></td>
                                    <td><%=nonPayes[i].getSomme()  %></td>
                                    <td><%=nonPayes[i].getTotal() %></td>
                                    <td><%=nonPayes[i].getResteAPaye() %></td>
                                    
                                </tr>
                                <% } } %>
                            </tbody>
                        </table>
                </div>
            </div>
        </div>
    </body>
</html>
