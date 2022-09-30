buildscript {

}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.2.2" apply false
    id("com.android.library") version "7.2.2" apply false
    id("org.jetbrains.kotlin.andoid") version "1.5.31" apply false
}

task("clean") {
    delete(rootProject.buildDir)
}



