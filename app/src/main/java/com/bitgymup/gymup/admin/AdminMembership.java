package com.bitgymup.gymup.admin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bitgymup.gymup.R;

import static com.bitgymup.gymup.admin.AdminHome.redirectActivity;

public class AdminMembership extends AppCompatActivity {
    private static final String TAG = "AdminMembership";
    DrawerLayout drawerLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_membership);
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    /*INICIO DE TODO EL NAVIGATION DRAWER */
    public void ClickMenu(View view){
        //Abrir drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer Layout, es un procedimiento público que no necesita ser instanciado, es visible en toda la APP.
        drawerLayout.openDrawer(GravityCompat.START);
        //hideSoftKeyboard (AdminHome.this);
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

    public void ClickLogo(View view){
        AdminHome.closeDrawer(drawerLayout);
    }

    /*Listado de todas las funciones de click*/
    public void ClickHome(View view) {
        redirectActivity(this, AdminHome.class);
    }
    public void ClickClientes(View view) {
        redirectActivity(this, AdminUsers.class);
    }
    public void ClickNews(View view) {
        redirectActivity(this, AdminNews.class);
    }
    public void ClickInvoices(View view) {
        redirectActivity(this, AdminInvoices.class);
    }
    public void ClickMembership(View view) {recreate(); }
    /*Fin de los enlaces generales*/
    public void ClickLogout(View view) {
        AdminHome.salir(this);
    }
}