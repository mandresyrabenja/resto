<%@page import="model.Serveur"%>
<%@page import="model.Tablee"%>
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
</style>
<body>
    
<!-- header section starts      -->

<header>

    <a href="#" class="logo"><i class="fas fa-utensils"></i>resto.</a>

    <nav class="navbar">
    </nav>

</header>

<!-- header section ends-->

<!-- home section starts  -->

<article>

        <h1 class="text-center">Créer un commande</h1>
        <div class="container">
            <div class="row">
            	<div class="col-md-4"></div>
            	
                <div class="col-md-4">
	                <form class="form-inline"  action="ListePlat" method="GET">
					  <div class="form-group">
					    <label for="idServeur">Serveur</label>
					    <select class="form-select" id="idServeur" name="idServeur">
                             <%
                             	Serveur[] s=(Serveur[])request.getAttribute("listeServeurs");
                                                             for(int i=0;i<s.length;i++){
                             %>
                            <option value="<%=s[i].getIdServeur()%>"><%=s[i].getNomServeur()%></option>
                           <%
                           	}
                           %>
                        </select>
					  </div>
					  <div class="form-group">
					    <label for="idTable">Table</label>
						<select class="form-select" id="tables" name="idTable">
                             <%
                             	Tablee[] t=(Tablee[])request.getAttribute("listeTables");
                                                             for(int i=0;i<t.length;i++){
                             %>
                            <option value="<%=t[i].getIdtable()%>"><%= t[i].getNumerotable()  %></option>
                           <% }  %>
                        </select>
					  </div>
					  <button type="submit" class="btn btn-primary mb-2">Créer un commande</button>
					</form>
                    
                </div>
                
                <div class="col-md-4"></div>
            </div>
        </div>
    
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

</body>
</html>