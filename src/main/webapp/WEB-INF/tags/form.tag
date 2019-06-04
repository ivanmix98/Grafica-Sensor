<%@tag language="java" description="component form" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="/desarSensor" method="post">
    <div class="form-group">
        <label for="identitykey">identitykey</label>
        <input name="identitykey" type="text" class="form-control" id="identitykey" aria-describedby="identitykey" placeholder="Entra el identitykey">
    </div>


    <button type="submit" class="btn btn-primary">Submit</button>
</form>