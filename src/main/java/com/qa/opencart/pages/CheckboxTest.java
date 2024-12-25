package com.qa.opencart.pages;

import com.microsoft.playwright.*;

public class CheckboxTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the page with checkboxes
            page.navigate("https://practice.expandtesting.com/checkboxes");

            // Locate the first checkbox (e.g., Checkbox 1)
            Locator checkbox1 = page.locator("//*[@id=\"checkbox1\"]");

            // Check the checkbox if it's not already checked
            if (!checkbox1.isChecked()) {
                checkbox1.check();
                System.out.println("Checkbox 1 is checked.");
            }

            // Verify that the checkbox is selected
            if (checkbox1.isChecked()) {
               // checkbox1.uncheck();
                System.out.println("Checkbox 1 selection verified.");
            }

            // Locate the second checkbox (e.g., Checkbox 2)
            Locator checkbox2 = page.locator("//*[@id=\"checkbox2\"]");

            // Uncheck the checkbox if it's already checked
            if (checkbox2.isChecked()) {
                checkbox2.uncheck();
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                checkbox2.check();
                System.out.println("Checkbox 2 is checked.");
            }

            // Verify that the checkbox is unselected
            if (checkbox2.isChecked()) {
                System.out.println("Checkbox 2  selection verified.");
            }
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Close the browser
            browser.close();
        }
    }
}
