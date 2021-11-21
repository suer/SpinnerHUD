SpinnerHUD
==========

A HUD library for Android.

Inspired by [Kaopiz/KProgressHUD](https://github.com/Kaopiz/KProgressHUD)

## Compatibility

Android8(API level 26) or later.

## Gradle

TODO:

## Usage

```kotlin
// show HUD
val hud = SpinnerHUD.create(context)
              .setLabel("Loading.....")
              .show()

// dissmiss HUD
hud.dismiss()
```
