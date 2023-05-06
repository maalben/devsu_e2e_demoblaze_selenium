package com.devsu.demoblaze.util;


import org.openqa.selenium.*;

import java.util.*;
import static java.lang.Thread.sleep;

public class Utilities {

    public static void waitOwn(int seconds){
        long time = seconds * 1000L;
        try {
            sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int totalValuesList(List<Integer> listPriceSelected){
        int sum = 0;

        for (Integer price : listPriceSelected) {
            sum += price;
        }

        return sum;
    }

    public static void moveScreen(WebDriver driver, String direction){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        switch (direction){
            case "up":
                js.executeScript("javascript:window.scrollTo(0,document.body.scrollHeight)");
                break;

            case "down":
                js.executeScript("javascript:window.scrollBy(0,document.body.scrollTop)");
                break;
        }
    }

}
