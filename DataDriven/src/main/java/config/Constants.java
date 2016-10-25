package config;

/**
 * Created by ganesh on 21/10/2016.
 */
public class Constants {

    //This is the list of System Variables
    //Declared as 'public', so that it can be used in other classes of this project
    //Declared as 'static', so that we do not need to instantiate a class object
    //Declared as 'final', so that the value of this variable can be changed
    // 'String' & 'int' are the data type for storing a type of value
    public static final String URL = "http://dsq01wlt:8088/testharness";
    public static final String Path_TestData = "C:\\Users\\a1180386\\Desktop\\Ex_replacement\\Automation\\DataProvider.xlsx";
    //public static final String File_TestData = "DataProvider.xlsx";
    public static final String KEYWORD_FAIL = "FAIL";
    public static final String KEYWORD_PASS = "PASS";

    //Data Sheet Column Numbers
    public static final int Col_TestSheetName = 1;
    public static final int Col_TestScriptID =2;
    public static final int Col_RunMode =3;
    public static final int Col_TestScriptResult =4;
    public static final int Col_TestScriptName = 0;
    public static final int Col_ActionKeyword =1;
    public static final int Col_PageObject =2;
    public static final int Col_DataSet =3;
    public static final int Col_TestStepResult =6;
    public static final int Col_ObjectReference= 5;
    public static final int Col_ObjectID =7;


    public static final int USER_TEST_ID = 0;
    public static final int USER_EMAIL = 1;


    // Data Engine Excel sheets
    public static final String Sheet_TestCases = "Test Script Dashboard";
    public static final String Sheet_TestScripts = "AgentPortal-RegSuite1";


}
