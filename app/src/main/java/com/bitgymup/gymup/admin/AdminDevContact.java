package com.bitgymup.gymup.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bitgymup.gymup.R;
import com.bitgymup.gymup.email.Configuracion;
import com.bitgymup.gymup.email.EnviarMail;

import static com.bitgymup.gymup.admin.AdminHome.redirectActivity;
import static com.bitgymup.gymup.admin.Variables.id_gym_n;

public class AdminDevContact extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private static final String TAG = "";
    //Inicializar las variables
    Button btn_Notificaciones;
    EditText txt_titulo, txt_mensaje;
    PendingIntent pendingIntent;
    ImageView imageView;
    private Toolbar toolbar;
    private TextView gimnasio_nombre;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_contact_dev);
        //Asignamos la variable
        drawerLayout = findViewById(R.id.drawer_layout);
        gimnasio_nombre  = (TextView) findViewById(R.id.gimnasio_nombre);
        gimnasio_nombre.setText( getUserLogin("namegym"));
        txt_titulo = (EditText)findViewById(R.id.txt_titulo);
        txt_mensaje = (EditText)findViewById(R.id.txt_mensaje);
        btn_Notificaciones = findViewById(R.id.btn_EnviarCorreo);
        id_gym_n = getGymId("gym_id");
        //txt_titulo.setText( id_gym_n);
        imageView = findViewById(R.id.TresDot);
        btn_Notificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //enviarPush("https://www.zonahosting.com/NotifyFCM.php");
                sendEmail();
            }
        });


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

    private String getUserLogin(String key) {
        SharedPreferences sharedPref = getSharedPreferences("user_login", Context.MODE_PRIVATE);
        String username = sharedPref.getString(key,"");
        return username;
    }
    private String getGymId(String key) {
        SharedPreferences sharedPref = getSharedPreferences("gym_id", Context.MODE_PRIVATE);
        String gymid = sharedPref.getString(key,"");
        return gymid;
    }

    private void sendEmail() {

        EditText asunto = (EditText) findViewById(R.id.txt_titulo);
        //EditText correoc = (EditText) findViewById(R.id.intxt_Correo);
        String correoc = "origen@gmail.com";//Este correo debería ser obtenido desde la base de datos.
        EditText comentario = (EditText) findViewById(R.id.txt_mensaje);
        EnviarMail envialMail = new EnviarMail(this, Configuracion.EMAIL, correoc, asunto.getText().toString() + "\n" + comentario.getText().toString());
        envialMail.execute();
    }


    /*ABAJO VAN TODOS LOS MENUS*/
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

    /*Inicio de los enlaces*/
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
    /*Fin de los enlaces generales*/

    public void ClickLogout(View view){AdminHome.salir(this);}

    @Override
    protected void onPause(){
        super.onPause();
        //Close drawer
        AdminHome.closeDrawer(drawerLayout);
    }


}