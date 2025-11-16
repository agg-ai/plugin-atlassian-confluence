package io.kestra.plugin.atlassian_confluence.pages;

import io.kestra.core.models.annotations.Example;
import io.kestra.core.models.annotations.Plugin;
import io.kestra.core.models.property.Property;
import io.kestra.core.models.tasks.RunnableTask;
import io.kestra.core.runners.RunContext;
import io.kestra.plugin.atlassian_confluence.AbstractTask;
import io.kestra.plugin.atlassian_confluence.client.api.ContentApi;
import io.kestra.plugin.atlassian_confluence.client.model.ContentArray;
import io.kestra.plugin.atlassian_confluence.helpers.PropertyHelper;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@ToString
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Plugin(examples = @Example(full = true, code = """
            id: atlassian_confluence_search_content_by_cql
            namespace: io.kestra.plugin.atlassian_confluence.pages

            tasks:
              - id: search_content
                type: io.kestra.plugin.atlassian_confluence.pages.SearchContentByCQL
                cql: "type = page AND space = TEST"
                limit: 25
        """))
@Schema(title = "Search for content in Confluence using CQL.")
public class SearchContentByCQL extends AbstractTask implements RunnableTask<ContentArray> {
    @Schema(title = "CQL query", description = "The CQL string that is used to find the requested content.")
    @NotNull
    protected Property<String> cql;

    @Schema(title = "CQL context", description = "The space, content, and content status to execute the search against. Specify this as an object with the following properties:  - `spaceKey` Key of the space to search against. Optional. - `contentId` ID of the content to search against. Optional. Must be in the space spacified by `spaceKey`. - `contentStatuses` Content statuses to search against. Optional.")
    protected Property<String> cqlContext;

    @Schema(title = "Expand", description = "A multi-value parameter indicating which properties of the content to expand.  - `childTypes.all` returns whether the content has attachments, comments, or child pages/whiteboards. Use this if you only need to check whether the content has children of a particular type. - `childTypes.attachment` returns whether the content has attachments. - `childTypes.comment` returns whether the content has comments. - `childTypes.page` returns whether the content has child pages. - `childTypes.whiteboard` returns whether the content has child whiteboards. - `childTypes.database` returns whether the content has child databases. - `childTypes.embed` returns whether the content has child embeds (smartlinks). - `childTypes.folder` returns whether the content has child folders. - `container` returns the space that the content is in. This is the same as the information returned by [Get space](#api-space-spaceKey-get). - `metadata.currentuser` returns information about the current user in relation to the content, including when they last viewed it, modified it, contributed to it, or added it as a favorite. - `metadata.properties` returns content properties that have been set via the Confluence REST API. - `metadata.labels` returns the labels that have been added to the content. - `metadata.frontend` this property is only used by Atlassian. - `operations` returns the operations for the content, which are used when setting permissions. - `children.page` returns pages that are descendants at the level immediately below the content. - `children.whiteboard` returns whiteboards that are descendants at the level immediately below the content. - `children.database` returns databases that are descendants at the level immediately below the content. - `children.embed` returns embeds (smartlinks) that are descendants at the level immediately below the content. - `children.folder` returns folders that are descendants at the level immediately below the content. - `children.attachment` returns all attachments for the content. - `children.comment` returns all comments on the content. - `restrictions.read.restrictions.user` returns the users that have permission to read the content. - `restrictions.read.restrictions.group` returns the groups that have permission to read the content. Note that this may return deleted groups, because deleting a group doesn't remove associated restrictions. - `restrictions.update.restrictions.user` returns the users that have permission to update the content. - `restrictions.update.restrictions.group` returns the groups that have permission to update the content. Note that this may return deleted groups because deleting a group doesn't remove associated restrictions. - `history` returns the history of the content, including the date it was created. - `history.lastUpdated` returns information about the most recent update of the content, including who updated it and when it was updated. - `history.previousVersion` returns information about the update prior to the current content update. - `history.contributors` returns all of the users who have contributed to the content. - `history.nextVersion` returns information about the update after to the current content update. - `ancestors` returns the parent content, if the content is a page or whiteboard. - `body` returns the body of the content in different formats, including the editor format, view format, and export format. - `body.storage` returns the body of content in storage format. - `body.view` returns the body of content in view format. - `version` returns information about the most recent update of the content, including who updated it and when it was updated. - `descendants.page` returns pages that are descendants at any level below the content. - `descendants.whiteboard` returns whiteboards that are descendants at any level below the content. - `descendants.database` returns databases that are descendants at any level below the content. - `descendants.embed` returns embeds (smartlinks) that are descendants at any level below the content. - `descendants.folder` returns folders that are descendants at any level below the content. - `descendants.attachment` returns all attachments for the content, same as `children.attachment`. - `descendants.comment` returns all comments on the content, same as `children.comment`. - `space` returns the space that the content is in. This is the same as the information returned by [Get space](#api-space-spaceKey-get).  In addition, the following comment-specific expansions can be used: - `extensions.inlineProperties` returns inline comment-specific properties. - `extensions.resolution` returns the resolution status of each comment.")
    protected Property<List<String>> expand;

    @Schema(title = "Cursor", description = "Pointer to a set of search results, returned as part of the `next` or `prev` URL from the previous search call.")
    protected Property<String> cursor;

    @Schema(title = "Limit", description = "The maximum number of content objects to return per page. Note, this may be restricted by fixed system limits.")
    protected Property<Integer> limit;

    @Override
    public ContentArray run(RunContext runContext) throws Exception {
        var apiClient = getApiClient(runContext);
        var contentApi = new ContentApi(apiClient);

        var renderedCql = runContext.render(this.cql).as(String.class).orElseThrow();
        if (renderedCql == null || renderedCql.isEmpty()) {
            throw new IllegalArgumentException(
                    "Unbounded CQL queries are not allowed here. Please add a search restriction to your query.");
        }

        var renderedCqlContext = PropertyHelper.safeRenderString(runContext, this.cqlContext, null);
        var renderedExpand = PropertyHelper.safeRenderList(runContext, this.expand, null, String.class);
        var renderedCursor = PropertyHelper.safeRenderString(runContext, this.cursor, null);
        var renderedLimit = PropertyHelper.safeRender(runContext, this.limit, 25, Integer.class);

        ContentArray result = contentApi.searchContentByCQL(
                renderedCql,
                renderedCqlContext,
                renderedExpand,
                renderedCursor,
                renderedLimit);

        return result;
    }
}
