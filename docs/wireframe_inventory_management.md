---

## 2. Inventory Management

### 2.1. Item Tracking

#### Screen: Inventory Item List
*   **Purpose:** View, search, and filter all inventory items.
*   **Navigation:** Accessible from the "Inventory Management" section in the Main Dashboard.
*   **Tablet Layout:** Similar to Menu Item List, but displaying inventory-specific details like current stock, unit, reorder level.

##### Inventory Item List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Inventory Items               + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ] [Filter] [Add New] |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Name             Stock   Unit    Reorder   Vendor   Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Flour (AP)       50      kg      10        Sysco    [Edit] | |
| [Conf Icon] Configuration       | | Ground Beef      20      lbs     5         Local    [Edit] | |
|                                 | | Tomatoes         30      units   10        Farm     [Edit] | |
| [Cust Icon] Customer Management | | Milk             10      gal     2         Dairy    [Edit] | |
|                                 | | ... (More items) ...                                        | |
|                                 | +-------------------------------------------------------------+ |
|                                 |                               |
|                                 | ... (Scrollable Table/Grid) ...                                 |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

#### Screen: Inventory Item Detail/Edit Form
*   **Purpose:** View or modify details of a single inventory item.
*   **Navigation:** Accessed by tapping "Add New" on the Inventory Item List, or "Edit" next to an existing item.
*   **Tablet Layout:** Form with fields for Name, Description, Barcodes (package/unit), Unit Per Package, Unit, Reorder Level, Replenish Level, Average Package Price, Unit Purchase Price, Unit Selling Price, Visibility. Dropdowns for `InventoryGroup`, `InventoryLocation`, `InventoryVendor`, `InventoryWarehouse`.

##### Inventory Item Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Inventory Item           [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Name: [ Flour (All-Purpose)                                   ] |
| [Emp Icon]  Employee Management | Description: [ White flour, suitable for baking and cooking. ] |
|                                 |                               |
| [Rpt Icon]  Reporting & Analytics| Package Barcode: [                                          ] |
|                                 | Unit Barcode: [                                           ] |
| [Conf Icon] Configuration       | Unit Per Package: [ 1 ]   Unit: [ kg                      v ] |
|                                 |                               |
| [Cust Icon] Customer Management | Reorder Level: [ 10 ]   Replenish Level: [ 20 ]                 |
|                                 | Avg Package Price: [ 15.00 ] Unit Purchase Price: [ 0.75 ]     |
|                                 | Unit Selling Price: [ 1.50 ]                                  |
|                                 |                               |
|                                 | Group: [ Dry Goods             v ] Location: [ Pantry        v ] |
|                                 | Vendor: [ Sysco                 v ] Warehouse: [ Main Storage v ] |
|                                 |                               |
|                                 | [ Visible ] [X]                                                 |
|                                 |                               |
|                                 | --------------------------------------------------------------- |
|                                 | [ Delete Item ]                                                 |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

### 2.2. Recipe Management

#### Screen: Recipe List
*   **Purpose:** View and manage recipes.
*   **Navigation:** Accessible from the "Inventory Management" section in the Main Dashboard, likely as a sub-item or tab.
*   **Tablet Layout:** List of recipes, typically linked to menu items.

##### Recipe List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Recipes                       + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Recipe Name                                           Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Classic Burger (for Burger Deluxe)                    [Edit]| |
| [Conf Icon] Configuration       | | French Fries (for French Fries)                       [Edit]| |
|                                 | | Pizza Dough (for all Pizzas)                          [Edit]| |
| [Cust Icon] Customer Management | | ... (More recipes) ...                                      | |
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

#### Screen: Recipe Detail/Edit Form
*   **Purpose:** Create or modify a recipe.
*   **Navigation:** Accessed by tapping "Add New" on the Recipe List, or "Edit" next to an existing entry.
*   **Tablet Layout:**
    *   Select `MenuItem` this recipe is for.
    *   Section to add/remove `RecepieItem`s (linking to `InventoryItem` with quantity/percentage and inventory deductibility).

##### Recipe Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Recipe                   [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Menu Item: [ Burger Deluxe                                   v ] |
| [Emp Icon]  Employee Management |                               |
|                                 | --- Ingredients ------------------------------------------- |
| [Rpt Icon]  Reporting & Analytics| + Add Ingredient                                              |
|                                 |   > Ground Beef (0.25 lbs)                                    |
| [Conf Icon] Configuration       |   > Burger Bun (1 unit)                                       |
|                                 |   > Lettuce (0.05 lbs)                                        |
| [Cust Icon] Customer Management |   > Tomato (0.05 lbs)                                         |
|                                 |   > Onion (0.02 lbs)                                          |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

### 2.3. Supplier & Warehouse Management

#### Screen: Vendors List
*   **Purpose:** View and manage `InventoryVendor`s.
*   **Navigation:** Accessible from the "Inventory Management" section in the Main Dashboard, likely as a sub-item or tab.
*   **Tablet Layout:** List of vendors with basic contact info.

##### Vendors List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Vendors                       + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Name                  Phone                 Email     Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Sysco Foods           (555) 123-4567        contact@sysco.com [Edit]| |
| [Conf Icon] Configuration       | | Local Farm Produce    (555) 987-6543        farm@email.com  [Edit]| |
|                                 | | Dairy Distributors    (555) 555-1234        dairy@email.com [Edit]| |
| [Cust Icon] Customer Management | | ... (More vendors) ...                                      | |
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

