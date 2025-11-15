# DynamicModulesApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getModules**](DynamicModulesApi.md#getModules) | **GET** /atlassian-connect/1/app/module/dynamic | Get modules |
| [**registerModules**](DynamicModulesApi.md#registerModules) | **POST** /atlassian-connect/1/app/module/dynamic | Register modules |
| [**removeModules**](DynamicModulesApi.md#removeModules) | **DELETE** /atlassian-connect/1/app/module/dynamic | Remove modules |


<a id="getModules"></a>
# **getModules**
> ConnectModules getModules()

Get modules

Returns all modules registered dynamically by the calling app.  **[Permissions](#permissions) required:** Only Connect apps can make this request.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.DynamicModulesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://your-domain.atlassian.net");

    DynamicModulesApi apiInstance = new DynamicModulesApi(defaultClient);
    try {
      ConnectModules result = apiInstance.getModules();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DynamicModulesApi#getModules");
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

[**ConnectModules**](ConnectModules.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*, message

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the call is not from a Connect app. |  -  |

<a id="registerModules"></a>
# **registerModules**
> registerModules(body)

Register modules

Registers a list of modules. For the list of modules that support dynamic registration, see [Dynamic modules](https://developer.atlassian.com/cloud/confluence/dynamic-modules/).  **[Permissions](#permissions) required:** Only Connect apps can make this request.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.DynamicModulesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://your-domain.atlassian.net");

    DynamicModulesApi apiInstance = new DynamicModulesApi(defaultClient);
    ConnectModules body = new ConnectModules(); // ConnectModules | 
    try {
      apiInstance.registerModules(body);
    } catch (ApiException e) {
      System.err.println("Exception when calling DynamicModulesApi#registerModules");
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
| **body** | [**ConnectModules**](ConnectModules.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*, message

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if: * any of the provided modules is invalid. For example, required properties are missing. * any of the modules conflict with registered dynamic modules or modules defined in the app descriptor. For example, there are duplicate keys.  Details of the issues encountered are included in the error message. |  -  |
| **401** | Returned if the call is not from a Connect app. |  -  |

<a id="removeModules"></a>
# **removeModules**
> removeModules(moduleKey)

Remove modules

Remove all or a list of modules registered by the calling app.  **[Permissions](#permissions) required:** Only Connect apps can make this request.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.DynamicModulesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://your-domain.atlassian.net");

    DynamicModulesApi apiInstance = new DynamicModulesApi(defaultClient);
    List<String> moduleKey = Arrays.asList(); // List<String> | The key of the module to remove. To include multiple module keys, provide multiple copies of this parameter. For example, `moduleKey=dynamic-attachment-entity-property&moduleKey=dynamic-select-field`. Nonexistent keys are ignored.
    try {
      apiInstance.removeModules(moduleKey);
    } catch (ApiException e) {
      System.err.println("Exception when calling DynamicModulesApi#removeModules");
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
| **moduleKey** | [**List&lt;String&gt;**](String.md)| The key of the module to remove. To include multiple module keys, provide multiple copies of this parameter. For example, &#x60;moduleKey&#x3D;dynamic-attachment-entity-property&amp;moduleKey&#x3D;dynamic-select-field&#x60;. Nonexistent keys are ignored. | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*, message

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the request is successful. |  -  |
| **401** | Returned if the call is not from a Connect app. |  -  |

