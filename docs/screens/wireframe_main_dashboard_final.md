


# 🧭 Main Dashboard Wireframes (Tablet + Mobile Friendly)

Dashboards are role-based and adapt to the logged-in user's permissions. All screens are responsive and simplified for clarity in v1.

### Dashboard Responsibilities (Role-Based)

| Role        | Dashboard Focus                                |
| ----------- | ---------------------------------------------- |
| **Owner**   | High-level KPIs, access to reports/settings    |
| **Manager** | Staff/shift controls, inventory, sales alerts  |
| **Cashier** | Quick access to POS, clock-in, orders, drawer  |
| **Waiter**  | Only QR/order list or KDS view (if applicable) |


#### 📌 Dashboard Should Contain:
##### For Owner/Manager:
* 📈 KPIs: Today’s Sales, Orders, Tips, Avg Order
* 🔔 Stock Alerts
* 🧾 Recent Activity Log (Voids, Discounts, Drawer Events)
* 📊 Shortcut buttons: Reports, Inventory, Staff, Menu

##### For Cashier:
* 👤 Clock In/Out
* 💵 Cash Drawer Status
* 🧾 Start New Order / Open POS
* 🔐 End Shift or Logout

---

## 👑 Owner / Manager Dashboard

```
🧭 Dashboard – Owner
--------------------------------------------------
📅 [ Today ▼ ]   [ Location ▼ ]

📊 KPIs:
- 💰 Sales: $2,880.00  ↑ 5% vs yesterday
- 🧾 Orders: 64        ↑ 3 orders
- 💳 Tips: $172.00     ↓ 8% vs yesterday
- 🧺 Avg Order: $45.00

📈 Sales Trend – Today
[ Line Chart: hourly sales curve ]

👥 Clocked-in Staff (3)
- John (Cashier) – since 9:00 AM
- Jane (Waiter) – since 10:05 AM
- Ali (Waiter) – since 11:30 AM

🔔 Inventory Alerts:
- Cheese < 1kg
- Ground Beef low (3 lbs)

📝 Recent Activity:
- 2:14 PM – John voided item "Pizza"
- 12:05 PM – Jane clocked in
- 11:40 AM – Promo discount 20%

🔗 Quick Access:
[ Reports ] [ Inventory ] [ Staff ] [ Menu ]

```

---

## 👤 Cashier Dashboard (No Drawer Support)

```
🧭 Dashboard – Cashier
--------------------------------------------------
👤 Logged in: John (Cashier)

🕒 Clocked In: 09:00 AM (⏱ 5h 22m session)
📈 Today's Sales: $620.00  ↑ 8% vs yesterday
🧾 Orders Taken: 22        ↑ 3 orders

📝 Last Activity:
- 2:14 PM – Voided Pizza (ORD-123)
- 1:33 PM – Completed Order ORD-122

Actions:
[ New Order ]
[ Print Summary ]
[ Clock Out ]

```

---

## 🧑‍🍳 Waiter Dashboard

```
🧭 Dashboard – Waiter
--------------------------------------------------
👋 Welcome back, Ali
🕒 Clocked In: 10:02 AM (⏱ 4h 10m)

🍽️ Active Tables: 6
🧾 Open Orders: 4
📈 Orders Today: 12 (↓ 2 vs yesterday)

📝 Last Activity:
- 2:06 PM – Submitted Order ORD-204
- 12:33 PM – Cleared Table #3

Quick Actions:
[ My Orders ]
[ Scan QR ] 
[ Clock Out ]

```