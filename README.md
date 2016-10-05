# Colorful
[![Release](https://jitpack.io/v/garretyoder/Colorful.svg)](https://jitpack.io/#garretyoder/Colorful)


Colorful is a dynamic theme library allowing you to change your apps' color schemes easily.


## License

Colorful is licensed under the Apache 2.0 License, in common Android style.

Copyright 2016 Garret Yoder


## Installation
Add jitpack to your maven sources
```
allprojects {
        repositories {
            ...
            maven { url "https://jitpack.io" }
        }
    }
```
Add Colorful as a dependency to your `build.gradle`
```
dependencies {
            compile 'com.github.garretyoder:Colorful:0.7'
    }
```

## Usage

In your `Application class`, you must initialize Colorful
```java
public class SampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Colorful.init(this);
    }
}
```
Any `Activity` you wish to be themed must extend from `CActivity`
```java
public class MainActivity extends CActivity
```

You can set the default theme colors Colorful will use with the `Default` class
```java
public class SampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Colorful.Default.primaryColor(Colorful.ThemeColor.RED);
        Colorful.Default.accentColor(Colorful.ThemeColor.BLUE);
        Colorful.Default.translucent(true);
        Colorful.Default.dark(true);
        Colorful.init(this);
    }
}
```
You can set the colors at any time using the `Config` class
```java
Colorful.Config.primaryColor(Colorful.ThemeColor.DEEP_ORANGE);
Colorful.Config.accentColor(Colorful.ThemeColor.CYAN);
Colorful.Config.translucent(true);
Colorful.Config.dark(false);
```
After which you must call `Colorful.Config.apply(Context);` to save your changes

Colorful will handle saving and loading your theme preferences for you.

## Color Chooser

Colorful has a inbuilt color chooser dialog that will return a `ThemeColor` object you can pass directly to Colorful
```java
public class MainActivity extends CActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(((Toolbar) findViewById(R.id.toolbar)));

        ColorPickerDialog dialog = new ColorPickerDialog(this);
        dialog.setOnColorSelectedListener(new ColorPickerDialog.OnColorSelectedListener() {
            @Override
            public void onColorSelected(Colorful.ThemeColor color) {
                //TODO: Do something with the color
            }
        });
        dialog.show();
    }
}
```


## Screenshots
![Image](screenshots/art1.png)![Image](screenshots/art2.png)
