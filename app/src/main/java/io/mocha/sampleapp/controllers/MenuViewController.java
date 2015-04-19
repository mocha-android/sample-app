package io.mocha.sampleapp.controllers;

import io.mocha.sampleapp.views.SimpleTableViewCell;
import mocha.foundation.IndexPath;
import mocha.ui.*;
import io.mocha.sampleapp.R;

public class MenuViewController extends TableViewController implements TableView.Delegate.Selection {

	@Override
	protected void viewDidLoad() {
		super.viewDidLoad();

		this.setTitle(Application.sharedApplication().getContext().getString(R.string.app_name));

		this.getTableView().registerCellClass(SimpleTableViewCell.class, SimpleTableViewCell.REUSE_IDENTIFIER);

		this.getNavigationItem().setRightBarButtonItem(new BarButtonItem(BarButtonItem.SystemItem.MORE, new BarButtonItem.Action() {
			@Override
			public void action(BarButtonItem barButtonItem, Event event) {
				AlertView alertView = new AlertView("Alert", "Testing", null, "OK");
				alertView.setAppearance(AlertView.Appearance.LIGHT);
				alertView.show();
			}
		}));
	}

	@Override
	public int getNumberOfSections(TableView tableView) {
		return 1;
	}

	@Override
	public int getNumberOfRowsInSection(TableView tableView, int section) {
		return 3;
	}

	@Override
	public TableViewCell getCellForRowAtIndexPath(TableView tableView, IndexPath indexPath) {
		SimpleTableViewCell cell = (SimpleTableViewCell)tableView.dequeueReusableCellWithIdentifier(SimpleTableViewCell.REUSE_IDENTIFIER, indexPath);


		if(indexPath.row == 0) {
			cell.getTextLabel().setText("Table View");
		} else if(indexPath.row == 1) {
			cell.getTextLabel().setText("Collection View");
		} else {
			cell.getTextLabel().setText("Paged Collection View");
		}

		return cell;
	}

	@Override
	public IndexPath willSelectRowAtIndexPath(TableView tableView, IndexPath indexPath) {
		return indexPath;
	}

	@Override
	public void didSelectRowAtIndexPath(TableView tableView, IndexPath indexPath) {
		if(indexPath.row == 0) {
			this.getNavigationController().pushViewController(new ExampleTableViewController(), true);
		} else if(indexPath.row == 1) {
			this.getNavigationController().pushViewController(new ExampleCollectionViewController(), true);
		} else {
			this.getNavigationController().pushViewController(new ExamplePagedCollectionViewController(), true);
		}
	}
}
