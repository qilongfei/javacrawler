import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 功能1测试
 * @author holysky.zhao 2017/7/27 11:13
 * @version 1.0.0
 */
public class Utils {

    public static PhantomJSDriver getPhantomJSDriver() {
        //设置必要参数
        DesiredCapabilities dcaps = new DesiredCapabilities();
        //ssl证书支持
        dcaps.setCapability("acceptSslCerts", true);
        //截屏支持
        dcaps.setCapability("takesScreenshot", true);
        //css搜索支持
        dcaps.setCapability("cssSelectorsEnabled", true);
        //js支持
        dcaps.setJavascriptEnabled(true);
        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        String PROXY = "192.168.1.146:808";
        proxy.setHttpProxy(PROXY)
             .setFtpProxy(PROXY)
             .setSslProxy(PROXY);
        dcaps.setCapability(CapabilityType.PROXY, proxy);

        //驱动支持
        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "E:\\workspace\\brandcrawler\\src\\main\\resources\\phantomjs.exe");
        //创建无界面浏览器对象
        return new PhantomJSDriver(dcaps);
    }

    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "E:\\workspace\\brandcrawler\\src\\main\\resources\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("192.168.1.146:808");
//        proxy.setHttpProxy("127.0.0.1:1080");
        capabilities.setCapability("proxy", proxy);
// Add ChromeDriver-specific capabilities through ChromeOptions.
//        ChromeOptions options = new ChromeOptions();
//        options.addExtensions(new File("/path/to/extension.crx"));
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return new ChromeDriver(capabilities);
    }
}
