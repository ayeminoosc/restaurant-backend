Step 1
--------
```
┌────────────────────────────────────────────────────────────┐
│ ⬤ Main     ◯ Patio     ◯ Bar                               │ ← Floor selector tabs (top center) 
├────────────────────────────────────────────────────────────┤
│    [All Order] [Pending] [Opened] [Closed]
                                                      │
│   [ Table 1 ]  [ Table 2 🧑‍🤝‍🧑 ]  [ Table 3 🧑‍🤝‍🧑 ]         │
│                                                            │
│   [ Table 4 ]  [ Table 5 ]     [ Table 6 🧑‍🤝‍🧑 ]            │
│                                                            │
│   [ Table 7 ]  [ Table 8 ]     [ Table 9 ]                 │
│                                                            │
│   [ Table 10 🧑‍🤝‍🧑 ]                                     │
│                                                            │
│  (🟩 = Vacant, 🔴 = Occupied / 🧑‍🤝‍🧑 for visual hint)         │
├────────────────────────────────────────────────────────────┤
│  ⬜ Logout   ⬛ Table ⬜ Menu ⬜ Orders                  │ ← Bottom tabs
│                                                            │
└────────────────────────────────────────────────────────────┘
```


step - 2

```
┌────────────────────────────────────────────┐
│         🍽️ Choose the Number of Guests     │ ← Title
├────────────────────────────────────────────┤
│                                            │
│          Number of Guests = 3              │ ← Display selected number
│                                            │
│   [ 1 ]  [ 2 ]  [ 3 ]  [ 4 ]  [ 5 ]         │ ← Buttons row 1
│                                            │
│   [ 6 ]  [ 7 ]  [ 8 ]  [ 9 ]  [ 10 ]        │ ← Buttons row 2
│                                            │
│   [ ⬅ Back ]        [ 🗑 Delete ]           │ ← Action buttons
│                                            │
└────────────────────────────────────────────┘
```

step - 3
```
+---------------------------------------------------+
| [ Main Courses ]   [ Appetizer ]   [ Beverages ]  |
|                                                   |
| +---------------------------------------------+   |
| |               Popular Dishes                 |   |
| |                                             |   |
| |  [Steak]  [Dish Button 2]  [Dish Button 3]  |   |
| |  [Dish Button 4]  [Dish Button 5]            |   |
| +---------------------------------------------+   |
|                                                   |
| Selected Item: Steak                              |
|                                                   |
| Size:                                             |
| [ Small - $10 ]  [ Medium - $15 ]  [ Large - $20 ]|
| ------------------------------------------------  |
| Temperature (required):                           |
| [ Rare ]  [ Medium ]  [ Well Done ]               |
| ------------------------------------------------  |
| [ No ]  [ Extra ]  [ Less ]  [ On Side ]          |
| ------------------------------------------------  |
| Add-ons:                                          |
| [ Sauce ]  [ Tomato ]  [ Lettuce ]  [ Cheese ]    |
+---------------------------------------------------+
|  [Take Away(Parcel)]		    		
|====================================================
On the right side
```


```
| Name                      | Qty | Each  | Total  |
|---------------------------|-----|-------|--------|
| American Steak (L)         |  1  | $20   | $20    |
|   - Less salt              |     |       |        |
|   - Tomato on Side         |     |       |        |
|   - Extra cheese           |     | +$2   | +$2    |
|---------------------------|-----|-------|--------|
|                           |     |       | $22    |
+---------------------------+-----+-------+--------+
 [ Send to Kitchen ]  [ Hold Order ]  [ Cancel Order ]  [ Pay ]

```


```
+------------------------------------------------------------+
|                       PAYMENT SCREEN                       |
+------------------------------------------------------------+

Items:
--------------------------------------------------------------
| Item                        | Qty | Price   | Total        |
|----------------------------|-----|---------|--------------|
| American Steak (L)         |  1  |  $20.00 |   $20.00     |
| Extra Cheese               |  1  |   $2.00 |    $2.00     |
| Soft Drink                 |  1  |   $3.00 |    $3.00     |
--------------------------------------------------------------
| Subtotal:                                 |    $25.00     |
--------------------------------------------------------------
| Discount (10%):                           |   -$2.50      |
| Service Charge (5%):                      |   +$1.13      |
| Tip:                                      |   +$3.00      |
--------------------------------------------------------------
| TOTAL:                                    |   **$26.63**  |
+------------------------------------------------------------+

[ Discount ]   [ Tip ]   [ Split Bill ]   [ Pay with Cash ]
[ Member Card ]   [ KPay ]
```


