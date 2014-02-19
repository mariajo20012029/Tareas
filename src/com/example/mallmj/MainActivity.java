package com.example.mallmj;

import java.util.ArrayList;
import java.util.List;

import com.example.mallmj.DetalleTiendaActivity;
import com.example.mallmj.MainActivity;
import com.example.mallmj.R;
import com.example.mallmj.Tienda;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	
	public static final String TAG= MainActivity.class.toString();
	private ListView list;
	private List<Tienda> tiendas= new ArrayList <Tienda>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list=(ListView)findViewById(R.id.list);
		Tienda tienda1 = new Tienda("Pet Express",
								"Km 15.5 Carretera a El Salvador, Centro de Conveniencia Condado Concepci—n Local 16, Ciudad de Guatemala",
								"6634-7121",
								"Lun-Sab 9:00-20:30",
								"www.petexpressgt.com",
								"telemercadeo@petexpressgt.com");
		
		Tienda tienda2 = new Tienda("Taco Bell",
				"1a Calle, Coban, Guatemala",
				"2202-0009",
				"Lun-Dom 9:00-20:30",
				"www.tacobell.com.gt",
				"info@tacobell.com.gt");
		Tienda tienda3 = new Tienda("Subway",
				"Carretera Interamericana, Guatemala, Guatemala",
				"2386-8686",
				"Lun-Dom 9:00-20:30",
				"www.subwayguatemala.com",
				"info@subwayguatemala.com");

		tiendas.add(tienda1);
		tiendas.add(tienda2);
		tiendas.add(tienda3);
		
		String[] ListaTienda = {(String)tiendas.get(0).GetNombre(),
						        (String)tiendas.get(1).GetNombre(),
						        (String)tiendas.get(2).GetNombre()};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, ListaTienda);
	       
		 this.list.setAdapter(adapter);
		 this.list.setOnItemClickListener(new OnItemClickListener() {
			@Override
				public void onItemClick(AdapterView<?> arg0, View view,	int posicion, long id) {
				
					Intent intent=new Intent(getApplicationContext(), DetalleTiendaActivity.class);
					intent.putExtra("NombreTienda", tiendas.get(posicion).Nombre);
					intent.putExtra("Direccion", tiendas.get(posicion).Direccion);
					intent.putExtra("Telefono", tiendas.get(posicion).Telefono);
					intent.putExtra("Horario", tiendas.get(posicion).Horario);
					intent.putExtra("Website", tiendas.get(posicion).Website);
					intent.putExtra("Email", tiendas.get(posicion).Email);
				    startActivity(intent);
				}
	        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
