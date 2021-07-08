package com.bottomsheet;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class Button extends LinearLayout {

    private final ThemedReactContext context;

    public Button(ThemedReactContext context) {
        super(context);
        this.context = context;
    }

    public void onReceiveNativeEvent() {
        WritableMap event = Arguments.createMap();
        ReactContext reactContext = (ReactContext) getContext();
        reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                getId(),
                "topChange",
                event);
    }

    @Override
    public void addView(View child) {
        super.addView(child);
        child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (BSViewManager.isBSOpen()) {
                    context.getJSModule(RCTEventEmitter.class)
                            .receiveEvent(getId(),
                                    "onClick", null);

                }
            }
        });
    }
}
