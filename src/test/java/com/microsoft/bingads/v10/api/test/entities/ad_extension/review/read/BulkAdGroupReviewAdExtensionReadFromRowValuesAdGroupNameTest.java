package com.microsoft.bingads.v10.api.test.entities.ad_extension.review.read;

import com.microsoft.bingads.internal.functionalinterfaces.Function;
import com.microsoft.bingads.v10.api.test.entities.ad_extension.review.BulkAdGroupReviewAdExtensionTest;
import com.microsoft.bingads.v10.bulk.entities.BulkAdGroupReviewAdExtension;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class BulkAdGroupReviewAdExtensionReadFromRowValuesAdGroupNameTest extends BulkAdGroupReviewAdExtensionTest {
    @Parameterized.Parameter(value = 1)
    public String expectedResult;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Ad Group Name String", "Ad Group Name String"},
                {"", ""},
                {null, null}
        });
    }

    @Test
    public void testRead() {
        this.testReadProperty("Ad Group", this.datum, this.expectedResult, new Function<BulkAdGroupReviewAdExtension, String>() {
            @Override
            public String apply(BulkAdGroupReviewAdExtension c) {
                return c.getAdGroupName();
            }
        });
    }
}
