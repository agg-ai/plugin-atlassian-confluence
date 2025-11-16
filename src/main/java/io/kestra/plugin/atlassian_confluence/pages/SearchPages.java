package io.kestra.plugin.atlassian_confluence.pages;

import io.kestra.core.models.annotations.Example;
import io.kestra.core.models.annotations.Plugin;
import io.kestra.core.models.property.Property;
import io.kestra.core.models.tasks.RunnableTask;
import io.kestra.core.runners.RunContext;
import io.kestra.plugin.atlassian_confluence.AbstractTask;
import io.kestra.plugin.atlassian_confluence.client.api.SearchApi;
import io.kestra.plugin.atlassian_confluence.client.model.SearchPageResponseSearchResult;
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
            id: atlassian_confluence_search_pages
            namespace: io.kestra.plugin.atlassian_confluence.pages

            tasks:
              - id: search_pages
                type: io.kestra.plugin.atlassian_confluence.pages.SearchPages
                cql: "type = page AND space = TEST"
                nextPageToken: null
                maxResults: 50
        """))
@Schema(title = "Search for pages in Confluence using CQL.")
public class SearchPages extends AbstractTask implements RunnableTask<SearchPageResponseSearchResult> {
    @Schema(title = "CQL query to search for pages", description = "The CQL (Confluence Query Language) query to be used for the search. See [Advanced Searching using CQL](https://developer.atlassian.com/cloud/confluence/advanced-searching-using-cql/) for instructions on how to build a CQL query.")
    @NotNull
    protected Property<String> cql;

    @Schema(title = "CQL context", description = "The space, content, and content status to execute the search against. See [Advanced Searching using CQL](https://developer.atlassian.com/cloud/confluence/advanced-searching-using-cql/) for instructions on how to build a CQL context.")
    protected Property<String> cqlContext;

    @Schema(title = "Cursor", description = "Pointer to a set of search results, returned as part of the 'next' or 'prev' URL from the previous search call.")
    protected Property<String> cursor;

    @Schema(title = "Next", description = "Whether to return the next page of results.")
    protected Property<Boolean> next;

    @Schema(title = "Prev", description = "Whether to return the previous page of results.")
    protected Property<Boolean> prev;

    @Schema(title = "Limit", description = "The maximum number of content objects to return per page. Note, this may be restricted by fixed system limits.")
    protected Property<Integer> limit;

    @Schema(title = "Start", description = "The start point of the collection to return.")
    protected Property<Integer> start;

    @Schema(title = "Include archived spaces", description = "Include archived spaces in the results.")
    protected Property<Boolean> includeArchivedSpaces;

    @Schema(title = "Exclude current spaces", description = "Exclude current spaces in the results.")
    protected Property<Boolean> excludeCurrentSpaces;

    @Schema(title = "Excerpt", description = "The excerpt strategy to apply to the result. See [Excerpt strategy](https://developer.atlassian.com/cloud/confluence/advanced-searching-using-cql/#excerpt-strategy) for more details.")
    protected Property<String> excerpt;

    @Schema(title = "Site permission type filter", description = "Filters users by permission type. Use 'none' to default to licensed users, 'externalCollaborator' for external/guest users, and 'all' to include all permission types.")
    protected Property<String> sitePermissionTypeFilter;

    @Schema(title = "Expand", description = "A list of properties to expand. See [Expand](https://developer.atlassian.com/cloud/confluence/advanced-searching-using-cql/#expand) for more details.")
    protected Property<List<String>> expand;

    @Override
    public SearchPageResponseSearchResult run(RunContext runContext) throws Exception {
        var apiClient = getApiClient(runContext);
        var searchApi = new SearchApi(apiClient);

        var renderedCql = runContext.render(this.cql).as(String.class).orElseThrow();
        if (renderedCql == null || renderedCql.isEmpty()) {
            throw new IllegalArgumentException(
                    "Unbounded CQL queries are not allowed here. Please add a search restriction to your query.");
        }

        var renderedCqlContext = PropertyHelper.safeRenderString(runContext, this.cqlContext, null);
        var renderedCursor = PropertyHelper.safeRenderString(runContext, this.cursor, null);
        var renderedNext = runContext.render(this.next).as(Boolean.class).orElse(false);
        var renderedPrev = runContext.render(this.prev).as(Boolean.class).orElse(false);
        var renderedLimit = runContext.render(this.limit).as(Integer.class).orElse(50);
        var renderedStart = runContext.render(this.start).as(Integer.class).orElse(0);
        var renderedIncludeArchivedSpaces = runContext.render(this.includeArchivedSpaces).as(Boolean.class)
                .orElse(false);
        var renderedExcludeCurrentSpaces = runContext.render(this.excludeCurrentSpaces).as(Boolean.class).orElse(false);
        var renderedExcerpt = PropertyHelper.safeRenderString(runContext, this.excerpt, "highlight");
        var renderedSitePermissionTypeFilter = PropertyHelper.safeRenderString(runContext,
                this.sitePermissionTypeFilter, "none");
        var renderedExpand = PropertyHelper.safeRenderList(runContext, this.expand, null, String.class);

        SearchPageResponseSearchResult result = searchApi.searchByCQL(
                renderedCql,
                renderedCqlContext, // cqlcontext
                renderedCursor, // cursor
                renderedNext, // next
                renderedPrev, // prev
                renderedLimit, // limit
                renderedStart, // start
                renderedIncludeArchivedSpaces, // includeArchivedSpaces
                renderedExcludeCurrentSpaces, // excludeCurrentSpaces
                renderedExcerpt, // excerpt
                renderedSitePermissionTypeFilter, // sitePermissionTypeFilter
                null, // u
                renderedExpand // expand
        );

        return result;
    }
}
