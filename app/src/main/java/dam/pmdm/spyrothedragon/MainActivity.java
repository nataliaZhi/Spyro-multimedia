package dam.pmdm.spyrothedragon;



import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import dam.pmdm.spyrothedragon.databinding.ActivityMainBinding;
import dam.pmdm.spyrothedragon.databinding.FragmentGuiaBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    NavController navController = null;
    private PrefsHelper prefsHelper;
    private MediaPlayer mediaPlayer;

    private FragmentGuiaBinding guiaBinding;

    private int pantallaActual = 1; // Controla la pantalla en la que estamos
    private static final int TOTAL_PANTALLAS = 6; // Número total de pantallas de la guía

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        guiaBinding = binding.includeLayout;
        setContentView(binding.getRoot());

        // Inicializar PrefsHelper
        prefsHelper = new PrefsHelper(this);

        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        if (navHostFragment != null) {
            navController = NavHostFragment.findNavController(navHostFragment);
            NavigationUI.setupWithNavController(binding.navView, navController);
            NavigationUI.setupActionBarWithNavController(this, navController);
        }

        binding.navView.setOnItemSelectedListener(this::selectedBottomMenu);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.navigation_characters ||
                    destination.getId() == R.id.navigation_worlds ||
                    destination.getId() == R.id.navigation_collectibles) {
                // Para las pantallas de los tabs, no queremos que aparezca la flecha de atrás
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
            else {
                // Si se navega a una pantalla donde se desea mostrar la flecha de atrás, habilítala
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        });

       //   Verificar si la guía ya se mostró
      //  if (!prefsHelper.isGuideShown()) {
            // Mostrar la guía si no se ha mostrado antes


        mostrarGuia ();


            // Marcar que la guía ya se mostró
            //prefsHelper.setGuideShown(true);
      //  }
    }

    // Método para mostrar la guía
    private void mostrarGuia() {
        binding.includeLayout.includeGuia.setVisibility(View.VISIBLE); // Mostrar la guía

        // Configurar botones
        binding.includeLayout.btnOmitir.setOnClickListener(v -> cerrarGuia());
        binding.includeLayout.btnSiguiente.setOnClickListener(v -> avanzarPantalla(pantallaActual + 1));

        // Mostrar la primera pantalla
        avanzarPantalla(1);
        iniciarMusica();
    }

    // Método unificado para avanzar de pantalla
    private void avanzarPantalla(int nuevaPantalla) {
        if (nuevaPantalla > TOTAL_PANTALLAS) {
            cerrarGuia(); // Cerrar la guía si se llega al final
            return;
        }

        pantallaActual = nuevaPantalla;
ocultarToolbar();
        //  Mostrar la nueva pantalla de la guía
if (pantallaActual==1|| pantallaActual==6) {
    binding.includeLayout.btnSiguiente.setVisibility(View.GONE);
    binding.includeLayout.btnOmitir.setVisibility(View.GONE);
} else {
    binding.includeLayout.btnSiguiente.setVisibility(View.VISIBLE);
    binding.includeLayout.btnOmitir.setVisibility(View.VISIBLE);
}
        mostrarPantalla(pantallaActual);

        // Navegar al fragmento correspondiente en la aplicación
        switch (pantallaActual) {
            case 1:
                // No es necesario navegar en la pantalla de bienvenida
                break;
            case 2:
                // es pantalla de personajes
                break;
            case 3:
                navController.navigate(R.id.action_characters_to_worlds);
                break;
            case 4:
                navController.navigate(R.id.action_worlds_to_collectibles);
                break;
            case 5:

                showInfoDialog();

                break;
        }

        //  Configurar los botones de la pantalla actual
        configurarBotonesPantallaActual();
    }

    // Método para mostrar una pantalla específica de la guía
    private void mostrarPantalla(int numeroPantalla) {
        // Limpiar el contenedor de contenido
        binding.includeLayout.contenidoGuia.removeAllViews();

        // Inflar el layout de la pantalla actual
        int layoutResId = obtenerLayoutPantalla(numeroPantalla);
        View pantalla = LayoutInflater.from(this).inflate(layoutResId, binding.includeLayout.contenidoGuia, false);
        binding.includeLayout.contenidoGuia.addView(pantalla);

// Aplicar animación al bocadillo
        View bocadillo = pantalla.findViewById(R.id.bocadillo);
        if (bocadillo != null) {
            Animation animacion;
            switch (numeroPantalla) {
                case 2:
                    animacion = AnimationUtils.loadAnimation(this, R.anim.fade_in);
                    break;
                case 3:
                    animacion = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
                    break;
                case 4:
                    animacion = AnimationUtils.loadAnimation(this, R.anim.scale_up);
                    break;
                default:
                    animacion = AnimationUtils.loadAnimation(this, R.anim.fade_in);
                    break;
            }
            bocadillo.startAnimation(animacion);
        }



    }

    // Método para obtener el layout correspondiente a una pantalla
    private int obtenerLayoutPantalla(int numeroPantalla) {
        switch (numeroPantalla) {
            case 1:
                return R.layout.pantalla_bienvenido;
            case 2:
                return R.layout.pantalla_personajes;
            case 3:
                return R.layout.pantalla_mundo;
            case 4:
                return R.layout.pantalla_coleccionables;
            case 5:
                return R.layout.pantalla_icono;
            case 6:
                return R.layout.pantalla_resumen;
            default:
                return 0;
        }
    }

    // Método para configurar los botones de la pantalla actual
    private void configurarBotonesPantallaActual() {
        // Obtener la vista de la pantalla actual
        View pantalla = binding.includeLayout.contenidoGuia.getChildAt(0);

        // Configurar el botón "Siguiente"
        View botonSiguiente = pantalla.findViewById(R.id.btnSiguiente);
        if (botonSiguiente != null) {
            botonSiguiente.setOnClickListener(v -> avanzarPantalla(pantallaActual + 1));

        }

        // Configurar el botón de diamante
        View botonHuevo = pantalla.findViewById(R.id.btnHuevo);

        if (botonHuevo != null) {

            // Cargar la animación desde el archivo XML
            Animation shineAnimation = AnimationUtils.loadAnimation(this, R.anim.shine_animation);

            // Configurar la animación para que se repita infinitamente
            shineAnimation.setRepeatMode(Animation.REVERSE); // Alternar entre inicio y fin
            shineAnimation.setRepeatCount(Animation.INFINITE); // Repetir infinitamente

            // Aplicar la animación al marcadorTab
            botonHuevo.startAnimation(shineAnimation);


            botonHuevo.setOnClickListener(v -> avanzarPantalla(2));
        }
        // Configurar el botón de diamante
        View botonComenzar = pantalla.findViewById(R.id.btnComenzar);

        if (botonComenzar != null) {

            botonComenzar.setOnClickListener(v -> cerrarGuia());
        }

        View marcadorTab= pantalla.findViewById(R.id.marcadorTab);
        if (marcadorTab != null) {
            // Cargar la animación desde el archivo XML
            Animation shineAnimation = AnimationUtils.loadAnimation(this, R.anim.shine_animation);

            // Configurar la animación para que se repita infinitamente
            shineAnimation.setRepeatMode(Animation.REVERSE); // Alternar entre inicio y fin
            shineAnimation.setRepeatCount(Animation.INFINITE); // Repetir infinitamente

            // Aplicar la animación al marcadorTab
            marcadorTab.startAnimation(shineAnimation);

        }

    }



    private void cerrarGuia() {
        binding.includeLayout.includeGuia.setVisibility(View.GONE); // Ocultar la guía
        prefsHelper.setGuideShown(true); // Marcar que la guía ya se mostró
        detenerMusica();
        mostrarToolbar();


    }



    private void iniciarMusica() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.musica_fondo);
            mediaPlayer.setLooping(true); // Repetir en bucle
            mediaPlayer.setVolume(0.3f, 0.3f); // Volumen al 30%
        }
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start(); // Iniciar la reproducción
        }


    }

    private void detenerMusica() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop(); // Detener la reproducción
            }
            mediaPlayer.release(); // Liberar los recursos
            mediaPlayer = null;
        }

    }

    private void ocultarToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide(); // Ocultar el Toolbar
        }
    }

    private void mostrarToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().show(); // Mostrar el Toolbar
        }
    }

    private boolean selectedBottomMenu(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.nav_characters)
            navController.navigate(R.id.navigation_characters);
        else
        if (menuItem.getItemId() == R.id.nav_worlds)
            navController.navigate(R.id.navigation_worlds);
        else
            navController.navigate(R.id.navigation_collectibles);
        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla el menú
        getMenuInflater().inflate(R.menu.about_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Gestiona el clic en el ítem de información
        if (item.getItemId() == R.id.action_info) {
            showInfoDialog();  // Muestra el diálogo
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showInfoDialog() {
        // Crear un diálogo de información
        new AlertDialog.Builder(this)
                .setTitle(R.string.title_about)
                .setMessage(R.string.text_about)
                .setPositiveButton(R.string.accept, null)
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        detenerMusica();
        binding = null;
    }

}