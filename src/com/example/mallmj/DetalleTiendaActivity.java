package com.example.mallmj;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.mallmj.DetalleImagenActivity;
import com.example.mallmj.R;

public class DetalleTiendaActivity extends Activity{
	
	private TextView tVNombreTienda,tVDireccion,tVTelefono,tVHorario,tVWebsite,tVEmail;
	 private Button bLlamar,bDetalleImagen;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.detalletiendaactivity);
			tVNombreTienda=(TextView)findViewById(R.id.tVNombreTienda);
			tVDireccion=(TextView)findViewById(R.id.tVDireccion);
			tVTelefono=(TextView)findViewById(R.id.tVTelefono);
			tVHorario=(TextView)findViewById(R.id.tVHorario);
			tVWebsite=(TextView)findViewById(R.id.tVWebsite);
			tVEmail=(TextView)findViewById(R.id.tVEmail);
			bLlamar=(Button)findViewById(R.id.bLlamar);
			bDetalleImagen=(Button)findViewById(R.id.bDetalleImagen);
			bLlamar.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
				     String number = "tel:" + tVTelefono.getText().toString().trim();
				        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(number)); 
				        startActivity(callIntent);	
				}
			});
			bDetalleImagen.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
				    
				        Intent callIntent = new Intent(getApplicationContext(), DetalleImagenActivity.class); 
				        startActivity(callIntent);
					
					
				}
			});
			Bundle bundle= getIntent().getExtras();
			tVNombreTienda.setText(bundle.getString("NombreTienda"));
			tVDireccion.setText(bundle.getString("Direccion"));
			Linkify.addLinks(tVDireccion, Linkify.MAP_ADDRESSES);
			tVTelefono.setText(bundle.getString("Telefono"));
			Linkify.addLinks(tVTelefono, Linkify.PHONE_NUMBERS);
			tVHorario.setText(bundle.getString("Horario"));
			tVWebsite.setText(bundle.getString("Website"));
			Linkify.addLinks(tVWebsite, Linkify.WEB_URLS);
			tVEmail.setText(bundle.getString("Email"));
			Linkify.addLinks(tVEmail, Linkify.EMAIL_ADDRESSES);
			
		}
		
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.detalle_tienda, menu);
			return true;
		}

}
