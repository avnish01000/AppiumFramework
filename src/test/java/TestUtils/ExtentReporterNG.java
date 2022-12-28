package TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    public static ExtentReports extent;
    public static ExtentReports getReporterObject()
    {
        String path=System.getProperty("user.dir")+"\\Reports\\index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Avnish Sharma");
        return extent;
    }
}
