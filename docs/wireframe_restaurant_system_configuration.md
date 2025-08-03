---

## 5. Restaurant & System Configuration

### 5.1. Restaurant Settings

#### Screen: Restaurant Settings
*   **Purpose:** Configure global restaurant details (`Restaurant`).
*   **Navigation:** Accessible from the "Configuration" section in the Main Dashboard.
*   **Tablet Layout:** Form with fields for Name, Address, Zip Code, Telephone, Capacity, Tables, Currency Name/Symbol, Service Charge Percentage, Gratuity Percentage, Ticket Footer, Price Includes Tax, Allow Modifier Max Exceed.

##### Restaurant Settings (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Restaurant Settings           [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Name: [ My Awesome Restaurant                             ] |
| [Emp Icon]  Employee Management | Address: [ 123 Main St, Anytown, CA 90210                 ] |
|                                 | Telephone: [ (555) 123-4567                               ] |
| [Rpt Icon]  Reporting & Analytics| Capacity: [ 100 ]   Tables: [ 25 ]                          |
|                                 |                               |
| [Conf Icon] Configuration       | Currency Name: [ US Dollar ]   Symbol: [ $ ]                 |
|                                 | Service Charge %: [ 0.00 ]   Gratuity %: [ 0.00 ]             |
| [Cust Icon] Customer Management |                               |
|                                 | Ticket Footer: [ Thank you for your business!              ] |
|                                 |                               |
|                                 | [ Price Includes Tax ] [ ]                                  |
|                                 | [ Allow Modifier Max Exceed ] [X]                           |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

### 5.2. Global Settings

#### Screen: Global Settings
*   **Purpose:** Manage application-wide configurations (`GlobalConfig`).
*   **Navigation:** Accessible from the "Configuration" section in the Main Dashboard.
*   **Tablet Layout:** List of key-value pairs with inline editing or a detail form for each.

##### Global Settings (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Global Settings               [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | +-------------------------------------------------------------+ |
| [Emp Icon]  Employee Management | | Key                       Value                       Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | KITCHEN_PRINTER_IP        192.168.1.100               [Edit]| |
| [Conf Icon] Configuration       | | RECEIPT_PRINTER_TYPE      Thermal                     [Edit]| |
|                                 | | DEFAULT_TAX_RATE          0.0825                      [Edit]| |
| [Cust Icon] Customer Management | | ... (More settings) ...                                     | |
|                                 | +-------------------------------------------------------------+ |
|                                 |                               |
|                                 | ... (Scrollable List) ...                                       |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

### 5.3. Terminal & Printer Setup

#### Screen: Terminal Management
*   **Purpose:** View and manage `Terminal`s.
*   **Navigation:** Accessible from the "Configuration" section in the Main Dashboard.
*   **Tablet Layout:** List of terminals with name, status, assigned cash drawer. "Add New Terminal" button.

##### Terminal Management (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Terminal Management           + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Name             Status        Cash Drawer   Actions      | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Terminal 1       Active        Assigned      [Edit]       | |
| [Conf Icon] Configuration       | | Terminal 2       Inactive      N/A           [Edit]       | |
|                                 | | Kitchen POS      Active        N/A           [Edit]       | |
| [Cust Icon] Customer Management | | ... (More terminals) ...                                    | |
|                                 | +-------------------------------------------------------------+ |
|                                 |                               |
|                                 | ... (Scrollable List) ...                                       |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

#### Screen: Terminal Detail/Edit Form
*   **Purpose:** Create or modify a terminal.
*   **Navigation:** Accessed by tapping "Add New" on the Terminal Management List, or "Edit" next to an existing entry.
*   **Tablet Layout:**
    *   Fields for Name, Terminal Key, Opening Balance, Current Balance, Has Cash Drawer, In Use, Active, Location, Floor ID, Assigned User.
    *   Section to assign `TerminalPrinter`s.

