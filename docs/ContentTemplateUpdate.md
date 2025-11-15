

# ContentTemplateUpdate

This object is used to update content templates.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**templateId** | **String** | The ID of the template being updated. |  |
|**name** | **String** | The name of the template. Set to the current &#x60;name&#x60; if this field is not being updated. |  |
|**templateType** | [**TemplateTypeEnum**](#TemplateTypeEnum) | The type of the template. Set to &#x60;page&#x60;. |  |
|**body** | [**ContentTemplateBodyCreate**](ContentTemplateBodyCreate.md) |  |  |
|**description** | **String** | A description of the template. |  [optional] |
|**labels** | [**List&lt;Label&gt;**](Label.md) | Labels for the template. |  [optional] |
|**space** | **ContentTemplateUpdateSpace** |  |  [optional] |



## Enum: TemplateTypeEnum

| Name | Value |
|---- | -----|
| PAGE | &quot;page&quot; |



