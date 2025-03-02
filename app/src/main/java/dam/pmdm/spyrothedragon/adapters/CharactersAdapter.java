package dam.pmdm.spyrothedragon.adapters;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import dam.pmdm.spyrothedragon.R;
import dam.pmdm.spyrothedragon.models.Character;
import dam.pmdm.spyrothedragon.ui.FireAnimationView;

import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder> {

    private List<Character> list;

    public CharactersAdapter(List<Character> charactersList) {
        this.list = charactersList;
    }

    @Override
    public CharactersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new CharactersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CharactersViewHolder holder, int position) {
        Character character = list.get(position);
        holder.nameTextView.setText(character.getName());

        // Cargar la imagen (simulado con un recurso drawable)
        int imageResId = holder.itemView.getContext().getResources().getIdentifier(character.getImage(), "drawable", holder.itemView.getContext().getPackageName());
        holder.imageImageView.setImageResource(imageResId);

        // Configurar la pulsación prolongada para el ítem de Spyro
        if (character.getName().equals("Spyro")) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    // Mostrar la animación de la llama desde el centro de la imagen
                    showFireAnimation(holder.imageImageView, holder.itemView.findViewById(R.id.includeFireAnimation));
                    return true; // Indicar que el evento ha sido consumido


                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void showFireAnimation(ImageView imageView, final View animationView) {
        // Obtener el centro de la imagen
        int centerX = (imageView.getLeft() + imageView.getRight()) / 2;
        int centerY = (imageView.getTop() + imageView.getBottom()) / 2;

        // Desplazar el punto de inicio hacia abajo
        int offsetY = (int) (imageView.getHeight() * 0.5);
        int startY = centerY + offsetY;

        // Establecer la posición inicial de la vista de animación en el centro de la imagen
        animationView.setPivotX(centerX);
        animationView.setPivotY(startY);

        // Mostrar la vista de animación
        animationView.setVisibility(View.VISIBLE);

        // Crear una animación de escala desde 0 a 1
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(animationView, "scaleX", 0f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(animationView, "scaleY", 0f, 1f);

        scaleX.setDuration(1000);
        scaleY.setDuration(1000);

        // Iniciar la animación
        scaleX.start();
        scaleY.start();

        // Opcional: ocultar la vista de animación después de la animación
        scaleY.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                animationView.setVisibility(View.GONE);
            }
        });
    }

    public static class CharactersViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        ImageView imageImageView;

        public CharactersViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            imageImageView = itemView.findViewById(R.id.image);
        }
    }
}
