# Deprecated. 
This solution has pretty old code. Check other one's more up to date.

Hi, this project is my implementation of test assigment. I would like to underline the fact that my main purpose was to create understandable and robust architecture, so UI of an app is quite simple.

## Commits markdown keys description
  -   [Common] - git ignore changes, proguard rules etc
  -   [WIP] - work in progress
  -   [Build] - build.gradle changes, adding Flavors, library updates
  -   [%FeatureName%] - any feature name from traking system
        > [UsersList] - Main list
        
        > [UserDetails] - Details of picked user 
  -   [Bugfix] - Bugfix must have link or atleast bug ID in tracking system

## Architecture
For implementation of task I have chosen MVP + Clean Arch design.
    
## Technologies    
  - Retrofit 2  - API communication 
  - RxJava 2 - Multithreading
  - Dagger 2 - DI
  - ButterKnife - View binding
  - Glide - Images
