# Usage

## Overview

- DI integration: `app.di.datasource.ProvidesPagingSource`
- Data source: `app.datasource.paging.AppPagingSource`
- UI component: `shared.design.component.AppPagingList`

The integration includes an `AppPagingSource` class located in `app.datasource.paging` to facilitate working with the Paging Library.

## Example

This example utilizes `BasicPagingSource` to retrieve data from an in-memory list and load it using a `Pager` configured with the assistance of `AppPagingSource`.
The example is part of showcases provided when the feature is included into the app.

```kotlin
class BasicPagingViewModel(
    private val pagingSource: AppPagingSource = get()
) : BaseViewModel() {

    val itemsFlow by lazy {
        val pager = pagingSource.getPager { BasicPagingSource() }
        pager.flow.cachedIn(viewModelScope)
    }

}

@Composable
fun BasicPagingScreen() {
    val viewModel: BasicPagingViewModel = provideViewModel()
    val items = viewModel.itemsFlow.collectAsLazyPagingItems()
    AppPagingList(
        items = items,
        itemContent = {
            ItemBlock(item = it)
        }
    )
}

@Composable
private fun ItemBlock(item: String?) {
    AppText(text = item.orEmpty())
}

class BasicPagingSource(private val loadDelay: Long = 1000) : PagingSource<Int, String>() {

    private val allItems = (1..300).map { "Item-$it" }

    override fun getRefreshKey(state: PagingState<Int, String>): Int? = null

    override suspend fun load(params: PagingSourceLoadParams<Int>): PagingSourceLoadResult<Int, String> {
        val offset = params.key ?: 0
        val pageSize = params.loadSize
        val items = allItems.drop(offset).take(pageSize)
        delay(loadDelay)
        return PagingSourceLoadResultPage(
            data = items,
            prevKey = (offset - pageSize).takeIf { it >= 0 },
            nextKey = (offset + items.size).takeIf { it != offset }
        ) as PagingSourceLoadResult<Int, String>
    }
}
```
