Tabby
=====

<p align="center">
    <img src="images/ic_web.png" alt="Web Launcher"/>
</p>
Tabby (Cat), is a simple sample application demoing the features of the new Chrome Custom Tabs support library for Android. Using this application you can demo:

- Coloring the toolbar
- Displaying the title
- Customising the close icon
- Adding an action bar icon
- Adding menu items
- Using custom animations

The application uses Helper Classes from the [example project by Google](https://github.com/GoogleChrome/custom-tabs-client).
<br/>
<br/>

<p align="center">
    <img src="images/device.gif" alt="Web Launcher"/>
</p>

Forked Differences
------------

- Add 2 more buttons to launch the URL in external browser and in-app WebView for comparison purposes
- Display load time for Custom Tabs (after leaving the tab and returning to activity) and when loading WebView (for comparison)
- Change URL to point to GitHub instead of Argos (sorry, not from the UK!)
- Fix issue with `mayLaunchUrl` optimization not being called (due to the bulk of Tabby being based off [ServiceConnectionActivity](https://github.com/GoogleChrome/custom-tabs-client/blob/master/demos/src/main/java/org/chromium/customtabsdemos/ServiceConnectionActivity.java) which has `mayLaunchUrl` as a user button pressed optimization rather than handled automatically)


Requirements
------------

 - [Android SDK](http://developer.android.com/sdk/index.html).
 - Android [5.1 (API 22) ](http://developer.android.com/tools/revisions/platforms.html#5.1).
 - Android SDK Tools
 - Android SDK Build tools 23.0.0.0
 - Android Support Repository
 - Android Support library

Building
--------

To build and install a debug version, run this from the root of the project:

    ./gradlew installDebug

Attributions
------------

Thanks to the following for use of images off of Noun Project:

[Theresa Berens](https://thenounproject.com/theresaberens) - Cat Icon
