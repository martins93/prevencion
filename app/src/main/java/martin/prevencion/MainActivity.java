package martin.prevencion;

import android.os.Bundle;

public class MainActivity extends BaseMenu{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        super.onCreateDrawer(savedInstanceState);



    }

   }




