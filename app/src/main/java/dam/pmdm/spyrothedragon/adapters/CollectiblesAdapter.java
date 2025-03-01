package dam.pmdm.spyrothedragon.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dam.pmdm.spyrothedragon.R;
import dam.pmdm.spyrothedragon.models.Collectible;

public class CollectiblesAdapter extends RecyclerView.Adapter<CollectiblesAdapter.CollectiblesViewHolder> {

    private List<Collectible> list;

    // Variables para el Easter Egg
    private int clickCount = 0; // Contador de clics
    private static final int CLICKS_REQUIRED = 4; // Número de clics necesarios
    private static final long CLICK_TIMEOUT = 1000; // Tiempo máximo entre clics (1 segundo)
    private long lastClickTime = 0; // Tiempo del último clic
    public CollectiblesAdapter(List<Collectible> collectibleList) {
        this.list = collectibleList;
    }

    @Override
    public CollectiblesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new CollectiblesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CollectiblesViewHolder holder, int position) {
        Collectible collectible = list.get(position);
        holder.nameTextView.setText(collectible.getName());

        // Cargar la imagen (simulado con un recurso drawable)
        int imageResId = holder.itemView.getContext().getResources().getIdentifier(collectible.getImage(), "drawable", holder.itemView.getContext().getPackageName());
        holder.imageImageView.setImageResource(imageResId);




        // Configurar el Easter Egg si el nombre es "Gemas"
        if (collectible.getName().equals("Gemas")) {
            holder.imageImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    long currentTime = System.currentTimeMillis();

                    // Si el tiempo entre clics es mayor que el límite, reiniciar el contador
                    if (currentTime - lastClickTime > CLICK_TIMEOUT) {
                        clickCount = 0;
                    }

                    lastClickTime = currentTime; // Actualizar el tiempo del último clic
                    clickCount++; // Incrementar el contador de clics

                    // Si se alcanza el número de clics requeridos
                    if (clickCount == CLICKS_REQUIRED) {
                        // Reproducir el vídeo del Easter Egg
                        playEasterEggVideo(v);
                        clickCount = 0; // Reiniciar el contador después de activar el Easter Egg
                    }
                }
            });

        }












    }

    private void playEasterEggVideo(View view) {
        // Obtener el NavController desde la vista
        NavController navController = Navigation.findNavController(view);

        // Navegar al VideoFragment usando la acción definida en el nav_graph
        navController.navigate(R.id.action_collectiblesFragment_to_videoFragment);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CollectiblesViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        ImageView imageImageView;

        public CollectiblesViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            imageImageView = itemView.findViewById(R.id.image);
        }
    }
}
