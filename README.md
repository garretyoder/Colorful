# Colorful
[![Release](https://jitpack.io/v/garretyoder/Colorful.svg)](https://jitpack.io/#garretyoder/Colorful)


Colorful is a dynamic theme library allowing you to change your apps' color schemes easily.


## License

Colorful is licensed under the Apache 2.0 License

Copyright 2018 Garret Yoder

|                                    |                                    |                                    |
| ---------------------------------- | ---------------------------------- | ---------------------------------- |
| ![Image](screenshots/screen1.png)  | ![Image](screenshots/screen2.png)  | ![Image](screenshots/screen3.png)  |

## Installation
Add jitpack to your maven sources
```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
Add Colorful as a dependency to your `build.gradle`
```groovy
dependencies {
    compile 'com.github.garretyoder:Colorful:1.1'
}
```

## Usage

In your `Application` class, you must initialize Colorful and set the default theme colors.
```kotlin
class SampleApp:Application() {
    override fun onCreate() {
        super.onCreate()
        val defaults:Defaults = Defaults(
                primaryColor = ThemeColor.GREEN,
                accentColor = ThemeColor.BLUE,
                useDarkTheme = false,
                translucent = false)
        initColorful(this, defaults)
    }
}
```
Any `Activity` you wish to be automatically themed must extend from either `CActivity` or `CAppCompatActivity` if you wish to use AppCompat
```kotlin
class MainActivity : CActivity()
```
```kotlin
class MainActivity : CAppCompatActivity()
```
If you wish to use your own activity, you can manually apply Colorful's theme to any activity using `apply(activity:Activity)`
```kotlin
Colorful().apply(activity:Activity)
```
```kotlin
Colorful().apply(activity:Activity,appcompat = true)
```
You can set the colors at any time using the `edit()` method
```kotlin
        Colorful().edit()
                .setPrimaryColor(ThemeColor.RED)
                .setAccentColor(ThemeColor.BLUE)
                .setDarkTheme(true)
                .setTranslucent(true)
                .apply(context:Context)
```
You must call `apply(context:Context)` to save your changes

Colorful will handle saving and loading your theme preferences for you
