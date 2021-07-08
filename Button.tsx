import React, {useEffect} from 'react';
import {
  requireNativeComponent,
  NativeEventEmitter,
  NativeModules,
  TouchableOpacity,
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

  return (
    <TouchableOpacity
      onPress={() => {
        console.log('sapdap js side touch');
      }}>
      <Button children={children} onClick={onClick} />
    </TouchableOpacity>
  );
};
const Button = requireNativeComponent('AndroidButton');

export default BottomSheet;
