<%@page import="model.ServeurPourBoire"%>
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