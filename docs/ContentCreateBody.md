

# ContentCreateBody

The body of the new content. Does not apply to attachments. Only one body format should be specified as the property for this object, e.g. `storage`.  Note, `editor2` format is used by Atlassian only. `anonymous_export_view` is the same as `export_view` format but only content viewable by an anonymous user is included.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**view** | **ContentBodyCreate** |  |  [optional] |
|**exportView** | **ContentBodyCreate** |  |  [optional] |
|**styledView** | **ContentBodyCreate** |  |  [optional] |
|**storage** | **ContentBodyCreate** |  |  [optional] |
|**editor** | **ContentBodyCreate** |  |  [optional] |
|**editor2** | **ContentBodyCreate** |  |  [optional] |
|**wiki** | **ContentBodyCreate** |  |  [optional] |
|**anonymousExportView** | **ContentBodyCreate** |  |  [optional] |
|**plain** | **ContentBodyCreate** |  |  [optional] |
|**atlasDocFormat** | **ContentBodyCreate** |  |  [optional] |
|**raw** | **ContentBodyCreate** |  |  [optional] |



