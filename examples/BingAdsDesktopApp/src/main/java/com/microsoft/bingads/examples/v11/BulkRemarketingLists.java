package com.microsoft.bingads.examples.v11;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Calendar;

import com.microsoft.bingads.v11.bulk.entities.*;
import com.microsoft.bingads.v11.bulk.*;
import com.microsoft.bingads.v11.campaignmanagement.*;

public class BulkRemarketingLists extends BulkExampleBase {
	        
    public static void main(String[] args) {
		
        BulkEntityIterable downloadEntities = null;

        try {
            authorizationData = getAuthorizationData(null,null);

            BulkServiceManager = new BulkServiceManager(authorizationData, API_ENVIRONMENT);
            BulkServiceManager.setStatusPollIntervalInMilliseconds(5000);

            ArrayOfDownloadEntity entities = new ArrayOfDownloadEntity();
            entities.getDownloadEntities().add(DownloadEntity.REMARKETING_LISTS);

            DownloadParameters downloadParameters = new DownloadParameters();
            downloadParameters.setDownloadEntities(entities);
            downloadParameters.setFileType(BulkDownloadFileType.CSV);
            downloadParameters.setResultFileDirectory(new File(FileDirectory));
            downloadParameters.setResultFileName(DownloadFileName);
            downloadParameters.setOverwriteResultFile(true);
            downloadParameters.setLastSyncTimeInUTC(null);

            // Download all remarketing lists across all ad groups in the account.
            File bulkFilePath = BulkServiceManager.downloadFileAsync(downloadParameters, null, null).get();
            outputStatusMessage("Downloaded all remarketing lists that the current user can associate with ad groups.\n"); 
            Reader = new BulkFileReader(bulkFilePath, ResultFileType.FULL_DOWNLOAD, BulkDownloadFileType);
            downloadEntities = Reader.getEntities();

            List<BulkRemarketingList> remarketingListResults = new ArrayList<BulkRemarketingList>();

            for (BulkEntity entity : downloadEntities) {
                if (entity instanceof BulkRemarketingList) {
                    remarketingListResults.add((BulkRemarketingList) entity);
                    outputBulkRemarketingLists(Arrays.asList((BulkRemarketingList) entity) );
                }
            }
            downloadEntities.close();
            Reader.close();

            // You must already have at least one remarketing list. 
            if (remarketingListResults.size() < 1)
            {
                return;
            }


            // Prepare the bulk entities that you want to upload. 

            BulkCampaign bulkCampaign = new BulkCampaign();
            Campaign campaign = new Campaign();
            // When adding an entity using the Campaign Management service, the Id cannot be set. In the context of a BulkCampaign, the Id is optional  
            // and may be used as a negative reference key during bulk upload. For example the same negative reference key for the campaign Id  
            // will be used when adding new ad groups to this new campaign, or when associating ad extensions with the campaign. 
            campaign.setId(campaignIdKey);
            campaign.setName("Summer Shoes " + System.currentTimeMillis());
            campaign.setDescription("Summer shoes line.");
            campaign.setBudgetType(BudgetLimitType.DAILY_BUDGET_STANDARD);
            campaign.setDailyBudget(50.00);
            campaign.setTimeZone("PacificTimeUSCanadaTijuana");
            campaign.setStatus(CampaignStatus.PAUSED);

            EnhancedCpcBiddingScheme enhancedCpcBiddingScheme = new EnhancedCpcBiddingScheme();
            enhancedCpcBiddingScheme.setType("EnhancedCpcBiddingScheme");
            campaign.setBiddingScheme(enhancedCpcBiddingScheme);
            bulkCampaign.setCampaign(campaign);

            BulkAdGroup bulkAdGroup = new BulkAdGroup();
            bulkAdGroup.setCampaignId(campaignIdKey);
            // ClientId may be used to associate records in the bulk upload file with records in the results file. The value of this field  
            // is not used or stored by the server; it is simply copied from the uploaded record to the corresponding result record. 
            // Note: This bulk file Client Id is not related to an application Client Id for OAuth. 
            bulkAdGroup.setClientId("YourClientIdGoesHere");

            AdGroup adGroup = new AdGroup();
            // When adding an entity using the Campaign Management service, the Id cannot be set. In the context of a BulkAdGroup,  
            // the Id is optional and may be used as a negative reference key during bulk upload. 
            // For example the same negative value set for the ad group Id will be used when associating this new ad group with a 
            // new ad group remarketing list association in the BulkAdGroupRemarketingList object below. 
            adGroup.setId(adGroupIdKey);
            adGroup.setName("Women's Red Shoes");
            List<AdDistribution> adDistribution = new ArrayList<AdDistribution>();
            adDistribution.add(AdDistribution.SEARCH);
            adGroup.setAdDistribution(adDistribution);
            adGroup.setStartDate(null);
            Calendar calendar = Calendar.getInstance();
            adGroup.setEndDate(new com.microsoft.bingads.v11.campaignmanagement.Date());
            adGroup.getEndDate().setDay(31);
            adGroup.getEndDate().setMonth(12);
            adGroup.getEndDate().setYear(calendar.get(Calendar.YEAR));
            Bid searchBid = new Bid();
            searchBid.setAmount(0.09);
            adGroup.setSearchBid(searchBid);
            adGroup.setLanguage("English");

            // Applicable for all remarketing lists that are associated with this ad group. TARGET_AND_BID indicates 
            // that you want to show ads only to people included in the remarketing list, with the option to change
            // the bid amount. Ads in this ad group will only show to people included in the remarketing list.
            adGroup.setRemarketingTargetingSetting(RemarketingTargetingSetting.TARGET_AND_BID);

            bulkAdGroup.setAdGroup(adGroup);


            List<BulkEntity> uploadEntities = new ArrayList<BulkEntity>();
            uploadEntities.add(bulkCampaign);
            uploadEntities.add(bulkAdGroup);

            // This example associates all of the remarketing lists with the new ad group.

            for (BulkRemarketingList bulkRemarketingList : remarketingListResults) {
                if(bulkRemarketingList.getRemarketingList() != null && bulkRemarketingList.getRemarketingList().getId() != null)
                {
                    BulkAdGroupRemarketingListAssociation bulkAdGroupRemarketingListAssociation = new BulkAdGroupRemarketingListAssociation();
                    bulkAdGroupRemarketingListAssociation.setClientId("MyBulkAdGroupRemarketingList " + bulkRemarketingList.getRemarketingList().getId());
                    BiddableAdGroupCriterion biddableAdGroupCriterion = new BiddableAdGroupCriterion();
                    biddableAdGroupCriterion.setAdGroupId(adGroupIdKey);
                    AudienceCriterion audienceCriterion = new AudienceCriterion();
                    audienceCriterion.setAudienceId(bulkRemarketingList.getRemarketingList().getId());
                    ArrayList<AudienceType> audienceType = new ArrayList<AudienceType>();
                    audienceType.add(AudienceType.REMARKETING_LIST);
                    audienceCriterion.setAudienceType(audienceType);
                    biddableAdGroupCriterion.setCriterion(audienceCriterion);
                    BidMultiplier bidMultiplier = new BidMultiplier();
                    bidMultiplier.setMultiplier(90D);
                    biddableAdGroupCriterion.setCriterionBid(bidMultiplier);
                    biddableAdGroupCriterion.setStatus(AdGroupCriterionStatus.PAUSED);
                    bulkAdGroupRemarketingListAssociation.setBiddableAdGroupCriterion(biddableAdGroupCriterion);

                    uploadEntities.add(bulkAdGroupRemarketingListAssociation);
                }
            }

            outputStatusMessage("\nAdding campaign, ad group, and ad group remarketing list associations...\n");

            // Upload and write the output

            Reader = writeEntitiesAndUploadFile(uploadEntities);
            downloadEntities = Reader.getEntities();

            List<BulkCampaign> campaignResults = new ArrayList<BulkCampaign>();

            for (BulkEntity entity : downloadEntities) {
                if (entity instanceof BulkCampaign) {
                    campaignResults.add((BulkCampaign) entity);
                    outputBulkCampaigns(Arrays.asList((BulkCampaign) entity) );
                }
                else if (entity instanceof BulkAdGroup) {
                    outputBulkAdGroups(Arrays.asList((BulkAdGroup) entity) );
                }
                else if (entity instanceof BulkAdGroupRemarketingListAssociation) {
                    outputBulkAdGroupRemarketingListAssociations(Arrays.asList((BulkAdGroupRemarketingListAssociation) entity) );
                }
            }
            downloadEntities.close();
            Reader.close();

            // Delete the campaign, ad group, and ad group remarketing list associations that were previously added.
            // The remarketing lists will not be deleted. 
            // You should remove this region if you want to view the added entities in the 
            // Bing Ads web application or another tool.

            // You must set the Id field to the corresponding entity identifier, and the Status field to Deleted.

            // When you delete a BulkCampaign, the dependent entities such as BulkAdGroup and BulkAdGroupRemarketingList 
            // are deleted without being specified explicitly.   

            uploadEntities = new ArrayList<BulkEntity>();

            for (BulkCampaign campaignResult : campaignResults){
                campaignResult.getCampaign().setStatus(CampaignStatus.DELETED);
                uploadEntities.add(campaignResult);
            }

            // Upload and write the output

            Reader = writeEntitiesAndUploadFile(uploadEntities);
            downloadEntities = Reader.getEntities();

            for (BulkEntity entity : downloadEntities) {
                if (entity instanceof BulkCampaign) {
                    campaignResults.add((BulkCampaign) entity);
                    outputBulkCampaigns(Arrays.asList((BulkCampaign) entity) );
                }
            }
            downloadEntities.close();
            Reader.close();

            outputStatusMessage("Program execution completed\n"); 

        }
        catch (Exception ex) {
            String faultXml = BingAdsExceptionHelper.getBingAdsExceptionFaultXml(ex, System.out);
            String message = BingAdsExceptionHelper.handleBingAdsSDKException(ex, System.out);
            ex.printStackTrace();
        } 
        finally {
            if (downloadEntities != null){
                try {
                    downloadEntities.close();
                } 
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        System.exit(0);
    }
}
