# UsersApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAnonymousUser**](UsersApi.md#getAnonymousUser) | **GET** /wiki/rest/api/user/anonymous | Get anonymous user |
| [**getBulkUserLookup**](UsersApi.md#getBulkUserLookup) | **GET** /wiki/rest/api/user/bulk | Get multiple users using ids |
| [**getCurrentUser**](UsersApi.md#getCurrentUser) | **GET** /wiki/rest/api/user/current | Get current user |
| [**getGroupMembershipsForUser**](UsersApi.md#getGroupMembershipsForUser) | **GET** /wiki/rest/api/user/memberof | Get group memberships for user |
| [**getPrivacyUnsafeUserEmail**](UsersApi.md#getPrivacyUnsafeUserEmail) | **GET** /wiki/rest/api/user/email | Get user email address |
| [**getPrivacyUnsafeUserEmailBulk**](UsersApi.md#getPrivacyUnsafeUserEmailBulk) | **GET** /wiki/rest/api/user/email/bulk | Get user email addresses in batch |
| [**getUser**](UsersApi.md#getUser) | **GET** /wiki/rest/api/user | Get user |


<a id="getAnonymousUser"></a>
# **getAnonymousUser**
> UserAnonymous getAnonymousUser(expand)

Get anonymous user

Returns information about how anonymous users are represented, like the profile picture and display name.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission).

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.UsersApi;

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

    UsersApi apiInstance = new UsersApi(defaultClient);
    List<String> expand = Arrays.asList(); // List<String> | A multi-value parameter indicating which properties of the user to expand.    - `operations` returns the operations that the user is allowed to do.
    try {
      UserAnonymous result = apiInstance.getAnonymousUser(expand);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersApi#getAnonymousUser");
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
| **expand** | [**List&lt;String&gt;**](String.md)| A multi-value parameter indicating which properties of the user to expand.    - &#x60;operations&#x60; returns the operations that the user is allowed to do. | [optional] [enum: operations] |

### Return type

[**UserAnonymous**](UserAnonymous.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the anonymous user representation is returned. |  -  |
| **403** | Returned if the calling user does not have permission to use Confluence. |  -  |

<a id="getBulkUserLookup"></a>
# **getBulkUserLookup**
> BulkUserLookupArray getBulkUserLookup(accountId, expand)

Get multiple users using ids

Returns user details for the ids provided in the request. Currently this API returns a maximum of 100 results. If more than 100 account ids are passed in, then the first 100 will be returned.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission).

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.UsersApi;

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

    UsersApi apiInstance = new UsersApi(defaultClient);
    String accountId = "accountId_example"; // String | A list of accountId's of users to be returned.
    List<String> expand = Arrays.asList(); // List<String> | A multi-value parameter indicating which properties of the user to expand.    - `operations` returns the operations that the user is allowed to do.   - `personalSpace` returns the user's personal space, if it exists.   - `isExternalCollaborator`(@deprecated) use `isGuest` instead to return whether the user is a guest.
    try {
      BulkUserLookupArray result = apiInstance.getBulkUserLookup(accountId, expand);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersApi#getBulkUserLookup");
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
| **accountId** | **String**| A list of accountId&#39;s of users to be returned. | |
| **expand** | [**List&lt;String&gt;**](String.md)| A multi-value parameter indicating which properties of the user to expand.    - &#x60;operations&#x60; returns the operations that the user is allowed to do.   - &#x60;personalSpace&#x60; returns the user&#39;s personal space, if it exists.   - &#x60;isExternalCollaborator&#x60;(@deprecated) use &#x60;isGuest&#x60; instead to return whether the user is a guest. | [optional] [enum: operations, personalSpace, isExternalCollaborator] |

### Return type

[**BulkUserLookupArray**](BulkUserLookupArray.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if, the list of users is returned. |  -  |
| **403** | Returned if the calling user does not have permission to use Confluence. |  -  |

<a id="getCurrentUser"></a>
# **getCurrentUser**
> User getCurrentUser(expand)

Get current user

Returns the currently logged-in user. This includes information about the user, like the display name, userKey, account ID, profile picture, and more.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission).

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.UsersApi;

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

    UsersApi apiInstance = new UsersApi(defaultClient);
    List<String> expand = Arrays.asList(); // List<String> | A multi-value parameter indicating which properties of the user to expand.    - `operations` returns the operations that the user is allowed to do.   - `personalSpace` returns the user's personal space, if it exists.   - `isExternalCollaborator`(@deprecated) see `isGuest` in response to find out whether the user is a guest.
    try {
      User result = apiInstance.getCurrentUser(expand);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersApi#getCurrentUser");
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
| **expand** | [**List&lt;String&gt;**](String.md)| A multi-value parameter indicating which properties of the user to expand.    - &#x60;operations&#x60; returns the operations that the user is allowed to do.   - &#x60;personalSpace&#x60; returns the user&#39;s personal space, if it exists.   - &#x60;isExternalCollaborator&#x60;(@deprecated) see &#x60;isGuest&#x60; in response to find out whether the user is a guest. | [optional] [enum: operations, personalSpace, isExternalCollaborator] |

### Return type

[**User**](User.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the current user is returned. |  -  |
| **403** | Returned if the calling user does not have permission to use Confluence. |  -  |

<a id="getGroupMembershipsForUser"></a>
# **getGroupMembershipsForUser**
> GroupArrayWithLinks getGroupMembershipsForUser(accountId, start, limit)

Get group memberships for user

Returns the groups that a user is a member of.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission).

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.UsersApi;

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

    UsersApi apiInstance = new UsersApi(defaultClient);
    String accountId = "accountId_example"; // String | The account ID of the user. The accountId uniquely identifies the user across all Atlassian products. For example, `384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192`.
    Integer start = 0; // Integer | The starting index of the returned groups.
    Integer limit = 200; // Integer | The maximum number of groups to return per page. Note, this may be restricted by fixed system limits.
    try {
      GroupArrayWithLinks result = apiInstance.getGroupMembershipsForUser(accountId, start, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersApi#getGroupMembershipsForUser");
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
| **accountId** | **String**| The account ID of the user. The accountId uniquely identifies the user across all Atlassian products. For example, &#x60;384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192&#x60;. | |
| **start** | **Integer**| The starting index of the returned groups. | [optional] [default to 0] |
| **limit** | **Integer**| The maximum number of groups to return per page. Note, this may be restricted by fixed system limits. | [optional] [default to 200] |

### Return type

[**GroupArrayWithLinks**](GroupArrayWithLinks.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested groups are returned. |  -  |
| **403** | Returned if the calling user does not have permission to use Confluence. |  -  |

<a id="getPrivacyUnsafeUserEmail"></a>
# **getPrivacyUnsafeUserEmail**
> AccountIdEmailRecord getPrivacyUnsafeUserEmail(accountId)

Get user email address

Returns a user&#39;s email address regardless of the user’s profile visibility settings. For Connect apps, this API is only available to apps approved by Atlassian, according to these [guidelines](https://community.developer.atlassian.com/t/guidelines-for-requesting-access-to-email-address/27603). For Forge apps, this API only supports access via asApp() requests.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission).

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.UsersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://your-domain.atlassian.net");

    UsersApi apiInstance = new UsersApi(defaultClient);
    String accountId = "accountId_example"; // String | The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, `384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192`. Required.
    try {
      AccountIdEmailRecord result = apiInstance.getPrivacyUnsafeUserEmail(accountId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersApi#getPrivacyUnsafeUserEmail");
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
| **accountId** | **String**| The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, &#x60;384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192&#x60;. Required. | |

### Return type

[**AccountIdEmailRecord**](AccountIdEmailRecord.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested user&#39;s email is returned. |  -  |
| **400** | Returned if the calling app is not approved to use this API. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **404** | Returned if a user with the given accountId does not exist. |  -  |
| **501** | Indicates that the API is not currently enabled. |  -  |

<a id="getPrivacyUnsafeUserEmailBulk"></a>
# **getPrivacyUnsafeUserEmailBulk**
> List&lt;AccountIdEmailRecord&gt; getPrivacyUnsafeUserEmailBulk(accountId)

Get user email addresses in batch

Returns a user&#39;s email address regardless of the user’s profile visibility settings. For Connect apps, this API is only available to apps approved by Atlassian, according to these [guidelines](https://community.developer.atlassian.com/t/guidelines-for-requesting-access-to-email-address/27603). For Forge apps, this API only supports access via asApp() requests.  Any accounts which are not available will not be included in the result.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission).

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.UsersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://your-domain.atlassian.net");

    UsersApi apiInstance = new UsersApi(defaultClient);
    List<String> accountId = Arrays.asList(); // List<String> | The account IDs of the users.
    try {
      List<AccountIdEmailRecord> result = apiInstance.getPrivacyUnsafeUserEmailBulk(accountId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersApi#getPrivacyUnsafeUserEmailBulk");
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
| **accountId** | [**List&lt;String&gt;**](String.md)| The account IDs of the users. | |

### Return type

[**List&lt;AccountIdEmailRecord&gt;**](AccountIdEmailRecord.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the calling app is not approved to use this API. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **501** | Indicates that the API is not currently enabled. |  -  |

<a id="getUser"></a>
# **getUser**
> User getUser(accountId, expand)

Get user

Returns a user. This includes information about the user, such as the display name, account ID, profile picture, and more. The information returned may be restricted by the user&#39;s profile visibility settings.  **Note:** to add, edit, or delete users in your organization, see the [user management REST API](/cloud/admin/user-management/about/).  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission).

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.UsersApi;

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

    UsersApi apiInstance = new UsersApi(defaultClient);
    String accountId = "accountId_example"; // String | The account ID of the user. The accountId uniquely identifies the user across all Atlassian products. For example, `384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192`.
    List<String> expand = Arrays.asList(); // List<String> | A multi-value parameter indicating which properties of the user to expand.    - `operations` returns the operations that the user is allowed to do.   - `personalSpace` returns the user's personal space, if it exists.   - `isExternalCollaborator`(@deprecated) see `isGuest` in response to find out whether the user is a guest.
    try {
      User result = apiInstance.getUser(accountId, expand);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UsersApi#getUser");
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
| **accountId** | **String**| The account ID of the user. The accountId uniquely identifies the user across all Atlassian products. For example, &#x60;384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192&#x60;. | |
| **expand** | [**List&lt;String&gt;**](String.md)| A multi-value parameter indicating which properties of the user to expand.    - &#x60;operations&#x60; returns the operations that the user is allowed to do.   - &#x60;personalSpace&#x60; returns the user&#39;s personal space, if it exists.   - &#x60;isExternalCollaborator&#x60;(@deprecated) see &#x60;isGuest&#x60; in response to find out whether the user is a guest. | [optional] [enum: operations, personalSpace, isExternalCollaborator] |

### Return type

[**User**](User.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested user is returned. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **403** | Returned if the calling user does not have permission to view users. |  -  |
| **404** | Returned if a user with the given accountId does not exist. |  -  |

