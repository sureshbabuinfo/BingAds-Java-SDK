package com.microsoft.bingads.v11.api.test.entities.criterions.adgroup.radius.read;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.microsoft.bingads.internal.functionalinterfaces.Function;
import com.microsoft.bingads.v11.api.test.entities.criterions.adgroup.radius.BulkAdGroupRadiusCriterionTest;
import com.microsoft.bingads.v11.bulk.entities.BulkAdGroupRadiusCriterion;
import com.microsoft.bingads.v11.campaignmanagement.RadiusCriterion;

@RunWith(Parameterized.class)
public class BulkAdGroupRadiusCriterionReadLatitudeTest extends BulkAdGroupRadiusCriterionTest {

    @Parameter(value = 1)
    public Double expectedResult;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {"12.2", 12.2},
                        {"", null},
                        {null, null}
                }
        );
    }

    @Test
    public void testRead() {
        testReadProperty(
                "Latitude",
                datum,
                expectedResult,
                new Function<BulkAdGroupRadiusCriterion, Double>() {
                    @Override
                    public Double apply(BulkAdGroupRadiusCriterion c) {
                        return ((RadiusCriterion)c.getBiddableAdGroupCriterion().getCriterion()).getLatitudeDegrees();
                    }
                }
        );
    }
}
