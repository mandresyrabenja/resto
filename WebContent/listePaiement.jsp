<%-- 
    Document   : listePaiement
    Created on : 7 avr. 2022, 15:04:06
    Author     : U
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.DetailsPaiement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste-Paiement</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    </head>
    <body>
        <h1 class="text-center">Paiement</h1>
        <div class="container">
            <div class="row"> 
                <form action="DetailsPaiement" method="GET">
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
            <div class="row">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th scope="col">idCommande</th>
                            <th scope="col">Date</th>
                            <th scope="col">TypePaiement</th>
                            <th scope="col">Montant</th>

                        </tr>
                    </thead>
                    <tbody>
                        <% String key = "detailsPaiement";
                            DetailsPaiement[] espece = (DetailsPaiement[] )request.getAttribute("totalPaiementParType");
                            

                            if (request.getAttribute(key) != null) {
                                DetailsPaiement[] detailsPaiements = (DetailsPaiement[]) request.getAttribute(key);
                                Double total = (Double) request.getAttribute("totalPaiement");
                                for (int i = 0; i < detailsPaiements.length; i++) {
                        %>
                        <tr>
                            <td><%=detailsPaiements[i].getIdCommande()%></td>
                            <td><%
                                String pattern = "dd-MM-yyyy";
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                                String date = simpleDateFormat.format(detailsPaiements[i].getDatePaiement());
                                out.print(date);
                                %></td>
                            <td><%=detailsPaiements[i].getNomTypePaiement()%></td>
                            <td><%=detailsPaiements[i].getSommePaiement()%></td>
                        </tr>
                        
                        
                        <% 
                      
                          }
                        %>
                        <% for(int j=0;j<espece.length;j++){  %>
                        <tr>
                            <td class="scope" colspan="2"><%=espece[j].getNomTypePaiement() %> :</td>
                            <td ><%=espece[j].getSommePaiement() %></td>
                        </tr>
                        <% } %>
                        
                    </tbody>
                    <tfooter>
                        <td class="scope" colspan="2">Total : </td>
                        <td><%=total%></td>
                    </tfooter>
                    <% }%>
                </table>
            </div>
        </div>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
