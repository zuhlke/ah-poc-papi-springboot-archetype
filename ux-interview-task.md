# ActivateCreditCard

### The mobile banking team has requested a HTTP REST API for activating a credit card.

- They want a `POST` resource at the url path `/activate-credit-card`.

- They will pass json in the format like `{"credit-card-number": "1234 5678 9101 1213"}` in the request body (including the
  spaces between the numbers).

- They need you to send a `POST` request with the last 5 digits of the card in the request body to a backend API that hasn't even
  been written yet!
  - They know that the request url will be `http://bank.apis.creditcardactivation/lastfive` and that the json
    format you will need to provide in the request body will be like `{"lastfive": "11213"}`.
  - The response from this backend service will be json in a format like `{"activation-token": "YFam2FvBp9gt"}` and
    status code 200.
  - Having got this token, you need to prepend the string "ACTIVATION" and return it back to your client in a response with a response
    body of json format like `{"token": "ACTIVATION-YFam2FvBp9gt"}`. The status code you return should be 201.

### Here is an example of how it should work.

1. The mobile API calls your API: `POST /activate-credit-card` with request body `{"credit-card-number": "1234 5678 9101 1213"}`

2. You call the backend API: `POST http://bank.apis.creditcardactivation/lastfive` with request body `{"lastfive": "11213"}`

3. The backend API responds to you: Response body `{"activation-token": "YFam2FvBp9gt"}` with status code 200

4. You respond to the mobile API: Response body `{"token": "ACTIVATION-YFam2FvBp9gt"}` with status code 201

### The mobile banking team is very picky

- They have requested that you produce a demonstrative automated test suite within this project to show that your API does what they
  need it to do.

### Fortunately, the DS Domain API Reference Team has built a template for just this kind of thing!

- This repository (other than this README) has been auto-generated using a tool called maven archetypes. The PAPI team has designed
  this template to make it as easy as possible for you to deliver this API for the mobile team as quickly as possible.
  
### Exercise notes

- **You are not being tested.** **This template is being tested.** You are facilitating that test, thank you for your help!

- You should consider this to be your API. You own all of the code here and in this scenario you're responsible for getting it
  working by any means.

- This is an experiment about how developers use this product 'in the wild'. It is good and expected that you'll want to use a number
  of tools, so use them!
  - Google
  - Stackoverflow
  - The internet generally
  - All the files in this repository
  - Anything else on your laptop or phone
