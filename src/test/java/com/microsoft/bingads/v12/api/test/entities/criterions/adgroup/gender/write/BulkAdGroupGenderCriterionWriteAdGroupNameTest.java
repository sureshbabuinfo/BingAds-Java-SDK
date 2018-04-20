package com.microsoft.bingads.v12.api.test.entities.criterions.adgroup.gender.write;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.v12.api.test.entities.criterions.adgroup.gender.BulkAdGroupGenderCriterionTest;
import com.microsoft.bingads.v12.bulk.entities.BulkAdGroupGenderCriterion;

@RunWith(Parameterized.class)
public class BulkAdGroupGenderCriterionWriteAdGroupNameTest extends BulkAdGroupGenderCriterionTest {

    @Parameterized.Parameter(value = 1)
    public String propertyValue;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {"123", "123"},
                        {"XXX YYY", "XXX YYY"},
                        {"", ""},
                        {null, null}
                }
        );
    }

    @Test
    public void testWrite() {
        testWriteProperty(
                "Ad Group",
                datum,
                propertyValue,
                new BiConsumer<BulkAdGroupGenderCriterion, String>() {
                    @Override
                    public void accept(BulkAdGroupGenderCriterion c, String v) {
                        c.setAdGroupName(v);
                    }
                }
        );
    }
}