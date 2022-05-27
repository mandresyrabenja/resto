<%-- 
    Document   : PourBoire
    Created on : 28 mars 2022, 14:15:43
    Author     : U
--%>
<%@page import="model.IngredientConsome"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pour-Boire</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    </head>
   
    <body>
<h1 class="text-center mt-5 mb-2">Ingredients consommés</h1>
<div class="container">
    <div class="row"> 
        <form action="${pageContext.request.contextPath}/IngredientCosomeServlet" method="GET">
            <div class="col-md offset-3" style="display: flex;justify-content: space-between;">
                <div class="input-group flex-nowrap">
                    <span class="input-group-text" id="addon-wrapping">Date debut :</span>
                    <input type="date" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping" name="date1" required>
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
                        <th>Ingredients</th>
                        <th>Qte</th>
                         <th>Prix</th>
                    </tr>
                </thead>
                <tbody>
                    <% String key="ingredientConsome";
                    double tot = 0;
                        if(request.getAttribute(key)!=null){
                        IngredientConsome[] ingredientConsome=(IngredientConsome[])request.getAttribute(key);
                        tot = Double.valueOf(String.valueOf(request.getAttribute("sommeIngredientConsome")));
                                    for(int i=0;i<ingredientConsome.length;i++){
             %>
                    <tr>
                        <td><%=ingredientConsome[i].getNomIngredient()  %></td>
                        <td><%=ingredientConsome[i].getSommeConsommation() %></td>
                        <td><%=ingredientConsome[i].getPrix() %></td>
                    </tr>
                    <% } }%>
                </tbody>
            </table>
            Total : <%= tot  %>
        </div>
    </div>
</div>
</body>
</html>

