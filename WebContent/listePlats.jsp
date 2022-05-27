<%-- 
    Document   : Menu
    Created on : 22 mars 2022, 10:19:43
    Author     : U
--%>

<%@page import="model.TypePlat"%>
<%@page import="model.Plat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>liste-plat</title>

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    </head>
    <body>
        <h1>
            <nav id="navbar_top" class="navbar navbar-expand-sm navbar-light bg-light">
                <a class="navbar-brand" href="#">Restaurant qqq</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Restaurant</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-primary" href="voirCommande.jsp">Voir-commande</a>
                        </li>

                    </ul>

                </div>
                <form class="form-inline" action="ListePlat">
                    <select name="idTypePlat" class="form-control">
                        <% TypePlat[] typeplat = (TypePlat[]) request.getAttribute("typePlat");
                            for (int i = 0; i < typeplat.length; i++) {
                        %>
                        <option value="<%=typeplat[i].getIdTypePlat() %>"><%=typeplat[i].getNomTypePlat()%></option>

                        <% } %>

                    </select>
                    <button class="btn btn-outline-success" type="submit">Filtrer</button>
                </form>
            </nav>
            <div class="container">
                <div class="row">
                    <% Plat[] listePlat = (Plat[]) request.getAttribute("listePlats");

                    %>
                    <% for (int j = 0; j < listePlat.length; j++) {%>
                    <div class="col-md-4 mt-4" id="plat" >
                        <form action="CommanderPlat" method="GET">
                           
                            <input type="hidden" name="prix" value="<%=listePlat[j].getPrixPlat()%>">
                            <input type="hidden" name="idPlat" value="<%=listePlat[j].getIdPlat() %>">
                        <div class="card" >
                            <% if(listePlat[j].getNomTypePlat().equalsIgnoreCase("Entrée")){ %>
                            <img class="card-img-top" src="assets/img/pizza.jpg" alt="Card image cap">
                           <% } %>
                            <% if(listePlat[j].getNomTypePlat().equalsIgnoreCase("Resistance")){ %>
                            <img class="card-img-top" src="assets/img/resistance.jpg" alt="Card image cap">
                           <% } %>
                            <% if(listePlat[j].getNomTypePlat().equalsIgnoreCase("Desert")){ %>
                            <img class="card-img-top" src="assets/img/dessert.jpg" alt="Card image cap">
                           <% } %>
                            <% if(listePlat[j].getNomTypePlat().equalsIgnoreCase("Boisson")){ %>
                            <img class="card-img-top" src="assets/img/boisson.jpg" alt="Card image cap">
                           <% } %>
                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="ingredients(<%=listePlat[j].getIdPlat() %>)">
                                    Voir les ingredients
                            </button>
                            <div class="card-body">
                                <h1 class="text-center"><%=listePlat[j].getNomPlat()%></h1>
                                <hr/>
                                <p class="text-center"><%=listePlat[j].getPrixPlat() %>Ar</p>
                                <div class="col-xs-3">
                                <input class="form-control" type="number" name="qtt">
                            </div>
                                <input type="submit" class="btn btn-primary" value="Commander">
                            </div>
                        </div>
                                </form>
                    </div>
                    <% }%>
                </div>
            </div>
                <div class="container">
                    <div class="row">
                        <a href="=#" class="btn btn-primary">Voir liste commande</a>
                    </div> 
                </div>

                

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered">
                        <div id="ingredient">
                        </div>
                    </div>
                </div>
    </body>
    <script  src="assets/js/jquery.js"></script>
    <script  src="assets/js/popper.js"></script>
    <script  src="assets/js/bootstrap.min.js"></script>
    <script>
        function ingredients(id) {
            var xhr = new XMLHttpRequest()
            xhr.onreadystatechange = (e) => {
                e.preventDefault()
                if (xhr.readyState === 4) {
                    document.getElementById("ingredient").innerHTML = xhr.responseText
                    console.log(xhr.responseText)
                }
            }
            var url = "Recette?idPlat="+id;
            xhr.open('GET', url, true)
            xhr.send()
        }
    </script>
    <script>
        
document.addEventListener("DOMContentLoaded", function(){
  window.addEventListener('scroll', function() {
      if (window.scrollY > 50) {
        document.getElementById('navbar_top').classList.add('fixed-top');
        // add padding top to show content behind navbar
        navbar_height = document.querySelector('.navbar').offsetHeight;
        document.body.style.paddingTop = navbar_height + 'px';
      } else {
        document.getElementById('navbar_top').classList.remove('fixed-top');
         // remove padding top from body
        document.body.style.paddingTop = '0';
      } 
  });
}); 
    </script>

</html>
