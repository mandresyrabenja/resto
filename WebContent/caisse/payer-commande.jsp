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
					<h1>Payer le commande "${commande.idCommande }"</h1>
				</div>
			</div>
			<div class="row">
				<form action="${pageContext.request.contextPath }/insert-paiement">
				  <div class="form-group" style="display: none;">
				    <input type="text" class="form-control" id="idCommande" name="idCommande" value="${commande.idCommande }">
				  </div>
				  <div class="form-group">
				    <label for="sommepaye">Montant</label>
				    <input type="number" class="form-control" id="sommepaye" name="sommepaye" value="${commande.addition - commande.paye }" max="${commande.addition - commande.paye }">
				  </div>
				  <div class="form-group">
				    <label for="idtypepaiement">Type de paiement</label>
				    <select class="form-control" id="idtypepaiement" name="idtypepaiement">
				      <c:forEach items="${typePaiements }" var="typePaiement">
					      <option value="${typePaiement.idtypepaiement }">${typePaiement.nompaiement }</option>
				      </c:forEach>
				    </select>
				  </div>
				  <button type="submit" class="btn btn-success">Payer</button>
				</form>
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