# SampleExternalDataBase
This is a Sample application of Import External DataBase using SQLiteAssetHelper

How create your own external database step by step.

Step 1:
  Create a database my_sample.db using your favorite SQLite database application if not exist database and insert yout data.

Step 2:
  The database can be imported into project either directly as it is, or as a compressed file.
  The compressed file is recommended, if your database is too large in size.
  You can create either a ZIP compression or a GZ compression.
  
Step 3:
  Create a new application
  
Step 4:
  Open the build.gradle (Module: app) file and add the following dependency.
  
  dependencies {
    compile 'com.readystatesoftware.sqliteasset:sqliteassethelper:+'
    }
    
  click on the 'Sync Now' link to update the project
  
Step 5:
  Right click on the app folder and create new assets folder.
  
Step 6:
  Create a new folder 'databases' inside the assets folder.
  
Step 7:
  Copy and paste the  my_database.db file inside the assets/databases folder.
  
Step 8:
  Create a new class 'DatabaseOpenHelper'
  
