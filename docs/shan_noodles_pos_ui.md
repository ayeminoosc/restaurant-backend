# 🍜 POS System Design for Burmese Dish (Shan Noodles)

This document describes a full-featured POS UI and data model solution for handling complex per-item prefix-modifier mappings, inspired by real-world restaurant POS systems like Toast and Square for Restaurants.

---

## 🥡 Dish Example: Shan Noodles (Shan Khauk Swe)

### Base Item:

- **Name**: Shan Noodles (ရှမ်းခေါက်ဆွဲ)
- **Category**: Noodles
- **Base Price**: \$6.00

### Modifier Groups and Options:

| Group         | Modifiers                                                 | Allowed Prefixes (per item/modifier) |
| ------------- | --------------------------------------------------------- | ------------------------------------ |
| Protein       | Chicken, Pork, Tofu, Extra Meat (+\$1.00)                 | `No`, `Add`, `Extra`                 |
| Noodle Type   | Rice Noodle, Egg Noodle, Flat Noodle                      | `No`, `Extra`                        |
| Toppings      | Fried Garlic, Boiled Egg, Pickled Greens, Peanuts, Garlic | `No`, `Add`, `On Side`, `Extra`      |
| Sauce Options | Chili Oil, Fish Sauce                                     | `No`, `Light`, `Extra`               |
| Spice Level   | No, Mild, Medium, Spicy                                   | *(radio choice; no prefix)*          |

---

## 🖥️ Terminal-Style POS UI Flow

### Step 1: Main Order Screen

```
------------------------------
| Table 5 | Server: Aye Min  |
------------------------------
1x Coconut Noodles
1x Burmese Salad

[+ Add Item]   [Send to Kitchen]
```

### Step 2: Select Item

```
---- CATEGORY: NOODLES ----
- Shan Noodles - $6.00
- Mohinga - $5.00
- Coconut Noodles - $6.50
---------------------------
```

### Step 3: Modifier Selection (Edit Mode)

```
------ Shan Noodles Modifiers ------
🐓 Protein (Required):
  [Chicken] [Pork] [Tofu] [Extra Meat ⚙️]

🍜 Noodle Type:
  [Rice Noodle ✅] [Egg Noodle] [Flat Noodle]

🧂 Toppings:
  [Fried Garlic ✅] [Boiled Egg ✅ +$1.00]
  [Pickled Greens ⚙️] [Peanuts ⚙️] [Garlic ⚙️]

🥣 Sauce Options:
  [Chili Oil ⚙️] [Fish Sauce ⚙️]

🌶 Spice Level:
  ( ) No ( ) Mild (✓) Medium ( ) Spicy

--------------------------------------
✅ Selected Modifiers:
 • Chicken
 • Rice Noodle
 • Medium Spice
 • Fried Garlic
 • Boiled Egg (+$1.00)
 • No Peanuts
 • Extra Garlic
 • On Side Pickled Greens
 • Light Chili Oil

[⬅️ Cancel]   [✅ Add to Order]
```

### Step 4: Prefix Popup (e.g., Tap on "Pickled Greens ⚙️")

```
-- Set Prefix for Pickled Greens --
( ) No Pickled Greens
(✓) On Side Pickled Greens
( ) Extra Pickled Greens
( ) Add Pickled Greens

[Cancel] [Confirm]
```

---

## 📦 Data Modeling (Recommended Schema)

### Table: `items`

| Field | Type    | Description    |
| ----- | ------- | -------------- |
| id    | UUID    | Unique item ID |
| name  | Text    | Item name      |
| price | Numeric | Base price     |

### Table: `modifier_groups`

| Field | Type | Description                   |
| ----- | ---- | ----------------------------- |
| id    | UUID | Unique group ID               |
| name  | Text | Group name (e.g., "Toppings") |

### Table: `modifiers`

| Field | Type    | Description                     |
| ----- | ------- | ------------------------------- |
| id    | UUID    | Modifier ID                     |
| name  | Text    | Modifier name (e.g., "Peanuts") |
| price | Numeric | Additional price (if any)       |

### Table: `prefixes`

| Field | Type | Description         |
| ----- | ---- | ------------------- |
| id    | UUID | Prefix ID           |
| label | Text | e.g., "No", "Extra" |

### Table: `item_modifier_prefix`

| Field        | Type | Description       |
| ------------ | ---- | ----------------- |
| item\_id     | UUID | FK to `items`     |
| modifier\_id | UUID | FK to `modifiers` |
| prefix\_id   | UUID | FK to `prefixes`  |

---

## 🧾 Final Kitchen Ticket Output

```
Table: 5 | Server: Aye
-----------------------------------
1x Shan Noodles - $6.00
 + Chicken
 + Rice Noodle
 + Medium Spice
 + Fried Garlic
 + Boiled Egg (+$1.00)
 + No Peanuts
 + Extra Garlic
 + On Side Pickled Greens
 + Light Chili Oil
-----------------------------------
Subtotal: $7.00
```

---

## ✅ Summary

- Prefixes apply per modifier, **per item**
- UI supports prefix popups only when valid
- Summary section shows real-time selections
- Final kitchen ticket is structured, readable, and accurate

This structure supports scalability and flexibility in real-world restaurant POS systems, while remaining intuitive for staff during busy service hours.

