package com.microsoft.bingads.v11.api.test.entities.ad_extension.site_link;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.microsoft.bingads.v11.api.test.entities.ad_extension.site_link.read.BulkSiteLinkAdExtensionReadTests;
import com.microsoft.bingads.v11.api.test.entities.ad_extension.site_link.write.BulkSiteLinkAdExtensionWriteTests;

@RunWith(Suite.class)
@SuiteClasses({BulkSiteLinkAdExtensionReadTests.class, BulkSiteLinkAdExtensionWriteTests.class})
public class BulkSiteLinkAdExtensionTests {

}
