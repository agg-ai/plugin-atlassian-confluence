

# User


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) |  |  |
|**username** | **String** | This property is no longer available and will be removed from the documentation soon. Use &#x60;accountId&#x60; instead. See the [deprecation notice](/cloud/confluence/deprecation-notice-user-privacy-api-migration-guide/) for details. |  [optional] |
|**userKey** | **String** | This property is no longer available and will be removed from the documentation soon. Use &#x60;accountId&#x60; instead. See the [deprecation notice](/cloud/confluence/deprecation-notice-user-privacy-api-migration-guide/) for details. |  [optional] |
|**accountId** | **String** | The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, &#x60;384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192&#x60;. |  [optional] |
|**accountType** | [**AccountTypeEnum**](#AccountTypeEnum) | The account type of the user, may return empty string if unavailable. App is if the user is a bot user created on behalf of an Atlassian app. |  [optional] |
|**email** | **String** | The email address of the user. Depending on the user&#39;s privacy setting, this may return an empty string. |  [optional] |
|**publicName** | **String** | The public name or nickname of the user. Will always contain a value. |  [optional] |
|**profilePicture** | [**Icon**](Icon.md) |  |  [optional] |
|**displayName** | **String** | The displays name of the user. Depending on the user&#39;s privacy setting, this may be the same as publicName. |  [optional] |
|**timeZone** | **String** | This displays user time zone. Depending on the user&#39;s privacy setting, this may return null. |  [optional] |
|**externalCollaborator** | **Boolean** | This is deprecated. Use &#x60;isGuest&#x60; instead to find out whether the user is a guest user. |  [optional] |
|**isExternalCollaborator** | **Boolean** | This is deprecated. Use &#x60;isGuest&#x60; instead to find out whether the user is a guest user. |  [optional] |
|**isGuest** | **Boolean** | Whether the user is a guest user |  [optional] |
|**operations** | [**List&lt;OperationCheckResult&gt;**](OperationCheckResult.md) |  |  [optional] |
|**details** | [**UserDetails**](UserDetails.md) |  |  [optional] |
|**personalSpace** | [**Space**](Space.md) |  |  [optional] |
|**expandable** | [**BulkUserLookupExpandable**](BulkUserLookupExpandable.md) |  |  [optional] |
|**links** | [**Map&lt;String, GenericLinksValue&gt;**](GenericLinksValue.md) |  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| KNOWN | &quot;known&quot; |
| UNKNOWN | &quot;unknown&quot; |
| ANONYMOUS | &quot;anonymous&quot; |
| USER | &quot;user&quot; |



## Enum: AccountTypeEnum

| Name | Value |
|---- | -----|
| ATLASSIAN | &quot;atlassian&quot; |
| APP | &quot;app&quot; |
| EMPTY | &quot;&quot; |



