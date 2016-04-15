
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gpiskunov
 */
public class DemoTestRail {
    
    public static final String HIVE_URL = "jdbc:hive2://hw-test-dc1:10010/tracking";
    public static final String USER = "hdfs";
    public static final String PASSWORD = "";
    //public static final String[] INIT_QUERIES = new String[]{"add jar /usr/hdp/2.3.0.0-2557/hive/lib/hive-contrib-1.2.1.2.3.0.0-2557.jar", "CREATE TEMPORARY FUNCTION row_sequence as 'org.apache.hadoop.hive.contrib.udf.UDFRowSequence'", "set mapred.job.queue.name=test", "set hive.support.sql11.reserved.keywords=false"};
    public static final String[] INIT_QUERIES = new String[]{"add jar /usr/hdp/2.3.4.0-3485/hive/lib/hive-contrib-1.2.1.2.3.4.0-3485.jar", "CREATE TEMPORARY FUNCTION row_sequence as 'org.apache.hadoop.hive.contrib.udf.UDFRowSequence'", "set mapred.job.queue.name=test", "set hive.support.sql11.reserved.keywords=false"};
    public Connection con = null;
    public java.sql.Statement stmt = null;
    public Connection connVertica = null;
    public java.sql.Statement stmtVertica = null;
    public String resultString = "";
    public static String BarCodeDispatcherList;
    public static String BarCodeCasandraList;
    static List BarCodeCapacityList =  new ArrayList();
    static List BarCodeCapacityLinkedList = new ArrayList();
    public static String SelectCapacityList = "SELECT b.bar_code " +
                                            "FROM dasdb4.bags_v2 b LEFT OUTER JOIN dasdb4.documents_v2 d ON b.bar_code = d.bar_code  " +
                                            "WHERE d.bar_code is null " +
                                            "AND b.bag_info.bag_type = '1' " +
                                            "limit 50 ";
    public static String SelectCapacityLinked = "SELECT * FROM MATRESHKA.EDGES where barcode = ";
    public static Cluster clTest;
    public static Session ssTest;
    public static String addr = "hw-test-dc2";
    public static String conKeyspace = "sortmaster";
    public static ResultSet rsCasandra;
    
    public static void main (String agrs[]) throws APIException, IOException {
        
        String TestRailUser = "trapiuser.datacloud@russianpost.ru";
        String TestRailPassword = "dc1455021533";
        String TestRailURL = "https://testrail.tools.russianpost.ru";
        String TestRunID = "368";
        String TestCaseID = "10041";
        String Results = "This is a test results from API Test";
        /*
        Status int is 1 - success passed , 2 - Blocked , 3 - Untested can't be used , 4 - retest, 5 - failed
        */
        int StatusId = 5;
        
        APIClient client = new APIClient(TestRailURL);
        client.setUser(TestRailUser);
	client.setPassword(TestRailPassword);
        JSONObject c = (JSONObject) client.sendGet("get_case/" + TestCaseID);
        System.out.println(c.get("title"));
        
        Map data = new HashMap();
        data.put("status_id", new Integer(StatusId) );
        data.put("comment", Results + "Reslut status " + StatusId );
        JSONObject r = (JSONObject) client.sendPost("add_result_for_case/" + TestRunID + "/" + TestCaseID, data );
        
        
    }
    
    
}
