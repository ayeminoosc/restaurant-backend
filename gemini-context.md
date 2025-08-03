## Project: Restaurant POS SaaS Platform

**Objective:** To incrementally build a full-featured, commercial-grade restaurant Point of Sale (POS) system.

**Core Architecture:**
- **Dual-Mode Deployment:** The same codebase can run in two modes, configured by an `application.mode` property (`cloud` or `local`).
- **Cloud Service:** The central, authoritative backend (`application.mode=cloud`).
- **Local Hub Server:** Runs on a main cashier device, serves local devices, and syncs with the cloud (`application.mode=local`).
- **SaaS Model:** A cloud-based backend service.
- **Hybrid On-Premise:** Local cashier and waiter devices that sync with the cloud. A primary local device will act as a hub.
- **Technology:** The backend is being developed in Java with Spring/JPA (based on file structure and dependencies).

**Project Vision & Features (Based on `@docs`):**
The system is designed to be comprehensive, covering all major aspects of restaurant operations. Key modules include:
- **Menu Management:** Detailed configuration of items, categories, groups, and highly complex modifiers (including prefixes like "No", "Extra", "On Side").
- **Inventory Management:** Tracking stock levels, recipes, suppliers, warehouses, and purchase orders.
- **Employee & User Management:** Role-based access control (Owner, Manager, Cashier, Waiter), user accounts, and time/attendance tracking.
- **Reporting & Analytics:** A suite of reports covering sales, labor, inventory, and payments, with plans for a Business Intelligence (BI) component.
- **Restaurant & System Configuration:** Settings for restaurant details, terminals, printers, payment types, and other global configurations.
- **Customer & Table Management:** A customer database (CRM), floor plan design, and table booking capabilities.
- **Frontend POS:** Detailed wireframes exist for the entire order-taking process, from table selection to payment.

**Data Model:**
- **Primary Keys:** All tables use UUIDs (`VARCHAR(255)`) as primary keys to support the active-active and offline-first architecture, preventing ID collisions. The redundant `uuid` field has been removed from `BaseEntity` and all DDL table definitions.
- **Multi-Tenancy:** The schema is designed for multi-tenancy, with a `restaurant_id` column in most tables to ensure data isolation.
- **Synchronization:** All entities extend a `BaseEntity` that includes `createdAt`, `updatedAt`, `lastSyncTime`, `isDirty`, and `deleted` fields. These fields are explicitly mapped to their `snake_case` database column names using `@DatabaseField(columnName = "...")` to ensure correct ORM functionality.
- **Lazy Loading:** Foreign key relationships are configured for lazy loading to optimize query performance.

**Current Status (2025-08-03):**
- **Focus:** We are in the initial stages of backend development, working component by component.
- **Last Action:** We have started by examining the `Restaurant` entity, which corresponds to the "Restaurant Settings" feature in the backoffice.
- **Next Step:** Proceed with generating the necessary backend components (Service, Repository, Controller) to manage the `Restaurant` entity.