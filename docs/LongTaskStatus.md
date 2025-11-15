

# LongTaskStatus

Current status of a long running task  Status keys:  - `ERROR_UNKNOWN` - Generic error - `ERROR_LOCK_FAILED` - Could not get the lock on destination space - `ERROR_RELINK` - Error when relink pages/attachments - `ERROR_COPY_PAGE` - Error while copying 1 page - `WARN_RENAME_PAGE` - Warning page is rename during copy - `WARN_IGNORE_COPY_PERMISSION` - Warning could not copy permission - `WARN_IGNORE_COPY_ATTACHMENT` - Warning could not copy attachment - `WARN_IGNORE_DELETE_PAGE` - Warning ignoring delete of a non agreed on page - `STATUS_COPIED_PAGES` - Message total pages are copied - `STATUS_COPYING_PAGES` - Message copy pages - `STATUS_RELINK_PAGES` - Message relink pages/attachments - `STATUS_DELETING_PAGES` - Message delete pages - `STATUS_DELETED_PAGES` - Message total pages are deleted - `STATUS_MOVING_PAGES` - Message move pages - `WARN_IGNORE_VIEW_RESTRICTED` - Permission changed - view restricted - `WARN_IGNORE_EDIT_RESTRICTED` - Permission changed - edit restricted - `INITIALIZING_TASK` - Message when initializing task - `UNKNOWN_STATUS` - Message when status is unknown

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**ari** | **String** | the ARI for the long task, based on its ID |  [optional] |
|**id** | **String** |  |  |
|**name** | [**LongTaskStatusName**](LongTaskStatusName.md) |  |  |
|**elapsedTime** | **Long** |  |  |
|**percentageComplete** | **Integer** |  |  |
|**successful** | **Boolean** |  |  |
|**finished** | **Boolean** |  |  |
|**messages** | **List&lt;Message&gt;** |  |  |
|**status** | **String** |  |  [optional] |
|**errors** | **List&lt;Message&gt;** |  |  [optional] |
|**additionalDetails** | [**LongTaskStatusAdditionalDetails**](LongTaskStatusAdditionalDetails.md) |  |  [optional] |



