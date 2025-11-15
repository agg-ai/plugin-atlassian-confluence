

# PermissionSubject

The user or group that the permission applies to.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) |  |  |
|**identifier** | **String** | for &#x60;type&#x3D;user&#x60;, identifier should be user&#39;s accountId or &#x60;anonymous&#x60; for anonymous users  for &#x60;type&#x3D;group&#x60;, identifier should be the groupId. |  |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| USER | &quot;user&quot; |
| GROUP | &quot;group&quot; |



