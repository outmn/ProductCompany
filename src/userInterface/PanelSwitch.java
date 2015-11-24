package userInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maximgrozniy on 24.11.15.
 */
public class PanelSwitch implements NextableListener {

        private List<NextableFrame> windows = new ArrayList<NextableFrame>();

        public void addFrame(NextableFrame f) {
            windows.add(f);
            f.addNextableListener(this);
        }

        public void addFrame(int i, NextableFrame f) {
            windows.add(i, f);
            f.addNextableListener(this);
        }

        public void removeFrame(NextableFrame f) {
            int idx = windows.indexOf(f);
            if (idx >= 0) {
                windows.remove(idx).removeNextableListener(this);
            }
        }

        public void show(int idx) {
            for (int i = 0; i < windows.size(); i++) {
                windows.get(i).setVisible(i == idx);
            }
        }

        public void show(NextableFrame frame) {
            for (NextableFrame f : windows) {
                f.setVisible(f == frame);
            }
        }

        public void prevWin(NextableFrame f) {
            int idx = windows.indexOf(f);
            if (idx == 0) {
                show(windows.size() - 1);
            }
            else if (idx > 0) {
                show(--idx);
            }
        }

        public void nextWin(NextableFrame f) {
            int idx = windows.indexOf(f);
            if (idx == windows.size() - 1) {
                show(0);
            }
            else if (idx > -1) {
                show(++idx);
            }
        }
    }

    interface NextableFrame {

        void addNextableListener(NextableListener l);
        void removeNextableListener(NextableListener l);
        NextableListener[] getNextableListeners();

        void setVisible(boolean val);
    }

    interface NextableListener {

        void nextWin(NextableFrame source);
        void prevWin(NextableFrame source);
    }
