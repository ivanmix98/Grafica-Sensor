<jsp:include page="navbar.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ca">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container" >
    <h1 class="h1" style="text-align:center;">USUARI</h1>
<form action="/desarClient" method="post">
    <div class="form-group">
        <label for="nom">Nom</label>
        <input name="nom" type="text" class="form-control" id="nom" aria-describedby="nom" placeholder="Entra el nom">
    </div>
    <div class="form-group">
        <label for="cognom">Cognom</label>
        <input name="cognom"  type="text" class="form-control" id="cognom" aria-describedby="cognom" placeholder="Entra el cognom">
    </div>
    <div class="form-group">
        <label for="volumCompres">volum compres</label>
        <input name="volumCompres"  type="number" class="form-control" id="volumCompres" aria-describedby="volumCompres" placeholder="Entra el volum de compres">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</div>
</body>

</html>