package martin.prevencion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Encuesta extends BaseMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View encuesta = inflater.inflate(R.layout.activity_encuesta,null);
        pri.addView(encuesta);

    }


    @Override
    public void onBackPressed() {
        Intent k = new Intent(Encuesta.this, MainActivity.class);
        k.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(k, 0);
        Encuesta.this.finish();
        return;
    }
}
