# Restaurant POS Wireframe Redesign Plan

## ✅ RESTAURANT POS BACKOFFICE WIREFRAME REDESIGN PLAN

---

## 🔵 Module 1: Main Dashboard (Rework)

### 🔄 Current Weaknesses
- Static menu sidebar with no data summary
- No live metrics or alerts
- No clear landing zone for high-priority actions

### ✅ Redesign Goals
- Show **summary cards**: Today's Sales, Open Tickets, Low Stock, Clocked-In Staff
- Recent activity or audit log
- Terminal/device health status
- Alert banners: "Stock Below Reorder", "Tips Unclaimed"
- Role-aware view (Manager sees all, Cook sees orders only)

---

## 🔵 Module 2: Inventory Management (Rework)

### 🔄 Current Weaknesses
- Item editing is slow, not bulk-friendly
- No low-stock alerts or quick actions
- Recipe linkages are hidden
- Purchase Order flow is disjointed

### ✅ Redesign Goals
- Better **Inventory Item Grid**
  - Visual indicators for low stock
  - In-place quick edits
  - Tag view by category/vendor
- **Recipe Editor**
  - Tabs per MenuItem
  - Ingredient % and cost view
  - Link to usage analytics
- **PO Workflow**
  - Start from low-stock suggestion
  - Auto-fill vendor items
  - Approve & receive in one place
- **Inventory Log**
  - Better filters (date, PO, item, user)
  - Inline drill-down to PO or recipe

---

## 🔵 Module 3: Employee & User Management (Rework)

### 🔄 Current Weaknesses
- Clock-in/out is just raw log
- No schedule planning
- Roles & permission management too static

### ✅ Redesign Goals
- **User Grid View**
  - Status badge: Clocked In, On Break, Late
  - Filter by role, terminal, shift
- **Roles Editor**
  - Permission matrix
  - Role-based behaviors (auto-logout, access limits)
- **Shift Planner**
  - Calendar UI with drag-to-assign shifts
  - Labor cost estimate
- **Attendance & Payroll Summary**
  - Total hours this period
  - Auto-export to payroll

---

## 🔵 Module 4: Reporting & BI (Rework)

### 🔄 Current Weaknesses
- Reports are static
- BI config is SQL-focused
- No real visual dashboard

### ✅ Redesign Goals
- **Report Dashboard**
  - Visual cards for: Hourly Sales, Tips, Top Items
  - Date range filter
- **BI Report Builder**
  - Drag & drop fields
  - Templates (e.g. Sales by Hour)
  - Saved report library
- **Scheduled Reports Manager**
  - View/edit all scheduled exports

---

## 🔵 Module 5: New Screens You Are Missing

### 📜 POS/Ordering Screens (Frontend)
- Menu + Modifier picker
- Seat/Table map
- Payment screen (tips, split, partial)
- Reprint, Void, Refund
- Order status screen

### 👥 CRM & Loyalty
- Customer list with visit/spend stats
- Loyalty tier editor
- Reward configuration
- SMS/email campaign UI

### 🏢 Multi-Restaurant / Franchise
- "Organization" / "Brand" entity
- Centralized menu sync
- Store-specific overrides
- Consolidated reporting

### 🔄 Integration & Sync Status
- Terminal/device list
- Offline order queue viewer
- Manual sync retry
- API partner manager

---

## 🔢 Prioritized Redesign Rollout

| Phase | Focus Area                       | Type   |
|-------|----------------------------------|--------|
| 1     | Main Dashboard                   | Rework |
| 2     | Inventory Management             | Rework |
| 3     | Employee/User + Shifts           | Rework |
| 4     | Reporting & BI                   | Rework |
| 5     | POS Order Taking & Payments      | New    |
| 6     | Loyalty / CRM                    | New    |
| 7     | Multi-Restaurant Org Mgmt        | New    |
| 8     | Sync & Offline Status UI         | New    |