```
+------------------------------------------------------+
|                   CASH PAYMENT                       |
+------------------------------------------------------+
| Order Total:                                800 MMK  |
|                                                  🧾   |
| Received Amount:                         [ 1000  ]   |
|                                                  💵   |
| Change:                                    200 MMK   |
+------------------------------------------------------+

Quick Cash Buttons:
[ 1000 MMK ]   [ 2000 MMK ]   [ 5000 MMK ]   [ 10000 MMK ]

[ Cancel ]                            [ Confirm Payment ]
+------------------------------------------------------+

```


Order screen version 1

```
+---------------------------------------------------------------+
|                          ORDER SCREEN                         |
+---------------------------------------------------------------+

Filters:
[ 📅 Date ▼ ]   [ 👤 User ▼ ]   [ 📄 Status ▼ ]   [ 💳 Payment ▼ ]   [ 🔍 Search ]

Date:     [ Today ▼ ]  [ ⬇️ Calendar ]  
User:     [ All | Waiter A | Waiter B | Cashier ]  
Status:   [ All | Paid | Pending | Cancelled ]  
Payment:  [ All | Cash | Card | KPay | Member Card ]
```

```
-----------------------------------------------------------------------
| Order No | Date & Time       | User     | Status   | Total | Paid By |
|----------|-------------------|----------|----------|-------|---------|
| #A0123   | 30 Jul 2025 14:22 | Cashier1 | ✅ Paid   | 22,000| Cash    |
| #A0124   | 30 Jul 2025 14:30 | WaiterA  | ⏳ Pending| 18,500| -       |
| #A0125   | 30 Jul 2025 14:35 | WaiterB  | ❌ Cancel | 12,000| -       |
| #A0126   | 30 Jul 2025 14:50 | Cashier1 | ✅ Paid   | 45,000| KPay    |
-----------------------------------------------------------------------

[ View Order ]   [ Cancel Order ]   [ Refund ]   [ Reprint Receipt ]
```

Order Screen Version 2

```
+-------------------------------------------------------------+
|                        🧾 Orders (Today)                    |
+-------------------------------------------------------------+

[ 📅 Date ▼ ]   [ 👤 User ▼ ]   [ 🧾 Status ▼ ]   [ 💳 Payment ▼ ]   [ 🔍 Search ]

+-----------------------------+   +-----------------------------+
| Order #: A0123              |   | Order #: A0124              |
| Time: 14:22                 |   | Time: 14:30                 |
| User: Cashier1              |   | User: WaiterA               |
| Status: ✅ Paid             |   | Status: ⏳ Pending          |
| Total: 22,000 MMK           |   | Total: 18,500 MMK           |
| Payment: Cash               |   | Payment: -                  |
|                             |   |                             |
| [ View ] [ Reprint ] [ Refund ] | [ View ] [ Send to Kitchen ] [ Cancel ]
+-----------------------------+   +-----------------------------+

+-----------------------------+   +-----------------------------+
| Order #: A0125              |   | Order #: A0126              |
| Time: 14:35                 |   | Time: 14:50                 |
| User: WaiterB               |   | User: Cashier1              |
| Status: ❌ Cancelled        |   | Status: ✅ Paid             |
| Total: 12,000 MMK           |   | Total: 45,000 MMK           |
| Payment: -                  |   | Payment: KPay               |
|                             |   |                             |
| [ View ]                    |   | [ View ] [ Refund ]         |
+-----------------------------+   +-----------------------------+

Pagination: ◀ 1 2 3 ▶

```

Oder Screen Version 3

```
+------------------------------------------------------------------+
|                            ORDER SCREEN                          |
+------------------------------------------------------------------+

Filters:
[ Date 📅 ]   [ User ▼ ]   [ Status ▼ ]   [ Payment Type ▼ ]   [ Search 🔍 ]

• Date: Select from calendar (e.g., Today, Yesterday, Custom Range)  
• User: Waiter A, Waiter B, Cashier, Admin, etc.  
• Status: [ All | Paid | Pending | Cancelled ]  
• Payment Type: [ All | Cash | Card | KPay | Member Card ]

--------------------------------------------------------------------
| Order No | Date & Time       | User     | Status   | Total | Paid By |
|----------|-------------------|----------|----------|-------|---------|
| #A0123   | 30 Jul 2025 14:22 | Cashier1 | Paid     | 22,000| Cash    |
| #A0124   | 30 Jul 2025 14:30 | WaiterA  | Pending  | 18,500| -       |
| #A0125   | 30 Jul 2025 14:35 | WaiterB  | Cancelled| 12,000| -       |
| #A0126   | 30 Jul 2025 14:50 | Cashier1 | Paid     | 45,000| KPay    |
--------------------------------------------------------------------

[ View Order ]   [ Refund ]   [ Reprint Receipt ]   [ Cancel Order ]

```

