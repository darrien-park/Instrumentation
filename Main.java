package com.company;

public class Main {

    public static void main(String[] args) {
        Instrumentation ins = Instrumentation.Instance();
        ins.activate(true);
        ins.startTiming("main");
        ins.startTiming("loop");
        for (int i = 0; i < 100000; i++){
            int j = i;
        }
        ins.comment("This is an example of a comment!");
        ins.startTiming("loop 2");
        for (int i = 0; i < 100000; i++){
            int j = i;
        }
        ins.stopTiming("loop 2");
        ins.stopTiming("loop");

        ins.startTiming("loop 3");
        for (int i = 0; i < 100000; i++){
            int j = i;
        }
        ins.stopTiming("loop 3");
        ins.comment("This is another example of a comment!");
        ins.stopTiming("main");
        ins.dump("output.txt");
    }
}