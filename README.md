# API Fetcher

## Project Overview
API Fetcher is an Android app built using the MVVM architecture pattern with the recommended architecture components by Google. It aims to fetch and display a list of products from a public API, following best practices and utilizing modern Android development libraries.

## Technology Stack
The app utilizes the following technologies and libraries:

- AndroidX Libraries: Core functionality for Android apps.
- ViewModel: Part of Android Architecture Components, it manages UI-related data.
- LiveData: Android Architecture Components that provides lifecycle-aware observable data.
- Coroutines: A library for managing background threads with simplified code.
- Fragment: AndroidX library for fragment-related operations.
- Hilt: A dependency injection library provided by Google.
- Retrofit: An HTTP client for making network requests.
- Gson: A library for JSON serialization and deserialization.
- Glide: An image loading library for Android.

## Project Structure
The project follows the recommended architecture by Google and divides the codebase into three layers:

- UI: This layer contains the user interface components, including activities, fragments, and layout files. It is responsible for presenting the data to the user and handling user interactions.

- Domain: The domain layer contains the business logic and use cases of the app. It defines the operations that can be performed on the data and interacts with the data layer to retrieve and manipulate the data.

- Data: The data layer handles the data operations, such as fetching data from a network source, performing database operations, and managing local and remote data sources.

  ![Project Structure](https://miro.medium.com/v2/resize:fit:1014/1*XrAHH7288P3o9xtffw61QQ.jpeg)


## App Demo
Click [here](https://streamable.com/ekl9g1) to view a demo of the API Fetcher app in action.

## Installation Guide
Follow these steps to set up and run the app:

1. Clone the repository:
git clone https://github.com/abdbashar/api_fetcher.git


2. Open the project in Android Studio.

3. Build and run the app on an emulator or physical device.

## Public API Used
The app utilizes the public API available at [https://fakestoreapi.com/products](https://fakestoreapi.com/products) to fetch product data. For detailed API documentation, refer to [https://fakestoreapi.com/docs](https://fakestoreapi.com/docs).

## Contributing
Contributions to API Fetcher are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

## License
This project is licensed under the [MIT License](LICENSE).
