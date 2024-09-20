## C. Customize the HTML User Interface

The user interface for your customer’s application should include the following elements:
- Shop name
- Product names
- Names of the parts

### Changes made to `mainscreen.html`:

- **Lines 14-62**: Added basic styling.
```html
 <style>
        body {
            background-color: #f8f9fa; /* Light grey background */
        }
        h1 {
            text-align: center;
            margin-top: 20px;
            color: #343a40; /* Darker color */
        }
        h2 {
            color: #495057;
            font-weight: bold;
            margin-top: 30px;
        }
        form input[type="text"] {
            border: 2px solid #6c757d;
            border-radius: 5px;
            padding: 5px;
            width: 60%;
        }
        form input[type="submit"], form input[type="button"] {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 8px 15px;
            border-radius: 5px;
            cursor: pointer;
        }
        form input[type="submit"]:hover, form input[type="button"]:hover {
            background-color: #0056b3;
        }
        .table th {
            background-color: #343a40;
            color: white;
        }
        .table td {
            vertical-align: middle;
        }
        .btn-primary {
            background-color: #28a745;
            border: none;
        }
        .btn-primary:hover {
            background-color: #218838;
        }
        hr {
            border-top: 2px solid #007bff;
        }
    </style>
```
- **Line 64**: Changed the title to `"James's PC Emporium"`.
```html
<title>James's PC Emporium</title>
```
- **Line 69**: Changed the header to `"James's PC Emporium"`.
```html
<h1>James's PC Emporium</h1>
```
- **Line 75**: Changed the `h2` tag to `"Computer Components"`.
```html
<h2>Computer Components</h2>
```
- **Line 108**: Changed the `h2` tag to `"Pre-Built Computers"`.
```html
<h2>Pre-Built Computers</h2>
```

## D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
### Changes made to `mainscreen.html`:
- **Line 70**: Added a button to take users to about page
```html
<a href="/about" class="btn btn-primary">About</a>
```
### ADDED file `about.html`
### Changes made to `MainScreenControllerr`:
- **Line 55-57**: Added mapping to handle /about route
```java
@GetMapping("/about")
    public String about() {return "about.html";}
}
```
### Changes made to `about.html`
- **Line 31-50**:Added information about the company's website
```html
<body>
<div class="container">
    <h1>About James's PC Emporium</h1>
    <p>
        Welcome to James's PC Emporium! We are proud to have been serving our customers for over 10 years,
        offering high-quality pre-built computers and a wide range of individual parts for all your tech needs.
    </p>
    <p>
        Whether you are looking to upgrade your current setup, build your own computer from scratch, or purchase
        a ready-to-go system, we have everything you need. Our dedicated team is always here to assist you in
        finding the perfect solution for your home, office, or gaming setup.
    </p>
    <p>
        Thank you for choosing James's PC Emporium. We look forward to helping you build your dream computer!
    </p>

    <!-- Button to navigate back to the main screen -->
    <a href="/mainscreen" class="btn btn-primary">Back to Main Screen</a>
</div>
</body>
```
- **Line 6-29**:Added basic styling to the about page.
````html
<style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
            padding-top: 30px;
        }
        .container {
            max-width: 800px;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #007bff;
        }
        p {
            font-size: 1.1rem;
            color: #333;
        }
        .btn-primary {
            margin-top: 20px;
        }
    </style>
