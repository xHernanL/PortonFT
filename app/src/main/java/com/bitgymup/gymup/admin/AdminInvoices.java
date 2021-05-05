package com.bitgymup.gymup.admin;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bitgymup.gymup.R;

import static com.bitgymup.gymup.admin.AdminHome.redirectActivity;

public class AdminInvoices extends AppCompatActivity {
    private static final String TAG = "AdminInvoices";
    DrawerLayout drawerLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_invoices);
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    /*Menu*/
    public void ClickMenu(View view){
        AdminHome.openDrawer(drawerLayout);
        try
        {
            InputMethodManager im = (InputMethodManager)
                    getSystemService(INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        catch (Exception ex)
        {
            Log.e(TAG, ex.toString());
        }

    }
    public void ClickLogo(View view){
        AdminHome.closeDrawer(drawerLayout);
    }

    /*Listado de todas las funciones de click*/
    public void ClickHome(View view){
        redirectActivity(this, AdminHome.class);
    }
    public void ClickClientes(View view){
        redirectActivity(this,AdminUsers.class);
    }
    public void ClickNews(View view){
        redirectActivity(this,AdminNews.class);
    }
    public void ClickInvoices(View view){redirectActivity(this,AdminInvoices.class); }
    public void ClickMembership(View view){redirectActivity(this,AdminMembership.class); }
    public void ClickLogout(View view){AdminHome.salir(this);}
    /*Fin de los enlaces generales*/
}