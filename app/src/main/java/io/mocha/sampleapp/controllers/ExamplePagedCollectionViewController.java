/**
 *	@author Shaun
 *	@date 4/19/15
 *	@copyright 2015 Sample App. All rights reserved.
 */

package io.mocha.sampleapp.controllers;

import io.mocha.sampleapp.views.SimpleCollectionViewCell;
import mocha.foundation.IndexPath;
import mocha.graphics.Rect;
import mocha.graphics.Size;
import mocha.ui.EdgeInsets;
import mocha.ui.collectionview.*;

public class ExamplePagedCollectionViewController extends CollectionViewController {
	private final static float INSET = 16;
	private final Size lastSize = Size.zero();

	public ExamplePagedCollectionViewController() {
		super(new CollectionViewFlowLayout());

		this.setTitle("Paged Collection View");
	}

	@Override
	protected void viewDidLoad() {
		super.viewDidLoad();

		CollectionViewFlowLayout layout = (CollectionViewFlowLayout)this.getCollectionViewLayout();
		layout.setSectionInset(new EdgeInsets(INSET, -INSET, INSET, INSET));
		layout.setMinimumInteritemSpacing(0);
		layout.setMinimumLineSpacing(INSET * 2);
		layout.setScrollDirection(CollectionViewFlowLayout.ScrollDirection.HORIZONTAL);

		this.getCollectionView().setPagingEnabled(true);
		this.getCollectionView().registerClassForCellWithReuseIdentifier(SimpleCollectionViewCell.class, SimpleCollectionViewCell.REUSE_IDENTIFIER);

		this.updateLayout(this.getView().getBoundsSize());
	}

	@Override
	public void viewWillLayoutSubviews() {
		super.viewWillLayoutSubviews();

		Size size = this.getView().getBoundsSize();

		if(!this.lastSize.equals(size)) {
			this.updateLayout(size);
		}
	}

	private void updateLayout(Size size) {
		CollectionViewFlowLayout layout = (CollectionViewFlowLayout)this.getCollectionViewLayout();
		layout.setItemSize(new Size(size.width - (INSET * 2), size.height - (INSET * 2)));
		this.lastSize.set(size);
		this.getCollectionView().invalidateLayout();
	}

	@Override
	public int collectionViewNumberOfItemsInSection(CollectionView collectionView, int section) {
		return 10;
	}

	@Override
	public CollectionViewCell collectionViewCellForItemAtIndexPath(CollectionView collectionView, IndexPath indexPath) {
		SimpleCollectionViewCell cell = (SimpleCollectionViewCell)collectionView.dequeueReusableCellWithReuseIdentifierForIndexPath(SimpleCollectionViewCell.REUSE_IDENTIFIER, indexPath);
		cell.getTextLabel().setText("Page " + (indexPath.item + 1));
		return cell;
	}

}
