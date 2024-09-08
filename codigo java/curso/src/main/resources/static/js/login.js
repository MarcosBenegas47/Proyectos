$(function() {

});
  


iniciarSesion = async () =>{
    let datos = {}
    datos.email = document.getElementById('txtEmail').value
    datos.password = document.getElementById('txtPassword').value

  const request = await fetch('http://localhost:8080/api/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Bearer tu-token-aqui'
    },
    body: JSON.stringify(datos)
  })
  const respuesta = await request.text();
  console.log(respuesta)
  if (respuesta != "FAIL") {
    localStorage.token = respuesta
    localStorage.email = datos.email
    window.location.href = "usuarios.html"
  }
  else{
    alert("Las credenciales son incorrectas")
  }
}