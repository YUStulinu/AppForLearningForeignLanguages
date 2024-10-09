// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}


buildscript {
    extra.apply {
        set("room_version", "2.4.0")
    }
    dependencies {
        classpath("com.google.gms:google-services:4.4.1")
    }
}