##### Terminal Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Terminal                 [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Name: [ Terminal 1                                         ] |
| [Emp Icon]  Employee Management | Terminal Key: [ ABC-123-XYZ                               ] |
|                                 | Opening Balance: [ 100.00 ]   Current Balance: [ 250.00 ] |
| [Rpt Icon]  Reporting & Analytics|                               |
|                                 | [ Has Cash Drawer ] [X]                                     |
| [Conf Icon] Configuration       | [ In Use          ] [X]                                     |
|                                 | [ Active          ] [X]                                     |
| [Cust Icon] Customer Management |                               |
|                                 | Location: [ Front Counter                                 ] |
|                                 | Floor ID: [ 1 ]   Assigned User: [ John Doe               v ] |
|                                 |                               |
|                                 | --- Assigned Printers ------------------------------------- |
|                                 | + Add Printer                                               |
|                                 |   > Receipt Printer (Thermal)                               |
|                                 |   > Kitchen Printer (Impact)                                |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

#### Screen: Printer Management
*   **Purpose:** View and manage `Printer`s, `PrinterConfiguration`s, `PrinterGroup`s, `VirtualPrinter`s.
*   **Navigation:** Accessible from the "Configuration" section in the Main Dashboard.
*   **Tablet Layout:** Tabbed or segmented control to switch between lists of Printers, Printer Configurations, Printer Groups, Virtual Printers. Each list allows adding/editing.

##### Printer Management (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Printer Management            |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Printers ] [ Configs ] [ Groups ] [ Virtual ] |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | **Printers List**                                           | |
| [Rpt Icon]  Reporting & Analytics| | Name             Type          Status        Actions      | |
|                                 | +-------------------------------------------------------------+ |
| [Conf Icon] Configuration       | | Main Receipt     Thermal       Online        [Edit]       | |
|                                 | | Kitchen Line 1   Impact        Online        [Edit]       | |
| [Cust Icon] Customer Management | | Bar Printer      Thermal       Offline       [Edit]       | |
|                                 | | ... (More printers) ...                                     | |
|                                 | +-------------------------------------------------------------+ |
|                                 |                               |
|                                 | ... (Scrollable List) ...                                       |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

### 5.4. Payment Type Management

#### Screen: Payment Type List
*   **Purpose:** View and manage `CustomPayment` types.
*   **Navigation:** Accessible from the "Configuration" section in the Main Dashboard.
*   **Tablet Layout:** List of custom payment types. "Add New" button.

##### Payment Type List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Payment Types                 + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Name                                                  Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Gift Card                                             [Edit]| |
| [Conf Icon] Configuration       | | Store Credit                                          [Edit]| |
|                                 | | Loyalty Points                                        [Edit]| |
| [Cust Icon] Customer Management | | ... (More payment types) ...                                | |
|                                 | +-------------------------------------------------------------+ |
|                                 |                               |
|                                 | ... (Scrollable List) ...                                       |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

#### Screen: Payment Type Detail/Edit Form
*   **Purpose:** Create or modify a custom payment type.
*   **Navigation:** Accessed by tapping "Add New" on the Payment Type List, or "Edit" next to an existing entry.
*   **Tablet Layout:** Fields for Name, Required Ref Number, Ref Number Field Name.

##### Payment Type Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Payment Type             [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Name: [ Gift Card                                         ] |
| [Emp Icon]  Employee Management |                               |
|                                 | [ Required Ref Number ] [X]                                 |
| [Rpt Icon]  Reporting & Analytics| Ref Number Field Name: [ Gift Card Number                 ] |
|                                 |                               |
| [Conf Icon] Configuration       | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
| [Cust Icon] Customer Management |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

### 5.5. Void Reasons Management

#### Screen: Void Reasons List
*   **Purpose:** View and manage `VoidReason`s.
*   **Navigation:** Accessible from the "Configuration" section in the Main Dashboard.
*   **Tablet Layout:** Simple list of void reasons with add/edit functionality.

##### Void Reasons List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Void Reasons                  + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Reason Text                                           Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Customer changed mind                                 [Edit]| |
| [Conf Icon] Configuration       | | Item unavailable                                      [Edit]| |
|                                 | | Order error                                           [Edit]| |
| [Cust Icon] Customer Management | | ... (More reasons) ...                                      | |
|                                 | +-------------------------------------------------------------+ |
|                                 |                               |
|                                 | ... (Scrollable List) ...                                       |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

#### Screen: Void Reason Detail/Edit Form
*   **Purpose:** Create or modify a void reason.
*   **Navigation:** Accessed by tapping "Add New" on the Void Reasons List, or "Edit" next to an existing entry.
*   **Tablet Layout:** Form with a single field for Reason Text.

