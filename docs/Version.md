

# Version


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**by** | **User** |  |  [optional] |
|**when** | **OffsetDateTime** |  |  |
|**friendlyWhen** | **String** |  |  [optional] |
|**message** | **String** |  |  [optional] |
|**number** | **Integer** | Set this to the current version number incremented by one |  |
|**minorEdit** | **Boolean** | If &#x60;minorEdit&#x60; is set to &#39;true&#39;, no notification email or activity stream will be generated for the change. |  |
|**content** | **Content** |  |  [optional] |
|**collaborators** | **UsersUserKeys** |  |  [optional] |
|**expandable** | [**VersionExpandable**](VersionExpandable.md) |  |  [optional] |
|**links** | [**Map&lt;String, GenericLinksValue&gt;**](GenericLinksValue.md) |  |  [optional] |
|**contentTypeModified** | **Boolean** | True if content type is modifed in this version (e.g. page to blog) |  [optional] |
|**confRev** | **String** | The revision id provided by confluence to be used as a revision in Synchrony |  [optional] |
|**syncRev** | **String** | The revision id provided by Synchrony |  [optional] |
|**syncRevSource** | **String** | Source of the synchrony revision |  [optional] |



