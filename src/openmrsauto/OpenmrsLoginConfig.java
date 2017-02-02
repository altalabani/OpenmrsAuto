    package openmrsauto;

    import java.io.IOException;
    import java.util.Iterator;
    import java.util.LinkedHashMap;
    import java.util.List;
    import java.util.concurrent.TimeUnit;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Platform;
    //import org.openqa.selenium.Platform;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.firefox.FirefoxProfile;
    import org.openqa.selenium.firefox.MarionetteDriver;
    import org.openqa.selenium.ie.InternetExplorerDriver;
    import org.openqa.selenium.remote.DesiredCapabilities;
    //import org.openqa.selenium.remote.DesiredCapabilities;
    import org.openqa.selenium.remote.RemoteWebDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.Select;
    import org.openqa.selenium.support.ui.WebDriverWait;
    //import org.sikuli.api.DesktopScreenRegion;
    //import org.sikuli.api.ScreenRegion;
    //import org.sikuli.api.visual.Canvas;
    //import org.sikuli.api.visual.DesktopCanvas;
    //import org.sikuli.script.FindFailed;
    //import org.sikuli.script.Match;
    //import org.sikuli.script.Screen;

    /*import com.cobra.ldtp.Ldtp;
     import com.cobra.ldtp.LdtpExecutionError;
     import com.cobra.ldtp.PollEvents;*/

    //public class SeleniumSikuliPCD implements Runnable{

    public class OpenmrsLoginConfig {

            /*
             * final private Log logger = LogFactory.getLog(FirefoxDriver.class); static
             * private final int DEFAULT_WAIT_TIMEOUT_MSECS = 10000;
             */
            //	private static Match Returnfind = null;
            //static private WebDriver driver;
            //static private Screen screenRegion;
            // static JavascriptExecutor executor;
            static private String TestCase = "";
            static private String TestMachineIP = "";
            static private String CustmerName = "";
            /*
             * static private boolean LinuxVm=false; static private boolean
             * WindowsVm=false;
             */
            static private int linuxVmNum = 0;
            static private int windowsVmNum = 0;
            ProcessBuilder pb;
            Process p = null;
            String windowName;
            private boolean testingStatus = false;


            public void start() throws Exception {

    //		ScreenRegion DesktopScrRegion = new DesktopScreenRegion(300, 400, 200,50);
    //		Canvas Desktopcanvas = new DesktopCanvas();
    //		Match MatchStatus = null;

    //                File file = new File("C:\\out.txt");
    //                FileOutputStream fos = new FileOutputStream(file);
    //                PrintStream ps = new PrintStream(fos);
    //                System.setOut(ps);

    //                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    //                capabilities.setCapability("marionette", true);
    //                WebDriver driver = new MarionetteDriver(capabilities);
                    //WebDriver driver = new RemoteWebDriver(capabilities);

                    //System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");

                    //System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

    //               WebDriver driverIE = new InternetExplorerDriver();
    //               DesiredCapabilities cap = new DesiredCapabilities();
    //               cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
    //

                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setEnableNativeEvents(true);
                    profile.setPreference("plugin.state.java", 2);
                    profile.setAcceptUntrustedCertificates(true);
                    profile.setPreference("security.enable_java", true);
                    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                    capabilities.setCapability("marionette", true);
                    capabilities.setCapability(FirefoxDriver.PROFILE, profile);
                    capabilities.setCapability("platform", Platform.WINDOWS);
                    //WebDriver driver = new RemoteWebDriver(capabilities);
                    WebDriver driver = new FirefoxDriver(capabilities);

                    System.out.println("http://" + TestMachineIP + ":8080/openmrs/login.htm");
                    driver.get("http://" + TestMachineIP + ":8080/openmrs/login.htm");
                    //driver.get("http://" + TestMachineIP + "/egenpcd/egenpcd.jnlp");
                    //driverIE.get("http://104.223.93.183:8080/openmrs/login.htm");
                    driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

    //                  File file = new File("C:\\Users\\another\\Desktop\\out.txt");
    //                  FileOutputStream fos = new FileOutputStream(file);
    //                  PrintStream ps = new PrintStream(fos);
    //                  System.setOut(ps);
    //                  URL myResUrl = null;
    //                  //Class<?> cl = this.getClass();
    //                  ClassLoader cl = getClass().getClassLoader();
    //                  myResUrl=  this.getClass().getResource("/images/WEbStartButton.png");
    //                  System.out.println( myResUrl.toURI().toString());

    //Username:
    //<td>Username:</td>
    //
    //
             driver.manage().window().maximize();
             Thread.sleep(1000);
            // WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("portlet")));
                      
            driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin123");
            driver.findElement(By.xpath("//input[@value='Log In']")).click();  //<input value="Log In" type="submit">

           // WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='OpenMRS - Home']")));  //<title>OpenMRS - Home</title>

    //        OpenMRS - Login
    //                head > title:nth-child(17)
    //                        <title>OpenMRS - Home</title>
    //
    //
            //List<WebElement> input =  driver.findElements(By.xpath("//input[contains(*)"));

            //List<WebElement> rows = driver.findElements(By.xpath("//table/tr"));

            Thread.sleep(1000);

            List<WebElement> allRows = driver.findElements(By.tagName("tr"));
            Iterator<WebElement> iter = allRows.iterator();

            while (iter.hasNext()) {
            WebElement rowsItem = iter.next();
            String WElement = rowsItem.getText();
            System.out.println("Row WElement is " + WElement);

            }
            System.out.println("");
            List<WebElement> allcells = driver.findElements(By.tagName("td"));
            Iterator<WebElement> iter1 = allcells.iterator();

            while (iter1.hasNext()) {
            WebElement rowsItem = iter1.next();
            String WElement = rowsItem.getText();
            System.out.println("Cell WElement is " + WElement);

            }
            System.out.println("");

   
            List<WebElement> all = driver.findElements(By.xpath("//*"));
            Iterator<WebElement> iter3 = all.iterator();

            while (iter3.hasNext()) {
            WebElement rowsItem = iter3.next();
            String WElement = rowsItem.getText();
            System.out.println("all WElement is " + WElement);

            }

            driver.findElement(By.linkText("Find/Create Patient")).click();

            Thread.sleep(1000);
             System.out.println("");
            all = driver.findElements(By.xpath("//*"));
            iter3 = all.iterator();

            while (iter3.hasNext()) {
            WebElement rowsItem = iter3.next();
            String WElement = rowsItem.getText();
            System.out.println("all WElement is " + WElement);

            }

            driver.findElement(By.xpath("//input[@id='personName']")).sendKeys("osy");
            driver.findElement(By.xpath("//input[@id='age']")).sendKeys("52");
            
            driver.findElement(By.xpath("//input[@value='M']")).click(); //<input name="addGender" id="gender-M" value="M" onclick="hideError('genderError')" type="radio">
            driver.findElement(By.xpath("//input[@value='Create Person']")).click();

            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@value='I cannot find the person on the list']")).click();

            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@name='personName.familyName']")).sendKeys("fofo"); //<input name="personName.familyName" value="" size="30" type="text"> Outer HTML
            driver.findElement(By.xpath("//input[@name='identifiers[0].identifier']")).sendKeys("6266KT-6"); //<input size="30" name="identifiers[0].identifier" value="" type="text"> Outer HTML
            Thread.sleep(1000);

            Select dropdown = new Select(driver.findElement(By.id("locationId")));

    //        <select id="locationId" name="identifiers[0].location">
    //									<option></option>
    //
    //										<option value="4">Chulaimbo</option>
    //
    //										<option value="3">Mosoriot Hospital</option>
    //
    //										<option value="1">Unknown Location</option>
    //
    //										<option value="11">Unknown Location 10</option>
    //
    //										<option value="12">Unknown Location 11</option>
    //
    //										<option value="13">Unknown Location 12</option>
    //
    //										<option value="14">Unknown Location 13</option>
    //
    //										<option value="15">Unknown Location 14</option>
    //
    //										<option value="16">Unknown Location 15</option>
    //
    //										<option value="17">Unknown Location 16</option>
    //
    //										<option value="18">Unknown Location 17</option>
    //
    //										<option value="19">Unknown Location 18</option>
    //
    //										<option value="5">Unknown Location 4</option>
    //
    //										<option value="6">Unknown Location 5</option>
    //
    //										<option value="7">Unknown Location 6</option>
    //
    //										<option value="8">Unknown Location 7</option>
    //
    //										<option value="9">Unknown Location 8</option>
    //
    //										<option value="10">Unknown Location 9 </option>
    //
    //										<option value="2">Wishard Hospital</option>
    //
    //								</select>

             dropdown.selectByValue("2");

              driver.findElement(By.xpath("//input[@value='Save']")).click(); //<input value="Save" name="action" id="addButton" type="submit"> Outer HTML




            //GetAction getAction =new GetAction();


                    System.out.println("Full website login is loaded");
                    System.out.println("Starting testing path :" + TestCase);

                    testingStatus = true;

    //		if (TestCase.contentEquals("1")) {
    //			//AddNewCompany.AddCustBuildEnv();
    //			//getAction.RobotDoAction("TAB");
    //			//getAction.RobotDoAction("ENTER");
    //		}

    //		if (TestCase.contentEquals("5")) {
    //                    System.out.println("Starting testing path :" + TestCase);
    //			//AddNewCompany.AddCustBuildEnv(false);
    //			//Thread.sleep(1000L);
    //			//GetAction.RobotDoAction("ENTER");
    //			if (linuxVmNum != 0 || windowsVmNum != 0) {
    //                            //BuildNewVmwareEnvironment buildNewVmwareEnvironment = new BuildNewVmwareEnvironment();
    //                            //buildNewVmwareEnvironment.BuildNewVmwareEnv("New");
    //			}
    //		}

    //		if (TestCase.contentEquals("5")) {
    //			GetAction.findTargetText(CustmerName, CustmerName, "DoubleClick",
    //					null, null);
    //			//BuildNewVmwareEnvironment.BuildNewVmwareEnv(CustmerName);
    //
    //		}
                    testingStatus = false;
                    System.out.println("End");
    //		Desktopcanvas.addBox(DesktopScrRegion).withLineColor(null);
    //		Desktopcanvas.addLabel(DesktopScrRegion, "Testing ended");
    //		Desktopcanvas.display(1);

            }

            public void setTestCase(String TC) {
                    TestCase = TestCase.replaceAll("", TC.toString());

            }

            public void setTestMachineIP(String IP) {
                    TestMachineIP = TestMachineIP.replaceAll("", IP.toString());

            }

            public void setCustmerName(String Name) {
                    CustmerName = CustmerName.replaceAll("", Name.toString());

            }


    //	public void setVmType (boolean linuxVm,boolean windowsVm) {
    //	LinuxVm=linuxVm; WindowsVm=windowsVm;
    //
    //	}
    //

            public void setVmNumber(int linuxVmN, int windowsVmN) {
                    linuxVmNum = linuxVmN;
                    windowsVmNum = windowsVmN;

            }

            public static int getLinuxVmNum() {
                    return linuxVmNum;
            }

            public boolean getTestingStatus() {
                    return testingStatus;

            }

            public void setTestingStatus(boolean testingNow) {
                    testingStatus = testingNow;

            }
    }
