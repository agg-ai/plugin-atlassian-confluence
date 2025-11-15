# ContentVersionsApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteContentVersion**](ContentVersionsApi.md#deleteContentVersion) | **DELETE** /wiki/rest/api/content/{id}/version/{versionNumber} | Delete content version |
| [**restoreContentVersion**](ContentVersionsApi.md#restoreContentVersion) | **POST** /wiki/rest/api/content/{id}/version | Restore content version |


<a id="deleteContentVersion"></a>
# **deleteContentVersion**
> deleteContentVersion(id, versionNumber)

Delete content version

Delete a historical version. This does not delete the changes made to the content in that version, rather the changes for the deleted version are rolled up into the next version. Note, you cannot delete the current version.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to update the content.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ContentVersionsApi;

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

    ContentVersionsApi apiInstance = new ContentVersionsApi(defaultClient);
    String id = "id_example"; // String | The ID of the content that the version will be deleted from.
    Integer versionNumber = 56; // Integer | The number of the version to be deleted. The version number starts from 1 up to current version.
    try {
      apiInstance.deleteContentVersion(id, versionNumber);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentVersionsApi#deleteContentVersion");
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
| **id** | **String**| The ID of the content that the version will be deleted from. | |
| **versionNumber** | **Integer**| The number of the version to be deleted. The version number starts from 1 up to current version. | |

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
| **204** | Returned if the version is deleted. |  -  |
| **400** | Returned if;  - The content or version cannot be found. - The current version is specified. |  -  |
| **403** | Returned if the calling user doesn&#39;t have permission to edit the content. |  -  |

<a id="restoreContentVersion"></a>
# **restoreContentVersion**
> Version restoreContentVersion(id, body, expand)

Restore content version

Restores a historical version to be the latest version. That is, a new version is created with the content of the historical version.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to update the content.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ContentVersionsApi;

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

    ContentVersionsApi apiInstance = new ContentVersionsApi(defaultClient);
    String id = "id_example"; // String | The ID of the content for which the history will be restored.
    VersionRestore body = new VersionRestore(); // VersionRestore | The content version to be restored.
    List<String> expand = Arrays.asList(); // List<String> | A multi-value parameter indicating which properties of the content to expand. By default, the `content` object is expanded.  - `collaborators` returns the users that collaborated on the version. - `content` returns the content for the version.
    try {
      Version result = apiInstance.restoreContentVersion(id, body, expand);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentVersionsApi#restoreContentVersion");
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
| **id** | **String**| The ID of the content for which the history will be restored. | |
| **body** | [**VersionRestore**](VersionRestore.md)| The content version to be restored. | |
| **expand** | [**List&lt;String&gt;**](String.md)| A multi-value parameter indicating which properties of the content to expand. By default, the &#x60;content&#x60; object is expanded.  - &#x60;collaborators&#x60; returns the users that collaborated on the version. - &#x60;content&#x60; returns the content for the version. | [optional] |

### Return type

[**Version**](Version.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the version is restored. |  -  |
| **400** | Returned if;  - There is no content with the given ID. - There is no version with the given version number. - The version number is the current version. |  -  |
| **403** | Returned if the calling user doesn&#39;t have permission to edit the content. |  -  |

