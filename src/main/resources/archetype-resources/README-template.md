#set( $H = '#' ) ## Set the variable H to '#', so we can make a '#' with $H
$H ${app-name}

$H$H Why this API exists

The reason this API exists is that `MyPapiConsumer` wanted to add the functionality to do `SomeSmartChannelThing` and required an
API to integrate with the fulfilment systems to acheive that. This API fulfils this by communicating with `SomeSapi` and `AnotherSapi`
to `DoAUsefulThing`.

$H$H Endpoints provided by this API

- GET /some-data
    - This returns "I've got some data!" and status code 200.

- POST /some-data
    - This returns "I've posted some data!" and status code 200.
    
- GET `/another-resource-defined-by-you`
    - This resource returns `SomeData` and status code `AHttpStatusCode`. If `SomethingBad` happens then it will
      return `AnErrorStatusCode` with a message in the response body about what went wrong.

$H$H If you have an issue with this API

- You can find our operations dashboard at `SomeUrl` which shows `UsefulMetrics`.

- Our first point of contact is `Somebody` whose email address is `Someone@Something.com`. You can also raise an issue.