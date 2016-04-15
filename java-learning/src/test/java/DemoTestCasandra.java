


import com.datastax.driver.core.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.annotations.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gpiskunov
 */

public class DemoTestCasandra {
    
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
    
    
    @Test(enabled=true)
    public void changeTestRunStatus () {
        
    } 
    
    @Test(enabled=true)
    public void TestCasandra (){
        
        
        //Address to coonect
        
        clTest = Cluster.builder().addContactPoint(addr).build();
        // keyspace sortmaster
        
        ssTest = clTest.connect(conKeyspace);
        
        rsCasandra = ssTest.execute("SELECT * FROM BAG_INFO LIMIT 10 ");
        
        for (Row row: rsCasandra) {
            System.out.println(row.getString("bar_code") + " " + row.getString("create_date_time"));
        }
        clTest.close();
    }
    
    @Test(enabled=false)
    public void createCapacityList () {
        // Connect to Hive
        coonectToCL (HIVE_URL, USER, PASSWORD);
        String RpoBarCode;
        // Get CapacityList BarCodes
        
        try {
            java.sql.ResultSet res = stmt.executeQuery(SelectCapacityList);
            while ( res.next() ) {
                RpoBarCode = res.getString(1);
                addElementsToList(BarCodeCapacityList , RpoBarCode);
                System.out.println("Add BarCode to CapacitList  " + RpoBarCode );
                //Long CalculateFull = fullSimpleRest + 201 ;
                //System.out.println(CalculateFull);
            } 
         
        }   catch (Exception ex) {
            Logger.getLogger(DemoTestCasandra.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
       // Print CapacitList
       //for (int i = 0; i<BarCodeCapacityList.size() ; i++) {
       //    System.out.println("Capacity BarCode " + BarCodeCapacityList.get(i));
       //}
       // Connect to Casandra and Compapre is matreshka.edges not null
       connectToCasandra ();
       for (int i = 0; i < BarCodeCapacityList.size() ; i++) {
         System.out.println("Check Capacity BarCode " + BarCodeCapacityList.get(i) );
        
        String BarCodeCapacity = BarCodeCapacityList.get(i).toString();
        String SelectCasandraBarCode = SelectCapacityLinked + "'" + BarCodeCapacity  + "'";
        rsCasandra = ssTest.execute (SelectCasandraBarCode);
        
        for (Row row: rsCasandra) {
            //if (row.getString("bar_code") != null ) {
            //    addElementsToList (BarCodeCapacityLinkedList,  row.getString("barcode"));
            //}
            System.out.println("BarCode " + row.getString("barcode") + " Child " + row.getString("child"));
        }
         
       }
        
       if (!BarCodeCapacityLinkedList.isEmpty()) {
           System.out.println("There are found " + BarCodeCapacityLinkedList.size() + "Capacities ");
       }
       
    } 
    public void connectToCasandra () {
        //Address to coonect
        
        clTest = Cluster.builder().addContactPoint(addr).build();
        // keyspace sortmaster
        ssTest = clTest.connect(conKeyspace);
        
    }
    public void addElementsToList (List BarCodeList ,String BarCode  ) {
         BarCodeList.add( BarCode);
     }
     public String parseResultToString(java.sql.ResultSet res, Integer columnCount) {
        
        try {
            while (res.next()) {
                
                /*
                for (int i = 1; i <= columnCount; i++) {
                    resultString = resultString + res.getString(i);
                }
                */
            }
        } catch (SQLException | NullPointerException e) {
            System.out.println("Error, while parsing query result to string" + e);
        }
        return resultString;
    }
     
     public void coonectToCL (String hiveURL, String User, String Password) {
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            //log.error("Class not found", e);
            
        }
         try {
            con = DriverManager.getConnection(hiveURL, User, Password);
            runInitializationQueries(con, stmt);
        } catch (SQLException e) {
            System.out.println("Error while connection to " + hiveURL + "(user: " + User + ")" + e);
            //log.error("Error while connection to " + hiveURL + "(user: " + user + ")", e);
        }
        
        
        try {
            stmt = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
            ex.printStackTrace();
            //Logger.getLogger(SummaryRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //} catch (SQLException e) {
        //    System.out.println("Error while trying to create statement" +  e);
            //log.error("Error while trying to create statement", e);
        //}
       //return stmt;
    }
     
     private void runInitializationQueries(Connection con, java.sql.Statement stmnt) {
        //Statement stmnt = null;
        try {
            stmnt = con.createStatement();
            for (String query : INIT_QUERIES) {
                //log.debug("Executing: " + query);
                System.out.println("Executing: " + query);
                stmnt.execute(query);
            }
        } catch (SQLException e) {
            //log.error("Error while trying to execute hive init queries.", e);
            System.out.println("Error while trying to execute hive init queries." + e);
        
        }
        /*
        finally {
            try {
                stmnt.close();
            } catch (Exception e) {
                //log.error("Error while trying to close SQL Statement", e);
                System.out.println("Error while trying to close SQL Statement" + e);
            }
        }
        */
    }
    
}
