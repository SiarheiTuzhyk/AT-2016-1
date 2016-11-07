package test.java;

import main.java.ScannerAdapter;

public class ScannerMock extends ScannerAdapter {
    String entered;

    public ScannerMock(String entered) {
        this.entered = entered;
    }

    public String next() {
        return entered;
    }
}
