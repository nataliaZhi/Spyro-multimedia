# Spyro Multimedia

## Introducción
Spyro Multimedia es una aplicación interactiva diseñada para sumergir a los usuarios en el mundo mágico de Spyro the Dragon. La aplicación incluye una guía de inicio interactiva, animaciones, efectos de sonido, y Easter Eggs ocultos para una experiencia divertida y envolvente. Este proyecto fue desarrollado como parte de un ejercicio práctico para aprender a crear interfaces dinámicas y funcionales en Android.

---

## Características principales
- **Guía de inicio interactiva**: Una serie de pantallas que explican las funcionalidades de la aplicación.
- **Diseños XML personalizados**: Uso de `Drawable` y `ConstraintLayout` para crear interfaces atractivas.
- **Animaciones**: Transiciones y efectos visuales para mejorar la experiencia del usuario.
- **Efectos de sonido**: Sonidos temáticos de Spyro en momentos clave.
- **Easter Eggs**: Funcionalidades ocultas, como la reproducción de un video y una animación de fuego.
- **Persistencia de datos**: Uso de `SharedPreferences` para recordar si el usuario ha completado la guía.
- **Bloqueo de interacción**: La aplicación evita interacciones no deseadas durante la guía.

---

## Tecnologías utilizadas
- **Lenguaje de programación**: Java.
- **Animaciones**: `ObjectAnimator`.
- **Sonidos**: `MediaPlayer` para reproducir efectos de sonido.
- **Persistencia**: `SharedPreferences` para almacenar preferencias del usuario.
- **Gráficos personalizados**: Uso de la clase `Canvas` para crear animaciones.
- **Reproducción de video**: `VideoView` para el Easter Egg.

---

## Instrucciones de uso
1. **Clonar el proyecto**:
   - Abre Android Studio.
   - Selecciona `File > New > Project From Version Control...`.
   - En el diálogo, selecciona "Git" e introduce la URL: `https://github.com/lbarmar/SpyroTheDragon.git`.
   - Pulsa en "Clone" y espera a que el proyecto se descargue.

2. **Modificar el nombre del "About"**:
   - Abre el archivo correspondiente y cambia el nombre para que se muestre el tuyo.

3. **Ejecutar la aplicación**:
   - Conecta un dispositivo físico o inicia un emulador.
   - Pulsa el botón "Run" en Android Studio para compilar y ejecutar la aplicación.

4. **Explorar la aplicación**:
   - Navega por la guía interactiva.
   - Explora las pestañas de Personajes, Mundos y Coleccionables.
   - Descubre los Easter Eggs ocultos.


## Conclusiones del desarrollador
Durante el desarrollo de Spyro Multimedia, enfrenté varios desafíos que me permitieron aprender y mejorar mis habilidades en el desarrollo de aplicaciones Android. Uno de los primeros obstáculos fue diseñar la guía interactiva, ya que necesitaba que las pantallas se superpusieran a la aplicación sin bloquear completamente la interacción. Para resolver esto, utilicé FrameLayout junto con transparencias, lo que permitió crear un efecto de superposición sin interferir con la experiencia del usuario.

La implementación de animaciones también fue un reto, especialmente al sincronizar los efectos de los bocadillos con las transiciones entre pantallas. Para lograr una experiencia fluida, recurrí a ObjectAnimator, que me permitiera crear animaciones dinámicas y atractivas. Además, tuve que asegurarme de que la guía solo se mostrara la primera vez que el usuario abriera la aplicación. Aquí, SharedPreferences fue una herramienta clave, ya que me permitió guardar el estado de la guía y evitar que se repitiera innecesariamente.

Uno de los aspectos más divertidos pero desafiantes fue la creación de los Easter Eggs. Para el Easter Egg con animación, tuve que dibujar una llama de fuego frame por frame utilizando la clase Canvas, lo que requirió un manejo cuidadoso de los gráficos y la sincronización con eventos táctiles. Por otro lado, el Easter Egg con video implicó integrar VideoView y asegurarme de que el video se reprodujera correctamente en pantalla completa, redirigiendo al usuario automáticamente al finalizar.

En general, este proyecto me permitió explorar una amplia gama de tecnologías de Android, desde diseños XML y animaciones hasta la reproducción de sonidos y la persistencia de datos. Cada complicación fue una oportunidad para aprender y mejorar, y el resultado final es una aplicación que combina funcionalidad, diversión y un diseño atractivo inspirado en el mundo de Spyro the Dragon.


## Capturas de pantalla
![image](https://github.com/nataliaZhi/Spyro-multimedia/blob/master/pantallas/Spyro1.png)
![image](https://github.com/nataliaZhi/Spyro-multimedia/blob/master/pantallas/Spyro2.png)
![image](https://github.com/nataliaZhi/Spyro-multimedia/blob/master/pantallas/Spyro3.png)
![image](https://github.com/nataliaZhi/Spyro-multimedia/blob/master/pantallas/Spyro4.png)
![image](https://github.com/nataliaZhi/Spyro-multimedia/blob/master/pantallas/Spyro5.png)
![image](https://github.com/nataliaZhi/Spyro-multimedia/blob/master/pantallas/Spyro6.png)

# Video demostración:
Se puede ver una demostración del funcionamiento en el siguiente enlace:
https://www.youtube.com/shorts/uKgQfEJo8Z0
