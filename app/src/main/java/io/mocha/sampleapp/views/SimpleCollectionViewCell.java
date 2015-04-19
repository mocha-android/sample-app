/**
 *	    @author Shaun
 *	@date 4/19/15
 *	@copyright 2015 Sample App. All rights reserved.
 */

package io.mocha.sampleapp.views;

import mocha.graphics.Rect;
import mocha.graphics.TextAlignment;
import mocha.ui.Color;
import mocha.ui.Label;
import mocha.ui.collectionview.CollectionViewCell;

public class SimpleCollectionViewCell extends CollectionViewCell {
	public static final String REUSE_IDENTIFIER = "SimpleCollectionViewCell";
	private Label textLabel;

	public SimpleCollectionViewCell(Rect frame) {
		super(frame);

		this.getContentView().setBackgroundColor(Color.white(0.8f, 1.0f));

		this.textLabel = new Label(this.getContentView().getBounds());
		this.textLabel.setAutoresizing(Autoresizing.FLEXIBLE_SIZE);
		this.textLabel.setTextAlignment(TextAlignment.CENTER);
		this.getContentView().addSubview(this.textLabel);
	}

	public Label getTextLabel() {
		return this.textLabel;
	}
	
}
