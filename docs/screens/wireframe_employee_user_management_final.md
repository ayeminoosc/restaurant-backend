# 👥 Employee & User Management Wireframes (Tablet + Mobile Friendly)

All screens are responsive for both tablet and mobile form factors.

---

## 1. User List

### Tablet Layout
```
+------------------------------------------------------------------+
| 👥 Users                                      [ Search... ]      |
+------------------------------------------------------------------+
| Name         | Phone        | Email              | Role     | Actions           |
|--------------|--------------|--------------------|----------|-------------------|
| John Doe     | +65 9123 4567| john@example.com   | Manager  | [ Edit ] [ Reset ]|
| Jane Staff   | +65 8888 9999| jane@example.com   | Cashier  | [ Edit ] [ Reset ]|
+------------------------------------------------------------------+
| [ + Add User ]                                                   |
+------------------------------------------------------------------+
```

### Mobile Layout
```
👥 Users
-----------------------------
John Doe (Manager)
📞 +65 9123 4567
📧 john@example.com
[ Edit ] [ Reset PIN ]

-----------------------------
Jane Staff (Cashier)
📞 +65 8888 9999
📧 jane@example.com
[ Edit ] [ Reset PIN ]

[ + Add User ]
```

---

## 2. Add / Edit User

```
📝 Edit User
-----------------------------
Name:        [ John Doe          ]
Phone:       [ +65 9123 4567     ]
Email:       [ john@example.com  ]
Role:        [ Manager ▼         ]
PIN Login:   [ **** ] [ Change PIN ]

Role Description:
Managers can access POS, void, manage inventory, and view reports.

[ Save ]   [ Delete User ]
```

---

## 3. Clock In / Clock Out Screen

```
🕒 Clock In / Clock Out
-----------------------------
Enter PIN: [ ____ ]

[ Clock In ]    [ Clock Out ]
```

- Automatically detects user from PIN
- Timestamp logged with optional note/device info
- Optionally disable Clock Out if already done

---

## 4. Shift History

### Tablet Layout
```
+------------------------------------------------------------------+
| 🕓 Shift History – John Doe                                      |
+------------------------------------------------------------------+
| Date       | Clock In  | Clock Out | Duration  | Notes (opt)     |
|------------|-----------|-----------|-----------|-----------------|
| 2025-08-01 | 09:00 AM  | 06:30 PM  | 9h 30m    |                 |
| 2025-07-31 | 08:55 AM  | 05:45 PM  | 8h 50m    |                 |
+------------------------------------------------------------------+
```

### Mobile Layout
```
🕓 Shift History: John Doe
-----------------------------
📅 2025-08-01
IN: 09:00 AM | OUT: 06:30 PM
Duration: 9h 30m

📅 2025-07-31
IN: 08:55 AM | OUT: 05:45 PM
Duration: 8h 50m
```

---