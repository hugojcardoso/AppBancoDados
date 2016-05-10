package com.example.appbancodados;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MultaDao {

	private SQLiteOpenHelper conexao = null;

	public MultaDao(Context ctx) {
		conexao = new ConexaoFactory(ctx);
	}

	private ContentValues toContent(MultaBean multa) {
		ContentValues values = new ContentValues();
		values.put("placa", multa.getPlaca());
		values.put("motivo", multa.getMotivo());
		values.put("policial", multa.getPolicial());
		values.put("datanotificacao", multa.getDataNotificacao());
		values.put("imagem", multa.getPathimagem());
		values.put("latitude", multa.getLatitude());
		values.put("longitude", multa.getLongitude());
		return values;
	}

	public boolean inserir(MultaBean multa) {
		SQLiteDatabase db = conexao.getWritableDatabase();
		try {

			ContentValues values = toContent(multa);
			db.insert("multa", null, values);
			showInfo("Multa cadastrada com exito!");
			return true;

		} catch (Exception ex) {
			showErro(ex.getMessage());
			return false;
		} finally {
			if (db != null)
				db.close();
		}

	}
	
	public boolean alterar(MultaBean multa) {
		SQLiteDatabase db = conexao.getWritableDatabase();
		try {

			ContentValues values = toContent(multa);
			db.update("multa", values, "_id= ", new String[]{multa.getId().toString()});
			showInfo("Multa alterada com exito!");
			return true;

		} catch (Exception ex) {
			showErro(ex.getMessage());
			return false;
		} finally {
			if (db != null)
				db.close();
		}

	}
	
	public boolean remover(Integer id) {
		SQLiteDatabase db = conexao.getWritableDatabase();
		try {

			db.delete("multa", "_id= ", new String[]{id.toString()} );
			showInfo("Multa removida com exito!");
			return true;

		} catch (Exception ex) {
			showErro(ex.getMessage());
			return false;
		} finally {
			if (db != null)
				db.close();
		}

	}
	
	public ArrayList<MultaBean> getMultas(String condicao){
		SQLiteDatabase db = conexao.getWritableDatabase();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from multa");
		if(condicao != null){
			sb.append(" where");
			sb.append(condicao);
		}
		
		Cursor rs = db.rawQuery(sb.toString(), null);
		ArrayList<MultaBean> todos = new ArrayList<MultaBean>();
		while (rs.moveToNext()){
			MultaBean multa = new MultaBean();
			multa.setId(new Integer(rs.getString(0)));
			multa.setPlaca(rs.getString(1));
			multa.setMotivo(rs.getString(2));
			multa.setDataNotificacao(rs.getString(3));
			multa.setLatitude(new Double(rs.getString(4)));
			multa.setLongitude(new Double(rs.getString(5)));
			multa.setPathimagem(rs.getString(6));
			multa.setPolicial(rs.getString(7));
			todos.add(multa);
		}
		if(db != null)db.close();
		return todos;
	}
	
	private void showInfo(String mens){
		Log.i("APPBANCODADOS",mens);
		
	}
	private void showErro(String mens){
		Log.e("APPBANCODADOS",mens);
		
	}
	
	

}
