# Commercial Restaurant POS System: Developer Prompt

## Objective
Develop a fully functional, commercial-grade, multi-restaurant POS system with a sleek, highly professional, and intuitive UI/UX. The system must be ready for real-world deployment and sale, not a student or demo project. All screens, workflows, and integrations must be implemented end-to-end using mock data, with a focus on enterprise reliability, scalability, and extensibility.

---

## Step 1: Deep Requirement Analysis
- **Read and internalize** the full requirements in `full-requirements.md` (see docs/prompts/po/full-requirements.md).
- Understand all business logic, workflows, and commercial expectations for a modern, enterprise POS system.

## Step 2: Wireframe & Workflow Comprehension
- **Study** all wireframes and screen flows in `copilot-wireframes.md`.
- For each screen, document:
  - User actions and button behaviors
  - Data flows and state transitions
  - Integration points (e.g., kitchen, inventory, CRM, reporting)
- Map out navigation, error states, and edge cases for every workflow.

## Step 3: Exhaustive UI/UX Implementation
- **Design and build** every screen and workflow from the wireframes, ensuring:
  - Modern, visually stunning, and highly intuitive UI/UX (material, fluent, or custom professional design system)
  - Responsive layouts for tablet, mobile, and desktop
  - Accessibility and internationalization support
  - Realistic, production-quality microinteractions and transitions
- **No student/demo UI**: All visuals and flows must match or exceed leading commercial POS systems (e.g., Toast, Square, Lightspeed).

## Step 4: End-to-End Integration (Mock Data)
- **Implement all business logic** and data flows using mock data and services.
- Simulate real-world scenarios: multi-location, multi-user, offline/online, error states, and edge cases.
- Integrate all modules:
  - POS terminal (table/quick service, order, payment, split, refund, void)
  - Menu management (categories, items, modifiers, pricing, versioning)
  - Inventory (stock, receiving, recipes, waste, vendors, POs)
  - Employee (roles, permissions, clock-in/out, scheduling, performance)
  - CRM (customers, loyalty, segmentation, feedback)
  - Reporting & analytics (real-time dashboards, exports, drill-downs)
  - Delivery & third-party integrations (order routing, driver, API sync)
  - System admin (settings, security, audit, compliance, API)

## Step 5: Commercial-Ready Quality
- **Polish** every detail: error handling, loading states, confirmations, and edge cases.
- Ensure all screens are fully interactive and integrated.
- Provide exhaustive test coverage for all workflows.
- Prepare for easy transition to real backend/API integration.

## Deliverables
- Complete, production-quality source code for all UI, workflows, and integrations (mock data/services)
- Documentation for:
  - Screen/component structure and navigation
  - Data models and mock service contracts
  - UI/UX design system and accessibility
  - Integration points and extension guidelines
- Test suite covering all user flows and edge cases

## Notes
- This prompt is for generating a **ready-to-sell, commercial POS system**—not a prototype or MVP.
- All UI/UX must be at the level of leading industry products.
- Use the requirements and wireframes as the single source of truth for all features and flows.
- Focus on extensibility, maintainability, and real-world usability throughout.
