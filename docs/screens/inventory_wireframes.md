# aInventory Management Wireframes (Tablet + Mobile Friendly)

All screens are designed for both tablet and mobile usage, with mobile layouts using collapsible rows and single-column stacks when needed.

---

## 📊 1. Inventory Dashboard

**Tablet Layout:**

```
+------------------------------------------------------------------+
| Inventory Dashboard                                              |
+------------------------------------------------------------------+
| Summary:                                                        |
| - Total Items: 187     |  Vendors: 12     |  Warehouses: 3       |
+------------------------------------------------------------------+
| 🔔 Stock Alerts:                                                 |
| ---------------------------------------------------------------- |
| - Ground Beef below reorder level (3 lbs remaining)              |
| - Flour near zero stock (1 kg remaining)                         |
| - Cheese at critical level (0.5 kg remaining)                    |
| ---------------------------------------------------------------- |
| [ View All Items ]  [ Adjust Stock ]                             |
+------------------------------------------------------------------+
```

**Mobile Layout:**

```
📊 Inventory Summary
---------------------
Items:     187
Vendors:   12
Warehouses: 3

🔔 Stock Alerts
---------------------
⚠ Ground Beef: 3 lbs
⚠ Flour: 1 kg
⚠ Cheese: 0.5 kg

[ View Items ] [ Adjust Stock ]

```

---

## 🛋️ 2. Inventory Item List

**Tablet Layout:**

```
+----------------------------------------------------------------------------------+
| Inventory Items                                        [ Search... ] [ Filter ▼ ]|
+----------------------------------------------------------------------------------+
| Name            | Stock | Unit | Reorder | Vendor        | Actions              |
|-----------------|--------|------|---------|----------------------------|--------|
| Ground Beef     |   3    | lbs  |   5     | Local Farm    | [Edit] [Adjust]     |
| Flour (AP)      |   1    | kg   |  10     | Sysco         | [Edit] [Adjust]     |
| Tomatoes        |  25    | pcs  |  10     | Farm Direct   | [Edit] [Adjust]     |
| Milk            |   8    | gal  |   5     | Dairy Co.     | [Edit] [Adjust]     |
+----------------------------------------------------------------------------------+
| Showing 1–20 of 187 items      [ ◀ Prev ]  [ Next ▶ ]                            |
+----------------------------------------------------------------------------------+
```

**Mobile Layout:**

```
+-----------------------------+
| 🥩 Ground Beef              |
| -------------------------- |
| Stock:      3 lbs          |
| Reorder At: 5              |
| Vendor:     Local Farm     |
|                             |
| [ Edit ]       [ Adjust ]   |
+-----------------------------+

+-----------------------------+
| 🌾 Flour (AP)               |
| -------------------------- |
| Stock:      1 kg           |
| Reorder At: 10             |
| Vendor:     Sysco          |
|                             |
| [ Edit ]       [ Adjust ]   |
+-----------------------------+

```

---

## 📄 3. Inventory Item Detail / Edit

**Tablet Layout:**

```
+------------------------------------------------------------+
| Edit Inventory Item                                        |
+------------------------------------------------------------+
| Name:            [ Ground Beef                          ]  |
| Description:     [ Premium ground beef...              ]  |
| Barcodes:        Package: [1234567]  Unit: [2345678]      |
| Unit/Package:    [1.00]     Unit: [ lbs ▼ ]                 |
|------------------------------------------------------------|
| Reorder Level:   [5]      Replenish: [15]                 |
| Avg Price:       [6.50]   Purchase Price: [5.00]          |
| Selling Price:   [9.50]                                    |
|------------------------------------------------------------|
| Group: [Meats ▼]  Location: [Cold Storage ▼]             |
| Vendor: [Local Farm ▼]  Warehouse: [Main ▼]             |
|------------------------------------------------------------|
| [ ☑ Visible ]                                            |
| [ Save ]   [ Delete ]                                      |
+------------------------------------------------------------+
```

**Mobile Layout:**

```
📝 Edit Inventory Item
-----------------------------
Name:           Ground Beef
Unit:           lbs
Barcode:        1234567

📦 Stock Settings
-----------------------------
Reorder Level:   5
Replenish Level: 15

💰 Pricing
-----------------------------
Avg Price:       $6.50
Purchase Price:  $5.00
Selling Price:   $9.50

🏷️ Classification
-----------------------------
Group:           Meats
Vendor:          Local Farm
Warehouse:       Main

🔘 Actions
-----------------------------
[ Save ]   [ Delete ]

```

---

## 🍽️ 4. Recipe Builder (May not be needed - think more detail)

**Tablet Layout:**

