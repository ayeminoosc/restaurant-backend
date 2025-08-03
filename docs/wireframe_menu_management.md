## 1. Menu Management

### 1.1. Item Configuration

#### Screen: Menu Item List
*   **Purpose:** View, search, and filter all menu items.
*   **Navigation:** Accessible from the "Menu Management" section in the Main Dashboard.
*   **Tablet Layout:**
    *   Top: Search bar, "Add New Item" button.
    *   Main Content Area: Grid or list view of menu items with more details visible (e.g., name, price, category, stock). Tap to open detail view in a side panel or new screen.

##### Menu Item List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Menu Items                    |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ] [Filter] [Add New] |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Name             Price   Category    Stock   Image   Actions| |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Burger Deluxe    $12.99  Main        50      [IMG]   [Edit] | |
| [Conf Icon] Configuration       | | French Fries     $4.50   Sides       100     [IMG]   [Edit] | |
| [Cust Icon] Customer Management | | Soda             $2.50   Drinks      200     [IMG]   [Edit] | |
|                                 | | Pizza (Large)    $18.00  Pizza       30      [IMG]   [Edit] | |
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

#### Screen: Menu Item Detail/Edit Form
*   **Purpose:** View or modify details of a single menu item.
*   **Navigation:** Accessed by tapping "Add New" on the Menu Item List, or "Edit" next to an existing item.
*   **Tablet Layout:**
    *   Form fields laid out in multiple columns or using a tabbed interface for better organization of sections (e.g., "General", "Modifiers", "Pricing", "Images"). Side panel for navigation or list view.

