# SpaceApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createPrivateSpace**](SpaceApi.md#createPrivateSpace) | **POST** /wiki/rest/api/space/_private | Create private space |
| [**createSpace**](SpaceApi.md#createSpace) | **POST** /wiki/rest/api/space | Create space |
| [**deleteSpace**](SpaceApi.md#deleteSpace) | **DELETE** /wiki/rest/api/space/{spaceKey} | Delete space |
| [**updateSpace**](SpaceApi.md#updateSpace) | **PUT** /wiki/rest/api/space/{spaceKey} | Update space |


<a id="createPrivateSpace"></a>
# **createPrivateSpace**
> Space createPrivateSpace(spacePrivateCreate)

Create private space

Creates a new space that is only visible to the creator. This method is the same as the [Create space](#api-space-post) method with permissions set to the current user only. Note, currently you cannot set space labels when creating a space.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;Create Space(s)&#39; global permission.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.SpaceApi;

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

    SpaceApi apiInstance = new SpaceApi(defaultClient);
    SpaceCreate spacePrivateCreate = new SpaceCreate(); // SpaceCreate | The space to be created.
    try {
      Space result = apiInstance.createPrivateSpace(spacePrivateCreate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SpaceApi#createPrivateSpace");
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
| **spacePrivateCreate** | [**SpaceCreate**](SpaceCreate.md)| The space to be created. | |

### Return type

[**Space**](Space.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the space is created. |  -  |
| **400** | Returned if any of the following is true:  - The request is invalid. - The space already exists. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **403** | Returned if the user does not have permission to create a space. |  -  |

<a id="createSpace"></a>
# **createSpace**
> Space createSpace(body)

Create space

Creates a new space. Note, currently you cannot set space labels when creating a space.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;Create Space(s)&#39; global permission.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.SpaceApi;

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

    SpaceApi apiInstance = new SpaceApi(defaultClient);
    SpaceCreate body = new SpaceCreate(); // SpaceCreate | The space to be created.
    try {
      Space result = apiInstance.createSpace(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SpaceApi#createSpace");
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
| **body** | [**SpaceCreate**](SpaceCreate.md)| The space to be created. | |

### Return type

[**Space**](Space.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the space is created. |  -  |
| **400** | Returned if any of the following is true:  - The request is invalid. - The space already exists. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **403** | Returned if the callig user does not have permission to create a space. |  -  |

<a id="deleteSpace"></a>
# **deleteSpace**
> LongTask deleteSpace(spaceKey)

Delete space

Permanently deletes a space without sending it to the trash. Note, the space will be deleted in a long running task. Therefore, the space may not be deleted yet when this method has returned. Clients should poll the status link that is returned in the response until the task completes.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;Admin&#39; permission for the space.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.SpaceApi;

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

    SpaceApi apiInstance = new SpaceApi(defaultClient);
    String spaceKey = "spaceKey_example"; // String | The key of the space to delete.
    try {
      LongTask result = apiInstance.deleteSpace(spaceKey);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SpaceApi#deleteSpace");
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
| **spaceKey** | **String**| The key of the space to delete. | |

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
| **202** | Returns a pointer to the status of the space deletion task. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **404** | Returned if any of the following is true:  - There is no space with the given key. - The calling user does not have permission to delete the space. |  -  |

<a id="updateSpace"></a>
# **updateSpace**
> Space updateSpace(spaceKey, body)

Update space

Updates the name, description, or homepage of a space.  -   For security reasons, permissions cannot be updated via the API and must be changed via the user interface instead. -   Currently you cannot set space labels when updating a space.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;Admin&#39; permission for the space.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.SpaceApi;

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

    SpaceApi apiInstance = new SpaceApi(defaultClient);
    String spaceKey = "spaceKey_example"; // String | The key of the space to update.
    SpaceUpdate body = new SpaceUpdate(); // SpaceUpdate | The updated space.
    try {
      Space result = apiInstance.updateSpace(spaceKey, body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SpaceApi#updateSpace");
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
| **spaceKey** | **String**| The key of the space to update. | |
| **body** | [**SpaceUpdate**](SpaceUpdate.md)| The updated space. | |

### Return type

[**Space**](Space.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the space is updated. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **404** | Returned if any of the following is true:  - There is no space with the given key - The calling user does not have permission to update the space. |  -  |

