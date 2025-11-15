

# SpacePermissionV2

This object represents a single space permission. Permissions consist of at least one operation object with an accompanying subjects object.  The following combinations of `operation.key` and `operation.target` values are valid for the `operation` object: ``` bash 'create': 'page', 'blogpost', 'comment', 'attachment' 'read': 'space' 'delete': 'page', 'blogpost', 'comment', 'attachment', 'space' 'export': 'space' 'administer': 'space' 'archive': 'page' 'restrict_content': 'space' ```  For example, to enable Delete Own permission, set the `operation` object to the following: ``` \"operation\": {     \"key\": \"delete\",     \"target\": \"space\" } ``` To enable Add/Delete Restrictions permissions, set the `operation` object to the following: ``` \"operation\": {     \"key\": \"restrict_content\",     \"target\": \"space\" } ```

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **Long** |  |  |
|**subject** | [**PermissionSubject**](PermissionSubject.md) |  |  |
|**operation** | [**SpacePermissionV2Operation**](SpacePermissionV2Operation.md) |  |  |
|**links** | [**Map&lt;String, GenericLinksValue&gt;**](GenericLinksValue.md) |  |  [optional] |



