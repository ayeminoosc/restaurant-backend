---

## 4. Reporting & Analytics

#### Screen: Reports Dashboard/Selection
*   **Purpose:** Central hub for accessing various reports.
*   **Navigation:** Accessible from the "Reporting & Analytics" section in the Main Dashboard.
*   **Tablet Layout:** List or grid of available reports (Sales, Cash Drawer, Tips, Action History, BI Reports). Tap to view a specific report.

##### Reports Dashboard/Selection (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Reports & Analytics           |
|                                 |                               |
| [Inv Icon]  Inventory Management| +-------------------------------------------------------------+ |
|                                 | | [Sales Icon] Sales Reports                                | |
| [Emp Icon]  Employee Management | +-------------------------------------------------------------+ |
|                                 | | [Cash Icon] Cash Drawer Reports                           | |
| [Rpt Icon]  Reporting & Analytics| +-------------------------------------------------------------+ |
|                                 | | [Tips Icon] Tips Reports                                  | |
| [Conf Icon] Configuration       | +-------------------------------------------------------------+ |
|                                 | | [Action Icon] Action History                                | |
| [Cust Icon] Customer Management | +-------------------------------------------------------------+ |
|                                 | | [BI Icon] Business Intelligence Reports                   | |
|                                 | +-------------------------------------------------------------+ |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

#### Screen: Generic Report View (e.g., Sales Report)
*   **Purpose:** Display data for a specific report.
*   **Navigation:** Accessed by selecting a report from the Reports Dashboard.
*   **Tablet Layout:**
    *   Top: Date range picker, filters (e.g., by user, terminal, item).
    *   Middle: Data visualization (charts for trends, tables for detailed data).
    *   Bottom: Export options (PDF, CSV).

##### Generic Report View (Tablet Wireframe - Sales Report)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | Sales Report                  [Export] |
|                                 |                               |
| [Inv Icon]  Inventory Management| Date Range: [ 2025-07-01 ] to [ 2025-07-31 ] |
|                                 | Filters: [ All Users v ] [ All Terminals v ] |
| [Emp Icon]  Employee Management |                               |
|                                 | +-------------------------------------------------------------+ |
| [Rpt Icon]  Reporting & Analytics| | [Chart Area - e.g., Bar Chart of Daily Sales]               | |
|                                 | +-------------------------------------------------------------+ |
| [Conf Icon] Configuration       |                               |
|                                 | +-------------------------------------------------------------+ |
| [Cust Icon] Customer Management | | **Sales by Category**                                       | |
|                                 | | Category        Sales ($)   Items Sold                      | |
|                                 | | Main            1500.00     120                             | |
|                                 | | Drinks          500.00      250                             | |
|                                 | | Sides           300.00      100                             | |
|                                 | | ... (More data) ...                                         | |
|                                 | +-------------------------------------------------------------+ |
|                                 |                               |
|                                 | ... (Scrollable Table) ...                                      |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```

#### Screen: Business Intelligence (BI) Report Configuration
*   **Purpose:** Configure custom BI reports (`BusinessIntelligence`).
*   **Navigation:** Accessible from the Reports Dashboard.
*   **Tablet Layout:** Form with fields for Report Name, Type, Description, Data Source, Query SQL, Parameters, Output Format, Schedule (Cron), Active status.

##### Business Intelligence (BI) Report Configuration (Tablet Wireframe)
```
+-----------------------------------------------------------------+
| [LOGO] Restaurant POS           Welcome, John Doe       [Logout]|
+-----------------------------------------------------------------+
| [Menu Icon] Menu Management     | BI Report Configuration       [Save] |
|                                 |                               |
| [Inv Icon]  Inventory Management|                               |
|                                 | Report Name: [ Daily Sales Summary                            ] |
| [Emp Icon]  Employee Management | Report Type: [ Custom SQL                                   v ] |
|                                 | Description: [ Summarizes daily sales data.                 ] |
| [Rpt Icon]  Reporting & Analytics| Data Source: [ POS Database                                  v ] |
|                                 | Query SQL: [ SELECT date, SUM(totalPrice) FROM Ticket GROUP BY date; ] |
| [Conf Icon] Configuration       | Parameters: [ (e.g., startDate, endDate)                    ] |
|                                 | Output Format: [ CSV                                         v ] |
| [Cust Icon] Customer Management | Schedule (Cron): [ 0 0 * * * (daily at midnight)             ] |
|                                 | [ Active ] [X]                                                  |
|                                 |                               |
|                                 | ----------------------------------------------------------- |
|                                 | [ Delete ]                                                  |
|                                 |                               |
|                                 |                               |
|                                 |                               |
+-----------------------------------------------------------------+
```