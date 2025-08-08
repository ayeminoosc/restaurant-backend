# Backoffice System Wireframes (Tablet Friendly)

This document outlines detailed wireframe concepts for the backoffice system, designed to be responsive and user-friendly on tablet devices. Each section describes the typical screens and their key UI elements, followed by an ASCII representation of the wireframe.

---

## Main Dashboard (Tablet)
*   **Purpose:** Central hub for navigating to all backoffice features. Provides an overview and quick access to main sections.
*   **Layout:**
    *   **Top Header:** Restaurant Name/Logo, User Info (e.g., "Welcome, John Doe"), Logout button.
    *   **Left Sidebar:** Main navigation menu with icons and labels for each major section: Menu Management, Inventory Management, Employee & User Management, Reporting & Analytics, Restaurant & System Configuration, Customer & Table Management.
    *   **Main Content Area:** Could display a summary dashboard (e.g., daily sales, recent activity, quick links) or serve as the primary display area for the selected feature.

##### Main Dashboard (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
|                                 |                               |
| [Menu Icon] Menu Management     |                               |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 |                               |
| [Emp Icon]  Employee Management |     [ Main Content Area ]     |
|                                 |                               |
| [Rpt Icon]  Reporting & Analytics|                               |
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
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

---

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
|                                 | | Soda             $2.50   Drinks      200     [IMG]   [Edit] | |
| [Cust Icon] Customer Management | | Pizza (Large)    $18.00  Pizza       30      [IMG]   [Edit] | |
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
|                                 | | Category: [ Main Category v ] Group: [ Burgers v ]          | |
| [Cust Icon] Customer Management | | Tax Group: [ Food Tax v ]                                   | |
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

### 1.2. Category & Grouping

#### Screen: Categories/Groups List
*   **Purpose:** Manage menu categories and groups.
*   **Navigation:** Accessible from the "Menu Management" section in the Main Dashboard, likely as a sub-item or tab.
*   **Tablet Layout:** Simple list view for categories and groups. Each entry shows name, and an "Edit" button/icon. "Add New" button at the top.

##### Categories/Groups List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Categories/Groups             + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Name                                                  Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Main Category                                         [Edit]| |
| [Conf Icon] Configuration       | | Drinks Category                                       [Edit]| |
|                                 | | Burgers Group                                         [Edit]| |
| [Cust Icon] Customer Management | | Sides Group                                           [Edit]| |
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

#### Screen: Category/Group Detail/Edit Form
*   **Purpose:** Create or modify a category/group.
*   **Navigation:** Accessed by tapping "Add New" on the Categories/Groups List, or "Edit" next to an existing entry.
*   **Tablet Layout:** Form with fields for Name, Translated Name, Visibility, Sort Order, Button Color, Text Color.