##### Menu Item Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Item                     [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management| +-------------------------------------------------------------+ |
|                                 | | [ Item Image ] (Tap to change)                              | |
| [Emp Icon]  Employee Management | |                                                             | |
|                                 | | Name: [ Burger Deluxe                                     ] | |
| [Rpt Icon]  Reporting & Analytics| | Description: [ Juicy patty, fresh veggies, special sauce. ] | |
|                                 | | Price: [ 12.99 ]   Buy Price: [ 6.50 ] Stock: [ 50 ]         | |
| [Conf Icon] Configuration       | |                                                             | |
| [Cust Icon] Customer Management | | Category: [ Main Category v ] Group: [ Burgers v ]          | |
|                                 | | Tax Group: [ Food Tax v ]                                   | |
|                                 | |                                                             | |
|                                 | | +---------------------------------------------------------+ | |
|                                 | | | **Modifiers**                                           | | |
|                                 | | | + Add Modifier Group                                    | | |
|                                 | | |   > Cheese Options (Min:1, Max:1) [Edit] [X]            | | |
|                                 | | |   > Toppings (Min:0, Max:5)       [Edit] [X]            | | |
|                                 | | +---------------------------------------------------------+ | |
|                                 | |                                                             | |
|                                 | | +---------------------------------------------------------+ | |
|                                 | | | **Pricing & Shifts**                                    | | |
|                                 | | | > Shift Prices                                          | | |
|                                 | | | > Item Sizes                                            | | |
|                                 | | | > Pizza Configuration (Crusts, Prices, Modifiers)       | | |
|                                 | | +---------------------------------------------------------+ | |
|                                 | |                                                             | |
|                                 | | [ Show Image Only ] [ ]   [ Visible ] [X]                   | |
|                                 | | [ Fractional Unit ] [ ]   [ Pizza Type ] [ ]                | |
|                                 | |                                                             | |
|                                 | | [ Delete Item ]                                             | |
|                                 | +-------------------------------------------------------------+ |
+-----------------------------------------------------------------+
```



### 1.4. Pricing & Shifts

#### Screen: Shift Price Configuration
*   **Purpose:** Configure `MenuItemShift` prices.
*   **Navigation:** Accessible from the "Menu Management" section in the Main Dashboard, likely as a sub-item or tab.
*   **Tablet Layout:** Table-like layout for setting different prices per defined `Shift` for each menu item.

##### Shift Price Configuration (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Shift Prices                  [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management| Item: Burger Deluxe             |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Shift Name      Price                                       | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
| [Conf Icon] Configuration       | | Morning         [ 10.99 ]                                   | |
| [Cust Icon] Customer Management | | Lunch           [ 12.99 ]                                   | |
|                                 | | Dinner          [ 14.99 ]                                   | |
|                                 | | Late Night      [ 9.99  ]                                   | |
|                                 | | ... (More Shifts) ...                                       | |
|                                 | +-------------------------------------------------------------+ |
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

#### Screen: Item Size/Crust/Pizza Pricing
*   **Purpose:** Configure `MenuItemSize`, `PizzaCrust`, `PizzaPrice`, `PizzaModifierPrice`.
*   **Navigation:** Accessible from the "Menu Management" section in the Main Dashboard, likely as a sub-item or tab, or directly from the Menu Item Detail form.
*   **Tablet Layout:** Dedicated forms/tables for managing sizes, crusts, and their associated prices, potentially linked to specific menu items (especially for pizza).

##### Item Size/Crust/Pizza Pricing (Tablet Wireframe - Example: Pizza Sizes)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Pizza Sizes                   [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management| Item: Pepperoni Pizza           |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Size Name       Price                                       | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
| [Conf Icon] Configuration       | | Small           [ 10.00 ]                                   | |
| [Cust Icon] Customer Management | | Medium          [ 14.00 ]                                   | |
|                                 | | Large           [ 18.00 ]                                   | |
|                                 | | Extra Large     [ 22.00 ]                                   | |
|                                 | | ... (More Sizes) ...                                        | |
|                                 | +-------------------------------------------------------------+ |
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

### 1.5. Discounts & Coupons

#### Screen: Discounts/Coupons List
*   **Purpose:** View and manage `Discount` and `CouponAndDiscount` entries.
*   **Navigation:** Accessible from the "Menu Management" section in the Main Dashboard, likely as a sub-item or tab.
*   **Tablet Layout:** List of discounts/coupons. Each entry shows name, type, value, and expiry. "Add New" button.

##### Discounts/Coupons List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Discounts/Coupons             + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Name                  Type      Value     Expiry    Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
| [Conf Icon] Configuration       | | 10% Off Entire Bill   Percentage  10%       N/A       [Edit]| |
| [Cust Icon] Customer Management | | Free Drink Coupon     Amount    $3.00     2025-12-31[Edit]| |
|                                 | | Employee Discount     Percentage  15%       N/A       [Edit]| |
|                                 | | Happy Hour Special    Amount    $5.00     2025-07-31[Edit]| |
|                                 | | ... (More items) ...                                        | |
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

#### Screen: Discount/Coupon Detail/Edit Form
*   **Purpose:** Create or modify a discount/coupon.
*   **Navigation:** Accessed by tapping "Add New" on the Discounts/Coupons List, or "Edit" next to an existing entry.
*   **Tablet Layout:**
    *   Fields for Name, Type (amount/percentage), Barcode (for coupons), Qualification Type, Apply to All, Minimum Buy, Maximum Off, Value, Expiry Date, Enabled, Auto Apply, Modifiable, Never Expire.

##### Discount/Coupon Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Discount/Coupon          [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Name: [ 10% Off Entire Bill                             ] |
| [Emp Icon]  Employee Management | Type: [ Percentage                                  v ] |
| [Rpt Icon]  Reporting & Analytics| Value: [ 10.00 ]                                          |
| [Conf Icon] Configuration       |                               |
| [Cust Icon] Customer Management | [ Auto Apply      ] [X]                                     |
|                                 | [ Enabled         ] [X]                                     |
|                                 | [ Modifiable      ] [ ]                                     |
|                                 | [ Never Expire    ] [ ]                                     |
|                                 |                               |
|                                 | Barcode: [ (for coupons)                                ] |
|                                 | Expiry Date: [ 2025-12-31                               ] |
|                                 |                               |
|                                 | Min Buy: [ 0.00 ]                                           |
|                                 | Max Off: [ 0.00 ]                                           |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```