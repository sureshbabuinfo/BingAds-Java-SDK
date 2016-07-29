package com.microsoft.bingads.v10.api.test.entities.ads.expandedText;

import com.microsoft.bingads.v10.api.test.entities.BulkEntityTest;
import com.microsoft.bingads.v10.bulk.entities.BulkExpandedTextAd;
import com.microsoft.bingads.v10.campaignmanagement.ExpandedTextAd;
import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.internal.functionalinterfaces.Function;
import com.microsoft.bingads.internal.functionalinterfaces.Supplier;

import java.util.Map;

public abstract class BulkExpandedTextAdTest extends BulkEntityTest<BulkExpandedTextAd> {

    @Override
    protected void onEntityCreation(BulkExpandedTextAd entity) {
        entity.setExpandedTextAd(new ExpandedTextAd());
    }

    @Override
    protected <TProperty> void testWriteProperty(String header,
            String expectedRowValue, TProperty propertyValue,
            BiConsumer<BulkExpandedTextAd, TProperty> setFunc) {
        this.<TProperty>testWriteProperty(header, expectedRowValue, propertyValue, setFunc, new Supplier<BulkExpandedTextAd>() {
            @Override
            public BulkExpandedTextAd get() {
                return new BulkExpandedTextAd();
            }
        });
    }

    @Override
    protected <TProperty> void testReadProperty(String header, String input, TProperty expectedResult, Function<BulkExpandedTextAd, TProperty> actualValueFunc) {
        this.<TProperty>testReadProperty(header, input, expectedResult, actualValueFunc, new Supplier<BulkExpandedTextAd>() {
            @Override
            public BulkExpandedTextAd get() {
                return new BulkExpandedTextAd();
            }
        });
    }

    @Override
    protected <TProperty> void testReadProperty(Map<String, String> rowValues, TProperty expectedResult, Function<BulkExpandedTextAd, TProperty> actualValueFunc) {
        this.<TProperty>testReadProperty(rowValues, expectedResult, actualValueFunc, new Supplier<BulkExpandedTextAd>() {
            @Override
            public BulkExpandedTextAd get() {
                return new BulkExpandedTextAd();
            }
        });
    }
}
