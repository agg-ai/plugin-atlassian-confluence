# LabelInfoApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllLabelContent**](LabelInfoApi.md#getAllLabelContent) | **GET** /wiki/rest/api/label | Get label information |


<a id="getAllLabelContent"></a>
# **getAllLabelContent**
> LabelDetails getAllLabelContent(name, type, start, limit)

Get label information

Returns label information and a list of contents associated with the label.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission). Only contents that the user is permitted to view is returned.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.LabelInfoApi;

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

    LabelInfoApi apiInstance = new LabelInfoApi(defaultClient);
    String name = "name_example"; // String | Name of the label to query.
    String type = "page"; // String | The type of contents that are to be returned.
    Integer start = 0; // Integer | The starting offset for the results.
    Integer limit = 200; // Integer | The number of results to be returned.
    try {
      LabelDetails result = apiInstance.getAllLabelContent(name, type, start, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LabelInfoApi#getAllLabelContent");
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
| **name** | **String**| Name of the label to query. | |
| **type** | **String**| The type of contents that are to be returned. | [optional] [enum: page, blogpost, attachment, page_template] |
| **start** | **Integer**| The starting offset for the results. | [optional] [default to 0] |
| **limit** | **Integer**| The number of results to be returned. | [optional] [default to 200] |

### Return type

[**LabelDetails**](LabelDetails.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the query fetches zero or more results. |  -  |
| **400** | Returned if no label name is provide or if content type provided in the query is invalid. |  -  |
| **403** | Returned if the calling user does not have permission to view any content including label info. |  -  |
| **404** | Returned if the lable name is invalid or if no label is found for a given label. |  -  |

