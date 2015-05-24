package martin.prevencion;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Martin on 18/05/2015.
 */
 public class BaseMenu extends Activity {

    protected String[] titulos;
    protected DrawerLayout NavDrawerLayout;
    protected ListView NavList;
    protected ArrayList<Items> NavItms;
    protected TypedArray NavIcons;
    NavAdapter NavAdapter;
    View menu;
    LayoutInflater f;

    protected void onCreateDrawer(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
        setContentView(R.layout.lateral);
        generateLateralMenu();

        this.getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        this.getActionBar().setCustomView(R.layout.custom_imageview);
        this.getActionBar().setDisplayShowCustomEnabled(true);

        ImageButton menuIcon = (ImageButton) findViewById(R.id.slideMenuButton);

        menuIcon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (NavDrawerLayout.isDrawerOpen(Gravity.START)) {

                   NavDrawerLayout.closeDrawer(Gravity.START);
                } else

              {

                    NavDrawerLayout.openDrawer(Gravity.START);
                }

            }
        });

        NavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NavAdapter nav = (NavAdapter)parent.getAdapter();
                switch((int)nav.getItemId(position))
                {
                    case(3):
                    {
                        Intent k = new Intent(BaseMenu.this, martin.prevencion.apiyoutube.VideoList.class);
                        k.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivityForResult(k, 0);
                        BaseMenu.this.finish();
                        break;
                    }

                    case(0):
                    {
                        Intent k = new Intent(BaseMenu.this, SwipeTab.class);
                        k.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivityForResult(k, 0);
                        BaseMenu.this.finish();
                        break;
                    }
                }

            }
        });


    }

    public void generateLateralMenu()
    {

        NavDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavList = (ListView) findViewById(R.id.lista);

        NavIcons = getResources().obtainTypedArray(R.array.navigation_iconos);

        titulos = getResources().getStringArray(R.array.nav_options);

        NavItms = new ArrayList<Items>();

        NavItms.add(new Items(titulos[0], NavIcons.getResourceId(0, -1)));

        NavItms.add(new Items(titulos[1], NavIcons.getResourceId(1, -1)));

        NavItms.add(new Items(titulos[2], NavIcons.getResourceId(2, -1)));

        NavItms.add(new Items(titulos[3], NavIcons.getResourceId(3, -1)));

        NavItms.add(new Items(titulos[4], NavIcons.getResourceId(4, -1)));

        NavItms.add(new Items(titulos[5], NavIcons.getResourceId(5, -1)));

        NavItms.add(new Items(titulos[6], NavIcons.getResourceId(6, -1)));

        NavAdapter= new NavAdapter(this,NavItms);
        NavList.setAdapter(NavAdapter);


    }
}
