package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
//all code related linking of the extent or generating htm report
	public static ExtentReports getExtentReport() {
		String extendReportPath=System.getProperty("user.dir")+ "\\reports\\Extentreport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extendReportPath); 
		reporter.config().setReportName("SpiceJet Automation Report");
		reporter.config().setDocumentTitle("SpiceJet Automation Testing");
		ExtentReports extentReport=new ExtentReports();
		extentReport.attachReporter(reporter);
		return extentReport;
	}
}