# Colorful

## Screenshots
![Image](screenshots/art1.png)![Image](screenshots/art2.png)

## Installation


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
Colorful has a inbuilt color chooser dialog that will return a `ThemeColor` object you can pass directly to Cluttr
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

       
