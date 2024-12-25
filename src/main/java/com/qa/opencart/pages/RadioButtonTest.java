package com.qa.opencart.pages;

import com.microsoft.playwright.*;

public class RadioButtonTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the radio button page
            page.navigate("https://practice.expandtesting.com/radio-buttons");

            // Select a radio button by value
            Locator radioButton = page.locator("input[type='radio'][value='blue']");
            //radioButton.check();
            // Check if the radio button is visible and not already selected
            if (radioButton.isVisible() && !radioButton.isChecked()) {
                radioButton.check(); // Select the radio button
                System.out.println("Radio button 'Option 1' is selected.");
            }

            // Verify if the radio button is checked
            if (radioButton.isChecked()) {
                System.out.println("Selection verified for 'Option 1'.");
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Locator anotherRadioButton = page.locator("input[type='radio'][value='football']");
            anotherRadioButton.check();
            System.out.println("Radio button 'Option 2' is selected.");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
