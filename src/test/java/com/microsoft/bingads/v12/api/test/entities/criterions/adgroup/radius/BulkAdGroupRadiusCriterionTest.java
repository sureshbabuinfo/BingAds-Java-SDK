package com.microsoft.bingads.v12.api.test.entities.criterions.adgroup.radius;

import java.util.Map;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.internal.functionalinterfaces.Function;
import com.microsoft.bingads.internal.functionalinterfaces.Supplier;
import com.microsoft.bingads.v12.api.test.entities.BulkEntityTest;
import com.microsoft.bingads.v12.bulk.entities.BulkAdGroupRadiusCriterion;
import com.microsoft.bingads.v12.campaignmanagement.BiddableAdGroupCriterion;
import com.microsoft.bingads.v12.campaignmanagement.RadiusCriterion;

public abstract class BulkAdGroupRadiusCriterionTest extends BulkEntityTest<BulkAdGroupRadiusCriterion> {

    @Override
    protected void onEntityCreation(BulkAdGroupRadiusCriterion entity) {
        RadiusCriterion ageCriterion = new RadiusCriterion();
        ageCriterion.setType("RadiusCriterion");

        BiddableAdGroupCriterion biddableAdGroupCriterion = new BiddableAdGroupCriterion();
        biddableAdGroupCriterion.setCriterion(ageCriterion);

        entity.setBiddableAdGroupCriterion(biddableAdGroupCriterion);
    }

    @Override
    protected <TProperty> void testWriteProperty(
            String header,
            String expectedRowValue,
            TProperty propertyValue,
            BiConsumer<BulkAdGroupRadiusCriterion, TProperty> setFunc
    ) {
        testWriteProperty(
                header,
                expectedRowValue,
                propertyValue,
                setFunc,
                new Supplier<BulkAdGroupRadiusCriterion>() {
                    @Override
                    public BulkAdGroupRadiusCriterion get() {
                        return new BulkAdGroupRadiusCriterion();
                    }
                }
        );
    }

    @Override
    protected <TProperty> void testReadProperty(
            String header,
            String input,
            TProperty expectedResult,
            Function<BulkAdGroupRadiusCriterion, TProperty> actualValueFunc
    ) {
        testReadProperty(
                header,
                input,
                expectedResult,
                actualValueFunc,
                new Supplier<BulkAdGroupRadiusCriterion>() {
                    @Override
                    public BulkAdGroupRadiusCriterion get() {
                        return new BulkAdGroupRadiusCriterion();
                    }
                }
        );
    }

    @Override
    protected <TProperty> void testReadProperty(
            Map<String, String> rowValues,
            TProperty expectedResult,
            Function<BulkAdGroupRadiusCriterion, TProperty> actualValueFunc
    ) {
        testReadProperty(
                rowValues,
                expectedResult,
                actualValueFunc,
                new Supplier<BulkAdGroupRadiusCriterion>() {
                    @Override
                    public BulkAdGroupRadiusCriterion get() {
                        return new BulkAdGroupRadiusCriterion();
                    }
                }
        );
    }
}
