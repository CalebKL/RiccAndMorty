# RiccAndMorty

An android app built using Kotlin that consumes [Rick And Morty API](https://rickandmortyapi.com/documentation) to display list of characters.
It has been built following Architecture Principle, Repository Pattern, MVVM Architecture in the presentation layer as well as jetpack components.
### Prerequisites
The application doesn't require an API Key
### Libraries.

- [Hilt](https://github.com/google/hilt) - Dependency Injection library.
- [Jetpack](https://developer.android.com/jetpack)
    -   [Android KTX](https://developer.android.com/kotlin/ktx.html) - Provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
    - [AndroidX](https://developer.android.com/jetpack/androidx) - Major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
    -   [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
    -   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
    -   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
    - [Room](https://developer.android.com/training/data-storage/room) - Provides an abstraction layer over SQLite used for offline data caching.
    - [Navigation Component](https://developer.android.com/guide/navigation/navigation-getting-started)-Component that allows easier implementation of navigation from simple button clicks to more complex patterns.


- [Retrofit](https://square.github.io/retrofit/) - To make network request.


## 🌚 Screenshots
|   Movies Screen    |  TV Shows Screen    |   Splash Screen   |  SearchScreen |
|---	|---	|---    |---   
| ![movie page](https://user-images.githubusercontent.com/95022986/198876688-2ff49872-45f2-4463-b623-138c07f7493b.jpg)|  ![TVShow](https://user-images.githubusercontent.com/95022986/198876753-a691133a-6488-48c6-b967-045da852009f.jpg)|   ![Splash](https://user-images.githubusercontent.com/95022986/198876845-3cf5842e-9afd-42f9-b9d6-86fee72fb58a.jpg)| ![Search](https://user-images.githubusercontent.com/95022986/198876911-634896bd-5b55-430f-b15b-ac22cfe70a0c.jpg)

## Architecture.

### What is Clean Architecture?

A well planned architecture is extremely important for an app to scale and all architectures have one common goal- to manage complexity of your app. This isn't something to be worried about in smaller apps however it may prove very useful when working on apps with longer development lifecycle and a bigger team.

Clean architecture was proposed by [Robert C. Martin](https://en.wikipedia.org/wiki/Robert_C._Martin) in 2012 in the [Clean Code Blog](http://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) and it follow the SOLID principle.

<p align="center"><img src="screenshots/clean_arch.png" alt="Clean Architecture Diagram"></p>

The circles represent different layers of your app. Note that:

- The center circle is the most abstract, and the outer circle is the most concrete. This is called the [Abstraction Principle](https://en.wikipedia.org/wiki/Abstraction_principle_(computer_programming)). The Abstraction Principle specifies that inner circles should contain business logic, and outer circles should contain implementation details.

- Another principle of Clean Architecture is the [Dependency Inversion](https://en.wikipedia.org/wiki/Dependency_inversion_principle). This rule specifies that each circle can depend only on the nearest inward circle ie. low-level modules do not depend on high-level modules but the other way around.

### Why Clean Architecture?
- Loose coupling between the code - The code can easily be modified without affecting any or a large part of the app's codebase.
- Easier to test code.
- Separation of Concern - Different modules have specific responsibilities making it easier for modification and maintenance.