##### Void Reason Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Void Reason              [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Reason Text: [ Customer changed mind                            ] |
| [Emp Icon]  Employee Management |                               |
|                                 | ----------------------------------------------------------- |
| [Rpt Icon]  Reporting & Analytics| [ Delete ]                                                  |
|                                 |                               |
| [Conf Icon] Configuration       |                               |
|                                 |                               |
| [Cust Icon] Customer Management |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

### 5.6. Delivery Settings

#### Screen: Delivery Settings
*   **Purpose:** Configure `DeliveryConfiguration`, `DeliveryCharge`, `ZipCodeVsDeliveryCharge`.
*   **Navigation:** Accessible from the "Configuration" section in the Main Dashboard.
*   **Tablet Layout:** Tabbed or segmented control for general delivery settings, delivery charges, and zip code-based charges. Forms for each.

##### Delivery Settings (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Delivery Settings             [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ General ] [ Charges ] [ Zip Codes ] |
|                                 |                               |
| [Emp Icon]  Employee Management | --- General Delivery Configuration ------------------------ |
|                                 | Unit Name: [ Miles ]   Unit Symbol: [ mi ]                  |
| [Rpt Icon]  Reporting & Analytics| [ Charge By Zip Code ] [X]                                  |
|                                 |                               |
| [Conf Icon] Configuration       | --- Delivery Charges (if not by Zip Code) ----------------- |
|                                 | + Add Delivery Charge                                       |
| [Cust Icon] Customer Management |   > 0-5 mi: $5.00                                           |
|                                 |   > 5-10 mi: $8.00                                          |
|                                 |                               |
|                                 | --- Zip Code Based Charges -------------------------------- |
|                                 | + Add Zip Code Charge                                       |
|                                 |   > 90210: $3.00                                            |
|                                 |   > 90211: $4.50                                            |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

### 5.7. Order Type Management

#### Screen: Order Type List
*   **Purpose:** View and manage `OrderType`s.
*   **Navigation:** Accessible from the "Configuration" section in the Main Dashboard.
*   **Tablet Layout:** List of order types. "Add New" button.

##### Order Type List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Order Types                   + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Name             Delivery   Prepaid   Show Table   Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Dine-In          No         No        Yes          [Edit]| |
| [Conf Icon] Configuration       | | Take-Out         No         No        No           [Edit]| |
|                                 | | Delivery         Yes        No        No           [Edit]| |
| [Cust Icon] Customer Management | | Online Order     Yes        Yes       No           [Edit]| |
|                                 | | ... (More types) ...                                        | |
|                                 | +-------------------------------------------------------------+ |
|                                 |                               |
|                                 | ... (Scrollable List) ...                                       |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

#### Screen: Order Type Detail/Edit Form
*   **Purpose:** Create or modify an order type.
*   **Navigation:** Accessed by tapping "Add New" on the Order Type List, or "Edit" next to an existing entry.
*   **Tablet Layout:** Extensive form with fields for Name, Enabled, Show Table Selection, Show Guest Selection, Should Print to Kitchen, Prepaid, Close on Paid, Required Customer Data, Delivery, Show Item Barcode, Show In Login Screen, Consolidate Items in Receipt, Allow Seat Based Order, Hide Item with Empty Inventory, Has Forhere and Togo, Pre Auth Credit Card, Bar Tab, Retail Order, Show Price on Button, Show Stock Count on Button, Show Unit Price in Ticket Grid, Properties.

