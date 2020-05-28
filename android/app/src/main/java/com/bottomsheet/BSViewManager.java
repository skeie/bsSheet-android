package com.bottomsheet;

import android.view.View;
import android.widget.LinearLayout;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BSViewManager extends ViewGroupManager<CoordinatorLayout> {

    private final static String REACT_CLASS = "BSBCoordinatorLayoutAndroid";
    private ThemedReactContext context;
    private CoordinatorLayout bottomsheet;
    private CoordinatorLayout container;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public CoordinatorLayout createViewInstance(ThemedReactContext context) {
        this.context = context;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) context.getCurrentActivity().getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);
        bottomsheet = coordinatorLayout.findViewById(R.id.bottomSheet);
        container = coordinatorLayout.findViewById(R.id.container);
        return coordinatorLayout;

    }

    @Override
    public void addView(CoordinatorLayout parent, View child, int index) {
        if (container.getChildCount() + bottomsheet.getChildCount() > 1) {
            container.removeAllViews();
            bottomsheet.removeAllViews();
        }
        if(index ==  0) {
            container.addView(child);
        } else {
            bottomsheet.addView(child);
        }

    }
}