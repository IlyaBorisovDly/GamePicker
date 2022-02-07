# Game Picker 

## About
Game picker is a game search app developed with RAWG Games API.

## Screenshots

<p float="left">
  <img src="https://github.com/IlyaBorisovDly/GamePicker/blob/master/screenshots/screenshots.png" width="1000"> 
</p>

## Built with
* [Kotlin](https://developer.android.google.cn/kotlin/overview?hl=en) - Programming language officially supported by Google for Android development
* [Coroutines](https://developer.android.google.cn/kotlin/coroutines?hl=en) - A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously
* [Jetpack](https://developer.android.google.cn/jetpack?hl=en) - A suite of libraries to help developers follow best practices, reduce boilerplate code and much more
  * [ViewModel](https://developer.android.google.cn/topic/libraries/architecture/viewmodel?hl=en) - Allows data to survive configuration changes such as screen rotations]
  * [LiveData](https://developer.android.google.cn/topic/libraries/architecture/livedata?hl=en) - Observable lifecycle-aware data holder class
  * [Lifecycle](https://developer.android.google.cn/jetpack/androidx/releases/lifecycle?hl=en) - Lifecycle-aware components perform actions in response to a change in the lifecycle status of another component, such as activities and fragments
  * [ViewBinding](https://developer.android.google.cn/topic/libraries/view-binding?hl=en) - Generates a binding class for each XML layout file present in module for easier access to XML elements
  * [Navigation](https://developer.android.google.cn/guide/navigation?hl=en) - Used to navigate between fragments
* [Retrofit2](https://square.github.io/retrofit/) - A type-safe HTTP client for Android
* [Glide](https://bumptech.github.io/glide/) - Fast and efficient image loading library for Android
* [Facebook Shimmer](https://github.com/facebook/shimmer-android) - Provides an easy way to add a shimmer effect to any view in your Android app

## How to run the app

1. Get your api key [here](https://rawg.io/apidocs?)
2. Download project
3. In local.properties file insert your key like in example below

<p float="left">
  <img src="https://github.com/IlyaBorisovDly/GamePicker/blob/master/screenshots/screenshot_example.png" width="500"> 
</p>


## TODO
- [x] Home screen
- [x] Categories screen
- [ ] Statistics screen
- [ ] Search screen

## License

```
MIT License

Copyright (c) 2022 Ilya Borisov

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
