package com.microsoft.bingads.v12.api.test.entities.ads.expandedText.write;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.v12.api.test.entities.ads.expandedText.BulkExpandedTextAdTest;
import com.microsoft.bingads.v12.bulk.entities.BulkExpandedTextAd;

@RunWith(Parameterized.class)
public class BulkExpandedTextAdWriteToRowValuesPath1Test extends BulkExpandedTextAdTest {

    @Parameter(value = 1)
    public String propertyValue;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"path1", "path1"},
            {"", ""},
            {null, null},});
    }

    @Test
    public void testWrite() {
        this.<String>testWriteProperty("Path 1", this.datum, this.propertyValue, new BiConsumer<BulkExpandedTextAd, String>() {
            @Override
            public void accept(BulkExpandedTextAd c, String v) {
                c.getExpandedTextAd().setPath1(v);
            }
        });
    }
}
