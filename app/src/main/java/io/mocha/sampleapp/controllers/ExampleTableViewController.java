/**
 *	@author Shaun
 *	@date 4/19/15
 *	@copyright 2015 Sample App. All rights reserved.
 */

package io.mocha.sampleapp.controllers;

import io.mocha.sampleapp.views.SimpleTableViewCell;
import mocha.foundation.IndexPath;
import mocha.ui.TableView;
import mocha.ui.TableViewCell;
import mocha.ui.TableViewController;

public class ExampleTableViewController extends TableViewController implements TableView.Delegate.Selection {

	@Override
	protected void viewDidLoad() {
		super.viewDidLoad();

		this.setTitle("Table View");

		this.getTableView().registerCellClass(SimpleTableViewCell.class, SimpleTableViewCell.REUSE_IDENTIFIER);
	}

	@Override
	public int getNumberOfRowsInSection(TableView tableView, int section) {
		return 100;
	}

	@Override
	public TableViewCell getCellForRowAtIndexPath(TableView tableView, IndexPath indexPath) {
		SimpleTableViewCell cell = (SimpleTableViewCell)tableView.dequeueReusableCellWithIdentifier(SimpleTableViewCell.REUSE_IDENTIFIER, indexPath);
		cell.getTextLabel().setText("Row: " + indexPath.row);
		return cell;
	}

	@Override
	public IndexPath willSelectRowAtIndexPath(TableView tableView, IndexPath indexPath) {
		return indexPath;
	}

	@Override
	public void didSelectRowAtIndexPath(TableView tableView, IndexPath indexPath) {
		tableView.deselectRowAtIndexPath(indexPath, true);
	}
}
