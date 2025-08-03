# 📝 POS Terminal Final TODOs for Commercial Readiness

These items are critical for making the POS system production-grade and ready for sale to restaurants.

---

## ✅ Already Implemented
- Menu item browsing with category tabs
- Modifier selection with prefixes and price impacts
- Editable cart: quantity, notes, remove
- Cart-level and item-level discounts
- Tip support
- Order checkout with payment selection
- Refund, reprint, void (with reasons)
- Role-based UI screens (owner, cashier, waiter)
- Tablet + mobile responsive wireframes

---

## ⚠️ Missing or Needs Improvement

### 1. 🔀 Split Payments
- Support partial payments (e.g. cash + card)
- Allow splitting by item or seat
- Needed for dine-in with group customers

### 2. 🖨️ Receipt Preview & Printer Configuration
- Design receipt layout preview
- Allow printer routing:
  - Kitchen copy
  - Customer receipt
- Assign printers per device or station

### 3. 🧾 Hold & Fire Workflow
- Let staff place order on hold
- Fire only selected items to kitchen
- Useful for starter/main sequence

### 4. 🧩 Combo / Set Menu Support
- Enable fixed-price menus (e.g. Lunch Set)
- Include options/choices within combo
- Track individual ingredient usage if needed

### 5. 🪑 Table Merge / Split / Seat Assignment
- Merge tables into one ticket
- Split by guest or seat (e.g. split pizza cost)
- Especially important for high-volume dine-in

### 6. 🌐 Offline Mode UI Behavior
- Make it clear when in offline mode
- Show sync status indicator
- Warn if actions are not synced

### 7. 🔐 Auto-Lock / Session Timeout
- POS auto-lock after X minutes idle
- Require PIN to unlock

---

## 📌 Recommendation
Start with:
- Split Payment Flow
- Send to Kitchen / Hold Fire Logic
- Printer routing screen

These are most commonly expected in sales demos and pilot installations.