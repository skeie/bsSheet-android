import React, {useEffect} from 'react';
import {
  requireNativeComponent,
  NativeEventEmitter,
  NativeModules,
} from 'react-native';

export type BottomSheetState = 'collapsed' | 'expanded';

const {AndroidButton} = NativeModules;

const eventEmitter = new NativeEventEmitter(AndroidButton);

interface Props {
  sheetState?: BottomSheetState;
  onSheetStateChanged?: (newState: BottomSheetState) => void;

  style?: object;
  children?: object;
}

const BottomSheet = ({children}: Props) => {
  function onClick() {
    console.log('sapdap migc');
  }

  React.useEffect(() => {
    eventEmitter.addListener('sapdap', () => {
      console.log('sapdap sap i listner');
    });
  });

  return <Button children={children} onClick={onClick} />;
};
const Button = requireNativeComponent('AndroidButton');

export default BottomSheet;