```
------------------------------------------------------------+
|                         ORDER DETAILS                       |
+-------------------------------------------------------------+

Order No: #A0123
Date: 30 Jul 2025, 14:22
Handled By: Cashier1
Status: Paid
Payment Method: Cash

Items Ordered:
-------------------------------------------------------------
| Item                   | Qty | Price    | Total            |
|------------------------|-----|----------|------------------|
| American Steak (Large) |  1  | $20.00   | $20.00           |
|   - Less salt          |     |          |                  |
|   - Tomato on Side     |     |          |                  |
|   - Extra cheese       |     | +$2.00   | +$2.00           |
| Soft Drink             |  2  | $3.00    | $6.00            |
-------------------------------------------------------------
Subtotal:                                          $28.00
Service Charge (5%):                               $1.40
Tip:                                               $3.00
-------------------------------------------------------------
TOTAL:                                             $32.40

Notes:
- Customer requested extra napkins.
- No onions on the side salad.

[ Close ]   [ Print Receipt ]   [ Refund ]   [ Cancel Order ]
```


```
+--------------------------------------------+
|             CANCEL ORDER?                   |
+--------------------------------------------+
Order No: #A0123
Status: Pending

Are you sure you want to cancel this order?
This action cannot be undone.

Reason for cancellation:  
[______________________________]  (text input)

[ Cancel ]               [ Confirm Cancel ]
```


```
+-------------------------------------------------+
|                    REFUND ORDER                  |
+-------------------------------------------------+
Order No: #A0123
Status: Paid
Total Paid: $32.40

Select items to refund:
-------------------------------------------------
| [x] American Steak (Large)       $22.00        |
|     - Less salt                                  |
|     - Tomato on Side                             |
|     - Extra cheese        +$2.00                 |
| [ ] Soft Drink (2x)             $6.00           |
-------------------------------------------------

Refund Amount: $22.00

Reason for refund:  
[______________________________]  (text input)

[ Cancel ]               [ Process Refund ]
```


Sale Summary

```
┌──────────────────────────────────────────────────────────────┐
│                     🗓️  Sales Summary - Today                │
│    Date: 2025-07-30           Time: 10:00 AM - 10:00 PM       │
├──────────────────────────────────────────────────────────────┤
│ Total Orders:                           128                  │
│ Total Sales:                          1,520,000 Ks           │
│ Net Sales (After Discounts):          1,420,000 Ks           │
│ Total Discount Given:                   100,000 Ks           │
│ Total Tips:                              45,000 Ks           │
│ Total Service Charges:                  75,000 Ks            │
│ Tax (5%):                                71,000 Ks            │
│ ------------------------------------------------------------ │
│ **Gross Revenue:**                   1,611,000 Ks            │
├──────────────────────────────────────────────────────────────┤
│ 🔍 Breakdown by Payment Type                                 │
│     - Cash:                         700,000 Ks               │
│     - Card:                         450,000 Ks               │
│     - KPay:                         300,000 Ks               │
│     - MemberCard:                   81,000 Ks                │
├──────────────────────────────────────────────────────────────┤
│ 🔍 Breakdown by Staff/User                                   │
│     - Waiter A:                     550,000 Ks (38 orders)   │
│     - Waiter B:                     480,000 Ks (35 orders)   │
│     - Cashier A:                    490,000 Ks (55 orders)   │
├──────────────────────────────────────────────────────────────┤
│ 🔍 Order Status Summary                                     │
│     - Paid Orders:                 122                       │
│     - Voided Orders:               3                         │
│     - Refunded/Returned:           2                         │
│     - Cancelled Orders:            1                         │
├──────────────────────────────────────────────────────────────┤
│ 🔘 [ View Details ]   [ Export CSV ]   [ Print Summary ]      │
└──────────────────────────────────────────────────────────────┘
```

Category Summary