```
+------------------------------------------------------------+
| Recipe Editor: Burger Deluxe                               |
+------------------------------------------------------------+
| Ingredient          | Qty   | Unit  | Deduct from Stock? |  |
|---------------------|-------|--------|----------------------|
| Ground Beef         | 0.25  | lbs    | [☑]                |
| Burger Bun          | 1     | unit   | [☑]                |
| Lettuce             | 0.05  | lbs    | [☑]                |
+------------------------------------------------------------+
| Total Ingredient Cost: $2.85   Estimated Margin: 78%       |
+------------------------------------------------------------+
| [ + Add Ingredient ]   [ Save Recipe ]                     |
+------------------------------------------------------------+
```

**Mobile Layout:**

```
🍔 Burger Deluxe
---------------------
🧾 Ingredients
- Ground Beef | 0.25 lbs | ☑
- Bun         | 1 unit   | ☑
- Lettuce     | 0.05 lbs | ☑

💰 Cost: $2.85   Margin: 78%
[ + Add Ingredient ]
[ Save Recipe ]
```

---

## 📜 5. Inventory Transaction Log

**Tablet Layout:**

```
+--------------------------------------------------------------------------------+
| Inventory Transactions                                   [ Filter ▼ ] [ ⟳ ]    |
+--------------------------------------------------------------------------------+
| Date & Time         | Item         | Type   | Qty   | Source              |
|---------------------|--------------|--------|--------|---------------------|
| 2025-08-02 09:14 AM | Ground Beef  | OUT    | 0.25  | Recipe: Burger      |
| 2025-08-01 03:00 PM | Milk         | IN     | 10.0  | Manual Adjustment   |
| 2025-08-01 02:15 PM | Cheese       | OUT    | 0.20  | Recipe: Pizza       |
+--------------------------------------------------------------------------------+
| [ Export CSV ]   [ View Item Detail ]                                         |
+--------------------------------------------------------------------------------+
```

**Mobile Layout:**

```
📋 Inventory Transactions
-------------------------
📅 2025-08-02 09:14 AM
Item: Ground Beef
Qty: 0.25 OUT
Source: Recipe: Burger

📅 2025-08-01 03:00 PM
Item: Milk
Qty: 10.0 IN
Source: Manual Adjustment

[ Export CSV ]

```

---

## 👉 Adjust Stock Modal (Opened from Item List)

**All Devices:**

```
+----------------------------------------------------+
| Adjust Stock: Ground Beef                         ✕ |
+----------------------------------------------------+
| Current Stock: 3 lbs                               |
|----------------------------------------------------|
| Adjustment Type:   (•) Add to Stock                |
|                   ( ) Subtract from Stock          |
|                                                    |
| Quantity:        [     2.0      ] lbs              |
|                                                    |
| Reason:          [ Spoilage ▼ ]                    |
| Notes:           [ e.g. Catering Event           ]  |
|                                                    |
| [ Cancel ]                             [ Apply ]   |
+----------------------------------------------------+
```

---

## 🛠️ Final Final Design: Receive Inventory Screen (Clean + Accurate)

### 🖥️ Tablet Layout:

```
+------------------------------------------------------------+
| 📥 Receive Inventory                                        |
+------------------------------------------------------------+
| 📅 Date:         [ 2025-08-02 ▼ ]                          |
| 🧾 Voucher No.:  [ RCV-00017           ]                   |
| 🏢 Vendor:       [ Sysco Foods ▼ ]                         |
| 🗒️ Order Note:   [ Weekly restock delivery           ]     |
+------------------------------------------------------------+
| 🧾 Items Received                                          |
|------------------------------------------------------------|
| [ + Add Item ▼ ]                                          |
|------------------------------------------------------------|
| Item ▼        | Qty     | Unit    | Cost/Unit             |
|---------------|---------|---------|------------------------|
| [Flour     ▼] | [  20 ] |  kg     | [ 1.40 ]               |
| [Beef      ▼] | [  10 ] |  kg     | [ 6.50 ]               |
| [CheeseBox▼] | [   2 ] |  box    | [12.00 ]               |
+------------------------------------------------------------+
| [ Cancel ]                          [ Receive & Save ]     |
+------------------------------------------------------------+
```

### Mobile Layout

```
📥 Receive Inventory
-----------------------------
📅 Date: [ 2025-08-02 ▼ ]
🧾 Voucher No.: [ RCV-00017 ]
🏢 Vendor: [ Sysco Foods ▼ ]
🗒️ Order Note:
[ Weekly restock delivery ]

📦 Items Received
-----------------------------
[ + Add Item ▼ ]

Item 1
-----------------------------
Item:        [ Flour ▼ ]
Quantity:    [ 20 ]
Unit:        kg (readonly)
Cost/Unit:   [ 1.40 ]

Item 2
-----------------------------
Item:        [ Beef ▼ ]
Quantity:    [ 10 ]
Unit:        kg (readonly)
Cost/Unit:   [ 6.50 ]

Item 3
-----------------------------
Item:        [ CheeseBox ▼ ]
Quantity:    [ 2 ]
Unit:        box (readonly)
Cost/Unit:   [ 12.00 ]

-----------------------------
[ Cancel ]     [ Receive & Save ]

```
