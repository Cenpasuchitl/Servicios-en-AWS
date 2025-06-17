    document.getElementById('libroForm').addEventListener('submit', function(e) {
      e.preventDefault();

      const titulo = document.getElementById('titulo').value;
      const autor = document.getElementById('autor').value;
      const anio = document.getElementById('anio').value;
      const genero = document.getElementById('genero').value;

      const resultado = document.getElementById('resultado');
      resultado.innerHTML = `
        <strong>Libro Registrado:</strong><br>
        📘 <strong>Título:</strong> ${titulo}<br>
        ✍️ <strong>Autor:</strong> ${autor}<br>
        📅 <strong>Año:</strong> ${anio}<br>
        🏷️ <strong>Género:</strong> ${genero}
      `;
      resultado.style.display = 'block';

      // Limpiar formulario
      document.getElementById('libroForm').reset();
    });