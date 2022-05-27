<%-- 
    Document   : StockIngredient
    Created on : 5 avr. 2022, 11:06:09
    Author     : U
--%>

<%@page import="model.StockIngredient"%>
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
            
                <div class="row mt-3">
                    <div class="col-md-12">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Ingredients</th>
                                    <th>Quantite</th>
                                </tr>
                            </thead>
                            <tbody>
                               
                                 <% String key="resteStock";
                                     if(request.getAttribute(key)!=null){
                                         StockIngredient[] stock=(StockIngredient[])request.getAttribute(key);
                                  for(int i=0;i<stock.length;i++){ %>
                                    <tr>
                                        <td><%=stock[i].getNomIngredient() %></td>
                                        <td><%=stock[i].getQuantiteReste() %></td>
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
