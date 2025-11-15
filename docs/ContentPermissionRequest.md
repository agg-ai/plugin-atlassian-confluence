

# ContentPermissionRequest

This object represents the request for the content permission check API.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**subject** | [**PermissionSubjectWithGroupId**](PermissionSubjectWithGroupId.md) |  |  |
|**operation** | [**OperationEnum**](#OperationEnum) | The content permission operation to check. |  |



## Enum: OperationEnum

| Name | Value |
|---- | -----|
| READ | &quot;read&quot; |
| UPDATE | &quot;update&quot; |
| DELETE | &quot;delete&quot; |



