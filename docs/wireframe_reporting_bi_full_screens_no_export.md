# 📊 Reporting & BI Wireframes – Full Screens (No Export, With View Descriptions)

Designed for tablet and mobile. Includes filters, KPIs, charts, tables — no export options.

---

## 🔸 Sales Intelligence

### 1. Sales by Category
```
📊 Sales by Category
---------------------------------------------------
[ 📅 Date Range ▼ ]   [ View Type ▼ ] 
---------------------------------------------------
View Type Options:
- Revenue (default): Total sales in $
- Quantity Sold: Total units per category
- % of Total Sales: Proportion of revenue
- Avg per Order: Avg order value per category
- Chart Style: Pie or Bar

💰 Total Sales: $13,800
🍽 Categories: 3

📊 Chart: Pie – % Sales by Category
- Food: 60%
- Drinks: 30%
- Dessert: 10%

📋 Table:
Category   | Orders | Sales    | % Share
-----------|--------|----------|---------
Food       | 182    | $8,280   | 60%
Drinks     | 140    | $4,140   | 30%
Dessert    | 45     | $1,380   | 10%
```

---

### 2. Top-Selling Items
```
🥇 Top-Selling Items
---------------------------------------------------
[ 📅 Date Range ▼ ]   [ Category ▼ ]
---------------------------------------------------

📊 Chart: Bar – Item vs Quantity

📋 Table:
Item           | Qty Sold | Revenue
---------------|----------|---------
Beef Burger    | 182      | $2,730
Iced Tea       | 165      | $660
Chicken Pasta  | 140      | $1,960
```

---

### 3. Least-Selling Items
```
💔 Least Selling Items
---------------------------------------------------
[ 📅 Date Range ▼ ]   [ Category ▼ ]
---------------------------------------------------

📋 Table:
Item             | Qty Sold | Revenue
-----------------|----------|---------
Vegan Pizza      | 4        | $48.00
Eggplant Salad   | 5        | $35.00
Kombucha Bottle  | 7        | $56.00
```

---

### 4. Hourly Sales Breakdown
```
🕒 Hourly Sales Breakdown
---------------------------------------------------
[ 📅 Day ▼ ]   [ Location ▼ ]
---------------------------------------------------

📊 Chart: Line – Hour vs Sales

📋 Table:
Hour      | Orders | Sales
----------|--------|---------
10:00 AM  |  6     | $120
12:00 PM  | 18     | $680
06:00 PM  | 35     | $1,240

Peak Hour: 6–7 PM
```

---

## 🔸 Labor & Shift Analytics

### 5. Labor Cost vs Sales Ratio
```
⏱ Labor vs Sales
---------------------------------------------------
[ 📅 Date Range ▼ ]   [ Role ▼ ]
---------------------------------------------------

💼 Labor Cost: $2,960
💰 Sales: $14,800
📉 Ratio: 20.0%

📊 Chart: Bar – Sales vs Labor

📋 Table:
Date       | Sales    | Labor Cost | Ratio
-----------|----------|------------|--------
2025-08-01 | $2,100   | $420       | 20%
2025-08-02 | $1,900   | $370       | 19%
```

---

### 6. Hours Worked per Staff
```
💼 Hours Worked per Staff
---------------------------------------------------
[ 📅 Month ▼ ]   [ Role ▼ ]
---------------------------------------------------

📊 Chart: Bar – Hours per User

📋 Table:
Employee  | Hours Worked
----------|---------------
John      | 162h
Jane      | 98h
Ali       | 45h
```

---

### 7. No-Shows / Late-ins
```
📉 Attendance Alerts
---------------------------------------------------
[ 📅 Week ▼ ]
---------------------------------------------------

📋 Table:
Date       | User  | Issue        | Time
-----------|--------|--------------|-------
2025-08-02 | Jane  | No Clock In  | —
2025-08-01 | Ali   | Late         | 10:15 AM
```

---

## 🔸 Inventory & Cost Insights

### 8. COGS Summary
```
🍽 Cost of Goods Sold
---------------------------------------------------
[ 📅 Date Range ▼ ]
---------------------------------------------------

💰 Sales: $18,900
💸 COGS:  $6,750
📈 Gross Margin: 64.3%

📊 Chart: Pie – Revenue vs Cost

📋 Table:
Category | Sales   | COGS    | Margin
---------|---------|---------|--------
Food     | $12,000 | $4,500  | 62.5%
Drinks   | $4,500  | $1,800  | 60%
Dessert  | $2,400  | $450    | 81.3%
```

