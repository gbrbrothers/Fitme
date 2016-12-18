package com.gbrbrothers.fitme2;

import android.graphics.drawable.Drawable;

import java.text.Collator;
import java.util.Comparator;

/**
 * Created by TK on 2016-12-18.
 */

public class ListData {

    public Drawable mImage;
    public String mName;
    public String mLocation;

    public static final Comparator<ListData> ALPHA_COMPARATOR = new Comparator<ListData>() {
        private final Collator sCollator = Collator.getInstance();

        @Override
        public int compare(ListData mListData_1, ListData mListDate_2) {
            return sCollator.compare(mListData_1.mName, mListDate_2.mName);
        }
    };
}
