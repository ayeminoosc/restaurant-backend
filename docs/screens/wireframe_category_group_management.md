## 1.2. Category & Grouping

#### Screen: Categories/Groups Management (Tree View with Detail Panel)
*   **Purpose:** Provides a hierarchical view and management interface for all categories and groups, allowing for easy navigation and creation of nested structures.
*   **Navigation:** Accessible directly from the "Category & Grouping" menu item in the Main Dashboard's left sidebar.
*   **Tablet Layout:** The main content area will be divided into two distinct panels: a Tree View on the left and a Detail/Edit Form on the right.

    *   **Left Panel (Tree View):**
        *   Displays all top-level categories and groups.
        *   Each item can be expanded (`+`) or collapsed (`-`) to reveal or hide its sub-categories/nested groups.
        *   A search bar at the top of the tree allows filtering the entire hierarchy.
        *   An "Add New Top-Level" button would be available here.
        *   Selecting an item in the tree will populate the Detail/Edit Form on the right.

    *   **Right Panel (Detail/Edit Form):**
        *   Displays the detailed form for the category or group currently selected in the Tree View.
        *   This form will be used for editing existing items.
        *   When adding a new item (either top-level or child), this panel would switch to a blank form for creation.
        *   Includes fields like Name, Translated Name, Type (Category/Group - pre-filled or selectable based on context), Visibility, Sort Order, Button Color, Text Color, and the "Parent Category/Group" (which would be read-only and reflect the selected parent in the tree).
        *   An "Add Child" button would appear when a parent is selected in the tree, allowing creation of a sub-category or nested group.

##### Categories/Groups Management (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Categories/Groups Management                                  |
|                                 |                               |
| [Cat Icon]  Category & Grouping | +---------------------------+ +-----------------------------+ |
|                                 | | **Category/Group Tree**   | | **Details**                 | |
| [Inv Icon]  Inventory Management| | [ Search...           ]   | |                             | |
|                                 | | [Add Top-Level]           | | Name: [                     ] | |
| [Emp Icon]  Employee Management | |---------------------------| | Type: [ ( ) C ] [ ( ) G ]   | |
|                                 | | - Main Category           | | Parent: [ (Read-only)       ] | |
| [Rpt Icon]  Reporting & Analytics| |   + Item Configuration    | | Sort: [   ]                 | |
|                                 | |   + Drinks                | | Color: [ #FFF ]             | |
| [Conf Icon] Configuration       | | - Food Group              | | Text: [ #000 ]              | |
| [Cust Icon] Customer Management | |   - Burgers               | | [ Visible ] [X]             | |
|                                 | |     + Classic Burger      | | [ Beverage ] [ ]            | |
|                                 | |     + Veggie Burger       | |                             | |
|                                 | |   + Sides                 | | [Add Child]                 | |
|                                 | |   + Desserts              | |                             | |
|                                 | | + Beverages               | | --------------------------- | |
|                                 | | + Promotions              | | [ Save ] [ Delete ]         | |
|                                 | | ... (Scrollable Tree) ... | |                             | |
|                                 | +---------------------------+ +-----------------------------+ |
+-----------------------------------------------------------------+
```