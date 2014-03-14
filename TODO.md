#Simple path
1. Create URL
2. Get first page
3. Get `<li>` elements inside `<ul class="listProperties">`
4. Extract information from each element
5. If page has `<a>` element with `class="next"` go to next page
6. Repeat from step `3`
7. Else compile all information collected

#Alternative path
1. Create URL with 1 element
2. Access URL and collect total results number
3. Replace `resultsPerPage` value (initially 1) for the totalResultsNumber
4. Get `<li>` elements inside `<ul class="listProperties">`
5. Extract information from each element
6. Compile all information collected

#Cool stuff
- User interface (AngularJS)
- Send by e-mail
- Schedule job