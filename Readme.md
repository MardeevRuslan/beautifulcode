# Bracket Checker Application

This application checks if the brackets in a given text are balanced and if there is text inside brackets.

## Deployment Instructions

1. Clone the repository:
  shell git clone https://github.com/MardeevRuslan/beautifulcode
2. Navigate to the project directory: 
  shell cd beautifulcode
3. Build the application: 
  The application will start running on `http://localhost:8080`.


   

## API Endpoint

The application exposes a single API endpoint for checking brackets:

- URL: `http://localhost:8080/api/checkBrackets`
- Method: POST
- Body: JSON object with the following structure:
  json { "text": "Text to check" }

Replace `"Text to check"` with the actual text you want to check.

- Response: JSON object with the following structure: json { "isCorrect": true }

The `isCorrect` field will be `true` if the brackets are balanced and there is text inside brackets, or `false` otherwise.

## Request Example

You can use cURL to send a POST request to the API endpoint of the bracket checker application.

```shell curl -X POST -H "Content-Type: application/json" -d '{"text": "Example text"}' http://localhost:8080/api/checkBrackets ```
## License

This project is licensed under the [MIT License](LICENSE). Please refer to the [official MIT website](https://opensource.org/licenses/MIT) for more information about the rights and limitations of this license.