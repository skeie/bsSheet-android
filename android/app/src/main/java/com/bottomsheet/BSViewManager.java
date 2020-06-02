package com.bottomsheet;

import android.content.DialogInterface;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BSViewManager extends ViewGroupManager<LinearLayout> {

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
    public LinearLayout createViewInstance(ThemedReactContext context) {
        this.context = context;
        mBottomSheetDialog = new BottomSheetDialog(context);
        mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                System.out.println("sapdap drag down");
            }
        });
         return (LinearLayout) context.getCurrentActivity().getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);

    }


    @Override
    public void addView(LinearLayout parent, View child, int index) {
        mBottomSheetDialog.setContentView(child);
        mBottomSheetDialog.show();
    }
}