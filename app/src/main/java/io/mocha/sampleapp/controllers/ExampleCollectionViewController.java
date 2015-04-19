/**
 *	@author Shaun
 *	@date 4/19/15
 *	@copyright 2015 Sample App. All rights reserved.
 */

package io.mocha.sampleapp.controllers;

import io.mocha.sampleapp.views.SimpleCollectionViewCell;
import mocha.foundation.IndexPath;
import mocha.graphics.Size;
import mocha.ui.BarButtonItem;
import mocha.ui.EdgeInsets;
import mocha.ui.Event;
import mocha.ui.collectionview.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExampleCollectionViewController extends CollectionViewController implements CollectionViewFlowLayout.Delegate {
	private final Random random = new Random();
	private List<Size> sizes = new ArrayList<>();

	public ExampleCollectionViewController() {
		super(new CollectionViewFlowLayout());

		this.setTitle("Collection View");

		this.getNavigationItem().setRightBarButtonItem(new BarButtonItem(BarButtonItem.SystemItem.REFRESH, new BarButtonItem.Action() {
			@Override
			public void action(BarButtonItem barButtonItem, Event event) {
				randomizeSizes();
			}
		}));
	}

	@Override
	protected void viewDidLoad() {
		super.viewDidLoad();

		this.getCollectionView().registerClassForCellWithReuseIdentifier(SimpleCollectionViewCell.class, SimpleCollectionViewCell.REUSE_IDENTIFIER);

		CollectionViewFlowLayout layout = (CollectionViewFlowLayout)this.getCollectionViewLayout();
		layout.setSectionInset(new EdgeInsets(16, 16, 16, 16));

		this.randomizeSizes();
	}

	@Override
	public int collectionViewNumberOfItemsInSection(CollectionView collectionView, int section) {
		return this.sizes.size();
	}

	@Override
	public CollectionViewCell collectionViewCellForItemAtIndexPath(CollectionView collectionView, IndexPath indexPath) {
		SimpleCollectionViewCell cell = (SimpleCollectionViewCell)collectionView.dequeueReusableCellWithReuseIdentifierForIndexPath(SimpleCollectionViewCell.REUSE_IDENTIFIER, indexPath);
		cell.getTextLabel().setText(String.valueOf(indexPath.item));
		return cell;
	}

	public Size collectionViewLayoutSizeForItemAtIndexPath(CollectionView collectionView, CollectionViewLayout collectionViewLayout, IndexPath indexPath) {
		return this.sizes.get(indexPath.item);
	}

	private void randomizeSizes() {
		this.sizes.clear();

		int numberOfItems = this.randomInt(90, 120);

		for(int i = 0; i < numberOfItems; i++) {
			this.sizes.add(new Size(this.randomFloat(30.0f, 70.0f), this.randomFloat(30.0f, 70.0f)));
		}

		this.getCollectionView().invalidateLayout();
	}

	private float randomFloat(float min, float max) {
		return this.random.nextInt(((int)max - (int)min) + 1) + min;
	}

	private int randomInt(int min, int max) {
		return this.random.nextInt((max - min) + 1) + min;
	}

}
