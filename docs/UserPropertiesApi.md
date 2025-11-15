# UserPropertiesApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createUserProperty**](UserPropertiesApi.md#createUserProperty) | **POST** /wiki/rest/api/user/{userId}/property/{key} | Create user property by key |
| [**deleteUserProperty**](UserPropertiesApi.md#deleteUserProperty) | **DELETE** /wiki/rest/api/user/{userId}/property/{key} | Delete user property |
| [**getUserProperties**](UserPropertiesApi.md#getUserProperties) | **GET** /wiki/rest/api/user/{userId}/property | Get user properties |
| [**getUserProperty**](UserPropertiesApi.md#getUserProperty) | **GET** /wiki/rest/api/user/{userId}/property/{key} | Get user property |
| [**updateUserProperty**](UserPropertiesApi.md#updateUserProperty) | **PUT** /wiki/rest/api/user/{userId}/property/{key} | Update user property |


<a id="createUserProperty"></a>
# **createUserProperty**
> createUserProperty(userId, key, body)

Create user property by key

Creates a property for a user. For more information  about user properties, see [Confluence entity properties] (https://developer.atlassian.com/cloud/confluence/confluence-entity-properties/). &#x60;Note&#x60;, these properties stored against a user are on a Confluence site level and not space/content level.  &#x60;Note:&#x60; the number of properties which could be created per app in a tenant for each user might be restricted by fixed system limits. **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission).

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.UserPropertiesApi;

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

    UserPropertiesApi apiInstance = new UserPropertiesApi(defaultClient);
    String userId = "userId_example"; // String | The account ID of the user. The accountId uniquely identifies the user across all Atlassian products. For example, 384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192
    String key = "key_example"; // String | The key of the user property.
    UserPropertyCreate body = new UserPropertyCreate(); // UserPropertyCreate | The user property to be created.
    try {
      apiInstance.createUserProperty(userId, key, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserPropertiesApi#createUserProperty");
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
| **userId** | **String**| The account ID of the user. The accountId uniquely identifies the user across all Atlassian products. For example, 384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192 | |
| **key** | **String**| The key of the user property. | |
| **body** | [**UserPropertyCreate**](UserPropertyCreate.md)| The user property to be created. | |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the user property is created. |  -  |
| **400** | Returned if;  - The key is too long. - The value is empty. - The value is too long. - Request has malformed syntax or userId is not a valid user id. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **403** | Returned if the user does not have the correct permissions. |  -  |
| **404** | Returned if there is no user with the given user id. |  -  |
| **409** | Returned if the key already exists for the user. |  -  |

<a id="deleteUserProperty"></a>
# **deleteUserProperty**
> deleteUserProperty(userId, key)

Delete user property

Deletes a property for the given user. For more information about user properties, see [Confluence entity properties](https://developer.atlassian.com/cloud/confluence/confluence-entity-properties/). &#x60;Note&#x60;, these properties stored against a user are on a Confluence site level and not space/content level.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission).

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.UserPropertiesApi;

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

    UserPropertiesApi apiInstance = new UserPropertiesApi(defaultClient);
    String userId = "userId_example"; // String | The account ID of the user. The accountId uniquely identifies the user across all Atlassian products. For example, 384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192
    String key = "key_example"; // String | The key of the user property.
    try {
      apiInstance.deleteUserProperty(userId, key);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserPropertiesApi#deleteUserProperty");
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
| **userId** | **String**| The account ID of the user. The accountId uniquely identifies the user across all Atlassian products. For example, 384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192 | |
| **key** | **String**| The key of the user property. | |

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
| **204** | Returned if the user property is deleted. |  -  |
| **400** | Returned if;  - The key is too long. - Request has malformed syntax or userId is not a valid user id. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **403** | Returned if the user does not have the correct permissions. |  -  |
| **404** | Returned if;  - There is no user property with the given key - There is no user with the given user id |  -  |

<a id="getUserProperties"></a>
# **getUserProperties**
> UserPropertyKeyArray getUserProperties(userId, start, limit)

Get user properties

Returns the properties for a user as list of property keys. For more information about user properties, see [Confluence entity properties](https://developer.atlassian.com/cloud/confluence/confluence-entity-properties/). &#x60;Note&#x60;, these properties stored against a user are on a Confluence site level and not space/content level.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission).

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.UserPropertiesApi;

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

    UserPropertiesApi apiInstance = new UserPropertiesApi(defaultClient);
    String userId = "userId_example"; // String | The account ID of the user to be queried for its properties.
    Integer start = 0; // Integer | The starting index of the returned properties.
    Integer limit = 5; // Integer | The maximum number of properties to return per page. Note, this may be restricted by fixed system limits.
    try {
      UserPropertyKeyArray result = apiInstance.getUserProperties(userId, start, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserPropertiesApi#getUserProperties");
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
| **userId** | **String**| The account ID of the user to be queried for its properties. | |
| **start** | **Integer**| The starting index of the returned properties. | [optional] [default to 0] |
| **limit** | **Integer**| The maximum number of properties to return per page. Note, this may be restricted by fixed system limits. | [optional] [default to 5] |

### Return type

[**UserPropertyKeyArray**](UserPropertyKeyArray.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested properties are returned. |  -  |
| **400** | Returned if request has malformed syntax or userId is not a valid user id. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **403** | Returned if the user does not have the correct permissions. |  -  |
| **404** | Returned if there is no user with the given user ID. |  -  |

<a id="getUserProperty"></a>
# **getUserProperty**
> UserProperty getUserProperty(userId, key)

Get user property

Returns the property corresponding to &#x60;key&#x60; for a user. For more information about user properties, see [Confluence entity properties](https://developer.atlassian.com/cloud/confluence/confluence-entity-properties/). &#x60;Note&#x60;, these properties stored against a user are on a Confluence site level and not space/content level.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission).

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.UserPropertiesApi;

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

    UserPropertiesApi apiInstance = new UserPropertiesApi(defaultClient);
    String userId = "userId_example"; // String | The account ID of the user to be queried for its properties.
    String key = "key_example"; // String | The key of the user property.
    try {
      UserProperty result = apiInstance.getUserProperty(userId, key);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserPropertiesApi#getUserProperty");
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
| **userId** | **String**| The account ID of the user to be queried for its properties. | |
| **key** | **String**| The key of the user property. | |

### Return type

[**UserProperty**](UserProperty.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested properties are returned. |  -  |
| **400** | Returned if;  - The key is too long. - Request has malformed syntax or userId is not a valid user id. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **403** | Returned if the user does not have the correct permissions. |  -  |
| **404** | Returned if;  - There is no user with the given user ID - There is no user property with the given key |  -  |

<a id="updateUserProperty"></a>
# **updateUserProperty**
> updateUserProperty(userId, key, body)

Update user property

Updates a property for the given user. Note, you cannot update the key of a user property, only the value. For more information about user properties, see [Confluence entity properties](https://developer.atlassian.com/cloud/confluence/confluence-entity-properties/). &#x60;Note&#x60;, these properties stored against a user are on a Confluence site level and not space/content level.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission).

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.UserPropertiesApi;

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

    UserPropertiesApi apiInstance = new UserPropertiesApi(defaultClient);
    String userId = "userId_example"; // String | The account ID of the user. The accountId uniquely identifies the user across all Atlassian products. For example, 384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192
    String key = "key_example"; // String | The key of the user property.
    UserPropertyUpdate body = new UserPropertyUpdate(); // UserPropertyUpdate | The user property to be updated.
    try {
      apiInstance.updateUserProperty(userId, key, body);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserPropertiesApi#updateUserProperty");
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
| **userId** | **String**| The account ID of the user. The accountId uniquely identifies the user across all Atlassian products. For example, 384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192 | |
| **key** | **String**| The key of the user property. | |
| **body** | [**UserPropertyUpdate**](UserPropertyUpdate.md)| The user property to be updated. | |

### Return type

null (empty response body)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the user property is updated. |  -  |
| **400** | Returned if;  - The key is too long. - The value is empty. - The value is too long. - Request has malformed syntax or userId is not a valid user id. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **403** | Returned if the user does not have the correct permissions. |  -  |
| **404** | Returned if;  - There is no user property with the given key. - There is no user with the given user id. |  -  |