##### Category/Group Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Category/Group           [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Name: [ Main Category                                     ] |
| [Emp Icon]  Employee Management | Translated Name: [                                        ] |
|                                 |                               |
| [Rpt Icon]  Reporting & Analytics| Sort Order: [ 1 ]                                           |
|                                 | Button Color: [ #FFFFFF ]   Text Color: [ #000000 ]         |
| [Conf Icon] Configuration       |                               |
|                                 | [ Visible ] [X]                                             |
| [Cust Icon] Customer Management | [ Beverage  ] [ ] (for Categories only)                     |
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

### 1.3. Modifier Management

#### Screen: Modifier Group List
*   **Purpose:** View and manage `ModifierGroup`s.
*   **Navigation:** Accessible from the "Menu Management" section in the Main Dashboard, likely as a sub-item or tab.
*   **Tablet Layout:** List of modifier groups. Each entry shows group name, and an "Edit" button/icon. "Add New Group" button.

##### Modifier Group List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Modifier Groups               + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Name                                                  Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Cheese Options                                        [Edit]| |
| [Conf Icon] Configuration       | | Burger Toppings                                       [Edit]| |
|                                 | | Pizza Toppings                                        [Edit]| |
| [Cust Icon] Customer Management | | Drink Add-ons                                         [Edit]| |
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

#### Screen: Modifier Group Detail/Edit Form
*   **Purpose:** Create or modify a `ModifierGroup`.
*   **Navigation:** Accessed by tapping "Add New" on the Modifier Group List, or "Edit" next to an existing entry.
*   **Tablet Layout:**
    *   Fields for Group Name, Translated Name, Enabled, Exclusive, Required.
    *   Section to add/remove `MenuModifier`s to this group (with search/selection).

##### Modifier Group Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Modifier Group           [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Name: [ Cheese Options                                    ] |
| [Emp Icon]  Employee Management | Translated Name: [                                        ] |
|                                 |                               |
| [Rpt Icon]  Reporting & Analytics| [ Enabled   ] [X]                                           |
|                                 | [ Exclusive ] [ ]                                           |
| [Conf Icon] Configuration       | [ Required  ] [ ]                                           |
|                                 |                               |
| [Cust Icon] Customer Management | --- Modifiers in this Group ------------------------------- |
|                                 | + Add Modifier                                              |
|                                 |   > Cheddar Cheese                                          |
|                                 |   > Swiss Cheese                                            |
|                                 |   > American Cheese                                         |
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

#### Screen: Menu Modifier List
*   **Purpose:** View and manage individual `MenuModifier`s.
*   **Navigation:** Accessible from the "Menu Management" section in the Main Dashboard, likely as a sub-item or tab.
*   **Tablet Layout:** List of menu modifiers. Each entry shows modifier name, price, and an "Edit" button/icon. "Add New Modifier" button.

##### Menu Modifier List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Menu Modifiers                + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Name                  Price                           Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Extra Cheese          $1.00                           [Edit]| |
| [Conf Icon] Configuration       | | No Onions             $0.00                           [Edit]| |
|                                 | | Add Bacon             $2.50                           [Edit]| |
| [Cust Icon] Customer Management | | Gluten-Free Bun       $1.50                           [Edit]| |
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

#### Screen: Menu Modifier Detail/Edit Form
*   **Purpose:** Create or modify a `MenuModifier`.
*   **Navigation:** Accessed by tapping "Add New" on the Menu Modifier List, or "Edit" next to an existing entry.
*   **Tablet Layout:**
    *   Fields for Name, Translated Name, Price, Extra Price, Sort Order, Button Color, Text Color, Enabled, Fixed Price, Print to Kitchen, Section Wise Pricing, Pizza Modifier.
    *   Dropdown for associated Tax.

##### Menu Modifier Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Menu Modifier            [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Name: [ Extra Cheese                                      ] |
| [Emp Icon]  Employee Management | Translated Name: [                                        ] |
|                                 | Price: [ 1.00 ]   Extra Price: [ 0.00 ]                     |
| [Rpt Icon]  Reporting & Analytics|                               |
|                                 | Sort Order: [ 1 ]                                           |
| [Conf Icon] Configuration       | Button Color: [ #FFFFFF ]   Text Color: [ #000000 ]         |
|                                 |                               |
| [Cust Icon] Customer Management | Tax: [ Food Tax                                         v ] |
|                                 |                               |
|                                 | [ Enabled         ] [X]                                     |
|                                 | [ Fixed Price     ] [ ]                                     |
|                                 | [ Print to Kitchen] [X]                                     |
|                                 | [ Section Pricing ] [ ]                                     |
|                                 | [ Pizza Modifier  ] [ ]                                     |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
|                                 |                               |
|                                 |                               |
|                                 |                               |
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
|                                 | | Morning         [ 10.99 ]                                   | |
| [Conf Icon] Configuration       | | Lunch           [ 12.99 ]                                   | |
|                                 | | Dinner          [ 14.99 ]                                   | |
| [Cust Icon] Customer Management | | Late Night      [ 9.99  ]                                   | |
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
|                                 | | Small           [ 10.00 ]                                   | |
| [Conf Icon] Configuration       | | Medium          [ 14.00 ]                                   | |
|                                 | | Large           [ 18.00 ]                                   | |
| [Cust Icon] Customer Management | | Extra Large     [ 22.00 ]                                   | |
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
|                                 | | 10% Off Entire Bill   Percentage  10%       N/A       [Edit]| |
| [Conf Icon] Configuration       | | Free Drink Coupon     Amount    $3.00     2025-12-31[Edit]| |
|                                 | | Employee Discount     Percentage  15%       N/A       [Edit]| |
| [Cust Icon] Customer Management | | Happy Hour Special    Amount    $5.00     2025-07-31[Edit]| |
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
|                                 | Value: [ 10.00 ]                                          |
| [Rpt Icon]  Reporting & Analytics|                               |
|                                 | [ Auto Apply      ] [X]                                     |
| [Conf Icon] Configuration       | [ Enabled         ] [X]                                     |
|                                 | [ Modifiable      ] [ ]                                     |
| [Cust Icon] Customer Management | [ Never Expire    ] [ ]                                     |
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

---

## 3. Employee & User Management

### 3.1. User Accounts

#### Screen: User List
*   **Purpose:** View, search, and manage `User` accounts.
*   **Navigation:** Accessible from the "Employee Management" section in the Main Dashboard.
*   **Tablet Layout:** List of users with name, user type, and status (clocked in/out). "Add New User" button.

##### User List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | User Accounts                 + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ] [Filter] [Add New] |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Name             User Type       Status        Actions    | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | John Doe         Manager         Clocked In    [Edit]     | |
| [Conf Icon] Configuration       | | Jane Smith       Cashier         Clocked Out   [Edit]     | |
|                                 | | Bob Johnson      Cook            Clocked In    [Edit]     | |
| [Cust Icon] Customer Management | | ... (More users) ...                                        | |
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

#### Screen: User Detail/Edit Form
*   **Purpose:** Create or modify a user account.
*   **Navigation:** Accessed by tapping "Add New" on the User List, or "Edit" next to an existing user.
*   **Tablet Layout:**
    *   Fields for User ID, Password, First Name, Last Name, SSN, Cost Per Hour, Phone No.
    *   Dropdown for `UserType`.
    *   Toggles for Clocked In, Is Driver, Available for Delivery, Active.

##### User Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit User Account             [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | User ID: [ johndoe                                         ] |
| [Emp Icon]  Employee Management | Password: [ ************                                  ] |
|                                 | First Name: [ John ]   Last Name: [ Doe ]                     |
| [Rpt Icon]  Reporting & Analytics| SSN: [ XXX-XX-XXXX ]   Cost Per Hour: [ 15.00 ]             |
|                                 | Phone No: [ (555) 123-4567                                ] |
| [Conf Icon] Configuration       |                               |
|                                 | User Type: [ Manager                                       v ] |
| [Cust Icon] Customer Management |                               |
|                                 | [ Clocked In ] [X]                                          |
|                                 | [ Is Driver    ] [ ]                                          |
|                                 | [ Available for Delivery ] [ ]                                |
|                                 | [ Active       ] [X]                                          |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete User ]                                             |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

### 3.2. Roles & Permissions

#### Screen: User Type List
*   **Purpose:** View and manage `UserType`s.
*   **Navigation:** Accessible from the "Employee Management" section in the Main Dashboard, likely as a sub-item or tab.
*   **Tablet Layout:** List of user types.

##### User Type List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | User Types                    + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Name                                                  Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Manager                                               [Edit]| |
| [Conf Icon] Configuration       | | Cashier                                               [Edit]| |
|                                 | | Cook                                                  [Edit]| |
| [Cust Icon] Customer Management | | Server                                                [Edit]| |
|                                 | | ... (More user types) ...                                   | |
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

#### Screen: User Type Detail/Edit Form
*   **Purpose:** Create or modify a user type and assign permissions.
*   **Navigation:** Accessed by tapping "Add New" on the User Type List, or "Edit" next to an existing entry.
*   **Tablet Layout:**
    *   Field for User Type Name.
    *   List of `UserPermission`s with checkboxes to assign/revoke permissions for this user type.

##### User Type Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit User Type                [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Name: [ Manager                                           ] |
| [Emp Icon]  Employee Management |                               |
|                                 | --- Permissions ------------------------------------------- |
| [Rpt Icon]  Reporting & Analytics| [ ] Manage Menu Items                                       |
|                                 | [X] Process Sales                                           |
| [Conf Icon] Configuration       | [X] View Reports                                            |
|                                 | [ ] Manage Inventory                                        |
| [Cust Icon] Customer Management | [X] Clock In/Out                                            |
|                                 | [ ] Access System Settings                                  |
|                                 | [ ] Void Transactions                                       |
|                                 | [ ] Manage Users                                            |
|                                 | ... (More permissions) ...                                  |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

### 3.3. Time & Attendance

#### Screen: Attendance History
*   **Purpose:** View `AttendenceHistory` and `EmployeeInOutHistory` records.
*   **Navigation:** Accessible from the "Employee Management" section in the Main Dashboard, likely as a sub-item or tab.
*   **Tablet Layout:** Filterable list/table showing employee, clock-in/out times, and total hours.

##### Attendance History (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Attendance History            [Filter] |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search Employee...       ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Employee        Clock In            Clock Out       Hours | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | John Doe        2025-07-20 09:00 AM 2025-07-20 05:00 PM 8.0 | |
| [Conf Icon] Configuration       | | Jane Smith      2025-07-20 10:00 AM (Clocked In)      -   | |
|                                 | | Bob Johnson     2025-07-19 08:00 AM 2025-07-19 04:00 PM 8.0 | |
| [Cust Icon] Customer Management | | ... (More records) ...                                      | |
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

#### Screen: Shift Management
*   **Purpose:** View and manage `Shift`s.
*   **Navigation:** Accessible from the "Employee Management" section in the Main Dashboard, likely as a sub-item or tab.
*   **Tablet Layout:** List of shifts with start/end times and length. "Add New Shift" button.

##### Shift Management (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Shift Management              + |
|                                 |                               |
| [Inv Icon]  Inventory Management| [ Search...                ]    |
|                                 |                               |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | Shift Name      Start Time          End Time        Actions | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | Morning Shift   06:00 AM            02:00 PM        [Edit]| |
| [Conf Icon] Configuration       | | Lunch Shift     11:00 AM            07:00 PM        [Edit]| |
|                                 | | Dinner Shift    04:00 PM            12:00 AM        [Edit]| |
| [Cust Icon] Customer Management | | ... (More shifts) ...                                       | |
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

#### Screen: Shift Detail/Edit Form
*   **Purpose:** Create or modify a shift.
*   **Navigation:** Accessed by tapping "Add New" on the Shift Management List, or "Edit" next to an existing entry.
*   **Tablet Layout:** Fields for Name, Start Time, End Time, Shift Length.

##### Shift Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Shift                    [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Name: [ Morning Shift                                     ] |
| [Emp Icon]  Employee Management | Start Time: [ 06:00 AM                                    ] |
|                                 | End Time: [ 02:00 PM                                      ] |
| [Rpt Icon]  Reporting & Analytics| Shift Length: [ 8.0 hours                                 ] |
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

---

## 4. Reporting & Analytics

#### Screen: Reports Dashboard/Selection
*   **Purpose:** Central hub for accessing various reports.
*   **Navigation:** Accessible from the "Reporting & Analytics" section in the Main Dashboard.
*   **Tablet Layout:** List or grid of available reports (Sales, Cash Drawer, Tips, Action History, BI Reports). Tap to view a specific report.

##### Reports Dashboard/Selection (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Reports & Analytics           |
|                                 |                               |
| [Inv Icon]  Inventory Management| +-------------------------------------------------------------+ |
|                                 | | [Sales Icon] Sales Reports                                | |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | [Cash Icon] Cash Drawer Reports                           | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | [Tips Icon] Tips Reports                                  | |
| [Conf Icon] Configuration       | +-------------------------------------------------------------+ |
|                                 | | [Action Icon] Action History                                | |
| [Cust Icon] Customer Management | +-------------------------------------------------------------+ |
|                                 | | [BI Icon] Business Intelligence Reports                   | |
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

#### Screen: Generic Report View (e.g., Sales Report)
*   **Purpose:** Display data for a specific report.
*   **Navigation:** Accessed by selecting a report from the Reports Dashboard.
*   **Tablet Layout:**
    *   Top: Date range picker, filters (e.g., by user, terminal, item).
    *   Middle: Data visualization (charts for trends, tables for detailed data).
    *   Bottom: Export options (PDF, CSV).

##### Generic Report View (Tablet Wireframe - Sales Report)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Sales Report                  [Export] |
|                                 |                               |
| [Inv Icon]  Inventory Management| Date Range: [ 2025-07-01 ] to [ 2025-07-31 ] |
|                                 | Filters: [ All Users v ] [ All Terminals v ] |
| [Emp Icon]  Employee Management |                               |
|                                 | +-------------------------------------------------------------+ |
| [Rpt Icon]  Reporting & Analytics| | [Chart Area - e.g., Bar Chart of Daily Sales]               | |
|                                 | +-------------------------------------------------------------+ |
| [Conf Icon] Configuration       |                               |
|                                 | +-------------------------------------------------------------+ |
| [Cust Icon] Customer Management | | **Sales by Category**                                       | |
|                                 | | Category        Sales ($)   Items Sold                      | |
|                                 | | Main            1500.00     120                             | |
|                                 | | Drinks          500.00      250                             | |
|                                 | | Sides           300.00      100                             | |
|                                 | | ... (More data) ...                                         | |
|                                 | +-------------------------------------------------------------+ |
|                                 |                               |
|                                 | ... (Scrollable Table) ...                                      |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

#### Screen: Business Intelligence (BI) Report Configuration
*   **Purpose:** Configure custom BI reports (`BusinessIntelligence`).
*   **Navigation:** Accessible from the Reports Dashboard.
*   **Tablet Layout:** Form with fields for Report Name, Type, Description, Data Source, Query SQL, Parameters, Output Format, Schedule (Cron), Active status.

##### Business Intelligence (BI) Report Configuration (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | BI Report Configuration       [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Report Name: [ Daily Sales Summary                            ] |
| [Emp Icon]  Employee Management | Report Type: [ Custom SQL                                   v ] |
|                                 | Description: [ Summarizes daily sales data.                 ] |
| [Rpt Icon]  Reporting & Analytics| Data Source: [ POS Database                                  v ] |
|                                 | Query SQL: [ SELECT date, SUM(totalPrice) FROM Ticket GROUP BY date; ] |
| [Conf Icon] Configuration       | Parameters: [ (e.g., startDate, endDate)                    ] |
|                                 | Output Format: [ CSV                                         v ] |
| [Cust Icon] Customer Management | Schedule (Cron): [ 0 0 * * * (daily at midnight)             ] |
|                                 | [ Active ] [X]                                                  |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

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
+-----------------------------------------------------------------+
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
|                                 | | Bar Area         No          [Edit]                       | |
| [Cust Icon] Customer Management | | ... (More floor plans) ...                                  | |
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