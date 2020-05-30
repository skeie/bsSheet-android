package com.bottomsheet;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.image.ReactImageView;

import java.util.Map;

import static java.security.AccessController.getContext;

public class ButtonViewManager extends ViewGroupManager<LinearLayout> {

    private final static String REACT_CLASS = "AndroidButton";
    private ThemedReactContext context;
    private LinearLayout buttonContainer;
    private String buttonId;
    private int id;

    @Override
    public String getName() {
        return REACT_CLASS;
    }


    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.<String, Object>builder()
                .put("onClick",
                        MapBuilder.of("registrationName", "onClick"))
                .build();
    }

    private int getId() {
        System.out.println("sapdap id " + this.id);
        return this.id;
    }


    @Override
    public void onDropViewInstance(LinearLayout view) {
        super.onDropViewInstance(view);
        // on unmount
    }



    @Override
    public LinearLayout createViewInstance(ThemedReactContext context) {
        this.context = context;
        LinearLayout layout = (LinearLayout) context.getCurrentActivity().getLayoutInflater().inflate(R.layout.button, null);
        buttonContainer = layout.findViewById(R.id.buttonContent);
        System.out.println("sapdap " + buttonContainer);
        buttonContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.getJSModule(RCTEventEmitter.class)
                        .receiveEvent(getId(),
                                "onClick", null);
                WritableMap params = Arguments.createMap();
                System.out.println("sapdap click");
                context
                            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                            .emit("sapdap", params);
            }
        });
        return layout;

    }

    @Override
    public void addView(LinearLayout parent, View child, int index) {
        System.out.println("sapdap childcount " + buttonContainer.getChildCount());
            buttonContainer.removeAllViews();
        this.id = child.getId();
        buttonContainer.addView(child);
    }
}