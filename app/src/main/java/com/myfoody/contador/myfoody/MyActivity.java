package com.myfoody.contador.myfoody;


import android.app.Activity;
import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;



import java.util.List;
import android.util.Log;



public class MyActivity extends ActionBarActivity  {


    private String[] titulos;
    private DrawerLayout NavDrawerLayout;
    private ListView NavList;
    private ArrayList<Item_objct> NavItms;
    private TypedArray NavIcons;
    NavigationAdapter NavAdapter;

    //Parte 2
    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Drawer Layout
        NavDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        //Lista
        NavList=(ListView)findViewById(R.id.lista);
        //Declaramos el header el cual sera el layout del header.xml
        View header=getLayoutInflater().inflate(R.layout.header,null);
        //Establecemos header
        NavList.addHeaderView(header);
        //Tomamos listado de imagenes desde drawable
        NavIcons=getResources().obtainTypedArray(R.array.navigation_iconos);
        //Tomamos listado de titulos desde el string array
        titulos =getResources().getStringArray(R.array.nav_options);
        //Listado de titulos de barra de navegación
        NavItms=new ArrayList<Item_objct>();
        //Agregamos objetos Item_objct al array
        //Perfil
        NavItms.add(new Item_objct(titulos[0],NavIcons.getResourceId(0,-1)));
        //Recetas
        NavItms.add(new Item_objct(titulos[1],NavIcons.getResourceId(1,-1)));
        //Favoritos
        NavItms.add(new Item_objct(titulos[2],NavIcons.getResourceId(2,-1)));
        //Configuración
        NavItms.add(new Item_objct(titulos[3],NavIcons.getResourceId(3,-1)));
        //Declaramos y seteamos nuestro adaptador al cual le pasamos el array con los titulos
        NavAdapter=new NavigationAdapter(this,NavItms);
        NavList.setAdapter(NavAdapter);

        //Parte 2
        //Declaramos el mDrawerToggle y las ims a usar
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                NavDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* Icono de navegacion*/
                R.string.app_name,  /* "open drawer" description */
                R.string.hello_world  /* "close drawer" description */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                Log.e("Cerrado completo", "!!");
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                Log.e("Apertura completa", "!!");
            }
        };
        //Establecemos que mDrawerToggle declarado previamente sea el DrawerListener
        NavDrawerLayout.setDrawerListener(mDrawerToggle);
        //Establecemos que el ActonBar muestre el Boton Home

        android.support.v7.app.ActionBar actionBar =getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Establecemos la accion al clickear sobre cualquier item del menu
        //De la misma forma que haríamos en una app comun con un listview
        NavList.setOnClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id){
                MostrarFragment(position);
            }
        });

        MostrarFRragment(1);

    }
    /*Pasando la posicion de la opcion en el menu nos motrara el Fragment correspondiente*/
    private void MostrarFRragment(int position) {
     //actualizar el contenido principal, sustituyendo los fragmentos
        Fragment fragment=null;
        switch ()
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
