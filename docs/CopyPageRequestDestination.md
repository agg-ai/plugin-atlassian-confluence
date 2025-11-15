

# CopyPageRequestDestination

Defines where the page will be copied to, and can be one of the following types.    - `parent_page`: page will be copied as a child of the specified parent page   - `parent_content`: page will be copied as a child of the specified parent content   - `space`: page will be copied to the specified space as a root page on the space   - `existing_page`: page will be copied and replace the specified page

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) |  |  |
|**value** | **String** | The space key for &#x60;space&#x60; type, and content id for &#x60;parent_page&#x60;, &#x60;parent_content&#x60;, and &#x60;existing_page&#x60; |  |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| SPACE | &quot;space&quot; |
| EXISTING_PAGE | &quot;existing_page&quot; |
| PARENT_PAGE | &quot;parent_page&quot; |
| PARENT_CONTENT | &quot;parent_content&quot; |



