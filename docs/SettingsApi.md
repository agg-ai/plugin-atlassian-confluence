# SettingsApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getLookAndFeelSettings**](SettingsApi.md#getLookAndFeelSettings) | **GET** /wiki/rest/api/settings/lookandfeel | Get look and feel settings |
| [**getSystemInfo**](SettingsApi.md#getSystemInfo) | **GET** /wiki/rest/api/settings/systemInfo | Get system info |
| [**resetLookAndFeelSettings**](SettingsApi.md#resetLookAndFeelSettings) | **DELETE** /wiki/rest/api/settings/lookandfeel/custom | Reset look and feel settings |
| [**updateLookAndFeel**](SettingsApi.md#updateLookAndFeel) | **PUT** /wiki/rest/api/settings/lookandfeel | Select look and feel settings |
| [**updateLookAndFeelSettings**](SettingsApi.md#updateLookAndFeelSettings) | **POST** /wiki/rest/api/settings/lookandfeel/custom | Update look and feel settings |


<a id="getLookAndFeelSettings"></a>
# **getLookAndFeelSettings**
> LookAndFeelSettings getLookAndFeelSettings(spaceKey)

Get look and feel settings

Returns the look and feel settings for the site or a single space. This includes attributes such as the color scheme, padding, and border radius.  The look and feel settings for a space can be inherited from the global look and feel settings or provided by a theme.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: None

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.SettingsApi;

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

    SettingsApi apiInstance = new SettingsApi(defaultClient);
    String spaceKey = "spaceKey_example"; // String | The key of the space for which the look and feel settings will be returned. If this is not set, only the global look and feel settings are returned.
    try {
      LookAndFeelSettings result = apiInstance.getLookAndFeelSettings(spaceKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SettingsApi#getLookAndFeelSettings");
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
| **spaceKey** | **String**| The key of the space for which the look and feel settings will be returned. If this is not set, only the global look and feel settings are returned. | [optional] |

### Return type

[**LookAndFeelSettings**](LookAndFeelSettings.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested look and feel settings are returned. |  -  |
| **400** | Returned if &#x60;spaceKey&#x60; is invalid. |  -  |
| **404** | Returned if there is no space with the given &#x60;spaceKey&#x60;. |  -  |

<a id="getSystemInfo"></a>
# **getSystemInfo**
> SystemInfoEntity getSystemInfo()

Get system info

Returns the system information for the Confluence Cloud tenant. This information is used by Atlassian.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission).

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.SettingsApi;

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

    SettingsApi apiInstance = new SettingsApi(defaultClient);
    try {
      SystemInfoEntity result = apiInstance.getSystemInfo();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SettingsApi#getSystemInfo");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SystemInfoEntity**](SystemInfoEntity.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the system information for the Confluence Cloud tenant is returned. |  -  |
| **403** | Returned when the user does not have permission to view the system information. |  -  |

<a id="resetLookAndFeelSettings"></a>
# **resetLookAndFeelSettings**
> resetLookAndFeelSettings(spaceKey)

Reset look and feel settings

Resets the custom look and feel settings for the site or a single space. This changes the values of the custom settings to be the same as the default settings. It does not change which settings (default or custom) are selected. Note, the default space settings are inherited from the current global settings.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;Admin&#39; permission for the space.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.SettingsApi;

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

    SettingsApi apiInstance = new SettingsApi(defaultClient);
    String spaceKey = "spaceKey_example"; // String | The key of the space for which the look and feel settings will be reset. If this is not set, the global look and feel settings will be reset.
    try {
      apiInstance.resetLookAndFeelSettings(spaceKey);
    } catch (ApiException e) {
      System.err.println("Exception when calling SettingsApi#resetLookAndFeelSettings");
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
| **spaceKey** | **String**| The key of the space for which the look and feel settings will be reset. If this is not set, the global look and feel settings will be reset. | [optional] |

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
| **204** | Returned if the look and feel settings have been reset. |  -  |
| **400** | Returned if &#x60;spaceKey&#x60; is invalid. |  -  |
| **403** | Returned if the calling user doesn&#39;t have permission to reset the look and feel. |  -  |
| **404** | Returned if there is no space with the given &#x60;spaceKey&#x60;. |  -  |

<a id="updateLookAndFeel"></a>
# **updateLookAndFeel**
> LookAndFeelSelection updateLookAndFeel(body)

Select look and feel settings

Sets the look and feel settings to the default (global) settings, the custom settings, or the current theme&#39;s settings for a space. The custom and theme settings can only be selected if there is already a theme set for a space. Note, the default space settings are inherited from the current global settings.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;Admin&#39; permission for the space.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.SettingsApi;

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

    SettingsApi apiInstance = new SettingsApi(defaultClient);
    LookAndFeelSelection body = new LookAndFeelSelection(); // LookAndFeelSelection | The look and feel type to be set.
    try {
      LookAndFeelSelection result = apiInstance.updateLookAndFeel(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SettingsApi#updateLookAndFeel");
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
| **body** | [**LookAndFeelSelection**](LookAndFeelSelection.md)| The look and feel type to be set. | |

### Return type

[**LookAndFeelSelection**](LookAndFeelSelection.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the look and feel settings were set. |  -  |
| **400** | Returned if;  - &#x60;spaceKey&#x60; is invalid. - &#x60;lookAndFeelType&#x60; is invalid. |  -  |
| **403** | Returned if the calling user doesn&#39;t have permission to edit the look and feel settings. |  -  |
| **404** | Returned if there is no space with the given &#x60;spaceKey&#x60;. |  -  |
| **409** | Returned if &#x60;lookAndFeelType&#x60; is set to &#39;custom&#39; or &#39;theme&#39;, and a theme is not currently set for the space. |  -  |

<a id="updateLookAndFeelSettings"></a>
# **updateLookAndFeelSettings**
> LookAndFeelWithLinks updateLookAndFeelSettings(body, spaceKey)

Update look and feel settings

Updates the look and feel settings for the site or for a single space. If custom settings exist, they are updated. If no custom settings exist, then a set of custom settings is created.  Note, if a theme is selected for a space, the space look and feel settings are provided by the theme and cannot be overridden.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;Admin&#39; permission for the space.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.SettingsApi;

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

    SettingsApi apiInstance = new SettingsApi(defaultClient);
    LookAndFeel body = new LookAndFeel(); // LookAndFeel | The updated settings. All values for the settings must be included, regardless of whether they are being changed.  One way to create the request body is to copy the settings from the response body of [Get look and feel settings](#api-settings-lookandfeel-get) and modify it as needed.
    String spaceKey = "spaceKey_example"; // String | The key of the space for which the look and feel settings will be updated. If this is not set, the global look and feel settings will be updated.
    try {
      LookAndFeelWithLinks result = apiInstance.updateLookAndFeelSettings(body, spaceKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SettingsApi#updateLookAndFeelSettings");
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
| **body** | [**LookAndFeel**](LookAndFeel.md)| The updated settings. All values for the settings must be included, regardless of whether they are being changed.  One way to create the request body is to copy the settings from the response body of [Get look and feel settings](#api-settings-lookandfeel-get) and modify it as needed. | |
| **spaceKey** | **String**| The key of the space for which the look and feel settings will be updated. If this is not set, the global look and feel settings will be updated. | [optional] |

### Return type

[**LookAndFeelWithLinks**](LookAndFeelWithLinks.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the look and feel settings are updated. |  -  |
| **400** | Returned if;  - The &#x60;spaceKey&#x60; is invalid - The request body contains invalid data. |  -  |
| **403** | Returned if the calling user doesn&#39;t have permission to edit the look and feel settings. |  -  |
| **404** | Returned if there is no space with the given &#x60;spaceKey&#x60;. |  -  |

