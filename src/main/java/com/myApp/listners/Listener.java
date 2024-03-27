package com.myApp.listners;

import com.myApp.core.BaseTest;
import org.testng.*;

public class Listener implements IInvokedMethodListener, ITestListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.beforeInvocation(method, testResult);
    }

    @Override
    public void onTestStart(ITestResult result) {
        BaseTest.setupDriver();
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        BaseTest.quitDriver();
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

}
