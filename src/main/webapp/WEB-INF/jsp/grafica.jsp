<jsp:include page="navbar.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ca">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<body>

<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0/dist/Chart.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-git.js"></script>
<div class="container"">
<h1 class="h1" style="text-align:center;">GRÀFICA</h1>

<div class="col-xl-12 col-lg-12 col-md-12">
    <div class="columna mb-5" style="padding: 1em;">
        <i id="reload-button" class="fas fa-sync-alt" style="cursor: pointer"></i>
        <canvas class="canvas" id="line-chart" width="200" height="100"></canvas>
    </div>
</div>

</div>


<script>

    var xhr;
    var reloadbutton = document.getElementById("reload-button");
    function init() {
        try {
            // Firefox, Opera 8.0+, Safari, Chrome
            xhr = new XMLHttpRequest();
        } catch (e) {
            // Internet Explorer
            try {
                xhr = new ActiveXObject("Msxml2.XMLHTTP");
                //ie6+
            } catch (e) {
                try {
                    xhr = new ActiveXObject("Microsoft.XMLHTTP");
                    //ie5
                } catch (e) {
                    alert("El teu navegador no suporta AJAX!");
                    return false;
                }
            }
        }

        reloadbutton.addEventListener("click",cargaGrafic,true);
        cargaGrafic();
    }

    function cargaGrafic() {

        var json;
        var data;
        //callback
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4) {
                json = JSON.parse(xhr.responseText);
                var today = new Date();
                var hours = today.getHours();
                var min = today.getMinutes();
                var sec = today.getSeconds();

                new Chart(document.getElementById("line-chart"), {
                    type: 'line',
                    data: {
                        labels: [,1,2,3,4,5,6,7,8,hours+":"+min+":"+sec],
                        datasets: [{
                            label:"Data",
                            data: json.data,
                            borderColor: "#3e95cd",
                            fill: false
                        }
                        ]
                    }
                });
            }

        };

        xhr.open("GET", "/getdata/${identitykey}");
        xhr.send(null);

    }

    window.addEventListener("load", init, true);


</script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>

</html>