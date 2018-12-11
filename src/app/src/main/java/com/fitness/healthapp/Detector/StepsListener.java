package com.fitness.healthapp.Detector;

public class StepsListener {

    // Will listen to step alerts
    public interface StepListener {

        void step(long timeNs);

    }
}
