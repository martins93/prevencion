package martin.prevencion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Cuestionario extends BaseMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View encuesta = inflater.inflate(R.layout.activity_cuestionario,null);
        pri.addView(encuesta);

        final TextView resp1 = (TextView) findViewById(R.id.textRespuesta1);
        final TextView resp2 = (TextView) findViewById(R.id.textRespuesta2);
        final RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radio_group1);
        final RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radio_group2);

        final Button button = (Button) findViewById(R.id.buttonConfirmar);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {




                        // Check which radio button was clicked
                        switch(radioGroup1.getCheckedRadioButtonId()) {
                            case R.id.radioPreg1:
                                 {
                                    resp1.setVisibility(View.VISIBLE);
                                    resp1.setTextColor(Color.parseColor("#F44336"));
                                    resp1.setText("Respuesta 1: Incorrecta. Con los tratamientos actuales se puede evitar la progresión a desarrollar enfermedades.");

                                }
                                break;
                            case R.id.radioPreg2:

                                {
                                    resp1.setVisibility(View.VISIBLE);
                                    resp1.setTextColor(Color.parseColor("#2196F3"));
                                    resp1.setText("Respuesta 1: Correcta. Dados los tratamientos actuales muchas personas que viven con VIH logran evitar la etapa sida.");
                                }
                                break;
                        }





                        // Check which radio button was clicked
                        switch(radioGroup2.getCheckedRadioButtonId()) {
                            case R.id.radioPreg3:
                               {

                                    resp2.setVisibility(View.VISIBLE);
                                    resp2.setTextColor(Color.parseColor("#F44336"));
                                    resp2.setText("Respuesta 2: Incorrecta. Cualquiera que haya tenido una relación sexual sin preservativo puede adquirir el VIH.");
                                }
                                break;
                            case R.id.radioPreg4:

                                {
                                    resp2.setVisibility(View.VISIBLE);
                                    resp2.setTextColor(Color.parseColor("#2196F3"));
                                    resp2.setText("Respuesta 2: Correcta. El VIH nos afecta a todos.");
                                }
                                break;
                        }

            }
        });





    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?

    }
    @Override
    public void onBackPressed() {
        Intent k = new Intent(Cuestionario.this, MainActivity.class);
        k.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(k, 0);
        Cuestionario.this.finish();
        return;
    }
}
