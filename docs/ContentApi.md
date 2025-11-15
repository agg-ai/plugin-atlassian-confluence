# ContentApi

All URIs are relative to *http://your-domain.atlassian.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**archivePages**](ContentApi.md#archivePages) | **POST** /wiki/rest/api/content/archive | Archive pages |
| [**publishLegacyDraft**](ContentApi.md#publishLegacyDraft) | **POST** /wiki/rest/api/content/blueprint/instance/{draftId} | Publish legacy draft |
| [**publishSharedDraft**](ContentApi.md#publishSharedDraft) | **PUT** /wiki/rest/api/content/blueprint/instance/{draftId} | Publish shared draft |
| [**searchContentByCQL**](ContentApi.md#searchContentByCQL) | **GET** /wiki/rest/api/content/search | Search content by CQL |


<a id="archivePages"></a>
# **archivePages**
> LongTask archivePages(archivePagesRequest)

Archive pages

Archives a list of pages. The pages to be archived are specified as a list of content IDs. This API accepts the archival request and returns a task ID. The archival process happens asynchronously. Use the /longtask/&lt;taskId&gt; REST API to get the copy task status.  Each content ID needs to resolve to page objects that are not already in an archived state. The content IDs need not belong to the same space.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: &#39;Archive&#39; permission for each of the pages in the corresponding space it belongs to.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ContentApi;

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

    ContentApi apiInstance = new ContentApi(defaultClient);
    ArchivePagesRequest archivePagesRequest = new ArchivePagesRequest(); // ArchivePagesRequest | The pages to be archived.
    try {
      LongTask result = apiInstance.archivePages(archivePagesRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentApi#archivePages");
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
| **archivePagesRequest** | [**ArchivePagesRequest**](ArchivePagesRequest.md)| The pages to be archived. | [optional] |

### Return type

[**LongTask**](LongTask.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Returned if the archive request has been submitted. |  -  |
| **400** | Returned if: - there is an archival job already running for the tenant. - the number of pages to archive is larger than the limit of 300. - any of the content IDs specified in the array do not resolve to pages. - any of the specified pages are already archived. - the request is coming from a free edition tenant. - the request is coming from a non premium edition tenant with more than 1 page ID   in the archive request. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |

<a id="publishLegacyDraft"></a>
# **publishLegacyDraft**
> Content publishLegacyDraft(draftId, body, status, expand)

Publish legacy draft

Publishes a legacy draft of a page created from a blueprint. Legacy drafts will eventually be removed in favor of shared drafts. For now, this method works the same as [Publish shared draft](#api-content-blueprint-instance-draftId-put).  By default, the following objects are expanded: &#x60;body.storage&#x60;, &#x60;history&#x60;, &#x60;space&#x60;, &#x60;version&#x60;, &#x60;ancestors&#x60;.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to view the draft and &#39;Add&#39; permission for the space that the content will be created in.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ContentApi;

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

    ContentApi apiInstance = new ContentApi(defaultClient);
    String draftId = "draftId_example"; // String | The ID of the draft page that was created from a blueprint. You can find the `draftId` in the Confluence application by opening the draft page and checking the page URL.
    ContentBlueprintDraft body = new ContentBlueprintDraft(); // ContentBlueprintDraft | 
    String status = "draft"; // String | The status of the content to be updated, i.e. the draft. This is set to 'draft' by default, so you shouldn't need to specify it.
    List<String> expand = Arrays.asList(); // List<String> | A multi-value parameter indicating which properties of the content to expand.  - `childTypes.all` returns whether the content has attachments, comments, or child pages/whiteboards. Use this if you only need to check whether the content has children of a particular type. - `childTypes.attachment` returns whether the content has attachments. - `childTypes.comment` returns whether the content has comments. - `childTypes.page` returns whether the content has child pages. - `childTypes.whiteboard` returns whether the content has child whiteboards. - `childTypes.database` returns whether the content has child databases. - `childTypes.embed` returns whether the content has child embeds (smartlinks). - `childTypes.folder` returns whether the content has child folders. - `container` returns the space that the content is in. This is the same as the information returned by [Get space](#api-space-spaceKey-get). - `metadata.currentuser` returns information about the current user in relation to the content, including when they last viewed it, modified it, contributed to it, or added it as a favorite. - `metadata.properties` returns content properties that have been set via the Confluence REST API. - `metadata.labels` returns the labels that have been added to the content. - `metadata.frontend` this property is only used by Atlassian. - `operations` returns the operations for the content, which are used when setting permissions. - `children.page` returns pages that are descendants at the level immediately below the content. - `children.whiteboard` returns whiteboards that are descendants at the level immediately below the content. - `children.database` returns databases that are descendants at the level immediately below the content. - `children.embed` returns embeds (smartlinks) that are descendants at the level immediately below the content. - `children.folder` returns folders that are descendants at the level immediately below the content. - `children.attachment` returns all attachments for the content. - `children.comment` returns all comments on the content. - `restrictions.read.restrictions.user` returns the users that have permission to read the content. - `restrictions.read.restrictions.group` returns the groups that have permission to read the content. Note that this may return deleted groups, because deleting a group doesn't remove associated restrictions. - `restrictions.update.restrictions.user` returns the users that have permission to update the content. - `restrictions.update.restrictions.group` returns the groups that have permission to update the content. Note that this may return deleted groups because deleting a group doesn't remove associated restrictions. - `history` returns the history of the content, including the date it was created. - `history.lastUpdated` returns information about the most recent update of the content, including who updated it and when it was updated. - `history.previousVersion` returns information about the update prior to the current content update. - `history.contributors` returns all of the users who have contributed to the content. - `history.nextVersion` returns information about the update after to the current content update. - `ancestors` returns the parent content, if the content is a page or whiteboard. - `body` returns the body of the content in different formats, including the editor format, view format, and export format. - `body.storage` returns the body of content in storage format. - `body.view` returns the body of content in view format. - `version` returns information about the most recent update of the content, including who updated it and when it was updated. - `descendants.page` returns pages that are descendants at any level below the content. - `descendants.whiteboard` returns whiteboards that are descendants at any level below the content. - `descendants.database` returns databases that are descendants at any level below the content. - `descendants.embed` returns embeds (smartlinks) that are descendants at any level below the content. - `descendants.folder` returns folders that are descendants at any level below the content. - `descendants.attachment` returns all attachments for the content, same as `children.attachment`. - `descendants.comment` returns all comments on the content, same as `children.comment`. - `space` returns the space that the content is in. This is the same as the information returned by [Get space](#api-space-spaceKey-get).  In addition, the following comment-specific expansions can be used: - `extensions.inlineProperties` returns inline comment-specific properties. - `extensions.resolution` returns the resolution status of each comment.
    try {
      Content result = apiInstance.publishLegacyDraft(draftId, body, status, expand);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentApi#publishLegacyDraft");
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
| **draftId** | **String**| The ID of the draft page that was created from a blueprint. You can find the &#x60;draftId&#x60; in the Confluence application by opening the draft page and checking the page URL. | |
| **body** | [**ContentBlueprintDraft**](ContentBlueprintDraft.md)|  | |
| **status** | **String**| The status of the content to be updated, i.e. the draft. This is set to &#39;draft&#39; by default, so you shouldn&#39;t need to specify it. | [optional] [default to draft] |
| **expand** | [**List&lt;String&gt;**](String.md)| A multi-value parameter indicating which properties of the content to expand.  - &#x60;childTypes.all&#x60; returns whether the content has attachments, comments, or child pages/whiteboards. Use this if you only need to check whether the content has children of a particular type. - &#x60;childTypes.attachment&#x60; returns whether the content has attachments. - &#x60;childTypes.comment&#x60; returns whether the content has comments. - &#x60;childTypes.page&#x60; returns whether the content has child pages. - &#x60;childTypes.whiteboard&#x60; returns whether the content has child whiteboards. - &#x60;childTypes.database&#x60; returns whether the content has child databases. - &#x60;childTypes.embed&#x60; returns whether the content has child embeds (smartlinks). - &#x60;childTypes.folder&#x60; returns whether the content has child folders. - &#x60;container&#x60; returns the space that the content is in. This is the same as the information returned by [Get space](#api-space-spaceKey-get). - &#x60;metadata.currentuser&#x60; returns information about the current user in relation to the content, including when they last viewed it, modified it, contributed to it, or added it as a favorite. - &#x60;metadata.properties&#x60; returns content properties that have been set via the Confluence REST API. - &#x60;metadata.labels&#x60; returns the labels that have been added to the content. - &#x60;metadata.frontend&#x60; this property is only used by Atlassian. - &#x60;operations&#x60; returns the operations for the content, which are used when setting permissions. - &#x60;children.page&#x60; returns pages that are descendants at the level immediately below the content. - &#x60;children.whiteboard&#x60; returns whiteboards that are descendants at the level immediately below the content. - &#x60;children.database&#x60; returns databases that are descendants at the level immediately below the content. - &#x60;children.embed&#x60; returns embeds (smartlinks) that are descendants at the level immediately below the content. - &#x60;children.folder&#x60; returns folders that are descendants at the level immediately below the content. - &#x60;children.attachment&#x60; returns all attachments for the content. - &#x60;children.comment&#x60; returns all comments on the content. - &#x60;restrictions.read.restrictions.user&#x60; returns the users that have permission to read the content. - &#x60;restrictions.read.restrictions.group&#x60; returns the groups that have permission to read the content. Note that this may return deleted groups, because deleting a group doesn&#39;t remove associated restrictions. - &#x60;restrictions.update.restrictions.user&#x60; returns the users that have permission to update the content. - &#x60;restrictions.update.restrictions.group&#x60; returns the groups that have permission to update the content. Note that this may return deleted groups because deleting a group doesn&#39;t remove associated restrictions. - &#x60;history&#x60; returns the history of the content, including the date it was created. - &#x60;history.lastUpdated&#x60; returns information about the most recent update of the content, including who updated it and when it was updated. - &#x60;history.previousVersion&#x60; returns information about the update prior to the current content update. - &#x60;history.contributors&#x60; returns all of the users who have contributed to the content. - &#x60;history.nextVersion&#x60; returns information about the update after to the current content update. - &#x60;ancestors&#x60; returns the parent content, if the content is a page or whiteboard. - &#x60;body&#x60; returns the body of the content in different formats, including the editor format, view format, and export format. - &#x60;body.storage&#x60; returns the body of content in storage format. - &#x60;body.view&#x60; returns the body of content in view format. - &#x60;version&#x60; returns information about the most recent update of the content, including who updated it and when it was updated. - &#x60;descendants.page&#x60; returns pages that are descendants at any level below the content. - &#x60;descendants.whiteboard&#x60; returns whiteboards that are descendants at any level below the content. - &#x60;descendants.database&#x60; returns databases that are descendants at any level below the content. - &#x60;descendants.embed&#x60; returns embeds (smartlinks) that are descendants at any level below the content. - &#x60;descendants.folder&#x60; returns folders that are descendants at any level below the content. - &#x60;descendants.attachment&#x60; returns all attachments for the content, same as &#x60;children.attachment&#x60;. - &#x60;descendants.comment&#x60; returns all comments on the content, same as &#x60;children.comment&#x60;. - &#x60;space&#x60; returns the space that the content is in. This is the same as the information returned by [Get space](#api-space-spaceKey-get).  In addition, the following comment-specific expansions can be used: - &#x60;extensions.inlineProperties&#x60; returns inline comment-specific properties. - &#x60;extensions.resolution&#x60; returns the resolution status of each comment. | [optional] |

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
| **200** | Returned if the draft was successfully published. |  -  |
| **400** | Returned if a title is not specified or a page with the title already exists. |  -  |
| **409** | Returned if the version is not set to 1. |  -  |

<a id="publishSharedDraft"></a>
# **publishSharedDraft**
> Content publishSharedDraft(draftId, body, status, expand)

Publish shared draft

Publishes a shared draft of a page created from a blueprint.  By default, the following objects are expanded: &#x60;body.storage&#x60;, &#x60;history&#x60;, &#x60;space&#x60;, &#x60;version&#x60;, &#x60;ancestors&#x60;.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to view the draft and &#39;Add&#39; permission for the space that the content will be created in.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ContentApi;

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

    ContentApi apiInstance = new ContentApi(defaultClient);
    String draftId = "draftId_example"; // String | The ID of the draft page that was created from a blueprint. You can find the `draftId` in the Confluence application by opening the draft page and checking the page URL.
    ContentBlueprintDraft body = new ContentBlueprintDraft(); // ContentBlueprintDraft | 
    String status = "draft"; // String | The status of the content to be updated, i.e. the draft. This is set to 'draft' by default, so you shouldn't need to specify it.
    List<String> expand = Arrays.asList(); // List<String> | A multi-value parameter indicating which properties of the content to expand.  - `childTypes.all` returns whether the content has attachments, comments, or child pages/whiteboards. Use this if you only need to check whether the content has children of a particular type. - `childTypes.attachment` returns whether the content has attachments. - `childTypes.comment` returns whether the content has comments. - `childTypes.page` returns whether the content has child pages. - `childTypes.whiteboard` returns whether the content has child whiteboards. - `childTypes.database` returns whether the content has child databases. - `childTypes.embed` returns whether the content has child embeds (smartlinks). - `childTypes.folder` returns whether the content has child folders. - `container` returns the space that the content is in. This is the same as the information returned by [Get space](#api-space-spaceKey-get). - `metadata.currentuser` returns information about the current user in relation to the content, including when they last viewed it, modified it, contributed to it, or added it as a favorite. - `metadata.properties` returns content properties that have been set via the Confluence REST API. - `metadata.labels` returns the labels that have been added to the content. - `metadata.frontend` this property is only used by Atlassian. - `operations` returns the operations for the content, which are used when setting permissions. - `children.page` returns pages that are descendants at the level immediately below the content. - `children.whiteboard` returns whiteboards that are descendants at the level immediately below the content. - `children.database` returns databases that are descendants at the level immediately below the content. - `children.embed` returns embeds (smartlinks) that are descendants at the level immediately below the content. - `children.folder` returns folders that are descendants at the level immediately below the content. - `children.attachment` returns all attachments for the content. - `children.comment` returns all comments on the content. - `restrictions.read.restrictions.user` returns the users that have permission to read the content. - `restrictions.read.restrictions.group` returns the groups that have permission to read the content. Note that this may return deleted groups, because deleting a group doesn't remove associated restrictions. - `restrictions.update.restrictions.user` returns the users that have permission to update the content. - `restrictions.update.restrictions.group` returns the groups that have permission to update the content. Note that this may return deleted groups because deleting a group doesn't remove associated restrictions. - `history` returns the history of the content, including the date it was created. - `history.lastUpdated` returns information about the most recent update of the content, including who updated it and when it was updated. - `history.previousVersion` returns information about the update prior to the current content update. - `history.contributors` returns all of the users who have contributed to the content. - `history.nextVersion` returns information about the update after to the current content update. - `ancestors` returns the parent content, if the content is a page or whiteboard. - `body` returns the body of the content in different formats, including the editor format, view format, and export format. - `body.storage` returns the body of content in storage format. - `body.view` returns the body of content in view format. - `version` returns information about the most recent update of the content, including who updated it and when it was updated. - `descendants.page` returns pages that are descendants at any level below the content. - `descendants.whiteboard` returns whiteboards that are descendants at any level below the content. - `descendants.database` returns databases that are descendants at any level below the content. - `descendants.embed` returns embeds (smartlinks) that are descendants at any level below the content. - `descendants.folder` returns folders that are descendants at any level below the content. - `descendants.attachment` returns all attachments for the content, same as `children.attachment`. - `descendants.comment` returns all comments on the content, same as `children.comment`. - `space` returns the space that the content is in. This is the same as the information returned by [Get space](#api-space-spaceKey-get).  In addition, the following comment-specific expansions can be used: - `extensions.inlineProperties` returns inline comment-specific properties. - `extensions.resolution` returns the resolution status of each comment.
    try {
      Content result = apiInstance.publishSharedDraft(draftId, body, status, expand);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentApi#publishSharedDraft");
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
| **draftId** | **String**| The ID of the draft page that was created from a blueprint. You can find the &#x60;draftId&#x60; in the Confluence application by opening the draft page and checking the page URL. | |
| **body** | [**ContentBlueprintDraft**](ContentBlueprintDraft.md)|  | |
| **status** | **String**| The status of the content to be updated, i.e. the draft. This is set to &#39;draft&#39; by default, so you shouldn&#39;t need to specify it. | [optional] [default to draft] |
| **expand** | [**List&lt;String&gt;**](String.md)| A multi-value parameter indicating which properties of the content to expand.  - &#x60;childTypes.all&#x60; returns whether the content has attachments, comments, or child pages/whiteboards. Use this if you only need to check whether the content has children of a particular type. - &#x60;childTypes.attachment&#x60; returns whether the content has attachments. - &#x60;childTypes.comment&#x60; returns whether the content has comments. - &#x60;childTypes.page&#x60; returns whether the content has child pages. - &#x60;childTypes.whiteboard&#x60; returns whether the content has child whiteboards. - &#x60;childTypes.database&#x60; returns whether the content has child databases. - &#x60;childTypes.embed&#x60; returns whether the content has child embeds (smartlinks). - &#x60;childTypes.folder&#x60; returns whether the content has child folders. - &#x60;container&#x60; returns the space that the content is in. This is the same as the information returned by [Get space](#api-space-spaceKey-get). - &#x60;metadata.currentuser&#x60; returns information about the current user in relation to the content, including when they last viewed it, modified it, contributed to it, or added it as a favorite. - &#x60;metadata.properties&#x60; returns content properties that have been set via the Confluence REST API. - &#x60;metadata.labels&#x60; returns the labels that have been added to the content. - &#x60;metadata.frontend&#x60; this property is only used by Atlassian. - &#x60;operations&#x60; returns the operations for the content, which are used when setting permissions. - &#x60;children.page&#x60; returns pages that are descendants at the level immediately below the content. - &#x60;children.whiteboard&#x60; returns whiteboards that are descendants at the level immediately below the content. - &#x60;children.database&#x60; returns databases that are descendants at the level immediately below the content. - &#x60;children.embed&#x60; returns embeds (smartlinks) that are descendants at the level immediately below the content. - &#x60;children.folder&#x60; returns folders that are descendants at the level immediately below the content. - &#x60;children.attachment&#x60; returns all attachments for the content. - &#x60;children.comment&#x60; returns all comments on the content. - &#x60;restrictions.read.restrictions.user&#x60; returns the users that have permission to read the content. - &#x60;restrictions.read.restrictions.group&#x60; returns the groups that have permission to read the content. Note that this may return deleted groups, because deleting a group doesn&#39;t remove associated restrictions. - &#x60;restrictions.update.restrictions.user&#x60; returns the users that have permission to update the content. - &#x60;restrictions.update.restrictions.group&#x60; returns the groups that have permission to update the content. Note that this may return deleted groups because deleting a group doesn&#39;t remove associated restrictions. - &#x60;history&#x60; returns the history of the content, including the date it was created. - &#x60;history.lastUpdated&#x60; returns information about the most recent update of the content, including who updated it and when it was updated. - &#x60;history.previousVersion&#x60; returns information about the update prior to the current content update. - &#x60;history.contributors&#x60; returns all of the users who have contributed to the content. - &#x60;history.nextVersion&#x60; returns information about the update after to the current content update. - &#x60;ancestors&#x60; returns the parent content, if the content is a page or whiteboard. - &#x60;body&#x60; returns the body of the content in different formats, including the editor format, view format, and export format. - &#x60;body.storage&#x60; returns the body of content in storage format. - &#x60;body.view&#x60; returns the body of content in view format. - &#x60;version&#x60; returns information about the most recent update of the content, including who updated it and when it was updated. - &#x60;descendants.page&#x60; returns pages that are descendants at any level below the content. - &#x60;descendants.whiteboard&#x60; returns whiteboards that are descendants at any level below the content. - &#x60;descendants.database&#x60; returns databases that are descendants at any level below the content. - &#x60;descendants.embed&#x60; returns embeds (smartlinks) that are descendants at any level below the content. - &#x60;descendants.folder&#x60; returns folders that are descendants at any level below the content. - &#x60;descendants.attachment&#x60; returns all attachments for the content, same as &#x60;children.attachment&#x60;. - &#x60;descendants.comment&#x60; returns all comments on the content, same as &#x60;children.comment&#x60;. - &#x60;space&#x60; returns the space that the content is in. This is the same as the information returned by [Get space](#api-space-spaceKey-get).  In addition, the following comment-specific expansions can be used: - &#x60;extensions.inlineProperties&#x60; returns inline comment-specific properties. - &#x60;extensions.resolution&#x60; returns the resolution status of each comment. | [optional] |

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
| **200** | Returned if the draft was successfully published. |  -  |
| **400** | Returned if a title is not specified or a page with the title already exists. |  -  |
| **409** | Returned if the version is not set to 1. |  -  |

<a id="searchContentByCQL"></a>
# **searchContentByCQL**
> ContentArray searchContentByCQL(cql, cqlcontext, expand, cursor, limit)

Search content by CQL

Returns the list of content that matches a Confluence Query Language (CQL) query. For information on CQL, see: [Advanced searching using CQL](https://developer.atlassian.com/cloud/confluence/advanced-searching-using-cql/).  Example initial call: &#x60;&#x60;&#x60; /wiki/rest/api/content/search?cql&#x3D;type&#x3D;page&amp;limit&#x3D;25 &#x60;&#x60;&#x60;  Example response: &#x60;&#x60;&#x60; {   \&quot;results\&quot;: [     { ... },     { ... },     ...     { ... }   ],   \&quot;limit\&quot;: 25,   \&quot;size\&quot;: 25,   ...   \&quot;_links\&quot;: {     \&quot;base\&quot;: \&quot;&lt;url&gt;\&quot;,     \&quot;context\&quot;: \&quot;&lt;url&gt;\&quot;,     \&quot;next\&quot;: \&quot;/rest/api/content/search?cql&#x3D;type&#x3D;page&amp;limit&#x3D;25&amp;cursor&#x3D;raNDoMsTRiNg\&quot;,     \&quot;self\&quot;: \&quot;&lt;url&gt;\&quot;   } } &#x60;&#x60;&#x60;  When additional results are available, returns &#x60;next&#x60; and &#x60;prev&#x60; URLs to retrieve them in subsequent calls. The URLs each contain a cursor that points to the appropriate set of results. Use &#x60;limit&#x60; to specify the number of results returned in each call. Example subsequent call (taken from example response): &#x60;&#x60;&#x60; /wiki/rest/api/content/search?cql&#x3D;type&#x3D;page&amp;limit&#x3D;25&amp;cursor&#x3D;raNDoMsTRiNg &#x60;&#x60;&#x60; The response to this will have a &#x60;prev&#x60; URL similar to the &#x60;next&#x60; in the example response.  If the expand query parameter is used with the &#x60;body.export_view&#x60; and/or &#x60;body.styled_view&#x60; properties, then the query limit parameter will be restricted to a maximum value of 25.  **[Permissions](https://confluence.atlassian.com/x/_AozKw) required**: Permission to access the Confluence site (&#39;Can use&#39; global permission). Only content that the user has permission to view will be returned.

### Example
```java
// Import classes:
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiClient;
import io.kestra.plugin.atlassian_confluence.client.invoker.ApiException;
import io.kestra.plugin.atlassian_confluence.client.invoker.Configuration;
import io.kestra.plugin.atlassian_confluence.client.invoker.auth.*;
import io.kestra.plugin.atlassian_confluence.client.invoker.models.*;
import io.kestra.plugin.atlassian_confluence.client.api.ContentApi;

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

    ContentApi apiInstance = new ContentApi(defaultClient);
    String cql = "cql_example"; // String | The CQL string that is used to find the requested content.
    String cqlcontext = "cqlcontext_example"; // String | The space, content, and content status to execute the search against. Specify this as an object with the following properties:  - `spaceKey` Key of the space to search against. Optional. - `contentId` ID of the content to search against. Optional. Must be in the space spacified by `spaceKey`. - `contentStatuses` Content statuses to search against. Optional.
    List<String> expand = Arrays.asList(); // List<String> | A multi-value parameter indicating which properties of the content to expand.  - `childTypes.all` returns whether the content has attachments, comments, or child pages/whiteboards. Use this if you only need to check whether the content has children of a particular type. - `childTypes.attachment` returns whether the content has attachments. - `childTypes.comment` returns whether the content has comments. - `childTypes.page` returns whether the content has child pages. - `childTypes.whiteboard` returns whether the content has child whiteboards. - `childTypes.database` returns whether the content has child databases. - `childTypes.embed` returns whether the content has child embeds (smartlinks). - `childTypes.folder` returns whether the content has child folders. - `container` returns the space that the content is in. This is the same as the information returned by [Get space](#api-space-spaceKey-get). - `metadata.currentuser` returns information about the current user in relation to the content, including when they last viewed it, modified it, contributed to it, or added it as a favorite. - `metadata.properties` returns content properties that have been set via the Confluence REST API. - `metadata.labels` returns the labels that have been added to the content. - `metadata.frontend` this property is only used by Atlassian. - `operations` returns the operations for the content, which are used when setting permissions. - `children.page` returns pages that are descendants at the level immediately below the content. - `children.whiteboard` returns whiteboards that are descendants at the level immediately below the content. - `children.database` returns databases that are descendants at the level immediately below the content. - `children.embed` returns embeds (smartlinks) that are descendants at the level immediately below the content. - `children.folder` returns folders that are descendants at the level immediately below the content. - `children.attachment` returns all attachments for the content. - `children.comment` returns all comments on the content. - `restrictions.read.restrictions.user` returns the users that have permission to read the content. - `restrictions.read.restrictions.group` returns the groups that have permission to read the content. Note that this may return deleted groups, because deleting a group doesn't remove associated restrictions. - `restrictions.update.restrictions.user` returns the users that have permission to update the content. - `restrictions.update.restrictions.group` returns the groups that have permission to update the content. Note that this may return deleted groups because deleting a group doesn't remove associated restrictions. - `history` returns the history of the content, including the date it was created. - `history.lastUpdated` returns information about the most recent update of the content, including who updated it and when it was updated. - `history.previousVersion` returns information about the update prior to the current content update. - `history.contributors` returns all of the users who have contributed to the content. - `history.nextVersion` returns information about the update after to the current content update. - `ancestors` returns the parent content, if the content is a page or whiteboard. - `body` returns the body of the content in different formats, including the editor format, view format, and export format. - `body.storage` returns the body of content in storage format. - `body.view` returns the body of content in view format. - `version` returns information about the most recent update of the content, including who updated it and when it was updated. - `descendants.page` returns pages that are descendants at any level below the content. - `descendants.whiteboard` returns whiteboards that are descendants at any level below the content. - `descendants.database` returns databases that are descendants at any level below the content. - `descendants.embed` returns embeds (smartlinks) that are descendants at any level below the content. - `descendants.folder` returns folders that are descendants at any level below the content. - `descendants.attachment` returns all attachments for the content, same as `children.attachment`. - `descendants.comment` returns all comments on the content, same as `children.comment`. - `space` returns the space that the content is in. This is the same as the information returned by [Get space](#api-space-spaceKey-get).  In addition, the following comment-specific expansions can be used: - `extensions.inlineProperties` returns inline comment-specific properties. - `extensions.resolution` returns the resolution status of each comment.
    String cursor = "cursor_example"; // String | Pointer to a set of search results, returned as part of the `next` or `prev` URL from the previous search call.
    Integer limit = 25; // Integer | The maximum number of content objects to return per page. Note, this may be restricted by fixed system limits.
    try {
      ContentArray result = apiInstance.searchContentByCQL(cql, cqlcontext, expand, cursor, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContentApi#searchContentByCQL");
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
| **cql** | **String**| The CQL string that is used to find the requested content. | |
| **cqlcontext** | **String**| The space, content, and content status to execute the search against. Specify this as an object with the following properties:  - &#x60;spaceKey&#x60; Key of the space to search against. Optional. - &#x60;contentId&#x60; ID of the content to search against. Optional. Must be in the space spacified by &#x60;spaceKey&#x60;. - &#x60;contentStatuses&#x60; Content statuses to search against. Optional. | [optional] |
| **expand** | [**List&lt;String&gt;**](String.md)| A multi-value parameter indicating which properties of the content to expand.  - &#x60;childTypes.all&#x60; returns whether the content has attachments, comments, or child pages/whiteboards. Use this if you only need to check whether the content has children of a particular type. - &#x60;childTypes.attachment&#x60; returns whether the content has attachments. - &#x60;childTypes.comment&#x60; returns whether the content has comments. - &#x60;childTypes.page&#x60; returns whether the content has child pages. - &#x60;childTypes.whiteboard&#x60; returns whether the content has child whiteboards. - &#x60;childTypes.database&#x60; returns whether the content has child databases. - &#x60;childTypes.embed&#x60; returns whether the content has child embeds (smartlinks). - &#x60;childTypes.folder&#x60; returns whether the content has child folders. - &#x60;container&#x60; returns the space that the content is in. This is the same as the information returned by [Get space](#api-space-spaceKey-get). - &#x60;metadata.currentuser&#x60; returns information about the current user in relation to the content, including when they last viewed it, modified it, contributed to it, or added it as a favorite. - &#x60;metadata.properties&#x60; returns content properties that have been set via the Confluence REST API. - &#x60;metadata.labels&#x60; returns the labels that have been added to the content. - &#x60;metadata.frontend&#x60; this property is only used by Atlassian. - &#x60;operations&#x60; returns the operations for the content, which are used when setting permissions. - &#x60;children.page&#x60; returns pages that are descendants at the level immediately below the content. - &#x60;children.whiteboard&#x60; returns whiteboards that are descendants at the level immediately below the content. - &#x60;children.database&#x60; returns databases that are descendants at the level immediately below the content. - &#x60;children.embed&#x60; returns embeds (smartlinks) that are descendants at the level immediately below the content. - &#x60;children.folder&#x60; returns folders that are descendants at the level immediately below the content. - &#x60;children.attachment&#x60; returns all attachments for the content. - &#x60;children.comment&#x60; returns all comments on the content. - &#x60;restrictions.read.restrictions.user&#x60; returns the users that have permission to read the content. - &#x60;restrictions.read.restrictions.group&#x60; returns the groups that have permission to read the content. Note that this may return deleted groups, because deleting a group doesn&#39;t remove associated restrictions. - &#x60;restrictions.update.restrictions.user&#x60; returns the users that have permission to update the content. - &#x60;restrictions.update.restrictions.group&#x60; returns the groups that have permission to update the content. Note that this may return deleted groups because deleting a group doesn&#39;t remove associated restrictions. - &#x60;history&#x60; returns the history of the content, including the date it was created. - &#x60;history.lastUpdated&#x60; returns information about the most recent update of the content, including who updated it and when it was updated. - &#x60;history.previousVersion&#x60; returns information about the update prior to the current content update. - &#x60;history.contributors&#x60; returns all of the users who have contributed to the content. - &#x60;history.nextVersion&#x60; returns information about the update after to the current content update. - &#x60;ancestors&#x60; returns the parent content, if the content is a page or whiteboard. - &#x60;body&#x60; returns the body of the content in different formats, including the editor format, view format, and export format. - &#x60;body.storage&#x60; returns the body of content in storage format. - &#x60;body.view&#x60; returns the body of content in view format. - &#x60;version&#x60; returns information about the most recent update of the content, including who updated it and when it was updated. - &#x60;descendants.page&#x60; returns pages that are descendants at any level below the content. - &#x60;descendants.whiteboard&#x60; returns whiteboards that are descendants at any level below the content. - &#x60;descendants.database&#x60; returns databases that are descendants at any level below the content. - &#x60;descendants.embed&#x60; returns embeds (smartlinks) that are descendants at any level below the content. - &#x60;descendants.folder&#x60; returns folders that are descendants at any level below the content. - &#x60;descendants.attachment&#x60; returns all attachments for the content, same as &#x60;children.attachment&#x60;. - &#x60;descendants.comment&#x60; returns all comments on the content, same as &#x60;children.comment&#x60;. - &#x60;space&#x60; returns the space that the content is in. This is the same as the information returned by [Get space](#api-space-spaceKey-get).  In addition, the following comment-specific expansions can be used: - &#x60;extensions.inlineProperties&#x60; returns inline comment-specific properties. - &#x60;extensions.resolution&#x60; returns the resolution status of each comment. | [optional] |
| **cursor** | **String**| Pointer to a set of search results, returned as part of the &#x60;next&#x60; or &#x60;prev&#x60; URL from the previous search call. | [optional] |
| **limit** | **Integer**| The maximum number of content objects to return per page. Note, this may be restricted by fixed system limits. | [optional] [default to 25] |

### Return type

[**ContentArray**](ContentArray.md)

### Authorization

[basicAuth](../README.md#basicAuth), [oAuthDefinitions](../README.md#oAuthDefinitions)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the requested list of content is returned. |  -  |
| **400** | Returned if the CQL is invalid or missing. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing from the request. |  -  |