##### Order Type Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
| [Menu Icon] Menu Management     | Edit Order Type               [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Name: [ Dine-In                                           ] |
| [Emp Icon]  Employee Management |                               |
|                                 | [ Enabled ] [X]                                             |
| [Rpt Icon]  Reporting & Analytics| [ Show Table Selection ] [X]                                |
|                                 | [ Show Guest Selection ] [X]                                |
| [Conf Icon] Configuration       | [ Should Print to Kitchen ] [X]                             |
|                                 | [ Prepaid ] [ ]                                             |
| [Cust Icon] Customer Management | [ Close on Paid ] [X]                                       |
|                                 | [ Required Customer Data ] [ ]                              |
|                                 | [ Delivery ] [ ]                                            |
|                                 | [ Show Item Barcode ] [ ]                                   |
|                                 | [ Show In Login Screen ] [X]                                |
|                                 | [ Consolidate Items in Receipt ] [ ]                        |
|                                 | [ Allow Seat Based Order ] [X]                              |
|                                 | [ Hide Item with Empty Inventory ] [ ]                      |
|                                 | [ Has Forhere and Togo ] [ ]                                |
|                                 | [ Pre Auth Credit Card ] [ ]                                |
|                                 | [ Bar Tab ] [ ]                                             |
|                                 | [ Retail Order ] [ ]                                        |
|                                 | [ Show Price on Button ] [X]                                |
|                                 | [ Show Stock Count on Button ] [ ]                          |
|                                 | [ Show Unit Price in Ticket Grid ] [ ]                      |
|                                 | Properties: [ (JSON or key-value pairs)                   ] |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
|                                 |                               |
+-----------------------------------------------------------------+
```

---

## 6. Customer & Table Management

### 6.1. Customer Database

#### Screen: Customer List
*   **Purpose:** View, search, and manage `Customer` records.
*   **Navigation:** Accessible from the "Customer Management" section in the Main Dashboard.
*   **Tablet Layout:** List of customers with name, contact info. "Add New Customer" button.

##### Customer List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Customer Database             + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ] [Filter] [Add New] |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Name             Phone             Email             Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Alice Smith      (555) 111-2222    alice@email.com   [Edit]| |
| [Conf Icon] Configuration       | | Bob Johnson      (555) 333-4444    bob@email.com     [Edit]| |
|                                 | | Charlie Brown    (555) 555-6666    charlie@email.com [Edit]| |
| [Cust Icon] Customer Management | | ... (More customers) ...                                    | |
|                                 | +-------------------------------------------------------------+ |
|                                 |                               |
|                                 | ... (Scrollable List) ...                                       |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

#### Screen: Customer Detail/Edit Form
*   **Purpose:** Create or modify a customer record.
*   **Navigation:** Accessed by tapping "Add New" on the Customer List, or "Edit" next to an existing entry.
*   **Tablet Layout:**
    *   Fields for Loyalty No, Loyalty Point, SSN, Picture, Phone Numbers (Home, Mobile, Work), Email, Salutation, First Name, Last Name, Name, DOB, Address, City, State, Zip Code, Country, VIP, Credit Limit, Credit Spent, Credit Card No, Note.
    *   Section to manage `DeliveryAddress` and `DeliveryInstruction` for the customer.

##### Customer Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Customer                 [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Loyalty No: [ 123456                                      ] |
| [Emp Icon]  Employee Management | Loyalty Point: [ 150 ]                                      |
|                                 | SSN: [ XXX-XX-XXXX ]                                        |
| [Rpt Icon]  Reporting & Analytics| [ Customer Picture ] (Tap to change)                        |
|                                 |                               |
| [Conf Icon] Configuration       | First Name: [ Alice ]   Last Name: [ Smith ]                 |
|                                 | Email: [ alice@email.com                                   ] |
| [Cust Icon] Customer Management | Home Phone: [ (555) 111-2222 ]   Mobile: [ (555) 111-3333 ] |
|                                 | Work Phone: [ (555) 111-4444 ]                                |
|                                 |                               |
|                                 | Address: [ 456 Oak Ave                                      ] |
|                                 | City: [ Anytown ]   State: [ CA ]   Zip: [ 90210 ]             |
|                                 | Country: [ USA                                               ] |
|                                 |                               |
|                                 | [ VIP ] [ ]                                                 |
|                                 | Credit Limit: [ 500.00 ]   Credit Spent: [ 150.00 ]         |
|                                 | Credit Card No: [ **** **** **** 1234                       ] |
|                                 | Note: [ Prefers window seats.                               ] |
|                                 |                               |
|                                 | --- Delivery Addresses ------------------------------------ |
|                                 | + Add Address                                               |
|                                 |   > 789 Pine St (Home)                                      |
|                                 |                               |
|                                 | --- Delivery Instructions --------------------------------- |
|                                 | + Add Instruction                                           |
|                                 |   > Call upon arrival.                                      |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
|                                 |                               |
+-----------------------------------------------------------------+
```

### 6.2. Floor Plan Management

#### Screen: Floor Plan List
*   **Purpose:** View and manage `ShopFloor`s.
*   **Navigation:** Accessible from the "Customer Management" section in the Main Dashboard.
*   **Tablet Layout:** List of floor plans. "Add New Floor Plan" button.

##### Floor Plan List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Floor Plans                   + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Name             Occupied   Actions                       | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Main Dining Room No          [Edit]                       | |
| [Conf Icon] Configuration       | | Patio            Yes         [Edit]                       | |
| [Cust Icon] Customer Management | | Bar Area         No          [Edit]                       | |
|                                 | | ... (More floor plans) ...                                  | |
|                                 | +-------------------------------------------------------------+ |
|                                 |                               |
|                                 | ... (Scrollable List) ...                                       |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

#### Screen: Floor Plan Detail/Edit
*   **Purpose:** Design or modify a floor plan.
*   **Navigation:** Accessed by tapping "Add New" on the Floor Plan List, or "Edit" next to an existing entry.
*   **Tablet Layout:**
    *   Canvas area to drag and drop `ShopTable`s.
    *   Sidebar/bottom sheet for table properties (name, description, capacity, type, x/y coordinates).
    *   Tools for adding/removing tables, setting table types (`ShopTableType`).

##### Floor Plan Detail/Edit (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Floor Plan               [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management| Name: [ Main Dining Room ]                                  |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | [Canvas Area for Floor Plan Design]                         | |
| [Rpt Icon]  Reporting & Analytics| |                                                             | |
|                                 | |   [Table 1]   [Table 2]                                     | |
| [Conf Icon] Configuration       | |                                                             | |
|                                 | |   [Table 3]                                                 | |
| [Cust Icon] Customer Management | |                                                             | |
|                                 | |                                                             | |
|                                 | +-------------------------------------------------------------+ |
|                                 |                               |
|                                 | --- Table Properties (Selected Table) --------------------- |
|                                 | Name: [ Table 1 ]   Capacity: [ 4 ]                         |
|                                 | Type: [ Booth v ]   X: [ 100 ]   Y: [ 50 ]                  |
|                                 |                               |
|                                 | --- Tools ------------------------------------------------- |
|                                 | [ Add Table ] [ Remove Table ] [ Set Table Type ]          |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
|                                 |                               |
+-----------------------------------------------------------------+
```

### 6.3. Table Booking

#### Screen: Table Booking List
*   **Purpose:** View and manage `TableBookingInfo`.
*   **Navigation:** Accessible from the "Customer Management" section in the Main Dashboard.
*   **Tablet Layout:** List of bookings with date, time, customer, guest count, status. "Add New Booking" button.

##### Table Booking List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Table Bookings                + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ] [Filter] [Add New] |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Date             Time      Customer        Guests  Status | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | 2025-07-20       07:00 PM  Alice Smith     4       Confirmed| |
| [Conf Icon] Configuration       | | 2025-07-21       06:30 PM  Bob Johnson     2       Pending  | |
|                                 | | 2025-07-22       08:00 PM  Charlie Brown   6       Confirmed| |
| [Cust Icon] Customer Management | | ... (More bookings) ...                                     | |
|                                 | +-------------------------------------------------------------+ |
|                                 |                               |
|                                 | ... (Scrollable List) ...                                       |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

#### Screen: Table Booking Detail/Edit Form
*   **Purpose:** Create or modify a table booking.
*   **Navigation:** Accessed by tapping "Add New" on the Table Booking List, or "Edit" next to an existing entry.
*   **Tablet Layout:** Fields for From Date, To Date, Guest Count, Status, Payment Status, Booking Confirm, Booking Charge, Remaining Balance, Paid Amount, Booking ID, Booking Type. Customer selection and `ShopTable` selection.

##### Table Booking Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Table Booking            [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | From Date: [ 2025-07-20 ]   To Date: [ 2025-07-20 ]         |
| [Emp Icon]  Employee Management | Guest Count: [ 4 ]                                          |
|                                 | Status: [ Confirmed                                       v ] |
| [Rpt Icon]  Reporting & Analytics| Payment Status: [ Paid                                      v ] |
|                                 | Booking Confirm: [ (Checkbox) ]                             |
| [Conf Icon] Configuration       | Booking Charge: [ 0.00 ]   Remaining Balance: [ 0.00 ]      |
|                                 | Paid Amount: [ 0.00 ]                                       |
| [Cust Icon] Customer Management | Booking ID: [ BK-2025-001                                 ] |
|                                 | Booking Type: [ Online                                      v ] |
|                                 |                               |
|                                 | Customer: [ Alice Smith                                   v ] |
|                                 | Table: [ Table 5 (Main Dining Room)                      v ] |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```