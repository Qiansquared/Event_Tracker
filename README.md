# Event_Tracker
Before downloading the project to an Android device, a few extra steps need to be taken to make sure the app will successfully run. In the app gradle, it might be necessary to edit the Android debug keystore location. Find the keystore in the Project folder, and locate the directory path of where it is stored. Locate the “storefile File” line in the “signing configs” for “androiddebugkey” at the top of the app gradle. Replace the existing debug.keystore file path with the newly found one, up until “\debug.keystore” (without changing that part).  Make sure to change the “//” to “\” in the address. 
After making sure the project builds, run the app on a new Android phone. Using an emulator or an Android device with too low an API key is insufficient, and will not show the Google Maps interface. These problems should only inhibit the ability to see the map and building markers, and not affect the rest of the app. Older/Low API key Android devices may also cause an unexpected crash when editing and accessing the local database.  
Whenever the app is downloaded on a new phone, the local database will be empty, and no events will appear in the list view. Therefore, start the app by creating events. Begin logging in by clicking the “Login” button on the top left. Try testing different names and passwords in the login page to test authorization. Only admin@bu.edu and “12345” will gain access to the “Manage Events” page. Add an event by clicking the button and inputting the data fields for any event. An event will only be created and placed into the local database if all data fields are filled. Keep in mind that only events that are happening today, and have not ended yet will appear in the app. Additionally, the events are sequentially sorted by their start time. Once an event is successfully added, it will appear in the List View of that specific location, or in the List View for all events happening today. In either list view, clicking on the event title will open up the selected event’s details. To delete an event, log back into the admin account and click the “Delete Event” button. The specific Event ID must be entered when deleting an event, which can be found in the “Event Details” page. 
