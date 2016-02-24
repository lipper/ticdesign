package com.mobvoi.design.demo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import com.ticwear.design.demo.R;
import com.mobvoi.design.demo.fragments.DialogsFragment;
import com.mobvoi.design.demo.fragments.TransitionsFragment;

/**
 * Created by tankery on 1/12/16.
 *
 * Activity for details.
 */
public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Fragment detailFragment;
        switch (getIntent().getIntExtra("case", -1)) {
            case R.string.category_dialog_title:
                detailFragment = new DialogsFragment();
                break;
            case R.string.category_widgets_title:
                detailFragment = null;
                break;
            case R.string.category_showcase_title:
                detailFragment = new TransitionsFragment();
                break;
            default:
                detailFragment = null;
                break;
        }

        if (detailFragment != null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, detailFragment)
                    .commitAllowingStateLoss();
        } else {
            finish();
        }
    }

}