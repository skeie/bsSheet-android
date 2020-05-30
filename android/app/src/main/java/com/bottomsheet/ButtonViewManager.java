package com.bottomsheet;

import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Map;

public class ButtonViewManager extends ViewGroupManager<Button> {

    private final static String REACT_CLASS = "AndroidButton";
    private ThemedReactContext context;
    private LinearLayout buttonContainer;
    private String buttonId;
    private int id;

    @Override
    public String getName() {
        return REACT_CLASS;
    }


    @Nullable
    @Override
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.<String, Object>builder()
                .put("onClick",
                        MapBuilder.of("registrationName", "onClick"))
                .build();
    }

    @Override
    public void onDropViewInstance(Button view) {
        super.onDropViewInstance(view);
        // on unmount
    }



    @Override
    public Button createViewInstance(ThemedReactContext context) {
        return new Button(context);
    }

    @Override
    public void addView(Button parent, View child, int index) {
        parent.addView(child);
    }

}