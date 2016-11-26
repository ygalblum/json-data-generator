/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.data.json.generator.types;

/**
 *
 * @author ygalblum
 */
public class RandomIncrementLongType extends TypeHandler {
    public static final String TYPE_NAME = "randomIncrementLong";
    public static final String TYPE_DISPLAY_NAME = "Random Increment Long";

    private long nextValue;
    private long minStep;
    private long maxStep;
    
    @Override
    public void setLaunchArguments(String[] launchArguments) {
        super.setLaunchArguments(launchArguments);
        switch (launchArguments.length) {
            case 0:
                nextValue = 0;
                minStep = 0;
                maxStep = Long.MAX_VALUE;
                break;
            case 1:
                nextValue = Long.parseLong(launchArguments[0]);
                minStep = 0;
                maxStep = Long.MAX_VALUE;
                break;
            case 2:
                nextValue = Long.parseLong(launchArguments[0]);
                minStep = Long.parseLong(launchArguments[1]);
                maxStep = Long.MAX_VALUE;
                break;
            case 3:
                nextValue = Long.parseLong(launchArguments[0]);
                minStep = Long.parseLong(launchArguments[1]);
                maxStep = Long.parseLong(launchArguments[2]);
                break;
            default:
                break;
        }
    }
    
    @Override
    public Object getNextRandomValue() {
        long value = nextValue;
        nextValue += getRand().nextLong(minStep, maxStep);
        return value;
    }

    @Override
    public String getName() {
        return TYPE_NAME;
    } 
}
