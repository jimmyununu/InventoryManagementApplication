## C. Customize the HTML User Interface

The user interface for your customer’s application should include the following elements:
- Shop name
- Product names
- Names of the parts

### Changes made to `mainscreen.html`:

- **Lines 14-62**: Added basic styling.
- **Line 64**: Changed the title to `"James's PC Emporium"`.
- **Line 69**: Changed the header to `"James's PC Emporium"`.
- **Line 71**: Changed the `h2` tag to `"Computer Components"`.
- **Line 103**: Changed the `h2` tag to `"Pre-Built Computers"`.

## D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
### Changes made to `mainscreen.html`:
- **Line 70**: Added a button to take users to about page  
### ADDED file `about.html`
### Changes made to `MainScreenControllerr`:
- **Line 55-56**: Added mapping to handle /about route
### Changes made to `about.html`
- **Line 32-49**:Added information about the company's website
- **Line 6-29**:Added basic styling to the about page.

## E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
### Changes made to `BootStrapData`
- **Line 42, 69, 87**: Added conditional statement to ensure duplicate items arn't added
- **Line 43-67**:Added outsourced parts (3) to outsourcedPartRepository and set parameters
- **Line 70-85**:Added inhouse parts (2) to inhousePartRepository and set parameters
- **Line 88-100**:Added products (5) to productRepository and set parameters

## F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
- The “Buy Now” button must be next to the buttons that update and delete products.
- The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
- Display a message that indicates the success or failure of a purchase.
### Changes made to `mainscreen.html`:
- **Line 138** added "Buy now" button next to update and delete products
- **Line 71 - 73** added Success/ or Failure message dependent on stock 
### Changes made to `ProductServiceImpl`:
- **Line 72-81** added a buyProduct method to check if the product is available
### Changes made to `AddProductController`:
- **Line 181-190** added buyProduct mapping and success/failure messaging logic

## G.  Modify the parts to track maximum and minimum inventory by doing the following:
- Add additional fields to the part entity for maximum and minimum inventory.
- Modify the sample inventory to include the maximum and minimum fields.
- Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
- Rename the file the persistent storage is saved to.
- Modify the code to enforce that the inventory is between or at the minimum and maximum value.
### Changes made to `Part`:
- **Line 32-35**: Ensure that the value for min and max inv is positive
- **Line 45, 49-50**: Added mininv and maxinv to part constructor
- **Line 53, 58-59**: Added mininv and max inv to other part constructor
- **Line 62-68**: Added getter and setter methods for mininv and maxinv
### Changes made to `InhousePartForm.html`:
- **Line 26**: Added field for modifying the minimum inventory
- **Line 28**: added field for modifying the maximum inventory
### Changes made to `OutsourcedPartFrom.html`:
- **Line 27**: Added field for modifying the minimum inventory
- **Line 29**: Added field for modifying the maximum inventory
### Changes made to `BootStrapData.java`:
- **Line 49-50,58-59,67-68,82-83,90-91**: Modified sample inventory to include the maximum and minimum fields
### Changes made to `AddInhousePartController.java`:
- **Line 45-48**: Added Error handling to ensure the min and max inv are within range before saving
### Changes made to `AddOutsourcedPartController.java`:
- **Line 46-49**: Added Error handling to ensure the min and max inv are within range before saving
### Changes made to `application.properties`:
- **Line 6**: Renamed the file the persistent storage is saved to ensure our new fields are updated

## H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
- Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
- Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
- Display error messages when adding and updating parts if the inventory is greater than the maximum.

### Changes made to `AddOutsourcedPartController.java`:
- **Line 48**: Fixed an error outsource part was returning inhouse part form

### Changes made to `InhousePartForm.html`:
- **Line 11**: added a block of code to show our specific error that was created in task G when inv is < min or > max
### Changes made to `OutsourcedPartForm.html`:
- **Line 11**: added a block of code to show our specific error that was created in task G when inv is < min or > max
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
- **Line 170-176**: Added a method to check if the inserted min value matches the outputted min value

## J.  Remove the class files for any unused validators in order to clean your code.
### Deleted `DeletePartValidator.java`


## Other changes
### Changes made to `InhousePartForm.html`
- **Line 16, 18, 21, 24, 26, 28**: Added labels above the form field to indicate what value is being changed or added. 
### Changes made to `OutsourcedPartForm.html`
- **Line 16, 18, 21, 24, 26, 28**: Added labels above the form field to indicate what value is being changed or added. 
### Changes made to `productForm.html`
- **Line 16, 18, 21**: Added labels above the form field to indicate what value is being changed or added.