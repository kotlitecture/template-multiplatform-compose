package kotli.app.showcases.presentation.userflow.component.markdown

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shared.presentation.ui.component.AppMarkdown
import shared.presentation.ui.container.AppFixedTopBarColumn

@Composable
fun MarkdownScreen(onBack: () -> Unit) {
    AppFixedTopBarColumn(
        title = MarkdownRoute.screen.label,
        onBack = onBack,
        content = {
            AppMarkdown(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                text = """
                    # h1 Heading 8-)
                    ## h2 Heading
                    ### h3 Heading
                    #### h4 Heading
                    ##### h5 Heading
                    ###### h6 Heading
                    
                    Alternatively, for H1 and H2, an underline-ish style:
                    
                    Alt-H1
                    ======
                    
                    Alt-H2
                    ------
                    
                    Emphasis, aka italics, with *asterisks* or _underscores_.

                    Strong emphasis, aka bold, with **asterisks** or __underscores__.

                    Combined emphasis with **asterisks and _underscores_**.

                    Strikethrough uses two tildes. ~~Scratch this.~~

                    **This is bold text**

                    __This is bold text__

                    *This is italic text*

                    _This is italic text_

                    ~~Strikethrough~~
                    
                    1. First ordered list item
                    2. Another item
                    ⋅⋅* Unordered sub-list.
                    1. Actual numbers don't matter, just that it's a number
                    ⋅⋅1. Ordered sub-list
                    4. And another item.

                    ⋅⋅⋅You can have properly indented paragraphs within list items. Notice the blank line above, and the leading spaces (at least one, but we'll use three here to also align the raw Markdown).

                    ⋅⋅⋅To have a line break without a paragraph, you will need to use two trailing spaces.⋅⋅
                    ⋅⋅⋅Note that this line is separate, but within the same paragraph.⋅⋅
                    ⋅⋅⋅(This is contrary to the typical GFM line break behaviour, where trailing spaces are not required.)

                    * Unordered list can use asterisks
                    - Or minuses
                    + Or pluses

                    1. Make my changes
                        1. Fix bug
                        2. Improve formatting
                            - Make the headings bigger
                    2. Push my commits to GitHub
                    3. Open a pull request
                        * Describe my changes
                        * Mention all the members of my team
                            * Ask for feedback

                    + Create a list by starting a line with `+`, `-`, or `*`
                    + Sub-lists are made by indenting 2 spaces:
                      - Marker character change forces new list start:
                        * Ac tristique libero volutpat at
                        + Facilisis in pretium nisl aliquet
                        - Nulla volutpat aliquam velit
                    + Very easy!
                    
                    - [x] Finish my changes
                    - [ ] Push my commits to GitHub
                    - [ ] Open a pull request
                    - [x] @mentions, #refs, [links](), **formatting**, and <del>tags</del> supported
                    - [x] list syntax required (any unordered or ordered list supported)
                    - [x] this is a complete item
                    - [ ] this is an incomplete item
                    
                    [I'm an inline-style link](https://www.google.com)

                    [I'm an inline-style link with title](https://www.google.com "Google's Homepage")

                    [I'm a reference-style link][Arbitrary case-insensitive reference text]

                    [I'm a relative reference to a repository file](../blob/master/LICENSE)

                    [You can use numbers for reference-style link definitions][1]

                    Or leave it empty and use the [link text itself].

                    URLs and URLs in angle brackets will automatically get turned into links.
                    http://www.example.com or <http://www.example.com> and sometimes
                    example.com (but not on Github, for example).

                    Some text to show that the reference links can follow later.

                    [arbitrary case-insensitive reference text]: https://www.mozilla.org
                    [1]: http://slashdot.org
                    [link text itself]: http://www.reddit.com
                    
                    Here's our logo (hover to see the title text):

                    Inline-style:
                    ![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Logo Title Text 1")

                    Reference-style:
                    ![alt text][logo]

                    [logo]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Logo Title Text 2"

                    ![Minion](https://octodex.github.com/images/minion.png)
                    ![Stormtroopocat](https://octodex.github.com/images/stormtroopocat.jpg "The Stormtroopocat")
                """.trimIndent()
            )
        }
    )
}