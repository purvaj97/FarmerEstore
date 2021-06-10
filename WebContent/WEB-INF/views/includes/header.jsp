<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="images" value="/resources/images" />
<spring:url var="js" value="/resources/js" />
<spring:url var="fonts" value="/resources/fonts" />
<spring:url var="products" value="/resources/images/products" />

<c:set var="SITE_URL" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Best Deals | Buy, Sell and Shop</title>

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>Farmers E-Store</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<!-- Site Icons -->
<link rel="shortcut icon" href="${images}/logo.jpeg" type="image/x-icon">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${css}/bootstrap.min.css">

<!-- Bootstrap4 files-->
<script src="${js}/bootstrap.min.js" type="text/javascript"></script>

<!-- jQuery -->
<script src="${js}/jquery.min.js" type="text/javascript"></script>

<link href="${css}/bootstrap.css" rel="stylesheet" type="text/css" />

<!-- Font awesome 5 -->
<link href="${fonts}/fontawesome/css/all.min.css" type="text/css"
	rel="stylesheet">

<!-- custom style -->
<link href="${css}/ui.css" rel="stylesheet" type="text/css" />
<link href="${css}/responsive.css" rel="stylesheet"
	media="only screen and (max-width: 1200px)" />

<!-- custom javascript -->
<script src="js/script.js" type="text/javascript"></script>

<!-- cart files -->
<link href="${css}/cart.css" rel="stylesheet" type="text/css" />
<script src="${js}/cart.js" type="text/javascript"></script>

</head>
<body>