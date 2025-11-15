# ContentAttachmentsApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createAttachment**](ContentAttachmentsApi.md#createAttachment) | **POST** /wiki/rest/api/content/{id}/child/attachment | Create attachment |
| [**createOrUpdateAttachments**](ContentAttachmentsApi.md#createOrUpdateAttachments) | **PUT** /wiki/rest/api/content/{id}/child/attachment | Create or update attachment |
| [**downloadAttatchment**](ContentAttachmentsApi.md#downloadAttatchment) | **GET** /wiki/rest/api/content/{id}/child/attachment/{attachmentId}/download | Get URI to download attachment |
| [**updateAttachmentData**](ContentAttachmentsApi.md#updateAttachmentData) | **POST** /wiki/rest/api/content/{id}/child/attachment/{attachmentId}/data | Update attachment data |
| [**updateAttachmentProperties**](ContentAttachmentsApi.md#updateAttachmentProperties) | **PUT** /wiki/rest/api/content/{id}/child/attachment/{attachmentId} | Update attachment properties |


<a id="createAttachment"></a>
# **createAttachment**
> ContentArray createAttachment(id, _file, minorEdit, status, comment)

Create attachment

Adds an attachment to a piece of content. This method only adds a new attachment. If you want to update an existing attachment, use [Create or update attachments](#api-content-id-child-attachment-put).  Note, you must set a &#x60;X-Atlassian-Token: nocheck&#x60; header on the request for this method, otherwise it will be blocked. This protects against XSRF attacks, which is necessary as this method accepts multipart/form-data.  The media type &#39;multipart/form-data&#39; is defined in [RFC 7578](https://www.ietf.org/rfc/rfc7578.txt). Most client libraries have classes that make it easier to implement multipart posts, like the [MultipartEntityBuilder](https://hc.apache.org/httpcomponents-client-5.1.x/current/httpclient5/apidocs/) Java class provided by Apache HTTP Components.  Note, according to [RFC 7578](https://tools.ietf.org/html/rfc7578#section-4.5), in the case where the form data is text, the charset parameter for the \&quot;text/plain\&quot; Content-Type may be used to indicate the character encoding used in that part. In the case of this API endpoint, the &#x60;comment&#x60; body parameter should be sent with &#x60;type&#x3D;text/plain&#x60; and &#x60;charset&#x3D;utf-8&#x60; values. This will force the charset to be UTF-8.  Example: This curl command attaches a file (&#39;example.txt&#39;) to a container (id&#x3D;&#39;123&#39;) with a comment and &#x60;minorEdits&#x60;&#x3D;true.  &#x60;&#x60;&#x60; bash curl -D- \\   -u admin:admin \\   -X POST \\   -H &#39;X-Atlassian-Token: nocheck&#39; \\   -F &#39;file&#x3D;@\&quot;example.txt\&quot;&#39; \\   -F &#39;minorEdit&#x3D;\&quot;true\&quot;&#39; \\   -F &#39;comment&#x3D;\&quot;Example attachment comment\&quot;; type&#x3D;text/plain; charset&#x3D;utf-8&#39; \\   https://myhost/wiki/rest/api/content/123/child/attachment &#x60;&#x60;&#x60; **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to update the content.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ContentAttachmentsApi;

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

    ContentAttachmentsApi apiInstance = new ContentAttachmentsApi(defaultClient);
    String id = "id_example"; // String | The ID of the content to add the attachment to.
    File _file = new File("/path/to/file"); // File | The relative location and name of the attachment to be added to the content.
    File minorEdit = new File("/path/to/file"); // File | If `minorEdits` is set to 'true', no notification email or activity stream will be generated when the attachment is added to the content.
    String status = "current"; // String | The status of the content that the attachment is being added to.
    File comment = new File("/path/to/file"); // File | The comment for the attachment that is being added. If you specify a comment, then every file must have a comment and the comments must be in the same order as the files. Alternatively, don't specify any comments.
    try {
      ContentArray result = apiInstance.createAttachment(id, _file, minorEdit, status, comment);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentAttachmentsApi#createAttachment");
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
| **id** | **String**| The ID of the content to add the attachment to. | |
| **_file** | **File**| The relative location and name of the attachment to be added to the content. | |
| **minorEdit** | **File**| If &#x60;minorEdits&#x60; is set to &#39;true&#39;, no notification email or activity stream will be generated when the attachment is added to the content. | |
| **status** | **String**| The status of the content that the attachment is being added to. | [optional] [default to current] [enum: current, draft] |
| **comment** | **File**| The comment for the attachment that is being added. If you specify a comment, then every file must have a comment and the comments must be in the same order as the files. Alternatively, don&#39;t specify any comments. | [optional] |

### Return type

[**ContentArray**](ContentArray.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the attachments were added to the content. |  -  |
| **400** | Returned if the content already has an attachment with the same filename. |  -  |
| **403** | Returned if;  - Attachments are disabled in Confluence. - The calling user does not have permission to add attachments to the content. |  -  |
| **404** | Returned if;  - The requested content is not found. - The user does not have permission to view it - The attachment exceeds the maximum configured attachment size. |  -  |

<a id="createOrUpdateAttachments"></a>
# **createOrUpdateAttachments**
> ContentArray createOrUpdateAttachments(id, _file, minorEdit, status, comment)

Create or update attachment

Adds an attachment to a piece of content. If the attachment already exists for the content, then the attachment is updated (i.e. a new version of the attachment is created).  Note, you must set a &#x60;X-Atlassian-Token: nocheck&#x60; header on the request for this method, otherwise it will be blocked. This protects against XSRF attacks, which is necessary as this method accepts multipart/form-data.  The media type &#39;multipart/form-data&#39; is defined in [RFC 7578](https://www.ietf.org/rfc/rfc7578.txt). Most client libraries have classes that make it easier to implement multipart posts, like the [MultipartEntityBuilder](https://hc.apache.org/httpcomponents-client-5.1.x/current/httpclient5/apidocs/) Java class provided by Apache HTTP Components.  Note, according to [RFC 7578](https://tools.ietf.org/html/rfc7578#section-4.5), in the case where the form data is text, the charset parameter for the \&quot;text/plain\&quot; Content-Type may be used to indicate the character encoding used in that part. In the case of this API endpoint, the &#x60;comment&#x60; body parameter should be sent with &#x60;type&#x3D;text/plain&#x60; and &#x60;charset&#x3D;utf-8&#x60; values. This will force the charset to be UTF-8.  Example: This curl command attaches a file (&#39;example.txt&#39;) to a piece of content (id&#x3D;&#39;123&#39;) with a comment and &#x60;minorEdits&#x60;&#x3D;true. If the &#39;example.txt&#39; file already exists, it will update it with a new version of the attachment.  &#x60;&#x60;&#x60; bash curl -D- \\   -u admin:admin \\   -X PUT \\   -H &#39;X-Atlassian-Token: nocheck&#39; \\   -F &#39;file&#x3D;@\&quot;example.txt\&quot;&#39; \\   -F &#39;minorEdit&#x3D;\&quot;true\&quot;&#39; \\   -F &#39;comment&#x3D;\&quot;Example attachment comment\&quot;; type&#x3D;text/plain; charset&#x3D;utf-8&#39; \\   http://myhost/rest/api/content/123/child/attachment &#x60;&#x60;&#x60; **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to update the content.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ContentAttachmentsApi;

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

    ContentAttachmentsApi apiInstance = new ContentAttachmentsApi(defaultClient);
    String id = "id_example"; // String | The ID of the content to add the attachment to.
    File _file = new File("/path/to/file"); // File | The relative location and name of the attachment to be added to the content.
    File minorEdit = new File("/path/to/file"); // File | If `minorEdits` is set to 'true', no notification email or activity stream will be generated when the attachment is added to the content.
    String status = "current"; // String | The status of the content that the attachment is being added to. This should always be set to 'current'.
    File comment = new File("/path/to/file"); // File | The comment for the attachment that is being added. If you specify a comment, then every file must have a comment and the comments must be in the same order as the files. Alternatively, don't specify any comments.
    try {
      ContentArray result = apiInstance.createOrUpdateAttachments(id, _file, minorEdit, status, comment);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentAttachmentsApi#createOrUpdateAttachments");
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
| **id** | **String**| The ID of the content to add the attachment to. | |
| **_file** | **File**| The relative location and name of the attachment to be added to the content. | |
| **minorEdit** | **File**| If &#x60;minorEdits&#x60; is set to &#39;true&#39;, no notification email or activity stream will be generated when the attachment is added to the content. | |
| **status** | **String**| The status of the content that the attachment is being added to. This should always be set to &#39;current&#39;. | [optional] [default to current] [enum: current, draft] |
| **comment** | **File**| The comment for the attachment that is being added. If you specify a comment, then every file must have a comment and the comments must be in the same order as the files. Alternatively, don&#39;t specify any comments. | [optional] |

### Return type

[**ContentArray**](ContentArray.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the attachments were added to the content. |  -  |
| **403** | Returned if;  - Attachments are disabled. - The calling user does not have permission to add attachments to the content. |  -  |
| **404** | Returned if;  - The requested content is not found. - The user does not have permission to view it. - The attachment exceeds the maximum configured attachment size. |  -  |

<a id="downloadAttatchment"></a>
# **downloadAttatchment**
> downloadAttatchment(id, attachmentId, version, status)

Get URI to download attachment

Redirects the client to a URL that serves an attachment&#39;s binary data.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ContentAttachmentsApi;

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

    ContentAttachmentsApi apiInstance = new ContentAttachmentsApi(defaultClient);
    String id = "id_example"; // String | The ID of the content that the attachment is attached to.
    String attachmentId = "attachmentId_example"; // String | The ID of the attachment to download.
    Integer version = 56; // Integer | The version of the attachment. If this parameter is absent, the redirect URI will download the latest version of the attachment.
    List<String> status = Arrays.asList(); // List<String> | The statuses allowed on the retrieved attachment. If this parameter is absent, it will default to `current`.
    try {
      apiInstance.downloadAttatchment(id, attachmentId, version, status);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentAttachmentsApi#downloadAttatchment");
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
| **id** | **String**| The ID of the content that the attachment is attached to. | |
| **attachmentId** | **String**| The ID of the attachment to download. | |
| **version** | **Integer**| The version of the attachment. If this parameter is absent, the redirect URI will download the latest version of the attachment. | [optional] |
| **status** | [**List&lt;String&gt;**](String.md)| The statuses allowed on the retrieved attachment. If this parameter is absent, it will default to &#x60;current&#x60;. | [optional] |

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
| **302** | Returned if download URL is found. |  -  |
| **400** | Returned if version number is greater than attachment&#39;s latest version number or an invalid value. |  -  |
| **401** | Returned if there are authentication issues in request. |  -  |
| **404** | Returned if;  - No content is found with the specified content ID. - The specified content does not contain an attachment with the specified attachment ID. - The calling user does not have permission to view the attachment. |  -  |

<a id="updateAttachmentData"></a>
# **updateAttachmentData**
> Content updateAttachmentData(id, attachmentId, _file, minorEdit, comment)

Update attachment data

Updates the binary data of an attachment, given the attachment ID, and optionally the comment and the minor edit field.  This method is essentially the same as [Create or update attachments](#api-content-id-child-attachment-put), except that it matches the attachment ID rather than the name.  Note, you must set a &#x60;X-Atlassian-Token: nocheck&#x60; header on the request for this method, otherwise it will be blocked. This protects against XSRF attacks, which is necessary as this method accepts multipart/form-data.  The media type &#39;multipart/form-data&#39; is defined in [RFC 7578](https://www.ietf.org/rfc/rfc7578.txt). Most client libraries have classes that make it easier to implement multipart posts, like the [MultipartEntityBuilder](https://hc.apache.org/httpcomponents-client-5.1.x/current/httpclient5/apidocs/) Java class provided by Apache HTTP Components.  Note, according to [RFC 7578](https://tools.ietf.org/html/rfc7578#section-4.5), in the case where the form data is text, the charset parameter for the \&quot;text/plain\&quot; Content-Type may be used to indicate the character encoding used in that part. In the case of this API endpoint, the &#x60;comment&#x60; body parameter should be sent with &#x60;type&#x3D;text/plain&#x60; and &#x60;charset&#x3D;utf-8&#x60; values. This will force the charset to be UTF-8.  Example: This curl command updates an attachment (id&#x3D;&#39;att456&#39;) that is attached to a piece of content (id&#x3D;&#39;123&#39;) with a comment and &#x60;minorEdits&#x60;&#x3D;true.  &#x60;&#x60;&#x60; bash curl -D- \\   -u admin:admin \\   -X POST \\   -H &#39;X-Atlassian-Token: nocheck&#39; \\   -F &#39;file&#x3D;@\&quot;example.txt\&quot;&#39; \\   -F &#39;minorEdit&#x3D;\&quot;true\&quot;&#39; \\   -F &#39;comment&#x3D;\&quot;Example attachment comment\&quot;; type&#x3D;text/plain; charset&#x3D;utf-8&#39; \\   http://myhost/rest/api/content/123/child/attachment/att456/data &#x60;&#x60;&#x60; **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to update the content.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ContentAttachmentsApi;

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

    ContentAttachmentsApi apiInstance = new ContentAttachmentsApi(defaultClient);
    String id = "id_example"; // String | The ID of the content that the attachment is attached to.
    String attachmentId = "attachmentId_example"; // String | The ID of the attachment to update.
    File _file = new File("/path/to/file"); // File | The relative location and name of the attachment to be added to the content.
    File minorEdit = new File("/path/to/file"); // File | If `minorEdits` is set to 'true', no notification email or activity stream will be generated when the attachment is added to the content.
    File comment = new File("/path/to/file"); // File | The comment for the attachment that is being added. If you specify a comment, then every file must have a comment and the comments must be in the same order as the files. Alternatively, don't specify any comments.
    try {
      Content result = apiInstance.updateAttachmentData(id, attachmentId, _file, minorEdit, comment);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentAttachmentsApi#updateAttachmentData");
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
| **id** | **String**| The ID of the content that the attachment is attached to. | |
| **attachmentId** | **String**| The ID of the attachment to update. | |
| **_file** | **File**| The relative location and name of the attachment to be added to the content. | |
| **minorEdit** | **File**| If &#x60;minorEdits&#x60; is set to &#39;true&#39;, no notification email or activity stream will be generated when the attachment is added to the content. | |
| **comment** | **File**| The comment for the attachment that is being added. If you specify a comment, then every file must have a comment and the comments must be in the same order as the files. Alternatively, don&#39;t specify any comments. | [optional] |

### Return type

[**Content**](Content.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the attachment is updated. |  -  |
| **400** | Returned if the attachment id is invalid. |  -  |
| **404** | Returned if no attachment is found for the attachment ID. |  -  |

<a id="updateAttachmentProperties"></a>
# **updateAttachmentProperties**
> Content updateAttachmentProperties(id, attachmentId, body)

Update attachment properties

Updates the attachment properties, i.e. the non-binary data of an attachment like the filename, media-type, comment, and parent container.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to update the content.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ContentAttachmentsApi;

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

    ContentAttachmentsApi apiInstance = new ContentAttachmentsApi(defaultClient);
    String id = "id_example"; // String | The ID of the content that the attachment is attached to.
    String attachmentId = "attachmentId_example"; // String | The ID of the attachment to update.
    AttachmentPropertiesUpdateBody body = new AttachmentPropertiesUpdateBody(); // AttachmentPropertiesUpdateBody | The details of the attachment to be updated.
    try {
      Content result = apiInstance.updateAttachmentProperties(id, attachmentId, body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentAttachmentsApi#updateAttachmentProperties");
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
| **id** | **String**| The ID of the content that the attachment is attached to. | |
| **attachmentId** | **String**| The ID of the attachment to update. | |
| **body** | [**AttachmentPropertiesUpdateBody**](AttachmentPropertiesUpdateBody.md)| The details of the attachment to be updated. | |

### Return type

[**Content**](Content.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the attachment is updated. |  -  |
| **400** | Returned if;  - The attachment id is invalid. - The attachment version number is invalid. |  -  |
| **403** | Returned if;  - The calling user is not permitted to update or move the attachment. - The attachment is being moved to an invalid content type. |  -  |
| **404** | Returned if no attachment is found for the attachment ID. |  -  |
| **409** | Returned if the version of the supplied attachment does not match the version of the attachment stored in the database. |  -  |

