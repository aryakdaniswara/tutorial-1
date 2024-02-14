package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.util.List;
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {


    /**
     * The port number assigned to the running application during test execution. 
     * Set automatically during each test run by Spring Framework's test context. 
     * */
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    
    @Test
    void testCreateProduct(ChromeDriver driver) {
        // Navigate to the page
        driver.get(baseUrl + "/product/create");

        // Find the input field and submit button
        WebElement productNameInput = driver.findElement(By.id("nameInput"));
        String name="Gelas";
        productNameInput.sendKeys(name);

        WebElement productQuantityInput = driver.findElement(By.id("quantityInput"));
        String quantity="12";
        productQuantityInput.sendKeys(quantity);

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        // Input the product name and submit the form
        productNameInput.sendKeys("New Product");
        submitButton.click();

        // Verify the new product is in the product list table
        WebElement table = driver.findElement(By.className("table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            if (row.getText().contains("Gelas")) {
                Assertions.assertTrue(row.getText().contains("12"));
                return;
            }
        }
    }

    @AfterEach
    public void tearDown(ChromeDriver driver) {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}