```
┌──────────────────────────────────────────────────────────────┐
│                   🍽️  Category Sales Summary                 │
│   Date: 2025-07-30         Time: 10:00 AM - 10:00 PM          │
├──────────────────────────────────────────────────────────────┤
│ Category         | Qty Sold | Net Sales   | % of Total Sales │
├──────────────────────────────────────────────────────────────┤
│ Main Courses     |   184    |  820,000 Ks |       57.8%      │
│ Appetizers       |    92    |  210,000 Ks |       14.8%      │
│ Beverages        |   140    |  250,000 Ks |       17.6%      │
│ Desserts         |    60    |  115,000 Ks |        8.1%      │
│ Others           |    10    |   25,000 Ks |        1.7%      │
├──────────────────────────────────────────────────────────────┤
│ Total            |   486    | 1,420,000 Ks |      100%       │
├──────────────────────────────────────────────────────────────┤
│ 🔘 [ View by Item ]   [ Export CSV ]   [ Print Summary ]      │
└──────────────────────────────────────────────────────────────┘
```

Item Sales

```
┌────────────────────────────────────────────────────────────────────┐
│                     🧾 Item Sales Report - Today                   │
│   Date: 2025-07-30         Time: 10:00 AM – 10:00 PM               │
├────────────────────────────────────────────────────────────────────┤
│ Item Name             | Category     | Qty Sold | Net Sales       │
├────────────────────────────────────────────────────────────────────┤
│ American Steak (L)    | Main Courses |   36     |  720,000 Ks      │
│ Chicken Nuggets       | Appetizers   |   28     |   84,000 Ks      │
│ Beef Burger           | Main Courses |   22     |  198,000 Ks      │
│ French Fries          | Appetizers   |   40     |   60,000 Ks      │
│ Pepsi (Can)           | Beverages    |   50     |   75,000 Ks      │
│ Iced Lemon Tea        | Beverages    |   35     |   63,000 Ks      │
│ Mango Pudding         | Desserts     |   20     |   50,000 Ks      │
├────────────────────────────────────────────────────────────────────┤
│ Total Items Sold: 231           | Total Net Sales: 1,250,000 Ks   │
├────────────────────────────────────────────────────────────────────┤
│ 🔍 Filters: [Date Range] [Category] [Staff] [Shift]                │
│ 🔘 [ Export CSV ]   [ Print Summary ]   [ View by Modifiers ]      │
└────────────────────────────────────────────────────────────────────┘
```


Cash Management

```
┌──────────────────────────────────────────────────────┐
│               💵 CASH MANAGEMENT                     │
│ Date: 2025-07-30    Shift: Morning                   │
├──────────────────────────────────────────────────────┤

Starting Cash (Opening Float):           50,000 Ks
--------------------------------------------------------
Cash Sales Total:                      320,000 Ks
Other Cash Inflows:                     10,000 Ks
--------------------------------------------------------
Total Cash In:                        380,000 Ks

Cash Outflows:
 - Refunds/Payouts:                    15,000 Ks
 - Petty Cash / Supplies:              20,000 Ks
--------------------------------------------------------
Total Cash Out:                       35,000 Ks

Expected Cash in Drawer:              345,000 Ks

--------------------------------------------------------
Counted Cash in Drawer:               [_________] Ks  (input)

Cash Difference:                     [Calculated] Ks
--------------------------------------------------------

[ Add Cash Inflow ]   [ Add Cash Outflow ]   [ Close Shift ]
```


Sample UI for Add Cash Inflow:
markdown
Copy
Edit
```
+-----------------------------------+
|         ADD CASH INFLOW            |
+-----------------------------------+
Amount (Ks):          [__________]  
Reason:               [____________________________]  
[ Cancel ]          [ Confirm Add ]
```

Sample UI for Add Cash Outflow:
markdown
Copy
Edit
```
+-----------------------------------+
|         ADD CASH OUTFLOW           |
+-----------------------------------+
Amount (Ks):          [__________]  
Reason:               [____________________________]  
[ Cancel ]          [ Confirm Deduct ]
Optional Enhancements:
Preset buttons for common amounts (e.g., 5,000 Ks, 10,000 Ks) for faster input.
```

Date	User	Type	Amount	Reason
2025-07-30	Cashier1	Inflow	10,000 Ks	Petty cash replenishment
2025-07-30	Cashier1	Outflow	5,000 Ks	Refund order #A1005
2025-07-30	Manager	Outflow	20,000 Ks	Cash drop to safe













