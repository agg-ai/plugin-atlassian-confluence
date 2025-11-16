# Top 10 Important Confluence API Client Functions

Based on analysis of the generated Confluence API client, here are the top 10 most important functions for working with pages and content:

## 1. **Search Pages** - `SearchApi.searchByCQL()`
- **Class**: `SearchApi`
- **Method**: `searchByCQL(String cql, ...)`
- **Returns**: `SearchPageResponseSearchResult` (contains `SearchResult` objects)
- **Endpoint**: `/wiki/rest/api/search`
- **Purpose**: General-purpose search with search-specific features
- **Example CQL**: `type=page AND space=TEST`
- **Key Features**: 
  - Search result excerpts with highlighting
  - Filter archived spaces (`includeArchivedSpaces`, `excludeCurrentSpaces`)
  - User permission filtering (`sitePermissionTypeFilter`)
  - Search-specific metadata
  - **Limitation**: Does NOT support user-specific CQL fields (deprecated)

## 2. **Search Content by CQL** - `ContentApi.searchContentByCQL()`
- **Class**: `ContentApi`
- **Method**: `searchContentByCQL(String cql, ...)`
- **Returns**: `ContentArray` (contains full `Content` objects)
- **Endpoint**: `/wiki/rest/api/content/search`
- **Purpose**: Content-focused search that returns full content objects
- **Key Features**:
  - Returns complete `Content` objects (not search results)
  - Full expansion support (`expand` parameter for body, metadata, children, etc.)
  - Better for content manipulation workflows
  - Supports all content expansion options

## 3. **Create Page (Publish Draft)** - `ContentApi.publishSharedDraft()`
- **Class**: `ContentApi`
- **Method**: `publishSharedDraft(String draftId, ContentBlueprintDraft body, ...)`
- **Returns**: `Content`
- **Purpose**: Create a new page by publishing a shared draft
- **Note**: This is the primary method for creating pages in the API

## 4. **Create Page (Publish Legacy Draft)** - `ContentApi.publishLegacyDraft()`
- **Class**: `ContentApi`
- **Method**: `publishLegacyDraft(String draftId, ContentBlueprintDraft body, ...)`
- **Returns**: `Content`
- **Purpose**: Create a page from a legacy draft format
- **Use Case**: For backward compatibility with older draft formats

## 5. **Get Content by ID** - (Likely in ExperimentalApi or via direct REST)
- **Purpose**: Read/retrieve a specific page by its content ID
- **Note**: Standard GET operation on `/wiki/rest/api/content/{id}`
- **Use Case**: Retrieve full page details including body, metadata, version info

## 6. **Update Content** - (Likely in ExperimentalApi or via direct REST)
- **Purpose**: Update an existing page
- **Note**: Standard PUT operation on `/wiki/rest/api/content/{id}`
- **Use Case**: Modify page title, body, status, or other properties

## 7. **Copy Page** - `ContentChildrenAndDescendantsApi.copyPage()`
- **Class**: `ContentChildrenAndDescendantsApi`
- **Method**: `copyPage(String id, CopyPageRequest request, ...)`
- **Returns**: `Content`
- **Purpose**: Copy a page to a new location (same or different space)
- **Features**: Can copy attachments, permissions, labels, properties

## 8. **Get Content Descendants** - `ContentChildrenAndDescendantsApi.getContentDescendants()`
- **Class**: `ContentChildrenAndDescendantsApi`
- **Method**: `getContentDescendants(String id, ...)`
- **Returns**: `ContentChildren`
- **Purpose**: Get all child pages and content under a specific page
- **Use Case**: Navigate page hierarchy, list all pages in a section

## 9. **Get Descendants by Type** - `ContentChildrenAndDescendantsApi.getDescendantsOfType()`
- **Class**: `ContentChildrenAndDescendantsApi`
- **Method**: `getDescendantsOfType(String id, String type, ...)`
- **Returns**: `ContentArray`
- **Purpose**: Get specific type of descendants (pages, attachments, comments, etc.)
- **Use Case**: Filter children by content type

## 10. **Archive Pages** - `ContentApi.archivePages()`
- **Class**: `ContentApi`
- **Method**: `archivePages(ArchivePagesRequest archivePagesRequest)`
- **Returns**: `LongTask`
- **Purpose**: Archive multiple pages in bulk (up to 300 pages)
- **Note**: Returns a long-running task that needs to be polled for completion

---

## Key Differences: SearchApi vs ContentApi Search

### `SearchApi.searchByCQL()` - General Search
**Best for:**
- **User-facing search interfaces** - When building a search page or search widget
- **Quick discovery** - Finding content with highlighted excerpts
- **Search analytics** - Understanding what users are searching for
- **Archived content discovery** - Finding content in archived spaces
- **Permission-aware search** - Filtering by user permission types

**Real-Life Use Cases:**
1. **Building a Confluence search widget** for your company intranet
   - Users type "API documentation" and see highlighted excerpts
   - Shows where the search term appears in the content
   - Displays search result metadata (relevance, last modified)

2. **Content audit tool** - Finding all pages in archived spaces
   - Search across both active and archived spaces
   - Generate reports on content that needs to be migrated
   - Identify content that should be deleted

3. **Compliance search** - Finding content by permission level
   - Search for content accessible to external collaborators
   - Identify publicly accessible content
   - Audit content visibility

