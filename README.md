IntentDemo
==========

Demo Description  : Intent object's three aspects test : Action,Category&amp;Data.

Abstract  : Intents and Intent Filters

The official class overview
    An intent is an abstract description of an operation to be performed. It can be used with startActivity to launch an Activity
, broadcastIntent to send it to any interested BroadcastReceiver components, and startService(Intent) or bindService(Intent, Ser-
-viceConnection, int) to communicate with a background Service.
    An Intent called, to say, messages through which three of the core components of an application — activities, services, and b
roadcast receivers — are activated.

## Intent Structure

The primary pieces of information in an intent are:
action -- The general action to be performed, such as ACTION_VIEW, ACTION_EDIT, ACTION_MAIN, etc.
data -- The data to operate on, such as a person record in the contacts database, expressed as a Uri.

In addition to these primary attributes, there are a number of secondary attributes that you can also include with an intent:
category  -- For example, CATEGORY_LAUNCHER means it should appear in the Launcher as a top-level application;
                         CATEGORY_HOME means the home activity, that is the first activity that is displayed when the device boots.
component -- Specifies an explicit name of a component class to use for the intent.
type      -- Specifies an explicit type (a MIME type) of the intent data.
extra     -- A Bundle of Key-value pairs for any additional information.
flags     -- Activity launch-mode.

## Intent Resolution(解析)
Intents can be divided into two groups:
：Explicit intents designate the target component by its name (the component name field, mentioned earlier, has a value set). Since 
component names would generally not be known to developers of other applications, explicit intents are typically used for applica-
-tion-internal messages — such as an activity starting a subordinate service or launching a sister activity.
：Implicit intents do not name a target (the field for the component name is blank). Implicit intents are often used to activate c-
-omponents in other applications.
：Only three aspects of an Intent object are consulted when the object is tested against an intent filter:
action 
data (both URI and data type) 
category
The extras and flags play no part in resolving which component receives an intent.

At final, this demo is main to test intent usages & unusages. This parts include three parts of Action-Test,Category-Test,Data-Test.
Action test  ————————
An <intent-filter> element in the manifest file lists actions as <action> subelements. For example:
<intent-filter . . . >
    <action android:name="com.example.project.SHOW_CURRENT" />
    <action android:name="com.example.project.SHOW_RECENT" />
    <action android:name="com.example.project.SHOW_PENDING" />
    . . .
</intent-filter>
Category test————————
An <intent-filter> element also lists categories as subelements. For example:
<intent-filter . . . >
    <category android:name="android.intent.category.DEFAULT" />
    <category android:name="android.intent.category.BROWSABLE" />
    . . .
</intent-filter>
Data test    ————————
Like the action and categories, the data specification for an intent filter is contained in a subelement. And, as in those cases,
the subelement can appear multiple times, or not at all. For example:
<intent-filter . . . >
    <data android:mimeType="video/mpeg" android:scheme="http" . . . /> 
    <data android:mimeType="audio/mpeg" android:scheme="http" . . . />
    . . .
</intent-filter>
Each <data> element can specify a URI and a data type (MIME media type). There are separate attributes — scheme, host, port, and path — for each part of the URI:
scheme://host:port/path
For example, in the following URI,
content://com.example.project:200/folder/subfolder/etc。

It's over!