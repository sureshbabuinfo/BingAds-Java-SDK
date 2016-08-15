package com.microsoft.bingads.examples.v10;

import java.rmi.*;
import java.util.ArrayList;
import java.util.Calendar;

import com.microsoft.bingads.*;
import com.microsoft.bingads.v10.campaignmanagement.*;

public class KeywordsAds extends ExampleBase {

    static AuthorizationData authorizationData;
    static ServiceClient<ICampaignManagementService> CampaignService; 
    
    /*
    private static java.lang.String UserName = "<UserNameGoesHere>";
    private static java.lang.String Password = "<PasswordGoesHere>";
    private static java.lang.String DeveloperToken = "<DeveloperTokenGoesHere>";
    private static long CustomerId = <CustomerIdGoesHere>;
    private static long AccountId = <AccountIdGoesHere>;
    */

    public static void main(java.lang.String[] args) {
   	 
        try
        {
            authorizationData = new AuthorizationData();
            authorizationData.setDeveloperToken(DeveloperToken);
            authorizationData.setAuthentication(new PasswordAuthentication(UserName, Password));
            authorizationData.setCustomerId(CustomerId);
            authorizationData.setAccountId(AccountId);
	         
            CampaignService = new ServiceClient<ICampaignManagementService>(
                    	authorizationData, 
                        ICampaignManagementService.class);

            // Specify a campaign. 

            ArrayOfCampaign campaigns = new ArrayOfCampaign();
            Campaign campaign = new Campaign();
            campaign.setName("Summer Shoes " + System.currentTimeMillis());
            campaign.setDescription("Summer shoes line.");
            campaign.setBudgetType(BudgetLimitType.MONTHLY_BUDGET_SPEND_UNTIL_DEPLETED);
            campaign.setMonthlyBudget(1000.00);
            campaign.setTimeZone("PacificTimeUSCanadaTijuana");
            campaign.setDaylightSaving(true);
             
            // You can set your campaign bid strategy to Enhanced CPC (EnhancedCpcBiddingScheme) 
            // and then, at any time, set an individual ad group or keyword bid strategy to 
            // Manual CPC (ManualCpcBiddingScheme).
            // For campaigns you can use either of the EnhancedCpcBiddingScheme or ManualCpcBiddingScheme objects. 
            // If you do not set this element, then ManualCpcBiddingScheme is used by default.
            campaign.setBiddingScheme(new EnhancedCpcBiddingScheme());
             
            // Used with FinalUrls shown in the text ads that we will add below.
            campaign.setTrackingUrlTemplate(
                "http://tracker.example.com/?season={_season}&promocode={_promocode}&u={lpurl}");

            campaigns.getCampaigns().add(campaign);

            // Specify an ad group. 

            ArrayOfAdGroup adGroups = new ArrayOfAdGroup();
            AdGroup adGroup = new AdGroup();
            adGroup.setName("Women's Red Shoes");
            ArrayList<AdDistribution> adDistribution = new ArrayList<AdDistribution>();
            adDistribution.add(AdDistribution.SEARCH);
            adGroup.setAdDistribution(adDistribution);
            adGroup.setBiddingModel(BiddingModel.KEYWORD);
            adGroup.setPricingModel(PricingModel.CPC);
            adGroup.setStartDate(null);
            Calendar calendar = Calendar.getInstance();
            adGroup.setEndDate(new com.microsoft.bingads.v10.campaignmanagement.Date());
            adGroup.getEndDate().setDay(31);
            adGroup.getEndDate().setMonth(12);
            adGroup.getEndDate().setYear(calendar.get(Calendar.YEAR));
            Bid searchBid = new Bid();
            searchBid.setAmount(0.09);
            adGroup.setSearchBid(searchBid);
            adGroup.setLanguage("English");
            
            // For ad groups you can use either of the InheritFromParentBiddingScheme or ManualCpcBiddingScheme objects. 
            // If you do not set this element, then InheritFromParentBiddingScheme is used by default.
            adGroup.setBiddingScheme(new ManualCpcBiddingScheme());

            //You could use a tracking template which would override the campaign level
            //tracking template. Tracking templates defined for lower level entities 
            //override those set for higher level entities.
            //In this example we are using the campaign level tracking template.
            adGroup.setTrackingUrlTemplate(null);

            adGroups.getAdGroups().add(adGroup);

            // In this example only the second keyword should succeed. The Text of the first keyword exceeds the limit,
            // and the third keyword is a duplicate of the second keyword. 

            ArrayOfKeyword keywords = new ArrayOfKeyword();

            Keyword keyword1 = new Keyword();
            keyword1.setBid(new Bid());
            keyword1.getBid().setAmount(0.47);
            keyword1.setParam2("10% Off");
            keyword1.setMatchType(MatchType.BROAD);
            keyword1.setText("Brand-A Shoes Brand-A Shoes Brand-A Shoes Brand-A Shoes Brand-A Shoes " +
                             "Brand-A Shoes Brand-A Shoes Brand-A Shoes Brand-A Shoes Brand-A Shoes " +
                             "Brand-A Shoes Brand-A Shoes Brand-A Shoes Brand-A Shoes Brand-A Shoes");
            // For keywords you can use either of the InheritFromParentBiddingScheme or ManualCpcBiddingScheme objects. 
            // If you do not set this element, then InheritFromParentBiddingScheme is used by default.
            keyword1.setBiddingScheme(new InheritFromParentBiddingScheme());
            keywords.getKeywords().add(keyword1);

            Keyword keyword2 = new Keyword();
            keyword2.setBid(new Bid());
            keyword2.getBid().setAmount(0.47);
            keyword2.setParam2("10% Off");
            keyword2.setMatchType(MatchType.PHRASE);
            keyword2.setText("Brand-A Shoes");
            // For keywords you can use either of the InheritFromParentBiddingScheme or ManualCpcBiddingScheme objects. 
            // If you do not set this element, then InheritFromParentBiddingScheme is used by default.
            keyword2.setBiddingScheme(new InheritFromParentBiddingScheme());
            keywords.getKeywords().add(keyword2);

            Keyword keyword3 = new Keyword();
            keyword3.setBid(new Bid());
            keyword3.getBid().setAmount(0.47);
            keyword3.setParam2("10% Off");
            keyword3.setMatchType(MatchType.PHRASE);
            keyword3.setText("Brand-A Shoes");
            // For keywords you can use either of the InheritFromParentBiddingScheme or ManualCpcBiddingScheme objects. 
            // If you do not set this element, then InheritFromParentBiddingScheme is used by default.
            keyword3.setBiddingScheme(new InheritFromParentBiddingScheme());
            keywords.getKeywords().add(keyword3);


            // In this example only the first 3 ads should succeed. 
            // The Title of the fourth ad is empty and not valid,
            // and the fifth ad is a duplicate of the second ad. 

            ArrayOfAd ads = new ArrayOfAd();

            for(int i=0; i < 5; i++){
                TextAd textAd = new TextAd();
                textAd.setText("Huge Savings on red shoes.");
                textAd.setDisplayUrl("Contoso.com");

                // If you are currently using the Destination URL, you must upgrade to Final URLs. 
                // Here is an example of a DestinationUrl you might have used previously. 
                // textAd.setDestinationUrl("http://www.contoso.com/womenshoesale/?season=spring&promocode=PROMO123");

                // To migrate from DestinationUrl to FinalUrls for existing ads, you can set DestinationUrl
                // to an empty string when updating the ad. If you are removing DestinationUrl,
                // then FinalUrls is required.
                // textAd.setDestinationUrl("");

                // With FinalUrls you can separate the tracking template, custom parameters, and 
                // landing page URLs. 
                ArrayOfstring finalUrls = new ArrayOfstring();
                finalUrls.getStrings().add("http://www.contoso.com/womenshoesale");
                textAd.setFinalUrls(finalUrls);

                // Final Mobile URLs can also be used if you want to direct the user to a different page 
                // for mobile devices.
                ArrayOfstring finalMobileUrls = new ArrayOfstring();
                finalMobileUrls.getStrings().add("http://mobile.contoso.com/womenshoesale");
                textAd.setFinalMobileUrls(finalMobileUrls);

                // You could use a tracking template which would override the campaign level
                // tracking template. Tracking templates defined for lower level entities 
                // override those set for higher level entities.
                // In this example we are using the campaign level tracking template.
                textAd.setTrackingUrlTemplate(null);

                // Set custom parameters that are specific to this ad, 
                // and can be used by the ad, ad group, campaign, or account level tracking template. 
                // In this example we are using the campaign level tracking template.
                CustomParameters urlCustomParameters = new CustomParameters();
                CustomParameter customParameter1 = new CustomParameter();
                customParameter1.setKey("promoCode");
                customParameter1.setValue("PROMO" + (i+1));
                ArrayOfCustomParameter customParameters = new ArrayOfCustomParameter();
                customParameters.getCustomParameters().add(customParameter1);
                CustomParameter customParameter2 = new CustomParameter();
                customParameter2.setKey("season");
                customParameter2.setValue("summer");
                customParameters.getCustomParameters().add(customParameter2);
                urlCustomParameters.setParameters(customParameters);
                textAd.setUrlCustomParameters(urlCustomParameters);

                ads.getAds().add(textAd);
            }

            ((TextAd)(ads.getAds().get(0))).setTitle("Women's Shoe Sale");
            ((TextAd)(ads.getAds().get(1))).setTitle("Women's Super Shoe Sale");
            ((TextAd)(ads.getAds().get(2))).setTitle("Women's Red Shoe Sale");
            ((TextAd)(ads.getAds().get(3))).setTitle("");
            ((TextAd)(ads.getAds().get(4))).setTitle("Women's Super Shoe Sale");


            // Add the campaign, ad group, keywords, and ads

            AddCampaignsResponse addCampaignsResponse = addCampaigns(AccountId, campaigns);
            ArrayOfNullableOflong campaignIds = addCampaignsResponse.getCampaignIds();
            ArrayOfBatchError campaignErrors = addCampaignsResponse.getPartialErrors();

            AddAdGroupsResponse addAdGroupsResponse = addAdGroups(campaignIds.getLongs().get(0), adGroups);
            ArrayOfNullableOflong adGroupIds = addAdGroupsResponse.getAdGroupIds();
            ArrayOfBatchError adGroupErrors = addAdGroupsResponse.getPartialErrors();

            AddKeywordsResponse addKeywordsResponse = addKeywords(adGroupIds.getLongs().get(0), keywords);
            ArrayOfNullableOflong keywordIds = addKeywordsResponse.getKeywordIds();
            ArrayOfBatchError keywordErrors = addKeywordsResponse.getPartialErrors();

            AddAdsResponse addAdsResponse = addAds(adGroupIds.getLongs().get(0), ads);
            ArrayOfNullableOflong adIds = addAdsResponse.getAdIds();
            ArrayOfBatchError adErrors = addAdsResponse.getPartialErrors();

            // Output the new assigned entity identifiers, as well as any partial errors

            outputCampaignsWithPartialErrors(campaigns, campaignIds, campaignErrors);
            outputAdGroupsWithPartialErrors(adGroups, adGroupIds, adGroupErrors);
            outputKeywordsWithPartialErrors(keywords, keywordIds, keywordErrors);
            outputAdsWithPartialErrors(ads, adIds, adErrors);

            // Here is a simple example that updates the campaign budget

            Campaign updateCampaign = new Campaign();
            updateCampaign.setId(campaignIds.getLongs().get(0));
            updateCampaign.setMonthlyBudget(500.00);
            campaigns = new ArrayOfCampaign();
            campaigns.getCampaigns().add(updateCampaign);

            // As an exercise you can step through using the debugger and view the results.

            ArrayOflong updateCampaignIds = new ArrayOflong();
            updateCampaignIds.getLongs().add(campaignIds.getLongs().get(0));

            ArrayList<CampaignType> campaignTypes = new ArrayList<CampaignType>();
            campaignTypes.add(CampaignType.SHOPPING);
            campaignTypes.add(CampaignType.SEARCH_AND_CONTENT);
            
            ArrayList<CampaignAdditionalField> campaignAdditionalFields = new ArrayList<CampaignAdditionalField>();
            campaignAdditionalFields.add(CampaignAdditionalField.BIDDING_SCHEME);

            getCampaignsByIds(
                authorizationData.getAccountId(),
                updateCampaignIds,
                campaignTypes,
                campaignAdditionalFields);

            updateCampaigns(authorizationData.getAccountId(), campaigns);

            getCampaignsByIds(
                    authorizationData.getAccountId(),
                    updateCampaignIds,
                    campaignTypes,
                    campaignAdditionalFields);

            // Update the Text for the 3 successfully created ads, and update some UrlCustomParameters.

            ArrayOfAd updateAds = new ArrayOfAd();

            TextAd updateTextAd1 = new TextAd();
            updateTextAd1.setId(adIds.getLongs().get(0));
            updateTextAd1.setText("Huge Savings on All Red Shoes.");
            // Set the UrlCustomParameters element to null or empty to retain any 
            // existing custom parameters.
            CustomParameters urlCustomParameters1 = null;
            updateTextAd1.setUrlCustomParameters(urlCustomParameters1);
            updateAds.getAds().add(updateTextAd1);

            TextAd updateTextAd2 = new TextAd();
            updateTextAd2.setId(adIds.getLongs().get(1));
            updateTextAd2.setText("Huge Savings on All Red Shoes.");
            // To remove all custom parameters, set the Parameters element of the 
            // CustomParameters object to null or empty.
            CustomParameters urlCustomParameters2 = new CustomParameters();
            ArrayOfCustomParameter customParameters2 = null;
            urlCustomParameters2.setParameters(customParameters2);
            updateTextAd2.setUrlCustomParameters(urlCustomParameters2);
            updateAds.getAds().add(updateTextAd2);

            TextAd updateTextAd3 = new TextAd();
            updateTextAd3.setId(adIds.getLongs().get(2));
            updateTextAd3.setText("Huge Savings on All Red Shoes.");
            // To remove a subset of custom parameters, specify the custom parameters that 
            // you want to keep in the Parameters element of the CustomParameters object.
            CustomParameters urlCustomParameters3 = new CustomParameters();
            CustomParameter customParameter3 = new CustomParameter();
            customParameter3.setKey("promoCode");
            customParameter3.setValue("updatedpromo");
            ArrayOfCustomParameter customParameters3 = new ArrayOfCustomParameter();
            customParameters3.getCustomParameters().add(customParameter3);
            urlCustomParameters3.setParameters(customParameters3);
            updateTextAd3.setUrlCustomParameters(urlCustomParameters3);
            updateAds.getAds().add(updateTextAd3);

            // As an exercise you can step through using the debugger and view the results.

            ArrayOflong updateAdGroupIds = new ArrayOflong();
            updateAdGroupIds.getLongs().add(adGroupIds.getLongs().get(0));

            GetAdsByAdGroupIdResponse getAdsByAdGroupIdResponse = getAdsByAdGroupId(adGroupIds.getLongs().get(0));
            UpdateAdsResponse updateAdsResponse = updateAds(adGroupIds.getLongs().get(0), updateAds);
            getAdsByAdGroupIdResponse = getAdsByAdGroupId(adGroupIds.getLongs().get(0));


            // Here is a simple example that updates the keyword bid to use the ad group bid.

            Keyword updateKeyword = new Keyword();
            updateKeyword.setId(keywordIds.getLongs().get(0));
            updateKeyword.setBid(new Bid());
            updateKeyword.getBid().setAmount(null);
            ArrayOfKeyword updateKeywords = new ArrayOfKeyword();
            updateKeywords.getKeywords().add(updateKeyword);

            // As an exercise you can step through using the debugger and view the results.

            ArrayOflong updateKeywordIds = new ArrayOflong();
            updateKeywordIds.getLongs().add(keywordIds.getLongs().get(0));
            
            ArrayList<KeywordAdditionalField> keywordAdditionalFields = new ArrayList<KeywordAdditionalField>();
            keywordAdditionalFields.add(KeywordAdditionalField.BIDDING_SCHEME);

            GetKeywordsByAdGroupIdResponse getKeywordsByAdGroupIdResponse = getKeywordsByAdGroupId(adGroupIds.getLongs().get(0), keywordAdditionalFields);
            UpdateKeywordsResponse updateKeywordsResponse = updateKeywords(adGroupIds.getLongs().get(0), updateKeywords);
            getKeywordsByAdGroupIdResponse = getKeywordsByAdGroupId(adGroupIds.getLongs().get(0), keywordAdditionalFields);      


            // Delete the campaign, ad group, keyword, and ad that were previously added. 
            // You should remove this line if you want to view the added entities in the 
            // Bing Ads web application or another tool.

            ArrayOflong deleteCampaignIds = new ArrayOflong();
            deleteCampaignIds.getLongs().add(campaignIds.getLongs().get(0));
            deleteCampaigns(AccountId, deleteCampaignIds);
            System.out.printf("Deleted CampaignId %d\n", campaignIds.getLongs().get(0));

            outputStatusMessage("Program execution completed\n"); 

        // Campaign Management service operations can throw AdApiFaultDetail.
        } catch (AdApiFaultDetail_Exception ex) {
            outputStatusMessage("The operation failed with the following faults:\n");

            for (AdApiError error : ex.getFaultInfo().getErrors().getAdApiErrors())
            {
                outputStatusMessage("AdApiError\n");
                outputStatusMessage(String.format("Code: %d\nError Code: %s\nMessage: %s\n\n", error.getCode(), error.getErrorCode(), error.getMessage()));
            }
        
        // Campaign Management service operations can throw ApiFaultDetail.
        } catch (ApiFaultDetail_Exception ex) {
            outputStatusMessage("The operation failed with the following faults:\n");

            for (BatchError error : ex.getFaultInfo().getBatchErrors().getBatchErrors())
            {
                outputStatusMessage(String.format("BatchError at Index: %d\n", error.getIndex()));
                outputStatusMessage(String.format("Code: %d\nMessage: %s\n\n", error.getCode(), error.getMessage()));
            }

            for (OperationError error : ex.getFaultInfo().getOperationErrors().getOperationErrors())
            {
                outputStatusMessage("OperationError\n");
                outputStatusMessage(String.format("Code: %d\nMessage: %s\n\n", error.getCode(), error.getMessage()));
            }
        } catch (RemoteException ex) {
            outputStatusMessage("Service communication error encountered: ");
            outputStatusMessage(ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            outputStatusMessage("Error encountered: ");
            outputStatusMessage(ex.getMessage());
            ex.printStackTrace();
        }
     }

     // Adds one or more campaigns to the specified account.

     static AddCampaignsResponse addCampaigns(long accountId, ArrayOfCampaign campaigns) throws RemoteException, Exception
     {
         AddCampaignsRequest request = new AddCampaignsRequest();
         
         request.setAccountId(accountId);
         request.setCampaigns(campaigns);

         return CampaignService.getService().addCampaigns(request);
     }
     
     // Deletes one or more campaigns from the specified account.

     static void deleteCampaigns(long accountId, ArrayOflong campaignIds) throws RemoteException, Exception
     {
    	 DeleteCampaignsRequest request = new DeleteCampaignsRequest();
         
         request.setAccountId(accountId);
         request.setCampaignIds(campaignIds);

         CampaignService.getService().deleteCampaigns(request);
     }
     
     // Gets one or more campaigns for the specified campaign identifiers
     
     static ArrayOfCampaign getCampaignsByIds(
    		 long accountId, 
    		 ArrayOflong campaignIds,
    		 ArrayList<CampaignType> campaignType,
                 ArrayList<CampaignAdditionalField> returnAdditionalFields) throws RemoteException, Exception
     {
    	 GetCampaignsByIdsRequest request = new GetCampaignsByIdsRequest();
         
         request.setAccountId(accountId);;
         request.setCampaignIds(campaignIds);
         request.setCampaignType(campaignType);
         request.setReturnAdditionalFields(returnAdditionalFields);

         return CampaignService.getService().getCampaignsByIds(request).getCampaigns();
     }
     
     // Updates one or more campaigns.

     static void updateCampaigns(long accountId, ArrayOfCampaign campaigns) throws RemoteException, Exception
     {
    	 UpdateCampaignsRequest request = new UpdateCampaignsRequest();
         
         request.setAccountId(accountId);
         request.setCampaigns(campaigns);

         CampaignService.getService().updateCampaigns(request);
     }
          
     // Adds one or more ad groups to the specified campaign.

     static AddAdGroupsResponse addAdGroups(long campaignId, ArrayOfAdGroup adGroups) throws RemoteException, Exception
     {
         AddAdGroupsRequest request = new AddAdGroupsRequest();
         
         request.setCampaignId(campaignId);
         request.setAdGroups(adGroups);

         return CampaignService.getService().addAdGroups(request);
     }

     // Adds one or more keywords to the specified ad group.

     static AddKeywordsResponse addKeywords(long adGroupId, ArrayOfKeyword keywords) throws RemoteException, Exception
     {
         AddKeywordsRequest request = new AddKeywordsRequest();
         
         request.setAdGroupId(adGroupId);
         request.setKeywords(keywords);

         return CampaignService.getService().addKeywords(request);
     }

     // Adds one or more ads to the specified ad group.

     static AddAdsResponse addAds(long adGroupId, ArrayOfAd ads) throws RemoteException, Exception
     {
         AddAdsRequest request = new AddAdsRequest();
         
         request.setAdGroupId(adGroupId);
         request.setAds(ads);

         return CampaignService.getService().addAds(request);
     }
     
     // Gets the ads in the specified ad group.

     static GetAdsByAdGroupIdResponse getAdsByAdGroupId(long adGroupId) throws RemoteException, Exception
     {
    	 GetAdsByAdGroupIdRequest request = new GetAdsByAdGroupIdRequest();
         
         request.setAdGroupId(adGroupId);

         return CampaignService.getService().getAdsByAdGroupId(request);
     }
     
     // Updates the ads in the specified ad group.

     static UpdateAdsResponse updateAds(long adGroupId, ArrayOfAd ads) throws RemoteException, Exception
     {
    	 UpdateAdsRequest request = new UpdateAdsRequest();
         
         request.setAdGroupId(adGroupId);
         request.setAds(ads);

         return CampaignService.getService().updateAds(request);
     }
     
     // Gets the keywords in the specified ad group.

     static GetKeywordsByAdGroupIdResponse getKeywordsByAdGroupId(
             long adGroupId, 
             ArrayList<KeywordAdditionalField> returnAdditionalFields) throws RemoteException, Exception
     {
    	 GetKeywordsByAdGroupIdRequest request = new GetKeywordsByAdGroupIdRequest();
         
         request.setAdGroupId(adGroupId);
         request.setReturnAdditionalFields(returnAdditionalFields);

         return CampaignService.getService().getKeywordsByAdGroupId(request);
     }
     
     // Updates the keywords in the specified ad group.

     static UpdateKeywordsResponse updateKeywords(long adGroupId, ArrayOfKeyword keywords) throws RemoteException, Exception
     {
    	 UpdateKeywordsRequest request = new UpdateKeywordsRequest();
         
         request.setAdGroupId(adGroupId);
         request.setKeywords(keywords);

         return CampaignService.getService().updateKeywords(request);
     }
 }