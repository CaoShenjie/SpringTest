package java8.preview;

import java8.preview.Apple;
import java8.preview.AppleFormatter;

public class SimpleApplePrint implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        String weightDes =  apple.getWeight() > 150 ? "weight":"light";
        return "An Apple is "+ weightDes + "!";
    }
}
