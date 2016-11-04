package main.java;

import java.util.Scanner;

/**
 * Copy-class of Scanner.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 04.11.2016
 */
// in test - ScannerMock extend ScannerAdapter.
public class ScannerAdapter {
    Scanner in;

    public ScannerAdapter(Scanner in) {
        this.in = in;
    }
    public ScannerAdapter(){

    }

    public double nextDouble() {
        return in.nextDouble();
    }

    public String next() {
        return in.next();
    }
}
