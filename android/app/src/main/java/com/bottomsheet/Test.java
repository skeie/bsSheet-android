package com.bottomsheet;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class Test extends LinearLayout {
    private final LinearLayout buttonContainer;

    public Test(ThemedReactContext context) {
        super(context);
        LinearLayout layout = (LinearLayout) context.getCurrentActivity().getLayoutInflater().inflate(R.layout.button, null);
        buttonContainer = layout.findViewById(R.id.buttonContent);
        System.out.println("hva faen sapdap" + buttonContainer);
        buttonContainer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("sapdap");
            }
        });
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
        System.out.println(child.getId() + " neivel sapdap ");
        buttonContainer.addView(child);
    }
}