#### Screen: Vendor Detail/Edit Form
*   **Purpose:** Create or modify a vendor.
*   **Navigation:** Accessed by tapping "Add New" on the Vendors List, or "Edit" next to an existing entry.
*   **Tablet Layout:** Form with fields for Name, Address, City, State, Zip, Country, Email, Phone, Fax, Visibility.

##### Vendor Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Vendor                   [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Name: [ Sysco Foods                                           ] |
| [Emp Icon]  Employee Management | Address: [ 123 Main St                                       ] |
|                                 | City: [ Anytown ]   State: [ CA ]   Zip: [ 90210 ]             |
| [Rpt Icon]  Reporting & Analytics| Country: [ USA                                               ] |
|                                 |                               |
| [Conf Icon] Configuration       | Email: [ contact@sysco.com                                   ] |
|                                 | Phone: [ (555) 123-4567 ]   Fax: [ (555) 123-4568 ]             |
| [Cust Icon] Customer Management |                               |
|                                 | [ Visible ] [X]                                                 |
|                                 |                               |
|                                 | --------------------------------------------------------------- |
|                                 | [ Delete ]                                                      |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

#### Screen: Warehouses List
*   **Purpose:** View and manage `InventoryWarehouse`s.
*   **Navigation:** Accessible from the "Inventory Management" section in the Main Dashboard, likely as a sub-item or tab.
*   **Tablet Layout:** Simple list of warehouses.

##### Warehouses List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Warehouses                    + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Name                                                  Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Main Storage                                          [Edit]| |
| [Conf Icon] Configuration       | | Dry Goods Storage                                     [Edit]| |
|                                 | | Cold Storage                                          [Edit]| |
| [Cust Icon] Customer Management | | ... (More warehouses) ...                                   | |
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

#### Screen: Warehouse Detail/Edit Form
*   **Purpose:** Create or modify a warehouse.
*   **Navigation:** Accessed by tapping "Add New" on the Warehouses List, or "Edit" next to an existing entry.
*   **Tablet Layout:** Form with fields for Name, Visibility.

##### Warehouse Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Warehouse                [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Name: [ Main Storage                                          ] |
| [Emp Icon]  Employee Management |                               |
|                                 | [ Visible ] [X]                                                 |
| [Rpt Icon]  Reporting & Analytics|                               |
|                                 | --------------------------------------------------------------- |
| [Conf Icon] Configuration       | [ Delete ]                                                      |
|                                 |                               |
| [Cust Icon] Customer Management |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

### 2.4. Purchase Orders

#### Screen: Purchase Order List
*   **Purpose:** View and manage `PurchaseOrder`s.
*   **Navigation:** Accessible from the "Inventory Management" section in the Main Dashboard, likely as a sub-item or tab.
*   **Tablet Layout:** List of purchase orders with status, date, and total.

##### Purchase Order List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Purchase Orders               + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ] [Filter] [Add New] |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Order ID        Vendor          Date         Total   Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | PO-2025-001     Sysco Foods     2025-07-20   $150.00 [Edit]| |
| [Conf Icon] Configuration       | | PO-2025-002     Local Farm      2025-07-18   $75.50  [Edit]| |
|                                 | | PO-2025-003     Dairy Dist.     2025-07-15   $200.00 [Edit]| |
| [Cust Icon] Customer Management | | ... (More orders) ...                                       | |
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

#### Screen: Purchase Order Detail/Edit Form
*   **Purpose:** Create or modify a purchase order.
*   **Navigation:** Accessed by tapping "Add New" on the Purchase Order List, or "Edit" next to an existing entry.
*   **Tablet Layout:**
    *   Fields for Order ID, Name, Vendor selection.
    *   Section to add/remove `InventoryItem`s with quantities and prices.

##### Purchase Order Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Purchase Order           [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Order ID: [ PO-2025-001                                     ] |
| [Emp Icon]  Employee Management | Name: [ Weekly Sysco Order                                  ] |
|                                 | Vendor: [ Sysco Foods                                       v ] |
| [Rpt Icon]  Reporting & Analytics| Status: [ Pending                                           v ] |
|                                 |                               |
| [Conf Icon] Configuration       | --- Items ------------------------------------------------- |
|                                 | + Add Item                                                  |
| [Cust Icon] Customer Management |   > Flour (All-Purpose) (10 kg @ $15.00)                    |
|                                 |   > Ground Beef (5 lbs @ $20.00)                            |
|                                 |   > Tomatoes (20 units @ $1.00)                             |
|                                 |                               |
|                                 | Total: $150.00                                              |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

### 2.5. Inventory Transactions

#### Screen: Inventory Transaction Log
*   **Purpose:** View a log of all `InventoryTransaction`s.
*   **Navigation:** Accessible from the "Inventory Management" section in the Main Dashboard, likely as a sub-item or tab.
*   **Tablet Layout:** Filterable list displaying transaction date, item, quantity, type (in/out), remark.

##### Inventory Transaction Log (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Inventory Log                 [Filter] |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Date/Time           Item             Type        Qty   Remark | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | 2025-07-20 10:30 AM Flour (AP)       In (PO)     10 kg [View] | |
| [Conf Icon] Configuration       | | 2025-07-19 02:15 PM Ground Beef      Out (Recipe)0.5 lbs [View] | |
|                                 | | 2025-07-19 09:00 AM Tomatoes         In (PO)     20 units [View] | |
| [Cust Icon] Customer Management | | 2025-07-18 08:00 AM Milk             In (PO)     5 gal [View] | |
|                                 | | ... (More transactions) ...                                 | |
|                                 | +-------------------------------------------------------------+ |
|                                 |                               |
|                                 | ... (Scrollable Table) ...                                      |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```