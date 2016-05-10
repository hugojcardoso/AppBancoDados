package com.example.appbancodados;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText edid, edplaca, edmotivo, edpolicial;
	private MultaDao multadao = null;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edid = (EditText) findViewById(R.id.edid);
		edplaca = (EditText) findViewById(R.id.edplaca);
		edmotivo = (EditText) findViewById(R.id.edmotivo);
		edpolicial = (EditText) findViewById(R.id.edpolicial); 
		multadao = new MultaDao(this);
		
	}
	
	public MultaBean getTela(){
		MultaBean multa = new MultaBean();
		multa.setId(new Integer(edid.getText().toString()));
		multa.setPlaca(edplaca.getText().toString());
		multa.setMotivo(edmotivo.getText().toString());
		multa.setPolicial(edpolicial.getText().toString());
		//--
		multa.setLatitude(1.0);
		multa.setLongitude(2.0);
		multa.setPathimagem("teste");
		multa.setDataNotificacao("05/05/2015");
		return multa;
	}
	
	public void setTela(MultaBean multa){
		edid.setTag(multa.getId()+"");
		edplaca.setText(multa.getPlaca());
		edmotivo.setText(multa.getMotivo());
		edpolicial.setText(multa.getPolicial());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void novoClick(View view) {
		
		

	}

	public void alterarClick(View view) {

	}

	public void removerClick(View view) {

	}

	public void consultarClick(View view) {

	}

	public void limparClick(View view) {

	}

	public void sairClick(View view) {

	}

}
