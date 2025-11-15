# ContentPermissionsApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**checkContentPermission**](ContentPermissionsApi.md#checkContentPermission) | **POST** /wiki/rest/api/content/{id}/permission/check | Check content permissions |


<a id="checkContentPermission"></a>
# **checkContentPermission**
> PermissionCheckResponse checkContentPermission(id, body)

Check content permissions

Check if a user or a group can perform an operation to the specified content. The &#x60;operation&#x60; to check must be provided. The user’s account ID or the ID of the group can be provided in the &#x60;subject&#x60; to check permissions against a specified user or group. The following permission checks are done to make sure that the user or group has the proper access:  - site permissions - space permissions - content restrictions  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission) if checking permission for self, otherwise &#39;Confluence Administrator&#39; global permission is required.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ContentPermissionsApi;

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

    ContentPermissionsApi apiInstance = new ContentPermissionsApi(defaultClient);
    String id = "id_example"; // String | The ID of the content to check permissions against.
    ContentPermissionRequest body = new ContentPermissionRequest(); // ContentPermissionRequest | The content permission request.
    try {
      PermissionCheckResponse result = apiInstance.checkContentPermission(id, body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentPermissionsApi#checkContentPermission");
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
| **id** | **String**| The ID of the content to check permissions against. | |
| **body** | [**ContentPermissionRequest**](ContentPermissionRequest.md)| The content permission request. | |

### Return type

[**PermissionCheckResponse**](PermissionCheckResponse.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the permission check completed successfully |  -  |
| **400** | Returned if;  - If any of the required fields are missing. - If specified &#x60;subject&#x60; or &#x60;operation&#x60; is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |
| **403** | Returned if the user does not have permission perform the check. |  -  |
| **404** | Returned if there is no content with the given ID. |  -  |

