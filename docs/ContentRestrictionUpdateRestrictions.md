

# ContentRestrictionUpdateRestrictions

The users/groups that the restrictions will be applied to. At least one of `user` or `group` must be specified for this object.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**group** | [**List&lt;ContentRestrictionUpdateRestrictionsGroupInner&gt;**](ContentRestrictionUpdateRestrictionsGroupInner.md) | The groups that the restrictions will be applied to. This array must have at least one item, otherwise it should be omitted. |  [optional] |
|**user** | [**ContentRestrictionUpdateRestrictionsUser**](ContentRestrictionUpdateRestrictionsUser.md) |  |  [optional] |



