

# PermissionCheckResponse

This object represents the response for the content permission check API. If the user or group does not have permissions, the following errors may be returned:  - Group does not have permission to the space - Group does not have permission to the content - User is not allowed to use Confluence - User does not have permission to the space - User does not have permission to the content - Anonymous users are not allowed to use Confluence - Anonymous user does not have permission to the space - Anonymous user does not have permission to the content

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**hasPermission** | **Boolean** |  |  |
|**errors** | **List&lt;Message&gt;** |  |  [optional] |
|**links** | [**Map&lt;String, GenericLinksValue&gt;**](GenericLinksValue.md) |  |  [optional] |