---

### 9. Wastage / Spoilage Report
```
📦 Wastage Report
---------------------------------------------------
[ 📅 Date Range ▼ ]
---------------------------------------------------

📋 Table:
Date       | Item           | Qty   | Unit | Reason
-----------|----------------|-------|------|---------
2025-08-01 | Chicken Breast | 2.5   | kg   | Spoiled
2025-08-01 | Milk           | 4.0   | L    | Expired
```

---

### 10. Inventory Turnover
```
🔁 Inventory Turnover
---------------------------------------------------
[ 📅 Month ▼ ]
---------------------------------------------------

Avg Inventory: $4,000
COGS: $8,000
Rate: 2.0x

📊 Chart: Line – Month vs Turnover Rate
```

---

## 🔸 Payment Insights

### 11. Payment Method Breakdown
```
💳 Payment Breakdown
---------------------------------------------------
[ 📅 Date Range ▼ ]
---------------------------------------------------

📊 Chart: Pie – Payment Method %

📋 Table:
Method   | Amount   | % Share
---------|----------|---------
Cash     | $3,500   | 18%
Card     | $9,800   | 52%
QR Pay   | $5,200   | 30%
```

---

### 12. Avg Time to Close Ticket
```
⏳ Ticket Closure Time
---------------------------------------------------
[ 📅 Date Range ▼ ]
---------------------------------------------------

Avg: 4m 32s
Fastest: 1m 05s
Slowest: 17m 42s

📊 Chart: Bar – Orders vs Time to Close
```

---

### 13. Unpaid / Voided Orders
```
❗ Unpaid / Voided Orders
---------------------------------------------------
[ 📅 Date Range ▼ ]
---------------------------------------------------

📋 Table:
Order # | Amount | Status  | Reason
--------|--------|---------|----------------
ORD-103 | $75.00 | Voided  | Double Entry
ORD-107 | $42.00 | Unpaid  | Customer Left
ORD-109 | $66.00 | Voided  | Discount Error
```

### 14. Daily Summary Report 

```
📆 Daily Summary – 2025-08-02
---------------------------------------------------
[ 📅 Date ▼ ]

💰 Sales: $2,400.00
💵 Cash in Drawer: $680.00 (Start: $200)
💸 Labor Cost: $420.00
💳 Tips Paid: $76.00
📝 Voided Orders: 2   |  Discounts: 3

📋 Summary Table:
---------------------------------------------------
Metric            | Value
------------------|------------------
Gross Sales       | $2,400.00
Tax Collected     | $240.00
Net Sales         | $2,160.00
Labor % of Sales  | 17.5%
Tips Distribution | 3 Staff
No-Shows          | 1 (Jane)
---------------------------------------------------

```

### 14. Staff Performance Report

```
🧑‍🤝‍🧑 Staff Performance – This Week
---------------------------------------------------
[ 📅 Date Range ▼ ]   [ Role ▼ ]

📋 Table:
---------------------------------------------------
Staff   | Orders | Sales   | Avg Ticket | Tips
--------|--------|---------|------------|-------
John    | 45     | $2,100  | $46.67     | $82.00
Jane    | 38     | $1,640  | $43.15     | $55.00
Ali     | 20     | $920    | $46.00     | $21.00
---------------------------------------------------

Highlights:
🏅 Top Seller: John
💰 Most Tips: John

```

### 15. Void/Discount Reason Summary

```
📉 Voids & Discounts Summary – August
---------------------------------------------------
[ 📅 Month ▼ ]   [ Filter: All ▼ ]

📋 Table:
---------------------------------------------------
Reason                   | Type     | Count | Total Impact
-------------------------|----------|-------|---------------
Customer Changed Mind    | Void     | 23    | $475.00
Staff Mistake            | Void     | 18    | $330.00
Promo Code Applied       | Discount | 31    | $620.00
Manual Adjustment        | Discount | 12    | $240.00
---------------------------------------------------

🧠 Notes:
- Frequent staff mistakes? Consider training.
- Excessive promo codes? Audit discount policy.
```