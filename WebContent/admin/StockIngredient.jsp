<%@page import="model.StockIngredient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center">Etat de stock des ingrédients</h1>
<div class="container">
    <div class="row">
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