import React from 'react';
import {StyleSheet} from 'react-native';
// @ts-ignore
import RNModal from 'react-native-modal';

export default function Modal({children}): React.ReactElement {
  return (
    <RNModal
      testID={'modal'}
      isVisible
      onSwipeComplete={() => null}
      swipeDirection={['down', 'up']}
      style={styles.view}>
      {children}
    </RNModal>
  );
}

const styles = StyleSheet.create({
  view: {
    justifyContent: 'flex-end',
    margin: 0,
  },
});
