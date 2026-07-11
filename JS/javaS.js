document.addEventListener('DOMContentLoaded', () => {
    const contactForm = document.getElementById('form-contacto');
    const responseMessage = document.getElementById('form-response');

    if (contactForm) {
        contactForm.addEventListener('submit', (e) => {
            e.preventDefault(); // Prevenir el envío tradicional de HTML

            // Captura de datos (por si deseas conectarlo a una API)
            const formData = {
                nombre: document.getElementById('nombre').value,
                correo: document.getElementById('correo').value,
                telefono: document.getElementById('telefono').value,
                mensaje: document.getElementById('mensaje').value
            };

            console.log('Datos listos para enviar:', formData);

            // Simulación de respuesta de backend exitosa
            responseMessage.textContent = `¡Gracias por tu interés, ${formData.nombre}! Hemos recibido tu solicitud. Pronto nos comunicaremos contigo al correo ${formData.correo}.`;
            responseMessage.className = 'hidden-message success';

            // Limpiar el formulario
            contactForm.reset();
        });
    }
});
const anterior = document.getElementById('anterior');
const siguiente = document.getElementById('siguiente');
const slider = document.querySelector('.imagenes-slide');
const imagenes = document.querySelectorAll('.imagenes-slide img');

let indiceActual = 0;

function mostrarImagen(indice) {
    slider.style.transform = `translateX(-${indice * 100}%)`;
}

siguiente.addEventListener('click', () => {
    indiceActual = (indiceActual + 1) % imagenes.length;
    mostrarImagen(indiceActual);
});

anterior.addEventListener('click', () => {
    indiceActual = (indiceActual - 1 + imagenes.length) % imagenes.length;
    mostrarImagen(indiceActual);
});

setInterval(() => {
    indiceActual = (indiceActual + 1) % imagenes.length;
    mostrarImagen(indiceActual);
}, 3000);