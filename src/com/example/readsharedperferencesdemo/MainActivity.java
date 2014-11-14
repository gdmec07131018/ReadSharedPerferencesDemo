package com.example.readsharedperferencesdemo;

import java.io.FileInputStream;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText et1, et2, et3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et1 = (EditText) findViewById(R.id.et1);
		et2 = (EditText) findViewById(R.id.et2);
		et3 = (EditText) findViewById(R.id.et3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void Read(View view){
		Context  context = null;
		try {
			context = createPackageContext("cn.edu.gdmec.s0713108.sharedperferencesdemo",CONTEXT_RESTRICTED);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SharedPreferences sharedPreferences = context.getSharedPreferences("public",
				Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);
		String name = sharedPreferences.getString("name", "soul");
		int age = sharedPreferences.getInt("age",30);
		float height = sharedPreferences.getFloat("height", 1.8f);
		et1.setText(name);
		et2.setText(String.valueOf(age));
		et3.setText(String.valueOf(height));
	} 
}
