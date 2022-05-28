<%@page import="model.Plat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center">Prix de revient</h1>
<div class="container">
    <div class="row">
        <div class="col-md-10 offset-1 ">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col"></th>
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
                            <img src="assets/images/dish-1.png" class="img-fluid" alt="" width="100">
                            <% } else if(i%3 ==0){ %>
                            <img src="assets/images/dish-2.png" class="img-fluid" alt="" width="100">
                            <% }else{ %>
                            <img src="assets/images/dish-3.png" class="img-fluid" alt="" width="100">
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