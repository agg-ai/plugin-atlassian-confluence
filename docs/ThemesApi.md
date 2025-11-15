# ThemesApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getGlobalTheme**](ThemesApi.md#getGlobalTheme) | **GET** /wiki/rest/api/settings/theme/selected | Get global theme |
| [**getSpaceTheme**](ThemesApi.md#getSpaceTheme) | **GET** /wiki/rest/api/space/{spaceKey}/theme | Get space theme |
| [**getTheme**](ThemesApi.md#getTheme) | **GET** /wiki/rest/api/settings/theme/{themeKey} | Get theme |
| [**getThemes**](ThemesApi.md#getThemes) | **GET** /wiki/rest/api/settings/theme | Get themes |
| [**resetSpaceTheme**](ThemesApi.md#resetSpaceTheme) | **DELETE** /wiki/rest/api/space/{spaceKey}/theme | Reset space theme |
| [**setSpaceTheme**](ThemesApi.md#setSpaceTheme) | **PUT** /wiki/rest/api/space/{spaceKey}/theme | Set space theme |


<a id="getGlobalTheme"></a>
# **getGlobalTheme**
> Theme getGlobalTheme()

Get global theme

Returns the globally assigned theme.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: None

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ThemesApi;

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

    ThemesApi apiInstance = new ThemesApi(defaultClient);
    try {
      Theme result = apiInstance.getGlobalTheme();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ThemesApi#getGlobalTheme");
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

[**Theme**](Theme.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the global theme is returned. |  -  |
| **404** | Returned if Confluence does not have a global theme assigned, i.e. the default theme is used. |  -  |

<a id="getSpaceTheme"></a>
# **getSpaceTheme**
> Theme getSpaceTheme(spaceKey)

Get space theme

Returns the theme selected for a space, if one is set. If no space theme is set, this means that the space is inheriting the global look and feel settings.  **[Permissions required](https://confluence.atlassian.com/x/_AozKw)**: ‘View’ permission for the space.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ThemesApi;

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

    ThemesApi apiInstance = new ThemesApi(defaultClient);
    String spaceKey = "spaceKey_example"; // String | The key of the space to be queried for its theme.
    try {
      Theme result = apiInstance.getSpaceTheme(spaceKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ThemesApi#getSpaceTheme");
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
| **spaceKey** | **String**| The key of the space to be queried for its theme. | |

### Return type

[**Theme**](Theme.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested theme is returned. |  -  |
| **404** | Returned if any of the following is true:  - There is no space with the given key. - The space does not have a theme assigned to it. |  -  |

<a id="getTheme"></a>
# **getTheme**
> Theme getTheme(themeKey)

Get theme

Returns a theme. This includes information about the theme name, description, and icon.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: None

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ThemesApi;

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

    ThemesApi apiInstance = new ThemesApi(defaultClient);
    String themeKey = "themeKey_example"; // String | The key of the theme to be returned.
    try {
      Theme result = apiInstance.getTheme(themeKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ThemesApi#getTheme");
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
| **themeKey** | **String**| The key of the theme to be returned. | |

### Return type

[**Theme**](Theme.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested theme is returned. |  -  |
| **404** | Returned if there is no theme with the given key. |  -  |

<a id="getThemes"></a>
# **getThemes**
> ThemeArray getThemes(start, limit)

Get themes

Returns all themes, not including the default theme.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: None

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ThemesApi;

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

    ThemesApi apiInstance = new ThemesApi(defaultClient);
    Integer start = 0; // Integer | The starting index of the returned themes.
    Integer limit = 100; // Integer | The maximum number of themes to return per page. Note, this may be restricted by fixed system limits.
    try {
      ThemeArray result = apiInstance.getThemes(start, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ThemesApi#getThemes");
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
| **start** | **Integer**| The starting index of the returned themes. | [optional] [default to 0] |
| **limit** | **Integer**| The maximum number of themes to return per page. Note, this may be restricted by fixed system limits. | [optional] [default to 100] |

### Return type

[**ThemeArray**](ThemeArray.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested themes are returned. |  -  |

<a id="resetSpaceTheme"></a>
# **resetSpaceTheme**
> resetSpaceTheme(spaceKey)

Reset space theme

Resets the space theme. This means that the space will inherit the global look and feel settings  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;Admin&#39; permission for the space.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ThemesApi;

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

    ThemesApi apiInstance = new ThemesApi(defaultClient);
    String spaceKey = "spaceKey_example"; // String | The key of the space to reset the theme for.
    try {
      apiInstance.resetSpaceTheme(spaceKey);
    } catch (ApiException e) {
      System.err.println("Exception when calling ThemesApi#resetSpaceTheme");
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
| **spaceKey** | **String**| The key of the space to reset the theme for. | |

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
| **204** | Returned if the theme was reset for the space. |  -  |
| **404** | Returned if there is no space with the given key. |  -  |

<a id="setSpaceTheme"></a>
# **setSpaceTheme**
> Theme setSpaceTheme(spaceKey, body)

Set space theme

Sets the theme for a space. Note, if you want to reset the space theme to the default Confluence theme, use the &#39;Reset space theme&#39; method instead of this method.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;Admin&#39; permission for the space.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ThemesApi;

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

    ThemesApi apiInstance = new ThemesApi(defaultClient);
    String spaceKey = "spaceKey_example"; // String | The key of the space to set the theme for.
    ThemeUpdate body = new ThemeUpdate(); // ThemeUpdate | 
    try {
      Theme result = apiInstance.setSpaceTheme(spaceKey, body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ThemesApi#setSpaceTheme");
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
| **spaceKey** | **String**| The key of the space to set the theme for. | |
| **body** | [**ThemeUpdate**](ThemeUpdate.md)|  | |

### Return type

[**Theme**](Theme.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the theme was set for the space. |  -  |
| **403** | Returned if the theme key is invalid. |  -  |
| **404** | Returned if there is no space with the given key. |  -  |

