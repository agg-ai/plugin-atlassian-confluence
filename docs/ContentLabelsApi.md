# ContentLabelsApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addLabelsToContent**](ContentLabelsApi.md#addLabelsToContent) | **POST** /wiki/rest/api/content/{id}/label | Add labels to content |
| [**removeLabelFromContent**](ContentLabelsApi.md#removeLabelFromContent) | **DELETE** /wiki/rest/api/content/{id}/label/{label} | Remove label from content |
| [**removeLabelFromContentUsingQueryParameter**](ContentLabelsApi.md#removeLabelFromContentUsingQueryParameter) | **DELETE** /wiki/rest/api/content/{id}/label | Remove label from content using query parameter |


<a id="addLabelsToContent"></a>
# **addLabelsToContent**
> LabelArray addLabelsToContent(id, body)

Add labels to content

Adds labels to a piece of content. Does not modify the existing labels.  Notes:  - Labels can also be added when creating content ([Create content](#api-content-post)). - Labels can be updated when updating content ([Update content](#api-content-id-put)). This will delete the existing labels and replace them with the labels in the request.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to update the content.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ContentLabelsApi;

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

    ContentLabelsApi apiInstance = new ContentLabelsApi(defaultClient);
    String id = "id_example"; // String | The ID of the content that will have labels added to it.
    AddLabelsToContentRequest body = new AddLabelsToContentRequest(); // AddLabelsToContentRequest | The labels to add to the content.
    try {
      LabelArray result = apiInstance.addLabelsToContent(id, body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentLabelsApi#addLabelsToContent");
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
| **id** | **String**| The ID of the content that will have labels added to it. | |
| **body** | [**AddLabelsToContentRequest**](AddLabelsToContentRequest.md)| The labels to add to the content. | |

### Return type

[**LabelArray**](LabelArray.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the labels are added to the content. |  -  |
| **400** | Returned if;  - The body contains labels with invalid characters or too many characters. - The body contains too many labels. - The target content would contain too many labels after the operation. - The calling user does not have permission to edit labels. |  -  |
| **403** | Returned if the calling user can view but not edit the content. |  -  |
| **404** | Returned if;  - There is no content with the given ID. - The calling user does not have permission to view the content. |  -  |

<a id="removeLabelFromContent"></a>
# **removeLabelFromContent**
> removeLabelFromContent(id, label)

Remove label from content

Removes a label from a piece of content. Labels can&#39;t be deleted from archived content. This is similar to [Remove label from content using query parameter](#api-content-id-label-delete) except that the label name is specified via a path parameter.  Use this method if the label name does not have \&quot;/\&quot; characters, as the path parameter does not accept \&quot;/\&quot; characters for security reasons. Otherwise, use [Remove label from content using query parameter](#api-content-id-label-delete).  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to update the content.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ContentLabelsApi;

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

    ContentLabelsApi apiInstance = new ContentLabelsApi(defaultClient);
    String id = "id_example"; // String | The ID of the content that the label will be removed from.
    String label = "label_example"; // String | The name of the label to be removed.
    try {
      apiInstance.removeLabelFromContent(id, label);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentLabelsApi#removeLabelFromContent");
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
| **id** | **String**| The ID of the content that the label will be removed from. | |
| **label** | **String**| The name of the label to be removed. | |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the label is removed. The response body will be empty. |  -  |
| **400** | Returned if the label name has a \&quot;/\&quot; character. |  -  |
| **403** | Returned if the calling user can view but not edit the content. |  -  |
| **404** | Returned if;  - There is no content with the given ID. - The calling user does not have permission to view the content. |  -  |

<a id="removeLabelFromContentUsingQueryParameter"></a>
# **removeLabelFromContentUsingQueryParameter**
> removeLabelFromContentUsingQueryParameter(id, name)

Remove label from content using query parameter

Removes a label from a piece of content. Labels can&#39;t be deleted from archived content. This is similar to [Remove label from content](#api-content-id-label-label-delete) except that the label name is specified via a query parameter.  Use this method if the label name has \&quot;/\&quot; characters, as [Remove label from content using query parameter](#api-content-id-label-delete) does not accept \&quot;/\&quot; characters for the label name.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to update the content.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ContentLabelsApi;

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

    ContentLabelsApi apiInstance = new ContentLabelsApi(defaultClient);
    String id = "id_example"; // String | The ID of the content that the label will be removed from.
    String name = "name_example"; // String | The name of the label to be removed.
    try {
      apiInstance.removeLabelFromContentUsingQueryParameter(id, name);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentLabelsApi#removeLabelFromContentUsingQueryParameter");
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
| **id** | **String**| The ID of the content that the label will be removed from. | |
| **name** | **String**| The name of the label to be removed. | |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the label is removed. The response body will be empty. |  -  |
| **403** | Returned if the calling user can view but not edit the content. |  -  |
| **404** | Returned if;  - There is no content with the given ID. - The calling user does not have permission to view the content. |  -  |

