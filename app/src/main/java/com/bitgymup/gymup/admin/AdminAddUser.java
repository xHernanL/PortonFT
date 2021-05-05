package com.bitgymup.gymup.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.bitgymup.gymup.R;

import static com.bitgymup.gymup.admin.AdminHome.redirectActivity;

public class AdminAddUser extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    //Inicializar las variables
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_user);
        //Asignamos la variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }



    public void ClickMenuOptions(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
        popup.inflate(R.menu.menu_admin_3);
        popup.show();
    }

    public boolean onMenuItemClick(MenuItem item){
        switch (item.getItemId()){
            case R.id.acerca_de:
                startActivity(new Intent(this, AdminDevelopers.class));
                return true;
            case R.id.contacto:
                startActivity(new Intent(this, AdminDevContact.class));
                return true;
            default:
                return false;
        }
    }
    /*Inicio de los enlaces*/
    public void ClickHome(View view){
        //Redirección de la activity Home
        redirectActivity(this,AdminHome.class);
    }

    public void ClickNews(View view){
        //Redirección de la activity News
        redirectActivity(this,AdminNews.class);
    }
    public void ClickInvoices(View view){
        //Redirección de la activity a Facturas
        redirectActivity(this,AdminInvoices.class);
    }
    public void ClickMembership(View view){
        //Redirección de la activity a Membresia
        redirectActivity(this,AdminMembership.class);
    }
    public void ClickClientes(View view){
        //Redirección de la activity a Users
        redirectActivity(this,AdminUsers.class);
    }
    /*Fin de los enlaces generales*/

    public void ClickLogout(View view){
        //Cerrar APP
        AdminHome.salir(this);
    }

    @Override
    protected void onPause(){
        super.onPause();
        //Close drawer
        AdminHome.closeDrawer(drawerLayout);
    }

}