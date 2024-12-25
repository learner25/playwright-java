package com.qa.opencart.pages;



import com.microsoft.playwright.*;

public class MultiTabTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Navigate to the target URL
            page.navigate("https://demo.automationtesting.in/Windows.html");

            // Click the tab with text: "Open New Seperate Windows"
            // page.locator("a:has-text('Open New Seperate Windows')").click();
            //*[@id="Seperate"]/button
            // Wait for the button to appear and click it to open a new window
            //
            Locator newWindowButton = page.locator("//a[text()='Open New Tabbed Windows ']");
            newWindowButton.click();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Locator clickButton = page.locator("//*[@id=\"Tabbed\"]/a/button");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clickButton.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Wait for the new window to open
            BrowserContext context = browser.contexts().get(0);
            Page newPage = context.waitForPage(() -> {
                System.out.println("Waiting for new window...");
            });

            // Interact with the new window (e.g., get its title)
            String newPageTitle = newPage.title();
            System.out.println("New window title: " + newPageTitle);

            // Close the new window
            newPage.close();

            // Verify you're back to the original page
            System.out.println("Original page title: " + page.title());

            // Close the browser
            browser.close();
        }
    }
}
