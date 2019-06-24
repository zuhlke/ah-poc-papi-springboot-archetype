#set( $H = '#' ) ## Set the variable H to '#', so we can make a '#' with $H
$H ${app-name}

$H$H Why this API exists

The reason this API exists is that `MySmartChannel` wanted to add the functionality to do `SomeSmartChannelThing` and required an
API to integrate with the fulfilment systems to acheive that. This API fulfils this by communicating with `SomeSapi` and `AnotherSapi`
to `DoAUsefulThing`.

$H$H Endpoints provided by this API

- GET /get
    - This returns "This is a GET request!" and status code 200.

- POST /post
    - This returns "This is a POST request!" and status code 200.
    
- GET `/anotherResource`
    - This resource returns `SomeData` and status code `AHttpStatusCode`. If `SomethingBad` happens then it will
      return `AnErrorStatusCode` with a message in the response body about what went wrong.

$H$H If you have an issue with this API

- You can find our operations dashboard at `SomeUrl` which shows `UsefulMetrics`.

- Our first point of contact is `Somebody` whose email address is `Someone@Something.com`. You can also raise an issue.