**Example:**
```java
// Building a search page for users
SearchPageResponseSearchResult results = searchApi.searchByCQL(
    "type=page AND title~\"API\"",
    null, // cqlcontext
    null, // cursor
    null, // next
    null, // prev
    10,   // limit
    0,    // start
    false, // includeArchivedSpaces
    false, // excludeCurrentSpaces
    "highlight", // excerpt - shows highlighted search terms
    "none", // sitePermissionTypeFilter
    null, // u
    null  // expand
);
// Results contain SearchResult objects with excerpts showing where "API" appears
```

### `ContentApi.searchContentByCQL()` - Content Search
**Best for:**
- **Content management workflows** - When you need to work with actual content
- **Bulk operations** - Updating, archiving, or processing multiple pages
- **Content analysis** - Extracting full content bodies for analysis
- **Integration workflows** - Syncing content to other systems
- **Content migration** - Moving content between spaces

**Real-Life Use Cases:**
1. **Automated content backup system**
   - Search for all pages modified in the last week
   - Get full content objects with body, metadata, attachments
   - Export to backup storage system
   - Process complete content data, not just search snippets

2. **Content migration tool** - Moving pages between spaces
   - Search for all pages in source space
   - Get full `Content` objects with all relationships
   - Copy content including body, labels, properties
   - Need complete content data to recreate pages

3. **Documentation generator** - Creating PDFs from Confluence pages
   - Search for all pages with label "documentation"
   - Get full content with body in storage format
   - Convert to PDF with full formatting
   - Need complete page content, not search excerpts

4. **Content analytics dashboard** - Analyzing content metrics
   - Search for pages by author, date, space
   - Get full content objects with metadata, history, contributors
   - Calculate statistics (word count, update frequency, etc.)
   - Need complete content objects for analysis

**Example:**
```java
// Bulk content processing workflow
ContentArray results = contentApi.searchContentByCQL(
    "type=page AND space=DEV AND lastModified >= \"2024-01-01\"",
    null, // cqlcontext
    Arrays.asList("body.storage", "metadata.labels", "version"), // expand
    null, // cursor
    50    // limit
);
// Results contain full Content objects - can directly update, archive, or process them
for (Content page : results.getResults()) {
    String body = page.getBody().getStorage().getValue();
    // Process full content...
}
```

### Summary Table

| Feature | SearchApi.searchByCQL() | ContentApi.searchContentByCQL() |
|---------|------------------------|--------------------------------|
| **Response Type** | `SearchPageResponseSearchResult` (SearchResult objects) | `ContentArray` (Content objects) |
| **Use Case** | User search, discovery, excerpts | Content management, bulk operations |
| **Excerpts** | ✅ Yes, with highlighting | ❌ No |
| **Full Content** | ❌ No (search metadata only) | ✅ Yes (complete Content objects) |
| **Expansion** | Limited | ✅ Full expansion support |
| **Archived Spaces** | ✅ Yes | ❌ No |
| **Permission Filtering** | ✅ Yes | ❌ No |
| **Best For** | Search UI, discovery | Content processing, workflows |

### When to Use Which?

**Use `SearchApi.searchByCQL()` when:**
- Building a search interface for end users
- You need search result excerpts with highlighting
- Searching archived spaces
- You only need basic content information (title, URL, metadata)
- Building search analytics or reporting tools

**Use `ContentApi.searchContentByCQL()` when:**
- You need to work with full content objects
- Performing bulk operations (update, archive, delete)
- Extracting content bodies for processing
- Building content management workflows
- Migrating or syncing content
- You need expanded content (body, children, metadata, etc.)

---

## Additional Important Functions:

### Space Management:
- **Create Space**: `SpaceApi.createSpace(SpaceCreate body)`
- **Update Space**: `SpaceApi.updateSpace(String spaceKey, SpaceUpdate body)`
- **Get Space**: (Standard GET operation)

### Content Attachments:
- **Create Attachment**: `ContentAttachmentsApi.createAttachment(String id, File file, ...)`
- **Update Attachment**: `ContentAttachmentsApi.updateAttachmentData(...)`

### Content Labels:
- **Add Labels**: Available through `ExperimentalApi` or content update operations

### Content Restrictions:
- **Get Restrictions**: `ContentRestrictionsApi.getRestrictions(String id, ...)`
- **Add Restrictions**: `ContentRestrictionsApi.addRestrictions(String id, ...)`

---

## Notes:
1. The Confluence API uses a draft-based model for creating content - you typically create a draft first, then publish it
2. Most content operations support the `expand` parameter to include related data (body, metadata, children, etc.)
3. Pagination is handled via `start` and `limit` parameters
4. The API uses CQL (Confluence Query Language) for advanced searching
5. Some operations return `LongTask` objects that need to be polled for completion

## Recommended Approach for CRUD Operations:

For **Create Page**:
1. Create a `ContentBlueprintDraft` object with title, body, space, type
2. Use `publishSharedDraft()` or `publishLegacyDraft()` to publish

For **Read Page**:
1. Use `searchByCQL()` with specific content ID: `id=123456`
2. Or use direct GET on `/wiki/rest/api/content/{id}` endpoint

For **Update Page**:
1. Get current content version
2. Create `ContentUpdate` object with incremented version
3. Use PUT operation on `/wiki/rest/api/content/{id}`

For **Delete Page**:
1. Update content status to "trashed" or "deleted"
2. Or use DELETE operation on `/wiki/rest/api/content/{id}`

