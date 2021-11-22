SpinnerHUD
==========

A HUD library for Android.

Inspired by [Kaopiz/KProgressHUD](https://github.com/Kaopiz/KProgressHUD)

## Compatibility

Android8(API level 26) or later.

## Gradle

Add this repository definition to settigs.gradle or build.gradle.

```groovy
    repositories {
        // Add this definition
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/suer/SpinnerHUD")
            credentials {
                username = project.findProperty("gpr.user") ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") ?: System.getenv("TOKEN") ?: ""
            }
        }
    }
```

Add package to app level build.gradle.

```groovy
    implementation 'org.codefirst.spinnerhud:spinner-hud:0.1.0-SNAPSHOT'
```

## Usage

```kotlin
// show HUD
val hud = SpinnerHUD.create(context)
              .setLabel("Loading.....")
              .show()

// dissmiss HUD
hud.dismiss()
```
