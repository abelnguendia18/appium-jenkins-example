import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.By
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.net.URL

class FirstTest {
    lateinit var driver: AppiumDriver
    private var desiredCapabilities = DesiredCapabilities()
    private val appiumServerUrl = "http://localhost:4723/"
    private val appPackage = "com.google.android.calculator"
    private val platform = "Android"
    private val automationName = "UiAutomator2"
    private val appActivity = "com.android.calculator2.Calculator"

    @BeforeTest
    fun setUp() {
        desiredCapabilities.apply {
            setCapability("platformName", platform)
            setCapability("appium:automationName", automationName)
            setCapability("appium:appPackage", appPackage)
            setCapability("appium:appActivity", appActivity)
        }
        driver = AndroidDriver(URL(appiumServerUrl), desiredCapabilities)
    }

    @Test
    fun `Simple multiplication gives correct result`() {
        driver.findElement(By.id(DIGIT_5)).click()
        driver.findElement(By.id(MULTIPLICATION)).click()
        driver.findElement(By.id(DIGIT_8)).click()
        driver.findElement(By.id(EQUAL)).click()
        val result = driver.findElement(By.className("android.widget.TextView")).text
        Assert.assertEquals(result, "40")
    }

    @AfterTest
    fun tearDown() {
        driver.quit()
    }
}