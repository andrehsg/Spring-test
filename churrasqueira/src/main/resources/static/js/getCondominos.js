$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/api/condominos"
    }).then(function(data) {
       $.each(data, function(index) {
       $('.apartamento').append(data[index].apartamento);
       $('.nome').append(data[index].condomino);
       });
    });
});