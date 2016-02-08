Instructions and tips on how to start using PUMa.

# Introduction #

Initial Instructions for using PUMa

# Details #

1. PUMa has to be running in the background all the time. So, when you open the app, to    test, click on either the “Call” button or “Menu” button and place your calls.

2. The user will see a blank Call log list and Bookmark list initially. The database need to be populated by placing calls.

3. If you are using an emulator to test PUMa, you can pass GPS values through the emulator control in DDMS.

4. Also, check to see if the “getgpscoords” service is running. This can be done by following this path,

Menu -> Options -> Applications -> Running Services.

The “getgpscoords” service is running continuously in the background to retrieve the GPS coordinates as and when a call is placed or received using Broadcast Receivers. The GPS has to be ON at all times because it takes an average of 20-30 seconds for the GPS hardware to get a fix from the satellites. This will not let the user collect real time data.

5. The “Viewmap” functionality in the Bookmarks section has the added feature of showing saved locations and their user groups visually. The following are the color codes for the placemarks on the map,

Blue 		-> 	Family

Green 		->	Friends

Red 		->	Work

Yellow		->	Others