## Spring Boot Cart API 

This Spring Boot application provides a RESTful API to interact with cart data, backed by the Fake Store API ([invalid URL removed]).

**Functionality**

# Cart API

This API provides endpoints for interacting with shopping cart data using the FakeStore API.

## Endpoints

* **GET /carts**
   * Description: Retrieves a list of all carts.
   * Response:
      * An array of `Cart` objects. (See the  `Cart` model for structure)

* **GET /carts/{id}**
   * Description: Retrieves a single cart by its ID.
   * Parameters: 
      * `id` (string): The ID of the cart.
   * Response:
      * A single `Cart` object.

* **GET /carts?startdate={start}&enddate={end}**
   * Description: Retrieves carts within a specified date range (assuming the API supports this filtering).
   * Parameters:
      * `start` (string): The start date (e.g., "2023-12-25").
      * `end` (string): The end date (e.g., "2024-01-10").
   * Response:
      * An array of `Cart` objects.

* **GET /carts/users/{id}**
   * Description: Retrieves carts associated with a particular user.
   * Parameters:
      * `id` (string): The ID of the user.
   * Response:
      * An array of `Cart` objects.

* **POST /carts**
   * Description: Creates a new cart.
   * Request Body: 
      * A `Cart` object (JSON format). 
   * Response:
      * The newly created `Cart` object.

* **DELETE /carts/{id}**
   * Description: Deletes a cart by its ID.
   * Parameters:
      * `id` (string): The ID of the cart.
   * Response:
      * Note: The fakestoreapi may or may not truly delete resources. Refer to its documentation. 

* **PUT /cart/{id}**
   * Description: Updates a cart by its ID. 
   * Parameters:
      * `id` (string): The ID of the cart.
   * Request Body:
      * A `Cart` object (JSON format) containing the updated data.
   * Note: For a true RESTful PUT, the entire cart representation should be sent. This implementation might need modification.

**Setup Instructions**

1. **Clone the repository:**
   
   ```bash
   git clone https://github.com/varundeepsaini/FakeStoreAPI.git```
3. Run the application: Using your IDE, run the main Spring Boot application class. Or, build a runnable JAR and run it:
```bash
mvn clean package
java -jar target/spring-boot-cart-api-0.0.1-SNAPSHOT.jar
```
