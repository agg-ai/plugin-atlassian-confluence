# ExperimentalApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addLabelsToSpace**](ExperimentalApi.md#addLabelsToSpace) | **POST** /wiki/rest/api/space/{spaceKey}/label | Add labels to a space |
| [**deleteLabelFromSpace**](ExperimentalApi.md#deleteLabelFromSpace) | **DELETE** /wiki/rest/api/space/{spaceKey}/label | Remove label from a space |
| [**deletePageTree**](ExperimentalApi.md#deletePageTree) | **DELETE** /wiki/rest/api/content/{id}/pageTree | Delete page tree |
| [**getLabelsForSpace**](ExperimentalApi.md#getLabelsForSpace) | **GET** /wiki/rest/api/space/{spaceKey}/label | Get Space Labels |


<a id="addLabelsToSpace"></a>
# **addLabelsToSpace**
> LabelArray addLabelsToSpace(spaceKey, labelCreate)

Add labels to a space

Adds labels to a piece of content. Does not modify the existing labels.  Notes:  - Labels can also be added when creating content ([Create content](#api-content-post)). - Labels can be updated when updating content ([Update content](#api-content-id-put)). This will delete the existing labels and replace them with the labels in the request.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to update the content.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ExperimentalApi;

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

    ExperimentalApi apiInstance = new ExperimentalApi(defaultClient);
    String spaceKey = "spaceKey_example"; // String | The key of the space to add labels to.
    List<LabelCreate> labelCreate = Arrays.asList(); // List<LabelCreate> | The labels to add to the content.
    try {
      LabelArray result = apiInstance.addLabelsToSpace(spaceKey, labelCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ExperimentalApi#addLabelsToSpace");
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
| **spaceKey** | **String**| The key of the space to add labels to. | |
| **labelCreate** | [**List&lt;LabelCreate&gt;**](LabelCreate.md)| The labels to add to the content. | |

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
| **404** | Returned if; - There is no space with the given space key. - The calling user does not have permission to view the space. |  -  |

<a id="deleteLabelFromSpace"></a>
# **deleteLabelFromSpace**
> deleteLabelFromSpace(spaceKey, name, prefix)

Remove label from a space



### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ExperimentalApi;

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

    ExperimentalApi apiInstance = new ExperimentalApi(defaultClient);
    String spaceKey = "spaceKey_example"; // String | The key of the space to remove a labels from.
    String name = "name_example"; // String | The name of the label to remove
    String prefix = "prefix_example"; // String | The prefix of the label to remove. If not provided defaults to global.
    try {
      apiInstance.deleteLabelFromSpace(spaceKey, name, prefix);
    } catch (ApiException e) {
      System.err.println("Exception when calling ExperimentalApi#deleteLabelFromSpace");
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
| **spaceKey** | **String**| The key of the space to remove a labels from. | |
| **name** | **String**| The name of the label to remove | |
| **prefix** | **String**| The prefix of the label to remove. If not provided defaults to global. | [optional] |

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
| **204** | Returned if the label was successfully deleted. |  -  |
| **400** | Returned if; - The user does not provide a label name |  -  |
| **404** | Returned if; - There is no space with the given space key. - The calling user does not have permission to view the space. |  -  |

<a id="deletePageTree"></a>
# **deletePageTree**
> LongTask deletePageTree(id)

Delete page tree

Moves a pagetree rooted at a page to the space&#39;s trash:  - If the content&#39;s type is &#x60;page&#x60; and its status is &#x60;current&#x60;, it will be trashed including all its descendants. - For every other combination of content type and status, this API is not supported.  This API accepts the pageTree delete request and returns a task ID. The delete process happens asynchronously.   Response example:  &lt;pre&gt;&lt;code&gt;  {       \&quot;id\&quot; : \&quot;1180606\&quot;,       \&quot;links\&quot; : {            \&quot;status\&quot; : \&quot;/rest/api/longtask/1180606\&quot;       }  }  &lt;/code&gt;&lt;/pre&gt;  Use the &#x60;/longtask/&lt;taskId&gt;&#x60; REST API to get the copy task status.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;Delete&#39; permission for the space that the content is in.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ExperimentalApi;

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

    ExperimentalApi apiInstance = new ExperimentalApi(defaultClient);
    String id = "id_example"; // String | The ID of the content which forms root of the page tree, to be deleted.
    try {
      LongTask result = apiInstance.deletePageTree(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ExperimentalApi#deletePageTree");
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
| **id** | **String**| The ID of the content which forms root of the page tree, to be deleted. | |

### Return type

[**LongTask**](LongTask.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Returned if the request to trash content and all its current page descendants, is successfully accepted. |  -  |
| **400** | Returned if the content id is invalid or id does not represents a &#39;CURRENT&#39; page. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **403** | Returned if the calling user can not delete the content with specified id. |  -  |
| **404** | Returned if;  - There is no content with the given ID. - The requesting user does not have permission to trash the content or any of it&#39;s descendant pages. |  -  |

<a id="getLabelsForSpace"></a>
# **getLabelsForSpace**
> LabelArray getLabelsForSpace(spaceKey, prefix, start, limit)

Get Space Labels

Returns a list of labels associated with a space. Can provide a prefix as well as other filters to select different types of labels.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ExperimentalApi;

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

    ExperimentalApi apiInstance = new ExperimentalApi(defaultClient);
    String spaceKey = "spaceKey_example"; // String | The key of the space to get labels for.
    String prefix = "global"; // String | Filters the results to labels with the specified prefix. If this parameter is not specified, then labels with any prefix will be returned.  - `global` prefix is used by labels that are on content within the provided space. - `my` prefix can be explicitly added by a user when adding a label via the UI, e.g. 'my:example-label'. - `team` prefix is used for labels applied to the space.
    Integer start = 0; // Integer | The starting index of the returned labels.
    Integer limit = 200; // Integer | The maximum number of labels to return per page. Note, this may be restricted by fixed system limits.
    try {
      LabelArray result = apiInstance.getLabelsForSpace(spaceKey, prefix, start, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ExperimentalApi#getLabelsForSpace");
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
| **spaceKey** | **String**| The key of the space to get labels for. | |
| **prefix** | **String**| Filters the results to labels with the specified prefix. If this parameter is not specified, then labels with any prefix will be returned.  - &#x60;global&#x60; prefix is used by labels that are on content within the provided space. - &#x60;my&#x60; prefix can be explicitly added by a user when adding a label via the UI, e.g. &#39;my:example-label&#39;. - &#x60;team&#x60; prefix is used for labels applied to the space. | [optional] [enum: global, my, team] |
| **start** | **Integer**| The starting index of the returned labels. | [optional] [default to 0] |
| **limit** | **Integer**| The maximum number of labels to return per page. Note, this may be restricted by fixed system limits. | [optional] [default to 200] |

### Return type

[**LabelArray**](LabelArray.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the list of labels is returned. |  -  |
| **404** | Returned if; - There is no space with the given space key. - The calling user does not have permission to view the space. |  -  |

