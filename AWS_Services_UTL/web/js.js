    document.getElementById('formLibro').addEventListener('submit', function(e) {
      e.preventDefault();

      const titulo = document.getElementById('titulo').value;
      const editorialId = parseInt(document.getElementById('editorialId').value);

      if (!titulo || !editorialId || editorialId < 1) {
        mostrarMensaje('Por favor, completa todos los campos correctamente.', 'error');
        return;
      }

      const libro = {
        titulo: titulo,
        editorial: {
          id: editorialId
        }
      };

      const datos = new URLSearchParams();
      datos.append("libro", JSON.stringify(libro));

      fetch("http://3.139.67.72:8080/AWS_Services_UTL/api/libros/insert", {
        method: "POST",
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: datos
      })
      .then(res => res.json())
      .then(data => {
        if (data.ok) {
          mostrarMensaje(data.ok, 'success');
          document.getElementById('formLibro').reset();
        } else {
          mostrarMensaje(data.error || 'Error desconocido al registrar el libro', 'error');
        }
      })
      .catch(err => {
        mostrarMensaje('Error de conexión con el servidor', 'error');
      });
      
      function mostrarMensaje(texto, tipo) {
        const mensaje = document.getElementById('mensaje');
        mensaje.textContent = texto;
        mensaje.className = 'message ' + tipo;
        mensaje.style.display = 'block';
      }
    });