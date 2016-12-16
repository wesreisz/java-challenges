package com.wesleyreisz.exercises;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple WordUtil.
 */
public class PalindroneTest {
    @Test
    public void testPalindrone(){
        Assert.assertTrue(WordUtil.isPalindrome("racecar"));
        Assert.assertFalse(WordUtil.isPalindrome("racecare"));
    }
    @Test
    public void isPalidroneIfEmptyOrNull(){
        Assert.assertFalse(WordUtil.isPalindrome(""));
        Assert.assertFalse(WordUtil.isPalindrome(null));
    }
    @Test
    public void isTextReversed(){
        Assert.assertEquals("racecar", WordUtil.reverse("racecar"));
        Assert.assertEquals("wes", WordUtil.reverse("sew"));
    }
    @Test
    public void testPalindroneDynamic(){
        Assert.assertTrue(WordUtil.isPalindromeDynamic("racecar"));
        Assert.assertFalse(WordUtil.isPalindromeDynamic(""));
        Assert.assertFalse(WordUtil.isPalindromeDynamic(null));
        Assert.assertFalse(WordUtil.isPalindromeDynamic("racecare"));
    }
    @Test
    public void testPalindroneWithGrammer(){
        Assert.assertTrue(WordUtil.isPalindrome("Madam, I’m Adam!"));
        Assert.assertTrue(WordUtil.isPalindromeDynamic("Madam, I’m Adam!"));
    }
}
