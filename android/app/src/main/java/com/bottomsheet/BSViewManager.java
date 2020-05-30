package com.bottomsheet;

import android.view.View;
import android.widget.LinearLayout;

import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BSViewManager extends ViewGroupManager<LinearLayout> {

    private final static String REACT_CLASS = "BSBCoordinatorLayoutAndroid";
    private ThemedReactContext context;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public LinearLayout createViewInstance(ThemedReactContext context) {
        this.context = context;
         return (LinearLayout) context.getCurrentActivity().getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);

    }

    @Override
    public void addView(LinearLayout parent, View child, int index) {
        System.out.println("sapdap her");
        BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(context);
        mBottomSheetDialog.setContentView(child);
        mBottomSheetDialog.show();
    }
}