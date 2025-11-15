

# ContentUpdateVersion

The new version for the updated content. Set this to the current version number incremented by one, unless you are changing the status to 'draft' which must have a version number of 1.  To get the current version number, use [Get content by ID](#api-content-id-get) and retrieve `version.number`.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**number** | **Integer** | The version number. |  |
|**message** | **String** | An optional message to be stored with the corresponding version. |  [optional] |



