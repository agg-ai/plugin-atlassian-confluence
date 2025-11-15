# AnalyticsApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getViewers**](AnalyticsApi.md#getViewers) | **GET** /wiki/rest/api/analytics/content/{contentId}/viewers | Get viewers |
| [**getViews**](AnalyticsApi.md#getViews) | **GET** /wiki/rest/api/analytics/content/{contentId}/views | Get views |


<a id="getViewers"></a>
# **getViewers**
> GetViewers200Response getViewers(contentId, fromDate)

Get viewers

Get the total number of distinct viewers a piece of content has.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.AnalyticsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://your-domain.atlassian.net");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    // Configure OAuth2 access token for authorization: oAuthDefinitions
    OAuth oAuthDefinitions = (OAuth) defaultClient.getAuthentication("oAuthDefinitions");
    oAuthDefinitions.setAccessToken("YOUR ACCESS TOKEN");

    AnalyticsApi apiInstance = new AnalyticsApi(defaultClient);
    String contentId = "contentId_example"; // String | The ID of the content to get the viewers for.
    String fromDate = "2021-03-21T00:00:00.000Z"; // String | The number of views for the content since the date.
    try {
      GetViewers200Response result = apiInstance.getViewers(contentId, fromDate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnalyticsApi#getViewers");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **contentId** | **String**| The ID of the content to get the viewers for. | |
| **fromDate** | **String**| The number of views for the content since the date. | [optional] |

### Return type

[**GetViewers200Response**](GetViewers200Response.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns the total number of distinct viewers for the content. |  -  |
| **400** | Returned if client input is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect. |  -  |
| **403** | Returned if the authentication credentials are missing from the request. |  -  |
| **404** | Returned if; - There is no content with the given ID. |  -  |

<a id="getViews"></a>
# **getViews**
> GetViews200Response getViews(contentId, fromDate)

Get views

Get the total number of views a piece of content has.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.AnalyticsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://your-domain.atlassian.net");
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("YOUR USERNAME");
    basicAuth.setPassword("YOUR PASSWORD");

    // Configure OAuth2 access token for authorization: oAuthDefinitions
    OAuth oAuthDefinitions = (OAuth) defaultClient.getAuthentication("oAuthDefinitions");
    oAuthDefinitions.setAccessToken("YOUR ACCESS TOKEN");

    AnalyticsApi apiInstance = new AnalyticsApi(defaultClient);
    String contentId = "contentId_example"; // String | The ID of the content to get the views for.
    String fromDate = "2021-03-21T00:00:00.000Z"; // String | The number of views for the content since the date.
    try {
      GetViews200Response result = apiInstance.getViews(contentId, fromDate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AnalyticsApi#getViews");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **contentId** | **String**| The ID of the content to get the views for. | |
| **fromDate** | **String**| The number of views for the content since the date. | [optional] |

### Return type

[**GetViews200Response**](GetViews200Response.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns the total number of views for the content. |  -  |
| **400** | Returned if client input is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect. |  -  |
| **403** | Returned if the authentication credentials are missing from the request. |  -  |
| **404** | Returned if; - There is no content with the given ID. |  -  |

