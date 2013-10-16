package com.codepath.gridimagesearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

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
		setCurrentOptions();
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
	
	private void setCurrentOptions() {
		OptionSet options = (OptionSet) getIntent().getExtras().get("options");
		if (options != null){
			setSpinnerSelectionByValue(spinnerImageSize, options.getSize());
			setSpinnerSelectionByValue(spinnerColorFilter, options.getColor());
			setSpinnerSelectionByValue(spinnerImageType, options.getType());
			etSiteFilter.setText(options.getFilter());
		}
	}
	
	private void setSpinnerSelectionByValue(Spinner spinner, String value)
	{
		ArrayAdapter<String> adap = (ArrayAdapter<String>) spinner.getAdapter();
		int spinnerPosition = adap.getPosition(value);
		spinner.setSelection(spinnerPosition);
	}
	
	public void onSave(View v) {
		//prepare data intent to send back to SearchActivity
		String size = spinnerImageSize.getSelectedItem().toString();
		String color = spinnerColorFilter.getSelectedItem().toString();
		String type = spinnerImageType.getSelectedItem().toString();
		String site = etSiteFilter.getText().toString();
		OptionSet options = new OptionSet(size, color, type, site);
		
		Intent data = new Intent();
		data.putExtra("options", options);
		setResult(RESULT_OK, data);
		finish();
	}

}
