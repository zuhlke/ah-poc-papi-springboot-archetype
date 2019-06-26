# ActivateCreditCard

### The mobile banking team has requested an API for activating a credit card.

- They want a `POST` resource `/activate-credit-card`.

- They will pass json in the format for example `{"credit-card-number": "1234 5678 9101 1213"}` in the request body (including the
  spaces between the numbers).

- They need you to send a `POST` request with the last 5 digits of the card in the request body to a backend API that hasn't even
  been written yet!
  - They know that the request url will be `http://bank.apis.creditcardactivation/lastfive` and that the json
    format you will need to provide in the request body will be for example `{"lastfive": "11213"}`.
  - The response from this backend service will be json in the format for example `{"activation-token": "YFam2FvBp9gt"}` and
    some 2XX status code.
  - Having got this token, you need to return it back to your client in a response with a json response body of the format for
    example `{"token": "ACTIVATION-YFam2FvBp9gt"}`. The status code you return should be 201.

### Here is an example of how it should work.

1. Mobile banking app calls your API: `POST /activate-credit-card {"credit-card-number": "1234 5678 9101 1213"}`

2. You call the backend API `POST http://bank.apis.creditcardactivation/lastfive {"lastfive": "11213"}`

3. The backend API responds to you with json response body `{"activation-token": "YFam2FvBp9gt"}`

4. You respond to the mobile banking app with response code 201 and jsonresponse body `{"token": "ACTIVATION-YFam2FvBp9gt"}`

### The mobile banking team is very picky

- They have requested that you produce a demonstrative automated test suite within this project to show that your API does what they
  need it to do.

### Fortunately, the PAPI team has built a template for just this kind of thing

- This repository (other than this README) has been auto-generated using a tool called maven archetypes. The PAPI team has designed
  this template to make it as easy as possible for you to deliver this API for the mobile team as quickly as possible.

- The PAPI team would love your feedback on your experience using this template. In fact, Rob will probably do some UX research by
  watching the way you interact with this product.