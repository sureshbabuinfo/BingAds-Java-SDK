
package com.microsoft.bingads.bulk;

import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebService(name = "IBulkService", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IBulkService {


    /**
     * 
     * @param parameters
     * @return
     *     returns javax.xml.ws.Response<com.microsoft.bingads.bulk.DownloadCampaignsByAccountIdsResponse>
     */
    @WebMethod(operationName = "DownloadCampaignsByAccountIds", action = "DownloadCampaignsByAccountIds")
    public Response<DownloadCampaignsByAccountIdsResponse> downloadCampaignsByAccountIdsAsync(
        @WebParam(name = "DownloadCampaignsByAccountIdsRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        DownloadCampaignsByAccountIdsRequest parameters);

    /**
     * 
     * @param asyncHandler
     * @param parameters
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "DownloadCampaignsByAccountIds", action = "DownloadCampaignsByAccountIds")
    public Future<?> downloadCampaignsByAccountIdsAsync(
        @WebParam(name = "DownloadCampaignsByAccountIdsRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        DownloadCampaignsByAccountIdsRequest parameters,
        @WebParam(name = "DownloadCampaignsByAccountIdsResponse", targetNamespace = "", partName = "asyncHandler")
        AsyncHandler<DownloadCampaignsByAccountIdsResponse> asyncHandler);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.microsoft.bingads.bulk.DownloadCampaignsByAccountIdsResponse
     * @throws AdApiFaultDetail_Exception
     * @throws ApiFaultDetail_Exception
     */
    @WebMethod(operationName = "DownloadCampaignsByAccountIds", action = "DownloadCampaignsByAccountIds")
    @WebResult(name = "DownloadCampaignsByAccountIdsResponse", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
    public DownloadCampaignsByAccountIdsResponse downloadCampaignsByAccountIds(
        @WebParam(name = "DownloadCampaignsByAccountIdsRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        DownloadCampaignsByAccountIdsRequest parameters)
        throws AdApiFaultDetail_Exception, ApiFaultDetail_Exception
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns javax.xml.ws.Response<com.microsoft.bingads.bulk.DownloadCampaignsByCampaignIdsResponse>
     */
    @WebMethod(operationName = "DownloadCampaignsByCampaignIds", action = "DownloadCampaignsByCampaignIds")
    public Response<DownloadCampaignsByCampaignIdsResponse> downloadCampaignsByCampaignIdsAsync(
        @WebParam(name = "DownloadCampaignsByCampaignIdsRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        DownloadCampaignsByCampaignIdsRequest parameters);

    /**
     * 
     * @param asyncHandler
     * @param parameters
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "DownloadCampaignsByCampaignIds", action = "DownloadCampaignsByCampaignIds")
    public Future<?> downloadCampaignsByCampaignIdsAsync(
        @WebParam(name = "DownloadCampaignsByCampaignIdsRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        DownloadCampaignsByCampaignIdsRequest parameters,
        @WebParam(name = "DownloadCampaignsByCampaignIdsResponse", targetNamespace = "", partName = "asyncHandler")
        AsyncHandler<DownloadCampaignsByCampaignIdsResponse> asyncHandler);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.microsoft.bingads.bulk.DownloadCampaignsByCampaignIdsResponse
     * @throws AdApiFaultDetail_Exception
     * @throws ApiFaultDetail_Exception
     */
    @WebMethod(operationName = "DownloadCampaignsByCampaignIds", action = "DownloadCampaignsByCampaignIds")
    @WebResult(name = "DownloadCampaignsByCampaignIdsResponse", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
    public DownloadCampaignsByCampaignIdsResponse downloadCampaignsByCampaignIds(
        @WebParam(name = "DownloadCampaignsByCampaignIdsRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        DownloadCampaignsByCampaignIdsRequest parameters)
        throws AdApiFaultDetail_Exception, ApiFaultDetail_Exception
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns javax.xml.ws.Response<com.microsoft.bingads.bulk.GetDownloadStatusResponse>
     */
    @WebMethod(operationName = "GetDownloadStatus", action = "GetDownloadStatus")
    public Response<GetDownloadStatusResponse> getDownloadStatusAsync(
        @WebParam(name = "GetDownloadStatusRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        GetDownloadStatusRequest parameters);

    /**
     * 
     * @param asyncHandler
     * @param parameters
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetDownloadStatus", action = "GetDownloadStatus")
    public Future<?> getDownloadStatusAsync(
        @WebParam(name = "GetDownloadStatusRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        GetDownloadStatusRequest parameters,
        @WebParam(name = "GetDownloadStatusResponse", targetNamespace = "", partName = "asyncHandler")
        AsyncHandler<GetDownloadStatusResponse> asyncHandler);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.microsoft.bingads.bulk.GetDownloadStatusResponse
     * @throws AdApiFaultDetail_Exception
     * @throws ApiFaultDetail_Exception
     */
    @WebMethod(operationName = "GetDownloadStatus", action = "GetDownloadStatus")
    @WebResult(name = "GetDownloadStatusResponse", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
    public GetDownloadStatusResponse getDownloadStatus(
        @WebParam(name = "GetDownloadStatusRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        GetDownloadStatusRequest parameters)
        throws AdApiFaultDetail_Exception, ApiFaultDetail_Exception
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns javax.xml.ws.Response<com.microsoft.bingads.bulk.GetDetailedBulkDownloadStatusResponse>
     */
    @WebMethod(operationName = "GetDetailedBulkDownloadStatus", action = "GetDetailedBulkDownloadStatus")
    public Response<GetDetailedBulkDownloadStatusResponse> getDetailedBulkDownloadStatusAsync(
        @WebParam(name = "GetDetailedBulkDownloadStatusRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        GetDetailedBulkDownloadStatusRequest parameters);

    /**
     * 
     * @param asyncHandler
     * @param parameters
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetDetailedBulkDownloadStatus", action = "GetDetailedBulkDownloadStatus")
    public Future<?> getDetailedBulkDownloadStatusAsync(
        @WebParam(name = "GetDetailedBulkDownloadStatusRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        GetDetailedBulkDownloadStatusRequest parameters,
        @WebParam(name = "GetDetailedBulkDownloadStatusResponse", targetNamespace = "", partName = "asyncHandler")
        AsyncHandler<GetDetailedBulkDownloadStatusResponse> asyncHandler);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.microsoft.bingads.bulk.GetDetailedBulkDownloadStatusResponse
     * @throws AdApiFaultDetail_Exception
     * @throws ApiFaultDetail_Exception
     */
    @WebMethod(operationName = "GetDetailedBulkDownloadStatus", action = "GetDetailedBulkDownloadStatus")
    @WebResult(name = "GetDetailedBulkDownloadStatusResponse", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
    public GetDetailedBulkDownloadStatusResponse getDetailedBulkDownloadStatus(
        @WebParam(name = "GetDetailedBulkDownloadStatusRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        GetDetailedBulkDownloadStatusRequest parameters)
        throws AdApiFaultDetail_Exception, ApiFaultDetail_Exception
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns javax.xml.ws.Response<com.microsoft.bingads.bulk.GetBulkUploadUrlResponse>
     */
    @WebMethod(operationName = "GetBulkUploadUrl", action = "GetBulkUploadUrl")
    public Response<GetBulkUploadUrlResponse> getBulkUploadUrlAsync(
        @WebParam(name = "GetBulkUploadUrlRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        GetBulkUploadUrlRequest parameters);

    /**
     * 
     * @param asyncHandler
     * @param parameters
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetBulkUploadUrl", action = "GetBulkUploadUrl")
    public Future<?> getBulkUploadUrlAsync(
        @WebParam(name = "GetBulkUploadUrlRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        GetBulkUploadUrlRequest parameters,
        @WebParam(name = "GetBulkUploadUrlResponse", targetNamespace = "", partName = "asyncHandler")
        AsyncHandler<GetBulkUploadUrlResponse> asyncHandler);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.microsoft.bingads.bulk.GetBulkUploadUrlResponse
     * @throws AdApiFaultDetail_Exception
     * @throws ApiFaultDetail_Exception
     */
    @WebMethod(operationName = "GetBulkUploadUrl", action = "GetBulkUploadUrl")
    @WebResult(name = "GetBulkUploadUrlResponse", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
    public GetBulkUploadUrlResponse getBulkUploadUrl(
        @WebParam(name = "GetBulkUploadUrlRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        GetBulkUploadUrlRequest parameters)
        throws AdApiFaultDetail_Exception, ApiFaultDetail_Exception
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns javax.xml.ws.Response<com.microsoft.bingads.bulk.GetBulkUploadStatusResponse>
     */
    @WebMethod(operationName = "GetBulkUploadStatus", action = "GetBulkUploadStatus")
    public Response<GetBulkUploadStatusResponse> getBulkUploadStatusAsync(
        @WebParam(name = "GetBulkUploadStatusRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        GetBulkUploadStatusRequest parameters);

    /**
     * 
     * @param asyncHandler
     * @param parameters
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetBulkUploadStatus", action = "GetBulkUploadStatus")
    public Future<?> getBulkUploadStatusAsync(
        @WebParam(name = "GetBulkUploadStatusRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        GetBulkUploadStatusRequest parameters,
        @WebParam(name = "GetBulkUploadStatusResponse", targetNamespace = "", partName = "asyncHandler")
        AsyncHandler<GetBulkUploadStatusResponse> asyncHandler);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.microsoft.bingads.bulk.GetBulkUploadStatusResponse
     * @throws AdApiFaultDetail_Exception
     * @throws ApiFaultDetail_Exception
     */
    @WebMethod(operationName = "GetBulkUploadStatus", action = "GetBulkUploadStatus")
    @WebResult(name = "GetBulkUploadStatusResponse", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
    public GetBulkUploadStatusResponse getBulkUploadStatus(
        @WebParam(name = "GetBulkUploadStatusRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        GetBulkUploadStatusRequest parameters)
        throws AdApiFaultDetail_Exception, ApiFaultDetail_Exception
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns javax.xml.ws.Response<com.microsoft.bingads.bulk.GetDetailedBulkUploadStatusResponse>
     */
    @WebMethod(operationName = "GetDetailedBulkUploadStatus", action = "GetDetailedBulkUploadStatus")
    public Response<GetDetailedBulkUploadStatusResponse> getDetailedBulkUploadStatusAsync(
        @WebParam(name = "GetDetailedBulkUploadStatusRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        GetDetailedBulkUploadStatusRequest parameters);

    /**
     * 
     * @param asyncHandler
     * @param parameters
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "GetDetailedBulkUploadStatus", action = "GetDetailedBulkUploadStatus")
    public Future<?> getDetailedBulkUploadStatusAsync(
        @WebParam(name = "GetDetailedBulkUploadStatusRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        GetDetailedBulkUploadStatusRequest parameters,
        @WebParam(name = "GetDetailedBulkUploadStatusResponse", targetNamespace = "", partName = "asyncHandler")
        AsyncHandler<GetDetailedBulkUploadStatusResponse> asyncHandler);

    /**
     * 
     * @param parameters
     * @return
     *     returns com.microsoft.bingads.bulk.GetDetailedBulkUploadStatusResponse
     * @throws AdApiFaultDetail_Exception
     * @throws ApiFaultDetail_Exception
     */
    @WebMethod(operationName = "GetDetailedBulkUploadStatus", action = "GetDetailedBulkUploadStatus")
    @WebResult(name = "GetDetailedBulkUploadStatusResponse", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
    public GetDetailedBulkUploadStatusResponse getDetailedBulkUploadStatus(
        @WebParam(name = "GetDetailedBulkUploadStatusRequest", targetNamespace = "https://bingads.microsoft.com/CampaignManagement/v9", partName = "parameters")
        GetDetailedBulkUploadStatusRequest parameters)
        throws AdApiFaultDetail_Exception, ApiFaultDetail_Exception
    ;

}