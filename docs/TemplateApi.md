# TemplateApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createContentTemplate**](TemplateApi.md#createContentTemplate) | **POST** /wiki/rest/api/template | Create content template |
| [**getBlueprintTemplates**](TemplateApi.md#getBlueprintTemplates) | **GET** /wiki/rest/api/template/blueprint | Get blueprint templates |
| [**getContentTemplate**](TemplateApi.md#getContentTemplate) | **GET** /wiki/rest/api/template/{contentTemplateId} | Get content template |
| [**getContentTemplates**](TemplateApi.md#getContentTemplates) | **GET** /wiki/rest/api/template/page | Get content templates |
| [**removeTemplate**](TemplateApi.md#removeTemplate) | **DELETE** /wiki/rest/api/template/{contentTemplateId} | Remove template |
| [**updateContentTemplate**](TemplateApi.md#updateContentTemplate) | **PUT** /wiki/rest/api/template | Update content template |


<a id="createContentTemplate"></a>
# **createContentTemplate**
> ContentTemplate createContentTemplate(body)

Create content template

Creates a new content template. Note, blueprint templates cannot be created via the REST API.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;Admin&#39; permission for the space to create a space template or &#39;Confluence Administrator&#39; global permission to create a global template.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.TemplateApi;

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

    TemplateApi apiInstance = new TemplateApi(defaultClient);
    ContentTemplateCreate body = new ContentTemplateCreate(); // ContentTemplateCreate | The content template to be created. The content body must be in 'storage' format.
    try {
      ContentTemplate result = apiInstance.createContentTemplate(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateApi#createContentTemplate");
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
| **body** | [**ContentTemplateCreate**](ContentTemplateCreate.md)| The content template to be created. The content body must be in &#39;storage&#39; format. | |

### Return type

[**ContentTemplate**](ContentTemplate.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the template is created. |  -  |
| **400** | Returned if template name is null or an empty string. |  -  |
| **403** | Returned if the calling user does not have permission to create the template. |  -  |

<a id="getBlueprintTemplates"></a>
# **getBlueprintTemplates**
> BlueprintTemplateArray getBlueprintTemplates(spaceKey, start, limit, expand)

Get blueprint templates

Returns all templates provided by blueprints. Use this method to retrieve all global blueprint templates or all blueprint templates in a space.  Note, all global blueprints are inherited by each space. Space blueprints can be customised without affecting the global blueprints.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;View&#39; permission for the space to view blueprints for the space and permission to access the Confluence site (&#39;Can use&#39; global permission) to view global blueprints.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.TemplateApi;

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

    TemplateApi apiInstance = new TemplateApi(defaultClient);
    String spaceKey = "spaceKey_example"; // String | The key of the space to be queried for templates. If the `spaceKey` is not specified, global blueprint templates will be returned.
    Integer start = 0; // Integer | The starting index of the returned templates.
    Integer limit = 25; // Integer | The maximum number of templates to return per page. Note, this may be restricted by fixed system limits.
    List<String> expand = Arrays.asList(); // List<String> | A multi-value parameter indicating which properties of the template to expand.  - `body` or `body.storage` returns the content of the template in storage format.
    try {
      BlueprintTemplateArray result = apiInstance.getBlueprintTemplates(spaceKey, start, limit, expand);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateApi#getBlueprintTemplates");
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
| **spaceKey** | **String**| The key of the space to be queried for templates. If the &#x60;spaceKey&#x60; is not specified, global blueprint templates will be returned. | [optional] |
| **start** | **Integer**| The starting index of the returned templates. | [optional] [default to 0] |
| **limit** | **Integer**| The maximum number of templates to return per page. Note, this may be restricted by fixed system limits. | [optional] [default to 25] |
| **expand** | [**List&lt;String&gt;**](String.md)| A multi-value parameter indicating which properties of the template to expand.  - &#x60;body&#x60; or &#x60;body.storage&#x60; returns the content of the template in storage format. | [optional] [enum: body, body.storage] |

### Return type

[**BlueprintTemplateArray**](BlueprintTemplateArray.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested templates are returned. |  -  |
| **403** | Returned if the calling user does not have permission to view blueprint templates. |  -  |

<a id="getContentTemplate"></a>
# **getContentTemplate**
> ContentTemplate getContentTemplate(contentTemplateId, expand)

Get content template

Returns a content template. This includes information about template, like the name, the space or blueprint that the template is in, the body of the template, and more.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;View&#39; permission for the space to view space templates and permission to access the Confluence site (&#39;Can use&#39; global permission) to view global templates.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.TemplateApi;

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

    TemplateApi apiInstance = new TemplateApi(defaultClient);
    String contentTemplateId = "contentTemplateId_example"; // String | The ID of the content template to be returned.
    List<String> expand = Arrays.asList(); // List<String> | A multi-value parameter indicating which properties of the template to expand.  - `body` or `body.storage` returns the content of the template in storage format.
    try {
      ContentTemplate result = apiInstance.getContentTemplate(contentTemplateId, expand);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateApi#getContentTemplate");
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
| **contentTemplateId** | **String**| The ID of the content template to be returned. | |
| **expand** | [**List&lt;String&gt;**](String.md)| A multi-value parameter indicating which properties of the template to expand.  - &#x60;body&#x60; or &#x60;body.storage&#x60; returns the content of the template in storage format. | [optional] [enum: body, body.storage] |

### Return type

[**ContentTemplate**](ContentTemplate.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested template is returned. |  -  |
| **403** | Returned if;  - There is no template with the given ID. - The calling user does not have permission to view the template. |  -  |

<a id="getContentTemplates"></a>
# **getContentTemplates**
> ContentTemplateArray getContentTemplates(spaceKey, start, limit, expand)

Get content templates

Returns all content templates. Use this method to retrieve all global content templates or all content templates in a space.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;View&#39; permission for the space to view space templates and permission to access the Confluence site (&#39;Can use&#39; global permission) to view global templates.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.TemplateApi;

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

    TemplateApi apiInstance = new TemplateApi(defaultClient);
    String spaceKey = "spaceKey_example"; // String | The key of the space to be queried for templates. If the `spaceKey` is not specified, global templates will be returned.
    Integer start = 0; // Integer | The starting index of the returned templates.
    Integer limit = 25; // Integer | The maximum number of templates to return per page. Note, this may be restricted by fixed system limits.
    List<String> expand = Arrays.asList(); // List<String> | A multi-value parameter indicating which properties of the template to expand.  - `body` or `body.storage` returns the content of the template in storage format.
    try {
      ContentTemplateArray result = apiInstance.getContentTemplates(spaceKey, start, limit, expand);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateApi#getContentTemplates");
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
| **spaceKey** | **String**| The key of the space to be queried for templates. If the &#x60;spaceKey&#x60; is not specified, global templates will be returned. | [optional] |
| **start** | **Integer**| The starting index of the returned templates. | [optional] [default to 0] |
| **limit** | **Integer**| The maximum number of templates to return per page. Note, this may be restricted by fixed system limits. | [optional] [default to 25] |
| **expand** | [**List&lt;String&gt;**](String.md)| A multi-value parameter indicating which properties of the template to expand.  - &#x60;body&#x60; or &#x60;body.storage&#x60; returns the content of the template in storage format. | [optional] [enum: body, body.storage] |

### Return type

[**ContentTemplateArray**](ContentTemplateArray.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested templates are returned. |  -  |
| **403** | Returned if the calling user does not have permission to view the content templates. |  -  |

<a id="removeTemplate"></a>
# **removeTemplate**
> removeTemplate(contentTemplateId)

Remove template

Deletes a template. This results in different actions depending on the type of template:  - If the template is a content template, it is deleted. - If the template is a modified space-level blueprint template, it reverts to the template inherited from the global-level blueprint template. - If the template is a modified global-level blueprint template, it reverts to the default global-level blueprint template.   Note, unmodified blueprint templates cannot be deleted.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**:         &#39;Admin&#39; permission for the space to delete a space template or &#39;Confluence Administrator&#39;         global permission to delete a global template.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.TemplateApi;

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

    TemplateApi apiInstance = new TemplateApi(defaultClient);
    String contentTemplateId = "contentTemplateId_example"; // String | The ID of the template to be deleted.
    try {
      apiInstance.removeTemplate(contentTemplateId);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateApi#removeTemplate");
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
| **contentTemplateId** | **String**| The ID of the template to be deleted. | |

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
| **204** | Returned if the template has been successfully been deleted. |  -  |
| **403** | Returned if;  - There is no template with the given ID. - The calling user does not have permission to delete the template. |  -  |

<a id="updateContentTemplate"></a>
# **updateContentTemplate**
> ContentTemplate updateContentTemplate(body)

Update content template

Updates a content template. Note, blueprint templates cannot be updated via the REST API.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;Admin&#39; permission for the space to update a space template or &#39;Confluence Administrator&#39; global permission to update a global template.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.TemplateApi;

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

    TemplateApi apiInstance = new TemplateApi(defaultClient);
    ContentTemplateUpdate body = new ContentTemplateUpdate(); // ContentTemplateUpdate | The updated content template.
    try {
      ContentTemplate result = apiInstance.updateContentTemplate(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemplateApi#updateContentTemplate");
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
| **body** | [**ContentTemplateUpdate**](ContentTemplateUpdate.md)| The updated content template. | |

### Return type

[**ContentTemplate**](ContentTemplate.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the template is updated. |  -  |
| **400** | Returned if template name is null or an empty string. |  -  |
| **403** | Returned if the calling user does not have permission. |  -  |
| **404** | Returned if the calling user does not have permission to update the template or if the template doesn&#39;t exist. |  -  |

