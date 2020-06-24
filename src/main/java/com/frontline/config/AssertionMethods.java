package com.frontline.config;

import org.junit.Assert;

public class AssertionMethods {
    public void assertTrue(boolean condition) {
        Assert.assertTrue(condition);
    }

    public void assertTrue(String errorMessage, boolean condition) {
        Assert.assertTrue(condition);
    }

    public void assertFalse(boolean condition) {
        Assert.assertFalse(condition);
    }

    public void assertNull(Object object) {
        Assert.assertNull(object);
    }

    public void assertNotNull(Object object) {
        Assert.assertNotNull(object);
    }

    public void assertEquals(Object expected, Object actual) {
        Assert.assertEquals(expected, actual);
    }

    public void assertEquals(float expected, float actual) {
        Assert.assertEquals(expected, actual, 0.0F);
    }

    public void assertEquals(double expected, double actual) {
        Assert.assertEquals(expected, actual, 0.0D);
    }

    public void assertEquals(long expected, long actual) {
        Assert.assertEquals(expected, actual);
    }
}