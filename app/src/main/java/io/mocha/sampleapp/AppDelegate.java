package io.mocha.sampleapp;

import android.net.Uri;
import io.mocha.sampleapp.controllers.MenuViewController;
import mocha.ui.Application;
import mocha.ui.NavigationController;
import mocha.ui.Window;

import java.util.Map;

public class AppDelegate implements Application.Delegate {
	private Window window;

	@Override
	public boolean didFinishLaunchingWithOptions(Application application, Map<String, Object> options) {

		NavigationController navigationController = new NavigationController(new MenuViewController());
//		navigationController.getNavigationBar().setBarTintColor(0xff00a580);

		this.window = new Window(application);
//		this.window.setTintColor(0xff114e40);
		this.window.setRootViewController(navigationController);
		this.window.makeKeyAndVisible();

		return true;
	}

	@Override
	public boolean handleOpenUri(Application application, Uri uri, String sourceApplication, Object annotation) {
		return false;
	}

}
