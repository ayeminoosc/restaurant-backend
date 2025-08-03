## 1.3. Modifier Management

#### Screen: Modifier Group List
*   **Purpose:** View and manage `ModifierGroup`s.
*   **Navigation:** Accessible from the "Modifier Management" section in the Main Dashboard.
*   **Tablet Layout:** List of modifier groups. Each entry shows group name, and an "Edit" button/icon. "Add New Group" button.

##### Modifier Group List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Modifier Groups               + |
|                                 |                               |
| [Mod Icon]  Modifier Management | [ Search...                ]    |
|                                 |                               |
| [Inv Icon]  Inventory Management| +-------------------------------------------------------------+ |
|                                 | | Name                                                  Actions | |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
| [Rpt Icon]  Reporting & Analytics| | Cheese Options                                        [Edit]| |
|                                 | | Burger Toppings                                       [Edit]| |
| [Conf Icon] Configuration       | | Pizza Toppings                                        [Edit]| |
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
| [Mod Icon]  Modifier Management |                               |
|                                 | Name: [ Cheese Options                                    ] |
| [Inv Icon]  Inventory Management| Translated Name: [                                        ] |
|                                 |                               |
| [Emp Icon]  Employee Management | [ Enabled   ] [X]                                           |
| [Rpt Icon]  Reporting & Analytics| [ Exclusive ] [ ]                                           |
|                                 | [ Required  ] [ ]                                           |
| [Conf Icon] Configuration       |                               |
| [Cust Icon] Customer Management | --- Modifiers in this Group ------------------------------- |
|                                 | + Add Modifier                                              |
|                                 |   > Cheddar Cheese                                          |
|                                 |   > Swiss Cheese                                            |
|                                 |   > American Cheese                                         |
|                                 |                               |
|                                 | +---------------------------------------------------------+ |
|                                 | | **Select Modifiers**                                    | |
|                                 | | [ Search Modifiers...                                 ] | |
|                                 | |---------------------------------------------------------| |
|                                 | | [ ] Extra Cheese ($1.00)                                | |
|                                 | | [X] No Onions ($0.00)                                   | |
|                                 | | [ ] Add Bacon ($2.50)                                   | |
|                                 | | [ ] Gluten-Free Bun ($1.50)                             | |
|                                 | | [ ] Spicy Mayo ($0.75)                                  | |
|                                 | | ... (Scrollable List) ...                               | |
|                                 | |---------------------------------------------------------| |
|                                 | | [ Add Selected (2) ] [ Add New Modifier ] [ Cancel ]    | |
|                                 | +---------------------------------------------------------+ |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
|                                 |                               |
+-----------------------------------------------------------------+
```

#### Screen: Menu Modifier List
*   **Purpose:** View and manage individual `MenuModifier`s.
*   **Navigation:** Accessible from the "Modifier Management" section in the Main Dashboard, likely as a sub-item or tab.
*   **Tablet Layout:** List of menu modifiers. Each entry shows modifier name, price, and an "Edit" button/icon. "Add New Modifier" button.

##### Menu Modifier List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Menu Modifiers                + |
|                                 |                               |
| [Mod Icon]  Modifier Management | [ Search...                ]    |
|                                 |                               |
| [Inv Icon]  Inventory Management| +-------------------------------------------------------------+ |
|                                 | | Name                  Price                           Actions | |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
| [Rpt Icon]  Reporting & Analytics| | Extra Cheese          $1.00                           [Edit]| |
|                                 | | No Onions             $0.00                           [Edit]| |
| [Conf Icon] Configuration       | | Add Bacon             $2.50                           [Edit]| |
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
    *   Fields for Name, Translated Name, Price, Extra Price, Sort Order, Button Color, Text Color.
    *   Dropdown for associated Tax.
    *   Dropdown for `ModifierBehavior` selection.

##### Menu Modifier Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Menu Modifier            [Save] |
|                                 |                               |
| [Mod Icon]  Modifier Management |                               |
|                                 | Name: [ Extra Cheese                                      ] |
| [Inv Icon]  Inventory Management| Translated Name: [                                        ] |
| [Emp Icon]  Employee Management | Price: [ 1.00 ]   Extra Price: [ 0.00 ]                     |
| [Rpt Icon]  Reporting & Analytics|                               |
|                                 | Sort Order: [ 1 ]                                           |
| [Conf Icon] Configuration       | Button Color: [ #FFFFFF ]   Text Color: [ #000000 ]         |
| [Cust Icon] Customer Management |                               |
|                                 | Tax: [ Food Tax                                         v ] |
|                                 | Modifier Behavior: [ Standard                             v ] |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

#### Screen: Modifier Behavior List
*   **Purpose:** View and manage `ModifierBehavior`s.
*   **Navigation:** Accessible from the "Modifier Management" section in the Main Dashboard, likely as a sub-item or tab.
*   **Tablet Layout:** List of modifier behaviors. Each entry shows name, display text, and actions.

##### Modifier Behavior List (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Modifier Behaviors            + |
|                                 |                               |
| [Mod Icon]  Modifier Management | [ Search...                ]    |
|                                 |                               |
| [Inv Icon]  Inventory Management| +-------------------------------------------------------------+ |
|                                 | | Name        Display Text    Price Adj. Type   Actions     | |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
| [Rpt Icon]  Reporting & Analytics| | No          No              NONE              [Edit]      | |
|                                 | | Extra       Extra           ADD_AMOUNT        [Edit]      | |
| [Conf Icon] Configuration       | | Side        Side of         NONE              [Edit]      | |
| [Cust Icon] Customer Management | | Light       Light           NONE              [Edit]      | |
|                                 | | ... (More behaviors) ...                                    | |
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

#### Screen: Modifier Behavior Detail/Edit Form
*   **Purpose:** Create or modify a `ModifierBehavior`.
*   **Navigation:** Accessed by tapping "Add New" on the Modifier Behavior List, or "Edit" next to an existing entry.
*   **Tablet Layout:** Form with fields for Name, Display Text, Price Adjustment Type, Default Price Adjustment, Kitchen Instruction Flag, Is Mutually Exclusive, Display Order, Is Active.

##### Modifier Behavior Detail/Edit Form (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Edit Modifier Behavior        [Save] |
|                                 |                               |
| [Mod Icon]  Modifier Management |                               |
|                                 | Name: [ Extra                                             ] |
| [Inv Icon]  Inventory Management| Display Text: [ Extra                                     ] |
| [Emp Icon]  Employee Management | Price Adjustment Type: [ ADD_AMOUNT                     v ] |
| [Rpt Icon]  Reporting & Analytics| Default Price Adjustment: [ 0.00                          ] |
|                                 |                               |
| [Conf Icon] Configuration       | [ Kitchen Instruction Flag ] [X]                            |
| [Cust Icon] Customer Management | [ Is Mutually Exclusive    ] [ ]                            |
|                                 | [ Is Active                ] [X]                            |
|                                 | Display Order: [ 1 ]                                        |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```