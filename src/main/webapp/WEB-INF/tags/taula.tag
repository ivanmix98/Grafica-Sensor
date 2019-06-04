<%@tag language="java" description="component taula" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">identitykey</th>
    </tr>
    </thead>
    <tbody>


    <c:forEach items="${sensors}" var="sensor" varStatus="loop">
        <tr>
            <th scope="row">${loop.index}</th>
            <td>${sensor.identitykey}</td>
            <td><a class="btn btn-warning" href="/grafica/${sensor.getIdentitykey()}">Veure gràfica</a></td>
            <td><a class="btn btn-primary" href="/esborrarSensor?id=${sensor.id}">esborra</a></td>
        </tr>
    </c:forEach>




    </tbody>
</table>