package ru.russianpost.qa.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import ru.russianpost.qa.actions.DataManagement;
import ru.russianpost.qa.actions.TestRail;
import ru.russianpost.qa.env.Environment;

import java.util.List;
import java.util.Map;

/**
 * Created by gpiskunov on 26.08.2016.
 */
public class Test_C13355_TestRPOoutOfReport {
    @Test(enabled = false)
    public static void getRpoOutOfReport (ITestContext context) throws Exception {
        // Получаю TestCaseID
        Map<String, String> testParameters = context.getCurrentXmlTest().getTestParameters();
        String testCaseID = testParameters.get("TestCaseID").toString();
        List failRPOList ;
        //System.out.println(Environment.selectFromFailTableQuery(testCaseID));
        failRPOList = DataManagement.builFailRPOList(testCaseID, Environment.oozieCommonProperties.getProperty("targetOutReportTable").toString());
        //System.out.println(failRPOList.toString());
        if (!failRPOList.isEmpty()) {
            // Тест возвращает ошибку по результатам обработки
            //Call TestRail add Results
            //Fail testResults
            String results = "The RpoFailList is not empty " + "Fail RPO out of Report List " + failRPOList;
            TestRail.setTestRailResults(testCaseID, TestRail.setFailStatusId(), results );
            throw new Exception( results );
            //Добавляем ошибку TestRail
        } else {
            //Add TestRail Susccess Results
            String results = "Test susccessfully passed";
            TestRail.setTestRailResults(testCaseID, TestRail.setSuccessStatusId(), TestRail.setSuccessResults() );


        }

        /*String failRPO = null;
        try {
            failRPO = DataManagement.checkRPOoutOfReport(testCaseID);
        } catch (Exception ex) {
            //Test провалился пишем результат в TestRail

            String results = ex.getLocalizedMessage();
            TestRail.setTestRailResults(testCaseID, TestRail.setFailStatusId(), results );
            ex.printStackTrace();
        }
        if (failRPO == null) {

            //Тест прошел успешно добавляем результаты в TestRail
            TestRail.setTestRailResults(testCaseID, TestRail.setSuccessStatusId(), TestRail.setSuccessResults() );

        } else {
            //Test провалился пишем результат в TestRail
            String failTestResults = "The test has been failed , RPO out of report "+ failRPO;
            TestRail.setTestRailResults(testCaseID, TestRail.setFailStatusId(), failTestResults );
            Assert.assertNotNull(failRPO);
        }
        TestRail.setTestRailResults(testCaseID, TestRail.setSuccessStatusId(), TestRail.setSuccessResults() );*/
    }
}
