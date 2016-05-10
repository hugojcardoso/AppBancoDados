package com.example.appbancodados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ConexaoFactory extends SQLiteOpenHelper {
	private static final String DATABASE = "multas.db";
	private static final int VERSAO = 4;// toda vez que alterar algo no banco ,
										// devera alterar a versão do
										// banco,senão não executara
	private static final String CREATE_TABLE = " CREATE TABLE MULTA("
			+ " _id INTEGER primary key autoincrement,"
			+ " placa TEXT not null," + " motivo TEXT not null,"
			+ " datanotificacao TEXT not null," + " latitude DOUBLE,"
			+ " longitude DOUBLE, " + " imagem TEXT,"
			+ " policial TEXT not null" + ")";

	private boolean criar = false;

	public ConexaoFactory(Context context) {

		super(context, DATABASE, null, VERSAO);
		// TODO Auto-generated constructor stub
	}

	public boolean isCriado() {
		return criar;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		try {
			db.execSQL(CREATE_TABLE);
			Log.i("APPBANCODADOS",
					"ConexaoFactory.java - onCreate() - Tabela Criada ");
			criar = true;
		} catch (Exception ex) {
			Log.e("APPBANCODADOS",
					"ConexaoFactory.java - onCreate()" + ex.getMessage());
			criar = false;
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

		db.execSQL("DROP TABLE IF EXISTS MULTA");
		onCreate(db);
	}

}
