package com.qa.opencart.pages;

import com.microsoft.playwright.*;

public class DropDownTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the page with the dropdown menu
            page.navigate("https://practice.expandtesting.com/dropdown");

            // Wait for the dropdown to appear
            Locator dropdown = page.locator("select#dropdown");

            // Select an option by value
            dropdown.selectOption("2");
            System.out.println("Option 2 is selected.");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Verify the selection
            String selectedValue = dropdown.inputValue();
            if ("2".equals(selectedValue)) {
                System.out.println("Selection verified: Option 2.");
            } else {
                System.out.println("Selection verification failed.");
            }
            Locator dropdown2 = page.locator("select#elementsPerPageSelect");

            // Select an option by value
            dropdown2.selectOption("20");
            System.out.println("Option 2 is selected.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Verify the selection
            String selectedValue2 = dropdown2.inputValue();
            if ("20".equals(selectedValue2)) {
                System.out.println("Selection verified: Option 20.");
            } else {
                System.out.println("Selection verification failed.");
            }
            // Close the browser

            Locator dropdown3 = page.locator("select#country");

            // Select an option by value
            dropdown3.selectOption("BD");
            System.out.println("BD is selected.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String selectedValue3 = dropdown3.inputValue();
            if ("BD".equals(selectedValue3)) {
                System.out.println("Selection verified: Option BD.");
            } else {
                System.out.println("Selection verification failed.");
            }

            browser.close();
        }
    }
}
