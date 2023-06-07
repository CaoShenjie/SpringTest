package java8.preview;

import java8.preview.Apple;

@FunctionalInterface
public interface AppleFormatter {
    String accept(Apple apple);
}
