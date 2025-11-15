

# AddContentRestrictionRestrictions

The users/groups that the restrictions will be applied to. At least one of `user` or `group` must be specified for this object.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**user** | [**List&lt;AddContentRestrictionRestrictionsUserInner&gt;**](AddContentRestrictionRestrictionsUserInner.md) | The users that the restrictions will be applied to. This array must have at least one item, otherwise it should be omitted. |  [optional] |
|**group** | [**List&lt;AddContentRestrictionRestrictionsGroupInner&gt;**](AddContentRestrictionRestrictionsGroupInner.md) | The groups that the restrictions will be applied to. This array must have at least one item, otherwise it should be omitted. |  [optional] |



