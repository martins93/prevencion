package martin.prevencion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Cuestionario extends BaseMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View encuesta = inflater.inflate(R.layout.activity_cuestionario,null);
        pri.addView(encuesta);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               // boolean checked = ((RadioButton) radioGroup.get).isChecked();
                boolean checked = true;


                // Check which radio button was clicked
                switch(checkedId) {
                    case R.id.radioButton:
                        if (checked) {Context context = getApplicationContext();
                            CharSequence text = "CORRECTO!";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                        break;
                    case R.id.radioButton2:
                        if (checked)
                        {Context context = getApplicationContext();
                            CharSequence text = "INCORRECTO! Con los tratamientos actuales se puede evitar la progresión a desarrollar enfermedades, por eso muchas personas que viven con VIH logran evitar la etapa sida";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                        break;
                    case R.id.radioButton4:
                        if (checked)
                        {Context context = getApplicationContext();
                            CharSequence text = "INCORRECTO! Cualquiera que haya tenido una relación sexual sin preservativo puede adquirir el VIH";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                        break;
                    case R.id.radioButton5:
                        if (checked)
                        {Context context = getApplicationContext();
                            CharSequence text = "CORRECTO!";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
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