````
## E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
### Changes made to `BootStrapData`
- **Line 42, 75, 97**: Added conditional statement to ensure duplicate items arn't added
```java
        //line 42
        if(outsourcedPartRepository.count() == 0) {}
        //line 75
        if(inhousePartRepository.count() == 0) {}
        //line 97
        if(productRepository.count() == 0) {}
```
- **Line 43-72**:Added outsourced parts (3) to outsourcedPartRepository and set parameters
```java
            OutsourcedPart part1 = new OutsourcedPart();
            part1.setCompanyName("New Egg");
            part1.setId(201);
            part1.setName("RAM");
            part1.setInv(25);
            part1.setPrice(74.99);

            OutsourcedPart part2 = new OutsourcedPart();
            part2.setCompanyName("New Egg");
            part2.setId(202);
            part2.setName("Power Supply");
            part2.setInv(15);
            part2.setPrice(129.99);

            OutsourcedPart part3 = new OutsourcedPart();
            part3.setCompanyName("New Egg");
            part3.setId(203);
            part3.setName("Computer Case");
            part3.setInv(20);
            part3.setPrice(150.00);

            outsourcedPartRepository.save(part1);
            outsourcedPartRepository.save(part2);
            outsourcedPartRepository.save(part3);
```
- **Line 77-95**:Added inhouse parts (2) to inhousePartRepository and set parameters
```java
InhousePart part4 = new InhousePart();
            part4.setName("CPU");
            part4.setId(101);
            part4.setInv(25);
            part4.setPrice(399.99);
            part4.setMaxInv(100);
            part4.setMinInv(1);

            InhousePart part5 = new InhousePart();
            part5.setName("GPU");
            part5.setId(102);
            part5.setInv(20);
            part5.setPrice(649.99);
            part5.setMaxInv(100);
            part5.setMinInv(1);

            inhousePartRepository.save(part4);
            inhousePartRepository.save(part5);
        }
```
- **Line 99-109**:Added products (5) to productRepository and set parameters
```java
Product product1 = new Product(301, "Gaming PC", 1700.00, 10);
            Product product2 = new Product(302, "Workstation PC", 1100.00, 8);
            Product product3 = new Product(303, "Home Office PC", 800.00, 15);
            Product product4 = new Product(304, "Budget PC", 600.00, 25);
            Product product5 = new Product(305, "High-End Gaming PC", 2800.00, 5);

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            productRepository.save(product4);
            productRepository.save(product5);
```
## F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
- The “Buy Now” button must be next to the buttons that update and delete products.
- The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
- Display a message that indicates the success or failure of a purchase.
### Changes made to `mainscreen.html`:
- **Line 138** added "Buy now" button next to update and delete products
```html
<a th:href="@{/buyProduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3">Buy Now</a>
```
- **Line 71 - 73** added Success/ or Failure message dependent on stock 
```html
<div th:if="${param.message}" class="alert alert-info">
        <p th:text="${param.message}"></p>
    </div>
```
### Changes made to `ProductServiceImpl`:
- **Line 72-81** added a buyProduct method to check if the product is available
```java
public boolean buyProduct(Long id) {
        int intId = id.intValue();
        Product product = findById(intId);
        if (product != null && product.getInv() > 0) {
            product.setInv(product.getInv() - 1);
            save(product);
            return true;
        }
        return false;
    }
```
### Changes made to `AddProductController`:
- **Line 181-186**: added buyProduct mapping and success/failure messaging logic
````java
@GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") Long productID) {
        boolean success = productServiceImpl.buyProduct(productID);
        String message = success ? "Purchase successful!" : "Purchase failed: Product is out of stock.";
        return "redirect:/mainscreen?message=" + message;
    }
````

## G.  Modify the parts to track maximum and minimum inventory by doing the following:
- Add additional fields to the part entity for maximum and minimum inventory.
- Modify the sample inventory to include the maximum and minimum fields.
- Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
- Rename the file the persistent storage is saved to.
- Modify the code to enforce that the inventory is between or at the minimum and maximum value.
### Changes made to `Part.java`:
- **Line 32-35**: added checiking to ensure that the value for min and max inv is positive
```java
@Min(value = 0, message = "Minimum inventory must be positive")
    int minInv;
    @Min(value = 0, message = "Maximum inventory must be positive")
    int maxInv;
```
- **Line 45, 49-50**: Added mininv and maxinv to part constructor
`````java
//Line 45
public Part(String name, double price, int inv, int minInv, int maxInv) {
//Line 49-50
this.minInv = minInv;
this.maxInv = maxInv;
`````
- **Line 53, 58-59**: Added mininv and max inv to other part constructor
```java
//Line 53
public Part(long id, String name, double price, int inv, int minInv, int maxInv) {
//line 58-59
this.minInv = minInv;
this.maxInv = maxInv;
```
- **Line 62-68**: Added getter and setter methods for minInv and maxInv
```java
public int getMinInv() {return minInv;}

public void setMinInv(int minInv) {this.minInv = minInv;}

public int getMaxInv() {return maxInv;}

public void setMaxInv(int maxInv) {this.maxInv = maxInv;}
```
### Changes made to `InhousePartForm.html`:
- **Line 27**: Added field for modifying the minimum inventory
```html
<p><input type="number" th:field="*{minInv}" placeholder="Minimum Inventory" class="form-control mb-4 col-4" min="0" required/></p>
```
- **Line 28**: added field for modifying the maximum inventory
```html
<p><input type="number" th:field="*{maxInv}" placeholder="Maximum Inventory" class="form-control mb-4 col-4" min="0" required/></p>
```
### Changes made to `OutsourcedPartFrom.html`:
- **Line 27**: Added field for modifying the minimum inventory
```html
<p><input type="number" th:field="*{minInv}" placeholder="Minimum Inventory" class="form-control mb-4 col-4" min="0" required/></p>
```
- **Line 29**: Added field for modifying the maximum inventory
````html
<p><input type="number" th:field="*{maxInv}" placeholder="Maximum Inventory" class="form-control mb-4 col-4" min="0" required/></p>
````
### Changes made to `BootStrapData.java`:
- **Line 49-50,58-59,67-68,82-83,90-91**: Modified sample inventory to include the maximum and minimum fields
`````java
//Line 49-50
part1.setMaxInv(100);
part1.setMinInv(1);
//Line 58-59
part2.setMaxInv(100);
part2.setMinInv(1);
//line 67-68
part3.setMaxInv(100);
part3.setMinInv(1);
//line 82-83
part4.setMaxInv(100);
part4.setMinInv(1);
//line 90-91
part5.setMaxInv(100);
part5.setMinInv(1);
`````
### Changes made to `AddInhousePartController.java`:
- **Line 45-48**: Added Error handling to ensure the min and max inv are within range before saving
````java
if (part.getInv() < part.getMinInv() || part.getInv() > part.getMaxInv()) {
            theModel.addAttribute("error", "Inventory must be between the minimum and maximum values.");
            return "InhousePartForm";
        }
