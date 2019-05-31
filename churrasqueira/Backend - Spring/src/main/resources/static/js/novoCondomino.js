const url = "http://localhost:8080/api/novoCondomino";
fetch(url, {
    method : "POST",
    headers: "application/x-www-form-urlencoded;charset=UTF-8",
    body: new FormData(document.getElementById("inputform")),
    // -- or --
    // body : JSON.stringify({
        // user : document.getElementById('user').value,
        // ...
    // })
}).then(
    response => response.text() // .json(), etc.
    // same as function(response) {return response.text();}
).then(
    html => console.log(html)
);