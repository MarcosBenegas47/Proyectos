
// Call the dataTables jQuery plugin
$(function() {
  cargarUsuario();
  $('#usuarios').DataTable();
});


cargarUsuario = async () =>{
  const request = await fetch('http://localhost:8080/api/usuarios', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': localStorage.token
    }
  })
  const content = await request.json()
  console.log(content)
  content.forEach(data => {
    let btnEliminar = `<a href="#" onclick="eliminarUsuario(${data.id})" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i> </a>`
    let usuariohtml = `<tr>
                          <td>${data.nombre}</td>
                          <td>${data.apellido}</td>
                          <td>${data.email}</td>
                          <td>${data.telefono}</td>
                          <td>2011/04/25</td>
                          <td>${btnEliminar}</td></tr>`;
    document.querySelector('#usuarios tbody').insertAdjacentHTML('beforeend', usuariohtml);

  });

}
const eliminarUsuario = async(id) =>{
  
  if(!confirm('¿Desea eliminar este usuario?')){
    return
  }
  await fetch('http://localhost:8080/api/usuarios/'+id, {
    method: 'DELETE',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': localStorage.token,

    }
  })
  location.reload()
}
