package aplicacion.android.serapina.mijuego_m08;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Juego j = new Juego(this);
        setContentView(j);

    }

    //clase con las funcionalidades del juego
    public class Juego extends View {
        private Bitmap fondo;
        private Bitmap cesta;

        //coordenadas donde aparecera la cesta
        private int coorX, coorY;

        public Juego(Context context){
            super(context);
            fondo = BitmapFactory.decodeResource(getResources(),R.drawable.bosque);
            cesta = BitmapFactory.decodeResource(getResources(),R.drawable.cesta);

            coorX = 500;
            coorY = 1300;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            //super.onDraw(canvas);
            pintaFondo(canvas);
            pintaCesta(canvas);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN){
                float x= event.getX();
                if (x> coorX) {
                    coorX = coorX + 50;}
                else {
                    coorX = coorX - 50;}
            }
            invalidate(); // repintar
            return true;
        }

        public void pintaFondo(Canvas canvas){
            Bitmap fondoEscalado = Bitmap.createScaledBitmap(fondo,getWidth(),getHeight(),true);
            canvas.drawBitmap(fondoEscalado,0,0,null);

        }

        public void pintaCesta(Canvas canvas){
            Bitmap cestaEscalada = Bitmap.createScaledBitmap(cesta, getWidth()/4, getHeight()/8, true);
            
            canvas.drawBitmap(cestaEscalada, coorX,coorY, null);
        }
    }
}
