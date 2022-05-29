<%@page import="model.TypePlat"%>
<%@page import="model.Plat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resto</title>

    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />

    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <!-- custom css file link  -->
    <link rel="stylesheet" href="assets/css/bootstrap.css">
    <link rel="stylesheet" href="assets/css/style.css">

</head>
<style>
	a {
		text-decoration: none;
	}
	article {
		margin-top: 90px;
	}
	#exampleModal {
		width: 300px;
	}
</style>
<body>
    
<!-- header section starts      -->

<header>

    <a href="#" class="logo"><i class="fas fa-utensils"></i>resto.</a>

    <nav id="navbar_top" class="navbar">
    	<a href="${pageContext.request.contextPath }/liste-commande">Liste des plats commandés</a>
  	</nav>


</header>

<!-- header section ends-->

<!-- home section starts  -->

<article>

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
                     <img class="card-img-top" src="assets/images/dish-4.png" alt="Card image cap">
                    <% } %>
                     <% if(listePlat[j].getNomTypePlat().equalsIgnoreCase("Resistance")){ %>
                     <img class="card-img-top" src="assets/images/dish-5.png" alt="Card image cap">
                    <% } %>
                     <% if(listePlat[j].getNomTypePlat().equalsIgnoreCase("Desert")){ %>
                     <img class="card-img-top" src="assets/images/dish-6.png" alt="Card image cap">
                    <% } %>
                     <% if(listePlat[j].getNomTypePlat().equalsIgnoreCase("Boisson")){ %>
                     <img class="card-img-top" src="assets/images/dish-1.png" alt="Card image cap">
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
			<div class="col-md-12">
				<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			         <div class="modal-dialog modal-dialog-centered">
			             <div id="ingredient">
			             </div>
			         </div>
		     	</div>			
			</div>
		</div>
	</div>
     <!-- Modal -->
    
</article>

<!-- home section ends  -->


<!-- footer section starts  -->

<section class="footer">

    <div class="credit"> copyright @ 2022 par <span>Mandresy RABENJAHARISON</span> </div>

</section>

<!-- footer section ends -->

<!-- loader part  -->
<div class="loader-container">
    <img src="assets/images/loader.gif" alt="">
</div>

<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<!-- custom js file link  -->
<script src="assets/js/script.js"></script>
<script src="assets/js/bootstrap.bundle.js"></script>
<script src="assets/js/bootstrap.js"></script>
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
</body>
</html>