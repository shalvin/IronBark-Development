package com.studentsaleapp.activities;

import com.studentsaleapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class SingleBuyListItemActivity extends Activity {
	
	/** The image integer */
	private int images;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_single_buy_list_item);

		// Storing properties to variables
		TextView txtProduct = (TextView) findViewById(R.id.product_label);
		TextView txtDesc = (TextView) findViewById(R.id.singleItemDescription); 
		TextView txtPrice = (TextView) findViewById(R.id.singleItemPrice); 
		TextView txtContact = (TextView) findViewById(R.id.singleItemPhoneNo);
		TextView txtLocation = (TextView) findViewById(R.id.singleItemLocation);
		ImageView picImages = (ImageView) findViewById(R.id.imageView1);
		Intent i = getIntent();

		// Getting attached intent data
		String product = i.getStringExtra("product");
		String desc = i.getStringExtra("desc");
		String price = i.getStringExtra("price");
		String contact = i.getStringExtra("contact");
		String location = i.getStringExtra("location");
		images = i.getExtras().getInt("iconimages");

		// Displaying selected product name
		txtProduct.setText(product);
		txtDesc.setText(desc);
		txtPrice.setText(price);
		txtContact.setText(contact);
		txtLocation.setText(location);
		picImages.setImageResource(images);

		// Show the Up button in the action bar.
		setupActionBar();
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.buy_options_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				NavUtils.navigateUpFromSameTask(this);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
