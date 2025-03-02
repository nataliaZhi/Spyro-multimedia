package dam.pmdm.spyrothedragon.ui;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import dam.pmdm.spyrothedragon.MainActivity;
import dam.pmdm.spyrothedragon.R;
import dam.pmdm.spyrothedragon.databinding.FragmentVideoBinding;

public class VideoFragment extends Fragment {

    private FragmentVideoBinding binding; // View Binding

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout usando View Binding
        binding = FragmentVideoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        // Ocultar el Toolbar al iniciar el fragmento
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).ocultarToolbar();
        }


        // Cargar el vídeo desde recursos raw
        Uri videoUri = Uri.parse("android.resource://" + requireContext().getPackageName() + "/" + R.raw.video_consejo);

        // Configurar el VideoView usando View Binding
        binding.videoView.setVideoURI(videoUri); // Establecer la ruta del vídeo


        binding.videoView.start(); // Iniciar la reproducción del vídeo

        // Redirigir al usuario a la pestaña de coleccionables al finalizar el vídeo
        binding.videoView.setOnCompletionListener(mp -> {
            // Navegar de regreso al CollectiblesFragment
            Navigation.findNavController(view).popBackStack();
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

        // Mostrar el Toolbar si el fragmento se destruye
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).mostrarToolbar();
        }
    }
}
