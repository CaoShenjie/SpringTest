package java8.preview;

import java8.preview.Apple;
import java8.preview.AppleFormatter;

public class ComplexApplePrint implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String colorDes = apple.getColor().equals("green") ? "green" : "yellow";
        String weightDes =  apple.getWeight() > 150 ? "weight" : "light";
        return "An apple is " + colorDes +" "+ weightDes + "!";
    }
}
