package com.microsoft.bingads.v12.api.test.entities.negative_keywords.campaign_negative_keyword.write;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.v12.api.test.entities.negative_keywords.campaign_negative_keyword.BulkCampaignNegativeKeywordTest;
import com.microsoft.bingads.v12.bulk.entities.BulkCampaignNegativeKeyword;
import com.microsoft.bingads.v12.campaignmanagement.MatchType;

@RunWith(Parameterized.class)
public class BulkCampaignNegativeKeywordWriteToRowValuesMatchTypeTest extends BulkCampaignNegativeKeywordTest {

    @Parameter(value = 1)
    public MatchType propertyValue;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"Broad", MatchType.BROAD},
            {"Exact", MatchType.EXACT},
            {"Phrase", MatchType.PHRASE},
            {null, null},});
    }

    @Test
    public void testWrite() {
        this.<MatchType>testWriteProperty("Match Type", this.datum, this.propertyValue, new BiConsumer<BulkCampaignNegativeKeyword, MatchType>() {
            @Override
            public void accept(BulkCampaignNegativeKeyword c, MatchType v) {
                c.getNegativeKeyword().setMatchType(v);
            }
        });
    }
}
