package com.newsblur.activity;

import android.os.Bundle;

import com.newsblur.database.FeedReadingAdapter;
import com.newsblur.domain.Classifier;
import com.newsblur.domain.Feed;
import com.newsblur.service.NBSyncService;
import com.newsblur.util.FeedUtils;
import com.newsblur.util.UIUtils;

public class FeedReading extends Reading {

    Feed feed;

    @Override
    protected void onCreate(Bundle savedInstanceBundle) {
        feed = (Feed) getIntent().getSerializableExtra(EXTRA_FEED);
        super.onCreate(savedInstanceBundle);

        Classifier classifier = FeedUtils.dbHelper.getClassifierForFeed(feed.feedId);

        UIUtils.setCustomActionBar(this, feed.faviconUrl, feed.title);

        readingAdapter = new FeedReadingAdapter(fragmentManager, feed, classifier, defaultFeedView);

        getLoaderManager().initLoader(0, null, this);
    }

}
