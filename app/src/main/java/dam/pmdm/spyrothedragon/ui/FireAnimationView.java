package dam.pmdm.spyrothedragon.ui;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import java.util.Random;
public class FireAnimationView extends View {

    private Paint paint;
    private Path path;
    private Random random;
    private int frame = 0;
    private boolean isAnimating = true;

    public FireAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        path = new Path();
        random = new Random();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Limpiar el canvas
        canvas.drawColor(Color.TRANSPARENT);

        // Dibujar la llama
        drawFire(canvas);

        // Actualizar la animación
        if (isAnimating) {
            frame++;
            if (frame > 100) {
                isAnimating = false; // Detener la animación después de 100 frames
            }
        }

        // Volver a dibujar si la animación está en curso
        if (isAnimating) {
            invalidate();
        }
    }

    private void drawFire(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();

        // Punto de inicio de la llama (centro del ImageView)
        int startX = width / 2; // Centro horizontal
        int startY = height / 2; // Centro vertical

        // Punto final de la llama (esquina inferior derecha)
        int endX = width; // Borde derecho
        int endY = height; // Borde inferior

        // Crear un degradado de colores para la llama
        int[] colors = {Color.YELLOW, Color.rgb(255, 165, 0), Color.RED}; // Amarillo, naranja, rojo
        float[] positions = {0f, 0.5f, 1f}; // Posiciones del degradado
        LinearGradient gradient = new LinearGradient(
                startX, startY, endX, endY, // Dirección del degradado (desde el centro hasta la esquina)
                colors, positions, Shader.TileMode.CLAMP
        );
        paint.setShader(gradient);

        // Crear un efecto de llama dinámico
        path.reset();
        path.moveTo(startX, startY);

        // Añadir puntos intermedios para simular el movimiento de la llama
        for (int i = 1; i <= 10; i++) {
            int x = startX + (i * (endX - startX) / 10); // Movimiento horizontal progresivo
            int y = startY + (i * (endY - startY) / 10) + random.nextInt(40) - 20; // Movimiento vertical con variación aleatoria (más grande)
            path.lineTo(x, y);
        }

        path.lineTo(endX, endY); // Terminar en la esquina inferior derecha

        // Ajustar el tamaño de la llama en función del frame
        float scale = getScaleFactor(frame);
        canvas.save();
        canvas.scale(scale, scale, startX, startY);
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    private float getScaleFactor(int frame) {
        // La llama crece hasta el frame 100 y termina en su tamaño máximo
        return 1 + (frame / 100f); // Crece de 1x a 2x
    }

    public void startAnimation() {
        frame = 0; // Reiniciar la animación
        isAnimating = true; // Activar la animación
        invalidate(); // Forzar el redibujado
    }
}
//public class FireAnimationView extends View {
//
//    private Paint paint;
//    private Path path;
//    private Random random;
//    private int frame = 0;
//    private boolean isAnimating = true;
//
//    public FireAnimationView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init();
//    }
//
//    private void init() {
//        paint = new Paint();
//        paint.setStyle(Paint.Style.FILL);
//        paint.setAntiAlias(true);
//
//        path = new Path();
//        random = new Random();
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
//        // Limpiar el canvas
//        canvas.drawColor(Color.TRANSPARENT);
//
//        // Dibujar la llama
//        drawFire(canvas);
//
//        // Actualizar la animación
//        if (isAnimating) {
//            frame++;
//            if (frame > 100) {
//                isAnimating = false; // Detener la animación después de 100 frames
//            }
//        }
//
//        // Volver a dibujar si la animación está en curso
//        if (isAnimating) {
//            invalidate();
//        }
//    }
//
//    private void drawFire(Canvas canvas) {
//        int width = getWidth();
//        int height = getHeight();
//
//        // Punto de inicio de la llama (centro del ImageView)
//        int startX = width / 2; // Centro horizontal
//        int startY = height / 2; // Centro vertical
//
//        // Punto final de la llama (esquina inferior derecha)
//        int endX = width; // Borde derecho
//        int endY = height; // Borde inferior
//
//        // Crear un degradado de colores para la llama
//        int[] colors = {Color.YELLOW, Color.rgb(255, 165, 0), Color.RED}; // Amarillo, naranja, rojo
//        float[] positions = {0f, 0.5f, 1f}; // Posiciones del degradado
//        LinearGradient gradient = new LinearGradient(
//                startX, startY, endX, endY, // Dirección del degradado (desde el centro hasta la esquina)
//                colors, positions, Shader.TileMode.CLAMP
//        );
//        paint.setShader(gradient);
//
//        // Crear un efecto de llama dinámico
//        path.reset();
//        path.moveTo(startX, startY);
//
//        // Añadir puntos intermedios para simular el movimiento de la llama
//        for (int i = 1; i <= 10; i++) {
//            int x = startX + (i * (endX - startX) / 10); // Movimiento horizontal progresivo
//            int y = startY + (i * (endY - startY) / 10) + random.nextInt(20) - 10; // Movimiento vertical con variación aleatoria
//            path.lineTo(x, y);
//        }
//
//        path.lineTo(endX, endY); // Terminar en la esquina inferior derecha
//
//        // Ajustar el tamaño de la llama en función del frame
//        float scale = getScaleFactor(frame);
//        canvas.save();
//        canvas.scale(scale, scale, startX, startY);
//        canvas.drawPath(path, paint);
//        canvas.restore();
//    }
//
//    private float getScaleFactor(int frame) {
//        // La llama crece hasta el frame 50 y luego disminuye
//        if (frame <= 50) {
//            return 1 + (frame / 50f); // Crece de 1x a 2x
//        } else {
//            return 2 - ((frame - 50) / 50f); // Disminuye de 2x a 1x
//        }
//    }
//
//    public void startAnimation() {
//        frame = 0; // Reiniciar la animación
//        isAnimating = true; // Activar la animación
//        invalidate(); // Forzar el redibujado
//    }
//}