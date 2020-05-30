import shiftUtil from '../nativeModules/shiftUtil';

const INTERVAL_EVENT_NAME = 'shift-interval';

export function waitSeconds(seconds: number): Promise<void> {
  return shiftUtil.waitSeconds(seconds);
}

interface Callback {
  [id: number]: {
    id: number;
    cb: () => any;
  };
}

class Button {
  idCounter = 0;
  callbacks: Callback = {};

  constructor() {
    shiftUtil.addListener<number>(
      INTERVAL_EVENT_NAME,
      (data: number | {id: number}) => {
        let id = data as number;
        if (typeof data !== 'number') {
          id = data.id;
        }

        this.cb(id);
      },
    );
  }

  add = (ms: number, cb: () => any) => {
    const newIdCounter = this.idCounter + 1;
    this.callbacks[newIdCounter] = {
      id: newIdCounter,
      cb,
    };
    shiftUtil.setInterval(ms, INTERVAL_EVENT_NAME, newIdCounter);
    return () => {
      delete this.callbacks[newIdCounter];
      this.remove(newIdCounter);
    };
  };

  remove = (id: number) => {
    shiftUtil.clearIntervalById(id);
  };

  private cb = (id: number) => {
    if (this.callbacks[id]) {
      const callbackById = this.callbacks[id];
      const {cb} = callbackById;
      cb();
    } else {
      delete this.callbacks[id];
    }
  };
}

const button = new Button();

export default button;
