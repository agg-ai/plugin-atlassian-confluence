

# SpacePermissionCreate

This object represents a permission for given space. Permissions consist of at least one operation object with an accompanying subjects object.  The following combinations of `operation` and `targetType` values are valid for the `operation` object:    - 'create': 'page', 'blogpost', 'comment', 'attachment'   - 'read': 'space'   - 'delete': 'page', 'blogpost', 'comment', 'attachment'   - 'export': 'space'   - 'administer': 'space'

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**subjects** | [**SpacePermissionCreateSubjects**](SpacePermissionCreateSubjects.md) |  |  [optional] |
|**operation** | [**OperationCheckResult**](OperationCheckResult.md) |  |  |
|**anonymousAccess** | **Boolean** | Grant anonymous users permission to use the operation. |  |
|**unlicensedAccess** | **Boolean** | Grants access to unlicensed users from JIRA Service Desk when used with the &#39;read space&#39; operation. |  |



