package dam.pmdm.spyrothedragon.ui;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import dam.pmdm.spyrothedragon.MainActivity;
import dam.pmdm.spyrothedragon.R;
import dam.pmdm.spyrothedragon.databinding.FragmentGuiaBinding;




public class GuiaFragment extends Fragment {

//
//
//    private FragmentGuiaBinding binding; // View Binding
//    private int pantallaActual = 1; // Controla la pantalla en la que estamos
//    private static final int TOTAL_PANTALLAS = 6; // Número total de pantallas de la guía
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // Inflar el layout usando View Binding
//        binding = FragmentGuiaBinding.inflate(inflater, container, false);
//        return binding.getRoot();
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        // Configurar el botón "Omitir"
//        binding.btnOmitir.setOnClickListener(v -> cerrarGuia());
//
//        // Configurar el botón "Siguiente"
//        binding.btnSiguiente.setOnClickListener(v -> cambiarPantalla());
//
//        // Mostrar la primera pantalla de la guía
//        mostrarPantalla(1);
//    }
//
//    // Método para mostrar una pantalla específica de la guía
//    private void mostrarPantalla(int numeroPantalla) {
//        // Obtener el layout correspondiente a la pantalla actual
//        int layoutResId = obtenerLayoutPantalla(numeroPantalla);
//        if (layoutResId == 0) return;
//
//        // Limpiar el contenedor de contenido
//        binding.contenidoGuia.removeAllViews();
//
//        // Inflar el layout de la pantalla actual
//        View pantalla = LayoutInflater.from(requireContext()).inflate(layoutResId, binding.contenidoGuia, false);
//        binding.contenidoGuia.addView(pantalla);
//
//        // Configurar botones o lógica específica de la pantalla actual
//        configurarPantallaActual(pantalla, numeroPantalla);
//    }
//
//    // Método para obtener el layout correspondiente a una pantalla
//    private int obtenerLayoutPantalla(int numeroPantalla) {
//        switch (numeroPantalla) {
//            case 1: return R.layout.pantalla_bienvenido;
//            case 2: return R.layout.pantalla_personajes;
//            case 3: return R.layout.pantalla_mundo;
//            case 4: return R.layout.pantalla_coleccionables;
//            case 5: return R.layout.pantalla_icono;
//            case 6: return R.layout.pantalla_resumen;
//            default: return 0;
//        }
//    }
//
//    // Método para configurar la lógica específica de cada pantalla
//    private void configurarPantallaActual(View pantalla, int numeroPantalla) {
//        // Ejemplo: Configurar un botón "Siguiente" en la pantalla actual
//        View botonSiguiente = pantalla.findViewById(R.id.btnSiguiente);
//        if (botonSiguiente != null) {
//            botonSiguiente.setOnClickListener(v -> {
//                if (pantallaActual < TOTAL_PANTALLAS) {
//                    pantallaActual++;
//                    mostrarPantalla(pantallaActual);
//                } else {
//                    cerrarGuia(); // Cerrar la guía al llegar al final
//                }
//            });
//        }
//    }
//
//    // Método para cerrar la guía
//    private void cerrarGuia() {
//        if (getActivity() instanceof MainActivity) {
//            ((MainActivity) getActivity()).saltarGuia();
//        }
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null; // Limpiar la referencia de View Binding
//    }
//















//    private FragmentGuiaBinding binding;
//    private int pantallaActual = 1; // Controla la pantalla en la que estamos
//    private static final int TOTAL_PANTALLAS = 6; // Número total de pantallas de la guía
//    private MediaPlayer mediaPlayer; // Reproductor de sonido para la música de fondo
//    private NavController navController; // Controlador de navegación
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        binding = FragmentGuiaBinding.inflate(inflater, container, false);
//
//        // Obtener el NavController
//        navController = Navigation.findNavController(requireActivity(), R.id.navHostFragment);
//
//        // Iniciar la música de fondo
////        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.musica_fondo);
////        if (mediaPlayer != null) {
////            mediaPlayer.setLooping(true); // La música se repite en bucle
////            mediaPlayer.setVolume(0.3f, 0.3f); // Volumen al 30%
////            mediaPlayer.start();
////        }
//
//        // Cargar la primera pantalla de la guía
//        mostrarPantalla(1);
//
//        return binding.getRoot();
//    }
//
//    // Método para mostrar una pantalla específica de la guía
//    private void mostrarPantalla(int numeroPantalla) {
//        int actionId = obtenerActionId(numeroPantalla);
//        if (actionId == 0) return;
//
//        // Navegar a la pantalla correspondiente
//        navController.navigate(actionId);
//
//        // Configurar botones y animaciones en la nueva pantalla
//        configurarBotones();
//    }
//
//    private int obtenerActionId(int numeroPantalla) {
//        switch (numeroPantalla) {
//
//            case 1:
//                return R.id.bienvenidoFragment;
//            case 2:
//                return R.id.personajesGuideFragment;
//            case 3:
//                return R.id.mundoGuideFragment;
//            case 4:
//                return R.id.coleccionablesGuideFragment;
//            case 5:
//                return R.id.iconoGuideFragment;
//            case 6:
//                return R.id.resumenGuiaFragment;
//            default:
//                return 0;
//        }
//    }
//
////
////            case 1: return R.id.action_guia_to_bienvenido;
////            case 2: return R.id.action_guia_to_personajesGuide;
////            case 3: return R.id.action_guia_to_mundoGuide;
////            case 4: return R.id.action_guia_to_coleccionablesGuide;
////            case 5: return R.id.action_guia_to_iconoGuide;
////            case 6: return R.id.action_guia_to_resumenGuia;
////            default: return 0;
////        }
////    }
//
//    // Configurar botones en cada pantalla de la guía
//    private void configurarBotones() {
//       View botonSiguiente = binding.btnSiguiente;
//        View botonOmitir =  binding.btnOmitir;
//
//        // Configurar el botón para avanzar a la siguiente pantalla
//        if (botonSiguiente != null) {
//
//
//            botonSiguiente.setOnClickListener(v -> {
//                if (pantallaActual < TOTAL_PANTALLAS) {
//                    if (pantallaActual == 5) {
//                      //  reproducirSonido(R.raw.fin_guia); // Sonido al finalizar la guía
//                    } else if (pantallaActual > 1 && pantallaActual < 5) {
//                    //    reproducirSonido(R.raw.boton_avanzar); // Sonido al avanzar
//                    }
//                    pantallaActual++;
//                    mostrarPantalla(pantallaActual);
//                } else {
//                    cerrarGuia(); // Cierra la guía cuando llega al final
//                }
//            });
//        }
//
//        // Configurar el botón para omitir la guía
//        if (botonOmitir != null) {
//            botonOmitir.setOnClickListener(v -> cerrarGuia());
//        }
//    }
//
//    // Método para cerrar la guía y guardar en SharedPreferences que ya se mostró
//    private void cerrarGuia() {
//        // Detener la música de fondo al cerrar la guía
////        if (mediaPlayer != null) {
////            mediaPlayer.stop();
////            mediaPlayer.release();
////            mediaPlayer = null;
////        }
//
//        // Navegar de regreso a la pantalla principal
//        navController.navigateUp();
//    }
//
//    // Método para reproducir sonidos en la guía
////    private void reproducirSonido(int sonidoResId) {
////        MediaPlayer mediaPlayer = MediaPlayer.create(requireContext(), sonidoResId);
////        if (mediaPlayer != null) {
////            mediaPlayer.setOnCompletionListener(MediaPlayer::release);
////            mediaPlayer.start();
////        }
////    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
}












//public class GuiaFragment extends Fragment {
//
//    private FragmentGuiaBinding binding;
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        // Inflar el layout usando ViewBinding
//        binding = FragmentGuiaBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        // Cargar la animación de brillo
//        Animation shineAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.shine_animation);
//
//        // Aplicar la animación al botón
//        binding.btnDiamond.startAnimation(shineAnimation);
//
//        // Configurar el clic del botón
////        binding.btnDiamond.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                // Navegar al siguiente fragmento (PersonajesFragment)
////                Navigation.findNavController(v).navigate(R.id.action_guiaFragment_to_personajesGuideFragment);
////            }
////        });
//
//        return root;
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        // Limpiar el binding cuando la vista se destruya
//        binding = null;
//    }
//}