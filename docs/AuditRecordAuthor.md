

# AuditRecordAuthor


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) |  |  |
|**displayName** | **String** |  |  |
|**operations** | [**List&lt;OperationCheckResult&gt;**](OperationCheckResult.md) |  |  [optional] |
|**username** | **String** | This property is no longer available and will be removed from the documentation soon. Use &#x60;accountId&#x60; instead. See the [deprecation notice](/cloud/confluence/deprecation-notice-user-privacy-api-migration-guide/) for details. |  [optional] |
|**userKey** | **String** | This property is no longer available and will be removed from the documentation soon. Use &#x60;accountId&#x60; instead. See the [deprecation notice](/cloud/confluence/deprecation-notice-user-privacy-api-migration-guide/) for details. |  [optional] |
|**accountId** | **String** | The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, &#x60;384093:32b4d9w0-f6a5-3535-11a3-9c8c88d10192&#x60;. |  [optional] |
|**accountType** | **String** |  |  [optional] |
|**externalCollaborator** | **Boolean** | This is deprecated. Use &#x60;isGuest&#x60; instead. |  [optional] |
|**isExternalCollaborator** | **Boolean** | This is deprecated. Use &#x60;isGuest&#x60; instead. Whether the user is an external collaborator user |  [optional] |
|**isGuest** | **Boolean** | Whether the user is a guest user |  [optional] |
|**publicName** | **String** | The public name or nickname of the user. Will always contain a value. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| USER | &quot;user&quot; |



