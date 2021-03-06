package com.microsoft.bingads.v12.api.test.entities.criterions.campaign.radius.write;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.v12.api.test.entities.criterions.campaign.radius.BulkCampaignRadiusCriterionTest;
import com.microsoft.bingads.v12.bulk.entities.BulkCampaignRadiusCriterion;
import com.microsoft.bingads.v12.campaignmanagement.DistanceUnit;
import com.microsoft.bingads.v12.campaignmanagement.RadiusCriterion;

@RunWith(Parameterized.class)
public class BulkCampaignRadiusCriterionWriteRadiusUnitTest extends BulkCampaignRadiusCriterionTest {

    @Parameter(value = 1)
    public DistanceUnit propertyValue;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {"Kilometers", DistanceUnit.KILOMETERS},
                        {"Miles", DistanceUnit.MILES},
                        {null, null}
                }
        );
    }

    @Test
    public void testWrite() {
        testWriteProperty(
                "Unit",
                datum,
                propertyValue,
                new BiConsumer<BulkCampaignRadiusCriterion, DistanceUnit>() {
                    @Override
                    public void accept(BulkCampaignRadiusCriterion c, DistanceUnit v) {
                    	((RadiusCriterion)c.getBiddableCampaignCriterion().getCriterion()).setRadiusUnit(v);
                    }
                }
        );
    }
}
