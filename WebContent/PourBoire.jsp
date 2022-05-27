<%-- 
    Document   : PourBoire
    Created on : 28 mars 2022, 14:15:43
    Author     : U
--%>

<%@page import="model.ServeurPourBoire"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pour-Boire</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    </head>
   
    <body>
        <h1 class="text-center">Pour boire serveur</h1>
        <div class="container">
            <div class="row"> 
                <form action="PourboireServeur" method="GET">
                <div class="col-md-8 offset-2" style="display: flex;justify-content: space-around;">
                    <div class="input-group flex-nowrap">
                        <span class="input-group-text" id="addon-wrapping">Date debut :</span>
                        <input type="date" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping" name="date1" required>
                    </div>
                    <div style="width: 10%">

                    </div>
                    <div class="input-group flex-nowrap">
                        <span class="input-group-text" id="addon-wrapping">Date fin :</span>
                        <input type="date" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping" name="date2" required>
                          <button type="submit" class="btn btn-primary btn-sm" sytle> Voir</button>
                    </div>
                </div>
                    </form>
                    <div class="row mt-1">
                        <div class="col-md-4 offset-6">
                          
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-12">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Nom serveur</th>
                                    <th>Pour boire (Ar)</th>
                                </tr>
                            </thead>
                            <tbody>
                                 <% if(request.getAttribute("serveurPourBoire")!=null){
                                    ServeurPourBoire[] s=(ServeurPourBoire[])request.getAttribute("serveurPourBoire"); %>
                                 <% for(int i=0;i<s.length;i++){ %>
                                    <tr>
                                        <td><%= s[i].getNomServeur() %></td>
                                        <td><%= s[i].getSommePourBoire() %></td>
                                    </tr>
                                <% } }%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
