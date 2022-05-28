<%@page import="model.IngredientConsome"%>

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
                    <button type="submit" class="btn btn-primary btn-sm">
				        <i class="fas fa-search" id="search-icon"></i>
                    </button>
                </div>
            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Ingredients</th>
                        <th>Quantité</th>
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
