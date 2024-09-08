$(function() {

});
  


registrarUsuario =  () =>{
    let datos = {}
    datos.nombre = document.getElementById('txtNombre').value
    datos.apellido = document.getElementById('txtApellido').value
    datos.email = document.getElementById('txtEmail').value
    datos.password = document.getElementById('txtPassword').value

    let repetirPassword = document.getElementById('txtRepeatPassword').value
    if(repetirPassword != datos.password){
        alert('la contraseña no coincide')
        return
    }
  const request =  fetch('http://localhost:8080/api/usuarios', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Bearer tu-token-aqui'
    },
    body: JSON.stringify(datos)
  })

}