package com.microsoft.bingads.api.test.operations.bulk_upload_operation;

import com.microsoft.bingads.api.test.operations.FakeBulkService;
import com.microsoft.bingads.api.test.operations.TestProgress;
import static org.junit.Assert.fail;

import java.util.concurrent.ExecutionException;

import org.junit.Test;
import com.microsoft.bingads.bulk.BulkOperationStatus;
import com.microsoft.bingads.bulk.BulkUploadOperation;
import com.microsoft.bingads.bulk.GetDetailedBulkUploadStatusResponse;
import com.microsoft.bingads.bulk.UploadStatus;
import com.microsoft.bingads.internal.functionalInterfaces.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;

public class TrackTest extends BulkUploadOperationTest {

    @Test
    public void pollsForStatusUntilCompletedAndReturnsCorrectStatusWhenCompleted() throws InterruptedException, ExecutionException {
        BulkUploadOperation operation = createBulkUploadOperation(10);

        FakeBulkService.setGetDetailedBulkUploadStatusResponse(new Supplier<GetDetailedBulkUploadStatusResponse>() {

            Integer pollNumber = 1;

            @Override
            public GetDetailedBulkUploadStatusResponse get() {
                switch (pollNumber++) {
                    case 1:
                        return createStatusResponse(1, "InProgress", null);
                    case 2:
                        return createStatusResponse(25, "InProgress", null);
                    case 3:
                        return createStatusResponse(100, "Completed", "http://downloadurl.com");
                    default:
                        fail("Unexpected polling attempt");
                        return null;
                }
            }
        });
        
        FakeBulkService.setInboundHeadersSupplier(createTrackingIdHeaderSupplier());

        TestProgress progress = new TestProgress();

        BulkOperationStatus<UploadStatus> actualStatus = operation.trackAsync(progress, null).get();

        assertEquals(UploadStatus.COMPLETED, actualStatus.getStatus());
        assertEquals(100, actualStatus.getPercentComplete());
        assertEquals("http://downloadurl.com", actualStatus.getResultFileUrl());

        List<Integer> expectedProgress = new ArrayList<Integer>();
        expectedProgress.add(1);
        expectedProgress.add(25);
        expectedProgress.add(100);

        progress.AssertReportedProgress(expectedProgress);
    }
}