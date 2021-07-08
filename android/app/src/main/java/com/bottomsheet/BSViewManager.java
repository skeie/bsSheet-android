package com.bottomsheet;

import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BSViewManager extends ViewGroupManager<CoordinatorLayout> {

    private final static String REACT_CLASS = "BSBCoordinatorLayoutAndroid";
    private ThemedReactContext context;
    public static BottomSheetDialog mBottomSheetDialog;

    public static boolean isBSOpen() {
        return mBottomSheetDialog.isShowing();
    }


    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public CoordinatorLayout createViewInstance(ThemedReactContext context) {
        this.context = context;
        mBottomSheetDialog = new BottomSheetDialog(context);
        mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                System.out.println("sapdap drag down");
            }
        });
        return (CoordinatorLayout) context.getCurrentActivity().getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);
    }


    @Override
    public void addView(CoordinatorLayout parent, View child, int index) {
        mBottomSheetDialog.setContentView(child);
        mBottomSheetDialog.show();
        BottomSheetBehavior mBehavior = BottomSheetBehavior.from((View) child.getParent());

        mBehavior.setPeekHeight(200);
    }
}