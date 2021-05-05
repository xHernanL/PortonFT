package com.bitgymup.gymup.admin;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bitgymup.gymup.R;

import static com.bitgymup.gymup.admin.AdminHome.redirectActivity;

public class AdminMembership extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_membership);

    }


    /*Inicio de los enlaces*/
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

    public void ClickMembership(View view) {
        redirectActivity(this, AdminMembership.class);
    }
    /*Fin de los enlaces generales*/

    public void ClickLogout(View view) {
        AdminHome.salir(this);
    }
}