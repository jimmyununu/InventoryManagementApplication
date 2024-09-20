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
