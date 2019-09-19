User registers (if user has already registered, you get a error message)
User Logs in
User Creates Wills
User Adds Trusted Contacts
User Logs Out


Additional Functionality
Add/Remove Wills
Add/Remove Trusted Contacts ( can't be null, at least one should be there)

Authentication:

User's registration date is stored
User should authenticate himself/herself every x days
A notification will be issued when required

If the user is not available, he/she can set a field in the app to auto authenticate
for a certain period of time ( perhaps 6 months)

Else the user will assume the person is dead and will enfore lockdown, upon which only 
the selected users will be able to view the selected wills (preset by the user)




PROBLEMS:
I need to authorize the user - add x days to reg date and repeat notificstion every x days
after x days, if user doesn't respond to notifications, increase the frequency


Create a custom event for this above problem:
 --> When Xth day is reached(event), issue notification