

# ContentBlueprintDraft


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**version** | **ContentBlueprintDraftVersion** |  |  |
|**title** | **String** | The title of the content. If you don&#39;t want to change the title, set this to the current title of the draft. |  |
|**type** | [**TypeEnum**](#TypeEnum) | The type of content. Set this to &#x60;page&#x60;. |  |
|**status** | [**StatusEnum**](#StatusEnum) | The status of the content. Set this to &#x60;current&#x60; or omit it altogether. |  [optional] |
|**space** | **ContentBlueprintDraftSpace** |  |  [optional] |
|**ancestors** | [**List&lt;ContentBlueprintDraftAncestorsInner&gt;**](ContentBlueprintDraftAncestorsInner.md) | The new ancestor (i.e. parent page) for the content. If you have specified an ancestor, you must also specify a &#x60;space&#x60; property in the request body for the space that the ancestor is in.  Note, if you specify more than one ancestor, the last ID in the array will be selected as the parent page for the content. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| PAGE | &quot;page&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| CURRENT | &quot;current&quot; |



