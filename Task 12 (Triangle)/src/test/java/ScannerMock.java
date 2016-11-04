package test.java;

import main.java.ScannerAdapter;

public class ScannerMock extends ScannerAdapter {
    double entered;
    ScannerAdapter scanner;

    public ScannerMock(double entered) {
        this.entered = entered;
    }

    public double nextDouble() {
        return entered;
    }
}
