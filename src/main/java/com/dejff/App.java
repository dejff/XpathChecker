package com.dejff;

import java.io.File;

public final class App {

    public static void main(String[] args) {
        Checker c = new Checker();
        c.getNode("/Tutorials/Tutorial", new File("C:\\Workspace\\XpathChecker\\src\\test\\resources\\test.xml"));
    }

}
