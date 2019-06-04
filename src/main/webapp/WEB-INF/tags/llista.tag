<%@tag language="java" description="component llista" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">nom</th>
        <th scope="col">cognom</th>
        <th scope="col">volum</th>
        <th scope="col">acció</th>
    </tr>
    </thead>
    <tbody>


    <c:forEach items="${clients}" var="client" varStatus="loop">
        <tr>
            <th scope="row">${loop.index}</th>
            <td>${client.nom}</td>
            <td>${client.cognom}</td>
            <td>${client.volumCompres}
            </td>
            <td><a class="btn btn-primary" href="/esborrarClient?id=${client.id}">esborra</a>
                <c:if test="${client.volumCompres<1000}">
                    <a class="btn btn-danger" href="#">contactar</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>



    <html>
    <body bgcolor="white">
    suma de 2+3: <daw:etiqueta  primer="2" segon="3" /> <br />
    suma de 1+1: <daw:etiqueta primer="1" segon="1" />
    </body>
    </html>

    </tbody>
</table>