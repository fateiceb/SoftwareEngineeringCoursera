package com.company.test;

import com.company.CalResult;
import com.company.Expression;
import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;

public class CalResultTest {
    public static void main(String[] args){
        CalResult calResult = new CalResult();
        calResult.Suffix(new Expression());
        calResult.calResult(calResult.getSuffix());
    }
}