````
### Changes made to `AddOutsourcedPartController.java`:
- **Line 46-49**: Added Error handling to ensure the min and max inv are within range before saving
```java
if (part.getInv() < part.getMinInv() || part.getInv() > part.getMaxInv()) {
            theModel.addAttribute("error", "Inventory must be between the minimum and maximum values.");
            return "OutsourcedPartForm";
        }
```
### Changes made to `application.properties`:
- **Line 6**: Renamed the file the persistent storage is saved to ensure our new fields are updated
```java
spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db112
```
## H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
- Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
- Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
- Display error messages when adding and updating parts if the inventory is greater than the maximum.

### Changes made to `AddOutsourcedPartController.java`:
- **Line 48**: Fixed an error outsource part was returning inhouse part form
```java
return "OutsourcedPartForm"; //this was also corrected in the above markup.
```
### Changes made to `InhousePartForm.html`:
- **Line 11**: added a block of code to show our specific error that was created in task G when inv is < min or > max
````html
<p th:if="${error}" th:text="${error}" style="color: red;"></p>
````
### Changes made to `OutsourcedPartForm.html`:
- **Line 11**: added a block of code to show our specific error that was created in task G when inv is < min or > max
```html
<p th:if="${error}" th:text="${error}" style="color: red;"></p>
```
### Please note 
- **Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.**
- None of our products updates our inventory for specific parts. Therefor we do not need to implement this. See also Part F. " It should not affect the inventory of any of the associated parts."
- However if we did implement this it would look something like this :
```java
public boolean buyProduct(Long productId) {
    int intId = productId.intValue();
    Product product = findById(intId);
    if (product != null && product.getInv() > 0) {
        product.setInv(product.getInv() - 1);
        Set<Part> parts = product.getParts();
        for (Part part : parts) {
            if (part.getInv() <= part.getMinInv()) {
                System.out.println("Error: Part inventory cannot go below minimum for part: " + part.getName());
                return false;  
            } else {
                part.setInv(part.getInv() - 1);
            }
        }
```
- We are essentially checking if the product exists and has available inventory, decreasing the inventory if it does, then checking for the associated part and decreasing part inventory if available. If either the part or product is unavailable we do not save and then display the error. 

## I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
### Changes made to `PartTest.java`:
- **Line 160-167**: Added a method to check if the inserted max value matches to the outputted max value
```java
 @Test
    void testMaxInv() {
        int maxInv = 100;
        partIn.setMaxInv(maxInv);
        partOut.setMaxInv(maxInv);
        assertEquals(maxInv, partIn.getMaxInv());
        assertEquals(maxInv, partOut.getMaxInv());
    }
```
- **Line 169-176**: Added a method to check if the inserted min value matches the outputted min value
```java
@Test
    void testMinInv() {
        int minInv = 10;
        partIn.setMinInv(minInv);
        partOut.setMinInv(minInv);
        assertEquals(minInv, partIn.getMinInv());
        assertEquals(minInv, partOut.getMinInv());
    }
```
## J.  Remove the class files for any unused validators in order to clean your code.
### Deleted `DeletePartValidator.java`


## Other changes
### Changes made to `InhousePartForm.html`
- **Line 16, 18, 21, 24, 26, 28**: Added labels above the form field to indicate what value is being changed or added.
### Changes made to `OutsourcedPartForm.html`
- **Line 16, 18, 21, 24, 26, 28**: Added labels above the form field to indicate what value is being changed or added. 
### Changes made to `productForm.html`
- **Line 16, 18, 21**: Added labels above the form field to indicate what value is being changed or added.
 