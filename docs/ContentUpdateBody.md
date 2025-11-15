

# ContentUpdateBody

The updated body of the content. Does not apply to attachments. If you are not sure how to generate these formats, you can create a page in the Confluence application, retrieve the content using [Get content](#api-content-get), and expand the desired content format, e.g. `expand=body.storage`.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**view** | **ContentBodyCreate** |  |  [optional] |
|**exportView** | **ContentBodyCreate** |  |  [optional] |
|**styledView** | **ContentBodyCreate** |  |  [optional] |
|**storage** | **ContentBodyCreateStorage** |  |  [optional] |
|**editor** | **ContentBodyCreate** |  |  [optional] |
|**editor2** | **ContentBodyCreate** |  |  [optional] |
|**wiki** | **ContentBodyCreate** |  |  [optional] |
|**atlasDocFormat** | **ContentBodyCreate** |  |  [optional] |
|**anonymousExportView** | **ContentBodyCreate** |  |  [optional] |



