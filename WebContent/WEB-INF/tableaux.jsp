<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vos tableaux</title>
</head>
<body>

<h1>Bienvenue</h1>
<h2>Voici vos tableaux</h2>

<c:forEach items="${ tableaux }" var="tableau">
	<p>
		<a href="tableau?id=${ tableau.idTableau }">${ tableau.nomTableau }</a>
	</p>
</c:forEach>

<form action="tableaux" method="post">
	<p>
		<label for="nom">Nom du tableau : </label>
		<input type="text" id="nom" name="nom">
	</p>
	<p>
		<label for="desc">Description du tableau : </label>
		<input type="text" id="desc" name="desc">
	</p>
	<p>
		<input type="submit">
	</p>
</form>

</body>
</html>