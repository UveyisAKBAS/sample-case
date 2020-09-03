# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-printusage removed-usage.txt
-printconfiguration full-r8-config.txt

-keep class * extends com.example.samplecase.domain.base.model.BaseItem {*;}
-keep,allowobfuscation class * extends com.example.samplecase.data.base.model.BaseResponse {*;}
-keep,allowobfuscation class com.example.samplecase.data.report.local.model.* {*;}
