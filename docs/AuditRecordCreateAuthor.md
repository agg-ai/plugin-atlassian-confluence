

# AuditRecordCreateAuthor

The user that actioned the event. If `author` is not specified, then all `author` properties will be set to null/empty, except for `type` which will be set to 'user'.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | Set to &#39;user&#39;. |  |
|**displayName** | **String** | The name that is displayed on the audit log in the Confluence UI. |  [optional] |
|**operations** | [**List&lt;OperationCheckResult&gt;**](OperationCheckResult.md) | Always defaults to null. |  [optional] |
|**username** | **String** | This property is no longer available and will be removed from the documentation soon. Use &#x60;accountId&#x60; instead. See the [deprecation notice](/cloud/confluence/deprecation-notice-user-privacy-api-migration-guide/) for details. |  [optional] |
|**userKey** | **String** | This property is no longer available and will be removed from the documentation soon. Use &#x60;accountId&#x60; instead. See the [deprecation notice](/cloud/confluence/deprecation-notice-user-privacy-api-migration-guide/) for details. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| USER | &quot;user&quot; |



