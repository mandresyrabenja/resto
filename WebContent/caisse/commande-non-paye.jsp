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

</header>

<!-- header section ends-->

<!-- home section starts  -->

<article>
		
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<h1>Liste des commandes non payés</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<table class="table table-success">
					  <thead>
					    <tr>
					      <th scope="col">Date</th>
					      <th scope="col">Commande</th>
					      <th scope="col">Table</th>
					      <th scope="col">Addition</th>
					      <th scope="col">Paye</th>
					      <th scope="col">Restant</th>
					      <th scope="col">Opération</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<c:forEach items="${commandeNonPayes }" var="commandeNonPaye">
					  		<tr>
						      <td>${commandeNonPaye.dateCommande }</td>
						      <td>${commandeNonPaye.idCommande }</td>
						      <td>${commandeNonPaye.idTable }</td>
						      <td>${commandeNonPaye.addition }Ar</td>
						      <td>${commandeNonPaye.paye }Ar</td>
						      <td>${commandeNonPaye.addition - commandeNonPaye.paye }Ar</td>
						      <td>
						      	<a class="btn btn success"
						      		 href="${pageContext.request.contextPath }/payer-commande?idCommande=${commandeNonPaye.idCommande }">
						      		Payer
					      		</a>
						      </td>
						    </tr>
					  	</c:forEach>
					  </tbody>
					</table>
				</div>
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