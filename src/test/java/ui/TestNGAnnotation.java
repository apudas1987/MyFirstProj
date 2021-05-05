package ui;

import org.testng.annotations.*;

public class TestNGAnnotation
{
    @BeforeSuite
    public void beforeSuiteAnnotation()
    {
        System.out.println("Before Suite Annotation \n");
    }
    @BeforeClass
    public void beforeClassAnnotation()
    {
        System.out.println("Before Class Annotation \n");
    }

    @BeforeTest
    public void beforeTestAnnotation()
    {
        System.out.println("Before Test Annotation \n");
    }
    @BeforeGroups
    public void beforeGroupsAnnotation()
    {
        System.out.println("Before Groups Annotation \n");
    }
    @BeforeMethod
    public void beforeMethodAnnotation()
    {
        System.out.println("Before Method Annotation \n");
    }
    @AfterSuite
    public void AfterSuitAnnotation()
    {
        System.out.println("After Suit Annotation \n");
    }
    @AfterGroups
    public void AfterGroupsAnnotation()
    {
        System.out.println("After Groups Annotation \n");
    }
    @AfterTest
    public void AfterTestAnnotation()
    {
        System.out.println("After Test Annotation \n");
    }
    @AfterClass
    public void AfterClassAnnotation()
    {
        System.out.println("After Class Annotation \n");
    }
    @AfterMethod
    public void AfterMethodAnnotation()
    {
        System.out.println("After Method Annotation \n");
    }
    @Test
    public  void TestAnnotation()
    {
        System.out.println("Test Annotations \n");
    }
}
