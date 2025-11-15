# SpaceSettingsApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getSpaceSettings**](SpaceSettingsApi.md#getSpaceSettings) | **GET** /wiki/rest/api/space/{spaceKey}/settings | Get space settings |
| [**updateSpaceSettings**](SpaceSettingsApi.md#updateSpaceSettings) | **PUT** /wiki/rest/api/space/{spaceKey}/settings | Update space settings |


<a id="getSpaceSettings"></a>
# **getSpaceSettings**
> SpaceSettings getSpaceSettings(spaceKey)

Get space settings

Returns the settings of a space. Currently only the &#x60;routeOverrideEnabled&#x60; setting can be returned.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;View&#39; permission for the space.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.SpaceSettingsApi;

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

    SpaceSettingsApi apiInstance = new SpaceSettingsApi(defaultClient);
    String spaceKey = "spaceKey_example"; // String | The key of the space to be queried for its settings.
    try {
      SpaceSettings result = apiInstance.getSpaceSettings(spaceKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SpaceSettingsApi#getSpaceSettings");
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
| **spaceKey** | **String**| The key of the space to be queried for its settings. | |

### Return type

[**SpaceSettings**](SpaceSettings.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the space settings are returned. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **404** | Returned if;  - There is no space with the given key. - The calling user does not have permission to view the space. |  -  |

<a id="updateSpaceSettings"></a>
# **updateSpaceSettings**
> SpaceSettings updateSpaceSettings(spaceKey, spaceSettingsUpdate)

Update space settings

Updates the settings for a space. Currently only the &#x60;routeOverrideEnabled&#x60; setting can be updated.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;Admin&#39; permission for the space.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.SpaceSettingsApi;

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

    SpaceSettingsApi apiInstance = new SpaceSettingsApi(defaultClient);
    String spaceKey = "spaceKey_example"; // String | The key of the space whose settings will be updated.
    SpaceSettingsUpdate spaceSettingsUpdate = new SpaceSettingsUpdate(); // SpaceSettingsUpdate | The space settings to update.
    try {
      SpaceSettings result = apiInstance.updateSpaceSettings(spaceKey, spaceSettingsUpdate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SpaceSettingsApi#updateSpaceSettings");
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
| **spaceKey** | **String**| The key of the space whose settings will be updated. | |
| **spaceSettingsUpdate** | [**SpaceSettingsUpdate**](SpaceSettingsUpdate.md)| The space settings to update. | |

### Return type

[**SpaceSettings**](SpaceSettings.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if space settings are updated. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **404** | Returned if;  - There is no space with the given key. - The calling user does not have permission to update the space. |  -  |

