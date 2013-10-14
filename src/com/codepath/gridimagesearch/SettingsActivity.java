package com.codepath.gridimagesearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class SettingsActivity extends Activity {
	private Spinner spinnerImageSize;
	private Spinner spinnerColorFilter;
	private Spinner spinnerImageType;
	private EditText etSiteFilter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		setupViews();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}
	
	private void setupViews() {
		spinnerImageSize = (Spinner) findViewById(R.id.spinnerImageSize);
		spinnerColorFilter = (Spinner) findViewById(R.id.spinnerColorFilter);
		spinnerImageType = (Spinner) findViewById(R.id.spinnerImageType);
		etSiteFilter = (EditText) findViewById(R.id.etSiteFilter);
	}
	
	public void onSave(View v) {
		//prepare data intent to send back to SearchActivity
		Intent data = new Intent();
		this.finish();
	}

}
