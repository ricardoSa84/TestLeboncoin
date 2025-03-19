Test for Leboncoin

This solution was based on a clean architecture, there is only one module because, well the app is very small and only one feature.

related to technology/library choices:
Retrofit -> Easy to use, performant and about 99% of the apps I worked in used it so used to it
Room -> Easy to implement and configure, good performance and the data structure is simple
ViewModel -> Lifecycle aware and ability to perform actions on the background (including finishing actions)
Coroutine flow -> Performant reactive programming ability 
Koin -> Easy to setup and use dependency injection, not truly one but the performance difference to hilt is not that much and also the app is quite small so…
Compose -> No reason to not use Compose :D declarative easy and way better than xml

By the way I also know about gitflow just didn’t see the necessity to use it :D 

•	Things to improve:
Fix the ViewModel unit test
•	Make a second screen for larger picture preview maybe but there is no more detail to load so…
•	Maybe a better-looking UI but for the lack of time I had this is what we get sorry
