<%-- 
    Document   : listePrixRevient
    Created on : 24 mars 2022, 14:29:36
    Author     : U
--%>

<%@page import="model.Plat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Prixderevient</title>
    </head>
    <style>
       
        table td{
            text-align: center;
        }
    </style>
    <body>
        <nav class="navbar navbar-light bg-light">
            <span class="navbar-brand mb-0 h1 ml-2">Restaurant</span>
        </nav>
        <h1 class="text-center">Prix de revient</h1>
        <div class="container">
            <div class="row">
                <div class="col-md-10 offset-1 ">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th scope="col" >#</th>
                                <th scope="col">Nom plat</th>
                                <th scope="col">Type Plat</th>
                                <th scope="col">Prix vente (Ar)</th>
                                <th scope="col">Prix revient (Ar)</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% Plat[] listePlatRevient=(Plat[])request.getAttribute("listePrixRevient");
                            for(int i=0;i<listePlatRevient.length;i++){
                            %>
                            <tr>
                                <td scope="row"><% if(i%2 ==0){ %>
                                    <img src="assets/img/ravitoto.jpg" class="img-fluid" alt="" width="100">
                                    <% } else if(i%3 ==0){ %>
                                    <img src="assets/img/resistance.jpg" class="img-fluid" alt="" width="100">
                                    <% }else{ %>
                                    <img src="assets/img/tsaramaso.jpg" class="img-fluid" alt="" width="100">
                                    <% }
                                    %>
                                </td>
                                <td> <%=listePlatRevient[i].getNomPlat() %></td>
                                <td><%=listePlatRevient[i].getNomTypePlat() %></td>
                                <td><%=(int)listePlatRevient[i].getPrixPlat() %></td>
                                <td><%=listePlatRevient[i].getPrixRevient() %></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
