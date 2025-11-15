

# ContentBodyCreate

This object is used when creating or updating content.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**value** | **String** | The body of the content in the relevant format. |  |
|**representation** | [**RepresentationEnum**](#RepresentationEnum) | The content format type. Set the value of this property to the name of the format being used, e.g. &#39;storage&#39;. |  |



## Enum: RepresentationEnum

| Name | Value |
|---- | -----|
| VIEW | &quot;view&quot; |
| EXPORT_VIEW | &quot;export_view&quot; |
| STYLED_VIEW | &quot;styled_view&quot; |
| STORAGE | &quot;storage&quot; |
| EDITOR | &quot;editor&quot; |
| EDITOR2 | &quot;editor2&quot; |
| ANONYMOUS_EXPORT_VIEW | &quot;anonymous_export_view&quot; |
| WIKI | &quot;wiki&quot; |
| ATLAS_DOC_FORMAT | &quot;atlas_doc_format&quot; |
| PLAIN | &quot;plain&quot; |
| RAW | &quot;raw&quot; |



