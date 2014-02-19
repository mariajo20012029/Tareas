package com.example.mallmj;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.example.mallmj.R;

public class DetalleImagenActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detalleimagenactivity);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detalle_imagen, menu);
		return true;
	}

}
