7zip-sfx-java
=============

I rarely use Windows, but other folks out there building and shipping Java applications on Windows might find this example useful.

Java is fantastic for its write once, run anywhere methodology.  Only problem is, unlike a native Windows app, you need a JRE to run a Java application.  Most vendors who sell software written in Java tell their end-users (customers) that they need to install a JRE first before they can run the app.  This makes sense, but it's a slight inconvenience &mdash; the Java installer is bulky and cumbersome.  Wouldn't it be nice if you could avoid that forced installation step, and simply ship a supported Java runtime with your Java application?  This way, the user simply double clicks an .exe, a launcher extracts a supported JRE, and starts.  In short, the user doesn't have to install a JRE at all, but rather the JRE they need is simply extracted to a temporary directory and your application starts using that freshly extracted JRE.  Further, when the user exits the application, the temporary JRE directory your app launcher created is automatically cleaned up, and all is well.
