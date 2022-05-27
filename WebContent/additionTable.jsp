<%-- 
    Document   : additionTable
    Created on : 31 mars 2022, 15:36:21
    Author     : U
--%>

<%@page import="model.Commande"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Addittion table</title>
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" >
    </head>
    <body>
        <h1 class="text-center">Addition table</h1>
        <div class="container">
            <div class="row">
                <div class="col-md-10">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th scope="col">Date Commande</th>
                                <th scope="col">Table</th>
                                <th scope="col">addtion</th>
                               
                            </tr>
                        </thead>
                        <tbody>
                            <% String key="addtionTable";
                                if(request.getAttribute(key)!=null){
                                
                                Commande[] listCommande=(Commande[])request.getAttribute(key);
                                    for(int i=0;i<listCommande.length;i++){
                            %>
                            <tr>
                                
                                <td><%=listCommande[i].getDateCommande() %></td>
                                <td><%=listCommande[i].getIdTable() %></td>
                                <td><%=listCommande[i].getAddition() %></td>
                            </tr>
                           <% } } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script  src="assets/js/jquery.js"></script>
        <script  src="assets/js/popper.js"></script>
        <script  src="assets/js/bootstrap.min.js"></script>
    </body>
</html>
