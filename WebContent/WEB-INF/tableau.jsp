<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ tableau.nomTableau }</title>
</head>
<body>

<h2>Tableau: ${ tableau.nomTableau }</h2>

<h3>Les lites du tableau: </h3>
<c:forEach items="${ listes }" var="liste">
	<!-- 
			private Long idListe;
			private String nomListe;
			private String descriptionListe;
			private List<Tache> tachesDeLaListe;
			private Long tableauID;
	 -->
	 <p><a href="liste?id=${ liste.idListe }">${ liste.nomListe }</a> : ${ liste.descriptionListe }</p>
</c:forEach>

<form action="tableau" method="post">
	<p>
		<label for="nom">Nom de la liste : </label>
		<input type="text" id="nom" name="nom">
	</p>
	<p>
		<label for="desc">Description de la liste : </label>
		<input type="text" id="desc" name="desc">
	</p>
	<p>
		<input type="hidden" name="id" value="${ tableau.idTableau }">
		<input type="submit">
	</p>
</form>

</body>
</html>