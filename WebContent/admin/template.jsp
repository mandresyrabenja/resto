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
        <a <c:if test="${page == 'StockIngredient' }">class="active"</c:if> href="${pageContext.request.contextPath }/ResteStock">Etat de stock</a>
        <a <c:if test="${page == 'IngredientConsome' }">class="active"</c:if> href="${pageContext.request.contextPath }/IngredientCosomeServlet">Ingrédients consommés</a>
        <a <c:if test="${page == 'listePrixRevient' }">class="active"</c:if> href="${pageContext.request.contextPath }/ListePrixRevient">Liste des prix de revient</a>
        <a <c:if test="${page == 'PourBoire' }">class="active"</c:if> href="${pageContext.request.contextPath }/PourboireServeur">Pourboire des serveurs</a>
    </nav>

</header>

<!-- header section ends-->

<!-- home section starts  -->

<article>

		<jsp:include page="${page }.jsp">
	        <jsp:param value="" name="" />
	    </jsp:include>
    
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