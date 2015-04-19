package io.mocha.sampleapp;

import android.os.Bundle;
import mocha.ui.Application;

public class MainActivity extends mocha.ui.Activity {
	private AppDelegate appDelegate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.appDelegate = new AppDelegate();
		Application.sharedApplication().setDelegate(this.appDelegate);
	}


}
