

# ContentBlogpost

Representation of a blogpost (content)

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  [optional] |
|**type** | **String** | Can be \&quot;page\&quot;, \&quot;blogpost\&quot;, \&quot;attachment\&quot; or \&quot;content\&quot; |  |
|**status** | **String** |  |  |
|**title** | **String** |  |  [optional] |
|**space** | [**Space**](Space.md) |  |  [optional] |
|**history** | [**ContentHistory**](ContentHistory.md) |  |  [optional] |
|**version** | **Version** |  |  [optional] |
|**ancestors** | **List&lt;Content&gt;** |  |  [optional] |
|**operations** | [**List&lt;OperationCheckResult&gt;**](OperationCheckResult.md) |  |  [optional] |
|**children** | **ContentChildren** |  |  [optional] |
|**childTypes** | **ContentChildType** |  |  [optional] |
|**descendants** | **ContentChildren** |  |  [optional] |
|**container** | **Map&lt;String, Object&gt;** | Container for content. This can be either a space (containing a page or blogpost) or a page/blog post (containing an attachment or comment) |  [optional] |
|**body** | [**ContentBody**](ContentBody.md) |  |  [optional] |
|**restrictions** | [**ContentRestrictions**](ContentRestrictions.md) |  |  [optional] |
|**metadata** | **ContentMetadata** |  |  |
|**macroRenderedOutput** | **Map&lt;String, Object&gt;** |  |  [optional] |
|**extensions** | **Object** |  |  [optional] |
|**expandable** | [**ContentExpandable**](ContentExpandable.md) |  |  [optional] |
|**links** | [**Map&lt;String, GenericLinksValue&gt;**](GenericLinksValue.md) |  |  |



