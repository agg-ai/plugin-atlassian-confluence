# LongRunningTaskApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getTask**](LongRunningTaskApi.md#getTask) | **GET** /wiki/rest/api/longtask/{id} | Get long-running task |
| [**getTasks**](LongRunningTaskApi.md#getTasks) | **GET** /wiki/rest/api/longtask | Get long-running tasks |


<a id="getTask"></a>
# **getTask**
> LongTaskStatusWithLinks getTask(id)

Get long-running task

Returns information about an active long-running task (e.g. space export), such as how long it has been running and the percentage of the task that has completed.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission).

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.LongRunningTaskApi;

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

    LongRunningTaskApi apiInstance = new LongRunningTaskApi(defaultClient);
    String id = "id_example"; // String | The ID of the task.
    try {
      LongTaskStatusWithLinks result = apiInstance.getTask(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LongRunningTaskApi#getTask");
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
| **id** | **String**| The ID of the task. | |

### Return type

[**LongTaskStatusWithLinks**](LongTaskStatusWithLinks.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested task is returned. |  -  |
| **401** | Returned if the calling user is not logged in to Confluence. |  -  |
| **404** | Returned if;  - There is no task with the given ID. - The calling user does not have permission to view the task. |  -  |

<a id="getTasks"></a>
# **getTasks**
> LongTaskStatusArray getTasks(key, start, limit)

Get long-running tasks

Returns information about all active long-running tasks (e.g. space export), such as how long each task has been running and the percentage of each task that has completed.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission).

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.LongRunningTaskApi;

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

    LongRunningTaskApi apiInstance = new LongRunningTaskApi(defaultClient);
    String key = "key_example"; // String | The key of the tasks.
    Integer start = 0; // Integer | The starting index of the returned tasks.
    Integer limit = 100; // Integer | The maximum number of tasks to return per page. Note, this may be restricted by fixed system limits.
    try {
      LongTaskStatusArray result = apiInstance.getTasks(key, start, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LongRunningTaskApi#getTasks");
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
| **key** | **String**| The key of the tasks. | [optional] |
| **start** | **Integer**| The starting index of the returned tasks. | [optional] [default to 0] |
| **limit** | **Integer**| The maximum number of tasks to return per page. Note, this may be restricted by fixed system limits. | [optional] [default to 100] |

### Return type

[**LongTaskStatusArray**](LongTaskStatusArray.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested tasks are returned. |  -  |
| **401** | Returned if the calling user is not logged in to Confluence. |  -  |

